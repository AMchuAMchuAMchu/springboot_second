package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootHotDeploy03Application {

    public static void main(String[] args) {

        System.setProperty("spring.devtools.restart.enabled","false");

        SpringApplication.run(SpringbootHotDeploy03Application.class, args);
    }

}
