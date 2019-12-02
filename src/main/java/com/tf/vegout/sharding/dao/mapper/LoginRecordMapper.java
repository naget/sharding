package com.tf.vegout.sharding.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tf.vegout.sharding.dao.entity.LoginRecord;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public interface LoginRecordMapper extends BaseMapper<LoginRecord> {
    @SelectProvider(type = Provider.class,method = "listA")
    List<LoginRecord> listA(Map<String,Object> params);

    class Provider{
        public String listA(Map<String,Object> params){
            return new SQL(){{
                SELECT("*");
                FROM("login_record");
                if (params.get("uid")!=null){
                    WHERE("uid="+params.get("uid"));
                }
            }}.toString();
        }
    }
}
