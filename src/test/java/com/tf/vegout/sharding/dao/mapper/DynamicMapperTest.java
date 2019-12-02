package com.tf.vegout.sharding.dao.mapper;

import com.tf.vegout.sharding.dao.entity.Dynamic;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DynamicMapperTest {
    @Autowired
    private DynamicMapper dynamicMapper;

    @Test
    public void selectTest(){
        log.info("start to test dynamicMapper [listA]");
        List<Dynamic> dynamics = dynamicMapper.listA(new HashMap<>());
        Assert.assertEquals(8,dynamics.size());
        dynamics.forEach(System.out::println);
    }
}
