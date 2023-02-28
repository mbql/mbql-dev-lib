package com.mbql.mongo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slp
 */
@RestController
@SpringBootApplication
public class SpringbootMongoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongoDemoApplication.class, args);
    }

}
