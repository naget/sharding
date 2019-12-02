package com.tf.vegout.sharding.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tf.vegout.sharding.dao.entity.User;
import net.sf.jsqlparser.expression.operators.relational.OldOracleJoinBinaryExpression;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    @SelectProvider(type = Provider.class,method = "listA")
    public List<User> listA(Map<String,Object> params);

    class Provider{
        public String listA(Map<String, Object> params){
            return new SQL(){{
                SELECT("*");
                FROM("sys_user");
                if (params.get("name")!=null){
                    WHERE("name="+params.get("name"));
                }
            }}.toString();
        }
    }
}
