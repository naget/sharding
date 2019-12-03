package com.tf.vegout.sharding.dao.sqlProcessor.impl;

import com.alibaba.druid.sql.ast.SQLLimit;
import com.tf.vegout.sharding.annotation.Sharding;
import com.tf.vegout.sharding.dao.sqlProcessor.SqlProcessor;
import com.tf.vegout.sharding.utils.DruidUtil;

import java.util.ArrayList;
import java.util.List;

public class SelectSqlProcessor implements SqlProcessor {
    @Override
    public String process(String sql, Sharding sharding) {
        StringBuilder result = new StringBuilder();
        String table = DruidUtil.getTableName(sql);
        SQLLimit limit = DruidUtil.getLimit(sql);
        if (limit==null){// TODO: 2019/12/3 计算count，sum等情况需要再做处理
            List<String> sqls = new ArrayList<>();
            for(int i=0;i<sharding.tableNum();i++){
                sqls.add(sql.replaceFirst(table,table+i));
            }
            return unionList(sqls);
        }
        return null;
    }


    private String unionList(List<String> sqls){
        StringBuilder mid = new StringBuilder();//分表union all部分
        StringBuilder resultSql = new StringBuilder();

        resultSql.append("select * from (");
        mid.append("(");
        for (int i=0;i<sqls.size();i++){
            mid.append(sqls.get(i));
            if (i<sqls.size()-1){
                mid.append(" )union all( ");
            }
        }
        mid.append(")");
        resultSql.append(mid);
        resultSql.append(") a ");
        return resultSql.toString();
    }
}
