package com.tf.vegout.sharding.configs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tf.vegout.sharding.dao*")
public class MybatisPlusConfig {

}
