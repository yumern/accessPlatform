package com.zzu.hezhifeng.stater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zzu.hezhifeng"})
public class AccessPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessPlatformApplication.class, args);
    }

}

