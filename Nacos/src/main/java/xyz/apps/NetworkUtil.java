package xyz.apps;

import java.net.InetAddress;

/**
 * @ClassName: NetworkUtil
 * @Description: 获取本机ip
 * @Author daiyating
 * @Date 2020/9/10 0010
 * @Version 1.0
 */

//因为往nacos注册时需要将应用ip注册上去，因此需要一个这个类来获取本机ip地址
public final class NetworkUtil {

    public static String getLocalIp() throws Exception{
        InetAddress inetAddress=InetAddress.getLocalHost();
        String ip=inetAddress.getHostAddress().toString();//获得本机Ip
        return ip;
    }

}
