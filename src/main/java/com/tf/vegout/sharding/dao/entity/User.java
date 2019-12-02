package com.tf.vegout.sharding.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {
    private Long id;
    private String name;
    private int status;
    private String avatar;
}
