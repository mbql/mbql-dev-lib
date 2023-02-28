package com.mbql.mongo.demo.mapper;

import com.mbql.mongo.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 用户持久化
 * @author slp
 */
public interface UserMapper extends MongoRepository<User, Long> {


}
