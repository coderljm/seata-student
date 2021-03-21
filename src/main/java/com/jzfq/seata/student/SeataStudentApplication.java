package com.jzfq.seata.student;

import com.jzfq.seata.student.feign.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@MapperScan("com.jzfq.seata.student.mapper")
@EnableHystrix
@EnableFeignClients(basePackages = "com.jzfq.seata.student.feign", defaultConfiguration = DefaultFeignConfig.class)
public class SeataStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStudentApplication.class,args);
    }
}
