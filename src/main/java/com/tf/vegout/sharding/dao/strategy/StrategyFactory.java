package com.tf.vegout.sharding.dao.strategy;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;
import com.tf.vegout.sharding.annotation.Sharding;
import com.tf.vegout.sharding.enums.ShareType;
import com.tf.vegout.sharding.utils.DruidUtil;
import org.apache.ibatis.mapping.BoundSql;

import java.util.List;
import java.util.Map;

public class StrategyFactory {
    private ShareType type;
    private BoundSql boundSql;
    private Sharding sharding;
    public StrategyFactory(ShareType type){
        this.type = type;
    }
    public  static StrategyFactory createShareStrategy(ShareType type){
        return new StrategyFactory(type);
    }

    public StrategyFactory setBoundSql(BoundSql boundSql) {
        this.boundSql = boundSql;
        return this;
    }

    public StrategyFactory setSharding(Sharding sharding) {
        this.sharding = sharding;
        return this;
    }
    public String getRouteValue(){
        final String[] result = new String[1];
        if (type==ShareType.MOD){
            Map<String,Object> params = DruidUtil.getParamsMap(boundSql.getSql());

            params.forEach((k,v)->{
                if (k.equalsIgnoreCase(sharding.shareBy())){
                    Integer id = (Integer) v;
                    result[0] = String.valueOf(id%sharding.tableNum());
                }
            });
        }
        return result[0];
    }

    public String getRouteValueTest(String sql){
        if (type==ShareType.MOD){
            StringBuilder out = new StringBuilder();
            MySqlOutputVisitor visitor = new MySqlOutputVisitor(out);
            MySqlStatementParser parser = new MySqlStatementParser(sql);
            List<SQLStatement> sqlStatements = parser.parseStatementList();
             for (SQLStatement statement : sqlStatements) {
             statement.accept(visitor);
             visitor.println();
             }
            System.out.println(out.toString());
            return out.toString();
        }
        return "";
    }

}
