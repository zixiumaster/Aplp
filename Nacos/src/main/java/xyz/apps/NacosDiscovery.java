package xyz.apps;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;



@PropertySource("classpath:application.yml")                   //指定读取的配置文件。
@EnableNacosDiscovery(globalProperties = @NacosProperties)                  //指定注册中心地址，通过配置文件中的nacos.server-addr读取。
@EnableNacosConfig(globalProperties = @NacosProperties)                      //指定配置中心地址，通过配置文件中的nacos.server-addr读取。
@NacosPropertySource(dataId = "common.properties", autoRefreshed = true)    //指定应用可以读取nacos配置中心的common.properties的配置文件。
public class NacosDiscovery {


    @Value("${server.port}")                 //获取配置文件里服务端口
    private int serverPort;

    @Value("${spring.application.name}")     //获取配置文件里服务名
    private String applicationName;

    @NacosInjected                          // 注入 Nacos 的 NamingService 实例
    private NamingService namingService;

    @PostConstruct
    public void registerInstance() throws Exception {
        System.out.println("registerInstance() is run");
        // 通过Nacos Open API 向 Nacos Server 注册一个名称为applicationName的服务
        namingService.registerInstance(applicationName, NetworkUtil.getLocalIp(), serverPort);
    }

}