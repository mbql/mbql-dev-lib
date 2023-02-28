package com.mbql.mongo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author slp
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Integer age;

    private UserDetails userDetails;

}
