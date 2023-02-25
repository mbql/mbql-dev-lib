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
public class UserDetails implements Serializable {

    private Long id;

    private Long userId;

    private Integer sex;

    private String phone;

    private Integer totalSum;

}
