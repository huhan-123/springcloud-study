package cn.edu.wust.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Author: huhan
 * @Date: 2020/1/16 16:32
 * @Description
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
public class HystrixServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixServerApplication.class,args);
    }
}
