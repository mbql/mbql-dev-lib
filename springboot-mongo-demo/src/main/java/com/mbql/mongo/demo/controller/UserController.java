package com.mbql.mongo.demo.controller;

import com.mbql.mongo.demo.entity.User;
import com.mbql.mongo.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器
 * @author slp
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    public List<User> test() {
        return userService.findAll();
    }

}
