package com.tf.vegout.sharding.dao.strategy;

import com.tf.vegout.sharding.enums.ShareType;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StrategyFactoryTest {
    @Test
    public void getRouteValueTest(){
        StrategyFactory.createShareStrategy(ShareType.MOD).getRouteValueTest("insert into dynamic(uid,description) values(1,'第一个哈哈')");
    }
}
