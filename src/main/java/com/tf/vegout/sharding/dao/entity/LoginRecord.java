package com.tf.vegout.sharding.dao.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LoginRecord {
    private Integer id;
    private Long uid;
    private Timestamp loginTime;
}
