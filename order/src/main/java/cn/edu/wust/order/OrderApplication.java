package cn.edu.wust.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

/**
 * @Author: huhan
 * @Date: 2020/1/15 21:03
 * @Description
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"cn.edu.wust.order.*","cn.edu.wust.common.*"})
@EnableFeignClients(basePackages = {"cn.edu.wust.order.*","cn.edu.wust.common.*"})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
