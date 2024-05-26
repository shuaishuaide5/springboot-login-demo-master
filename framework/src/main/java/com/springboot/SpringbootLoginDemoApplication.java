package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.springboot.repository")
//@ComponentScan("com.springboot.service")
//@ComponentScan("com.springboot")
public class SpringbootLoginDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootLoginDemoApplication.class,args);
    }
}
