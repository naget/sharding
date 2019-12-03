package com.tf.vegout.sharding.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DruidUtilTest {
    @Test
    public void testGetParams(){
        String sql = "select * from sys_user where id=2 and name=xiaohong and age=2";
        Map<String,Object> params = DruidUtil.getParamsMap(sql);
        System.out.println();
    }
}
