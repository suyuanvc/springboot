package com.cc.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmApplication.class, args);
    }

}
