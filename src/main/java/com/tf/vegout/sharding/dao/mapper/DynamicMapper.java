package com.tf.vegout.sharding.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tf.vegout.sharding.annotation.Sharding;
import com.tf.vegout.sharding.dao.entity.Dynamic;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;
@Sharding(tableName = "dynamic",tableNum = 10,shareBy = "uid")
public interface DynamicMapper extends BaseMapper<Dynamic> {
    @SelectProvider(type = Provider.class,method = "listA")
    List<Dynamic> listA(Map<String,Object> params);
    class Provider{
        public String listA(Map<String,Object> params){
            return new SQL(){{
                SELECT("*");
                FROM("dynamic");
                if (params.get("uid")!=null){
                    WHERE("uid="+params.get("uid"));
                }
            }}.toString();
        }
    }
}
