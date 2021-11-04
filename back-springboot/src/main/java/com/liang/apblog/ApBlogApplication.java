package com.liang.apblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liang.apblog.dao")
public class ApBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApBlogApplication.class, args);
    }

}
