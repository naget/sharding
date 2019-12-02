package com.tf.vegout.sharding.dao.mapper;

import com.tf.vegout.sharding.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        log.info("------------selectAll method test--------");
        List<User> users = userMapper.selectList(null);
        Assert.assertEquals(0,users.size());
        users.forEach(System.out::println);
    }
}
