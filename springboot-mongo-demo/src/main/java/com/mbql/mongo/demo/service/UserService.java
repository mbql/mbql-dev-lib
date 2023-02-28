package com.mbql.mongo.demo.service;

import com.mbql.mongo.demo.entity.User;
import com.mbql.mongo.demo.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务
 * @author slp
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

}
