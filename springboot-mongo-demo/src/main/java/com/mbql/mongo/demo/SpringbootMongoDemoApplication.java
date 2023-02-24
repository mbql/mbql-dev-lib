package com.mbql.mongo.demo;

import com.mbql.mongo.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author slp
 */
@RestController
@SpringBootApplication
public class SpringbootMongoDemoApplication {

    @Autowired
    private MongoTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongoDemoApplication.class, args);
    }

    @GetMapping("/test")
    public List<User> test() {
        return template.find(Query.query(Criteria.where("_id").is(1L)), User.class);
    }

}
