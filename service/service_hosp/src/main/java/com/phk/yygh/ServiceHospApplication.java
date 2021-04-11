package com.phk.yygh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/4/11
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.phk")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
