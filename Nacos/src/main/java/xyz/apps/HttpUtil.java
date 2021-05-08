package xyz.apps;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


//既然注册到注册中心上了，那么肯定要做两件事，
// 第一件事：别的服务可以调用你的接口；
// 第二件事：你可以调用别的服务的接口。
@Component
public class HttpUtil {

    // 注入 Nacos 的 NamingService 实例
    @NacosInjected
    private NamingService namingService;

    @Autowired
    private LoadBalancer loadBalancer;

    //设置连接超时时间
    @NacosValue(value = "${readTimeOut:20000}",autoRefreshed = true)
    private int time;
    /**
     * 发送post请求
     *
     * @param url    请求路径
     * @param header 请求头
     * @param body   请求体
     * @return String
     */
    public String doPost(String url, Map<String, String> header, String body) {

        String result = "";
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            //通过url获取相应的服务实例，返回ip和port的拼接的url
            String geturl = getUrl(url);
            // 设置 url
            URL realUrl = new URL(geturl);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            // 设置 header
            for (Map.Entry<String, String> entry: header.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            // 设置请求 body
            connection.setDoOutput(true);
            connection.setDoInput(true);

            //设置连接超时和读取超时时间
            connection.setConnectTimeout(time);
            connection.setReadTimeout(time);
            try {
                out = new PrintWriter(connection.getOutputStream());
                // 保存body
                out.print(body);
                // 发送body
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                // 获取响应body
                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        return result;
    }

    /**
     * 发送get请求
     *
     * @param url    请求路径
     * @param header 请求头
     * @return String
     */
    public String doGet(String url, Map<String, String> header) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            //轮询获取实例，返回ip和port的拼接的url
            String geturl = getUrl(url);
            // 设置 url
            URL realUrl = new URL(geturl);
            URLConnection connection = realUrl.openConnection();
            // 设置 header
            for (Map.Entry<String, String> entry: header.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            //设置连接超时和读取超时时间
            connection.setConnectTimeout(time);
            connection.setReadTimeout(time);

            // 设置请求 body
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result.toString();
    }

    /**
     * 轮询获取实例，返回ip和port的拼接的url
     *
     * @param url  请求路径
     * @return String
     */
    public String getUrl(String url) throws Exception {
        URI uri = new URI(url);
        //获取服务名
        String serverName = uri.getHost();
        //获取访问的方法
        String method = uri.getPath();
        //获取url中的参数
        String param = uri.getQuery();
        //获取服务实例列表
        List<Instance> list = namingService.getAllInstances(serverName);
        //如果无服务实例，则抛异常信息
        if(list.size() == 0){
            throw new Exception(serverName + "服务不存在！");
        }
        Instance instance = loadBalancer.getSingleAddress(list);
        String ip = instance.getIp();
        int port = instance.getPort();
        //请求的参数是拼接在url里的
        if(param != null){
            return "http://" + ip + ":" + port + "" + method + "?"+param+"";
        }else {
            return "http://" + ip + ":" + port + "" + method + "";
        }
    }

}