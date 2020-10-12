package cn.how2j.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import cn.hutool.core.util.NetUtil;

//SpringBoot
@SpringBootApplication
//配置服务器
@EnableConfigServer
//用于发现eureka的微服务
@EnableDiscoveryClient
//Eureka客户端
@EnableEurekaClient
public class ConfigServerApplication {
    public static void main(String[] args) {
        int port = 8030;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ConfigServerApplication.class).properties("server.port=" + port).run(args);

    }
}