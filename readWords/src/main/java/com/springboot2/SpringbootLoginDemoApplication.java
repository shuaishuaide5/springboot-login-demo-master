package com.springboot2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.repository")
public class SpringbootLoginDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootLoginDemoApplication.class,args);
    }
}
