package com.exc.kinfe4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 启动类
 * @author Huang Min
 * @date 2020/11/16 12:40
 * @description
 */
@SpringBootApplication
public class Kinfe4jApplication {
    private static final Logger logger = LoggerFactory.getLogger(Kinfe4jApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext application= SpringApplication.run(Kinfe4jApplication.class, args);
        Environment env = application.getEnvironment();
        String host= null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("获取当前服务器HOST失败:{}",e);
            e.printStackTrace();
        }
        String springApplicationName=env.getProperty("spring.application.name");
        String port=env.getProperty("server.port");
        String contextPath=env.getProperty("server.servlet.context-path");
        String portAndContextPath = null;
        String applicationName = "未获取服务名称";
        if (null != applicationName){
            applicationName = springApplicationName;
        }

        if (null == contextPath){
            portAndContextPath = port;
        }else {
            portAndContextPath = port+contextPath;
        }
        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is Running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t"+
                        "Doc: \thttp://{}:{}/doc.html\n\t"+
                        "----------------------------------------------------------",
                applicationName,
                portAndContextPath,
                host,portAndContextPath,
                host,portAndContextPath);
    }

}
