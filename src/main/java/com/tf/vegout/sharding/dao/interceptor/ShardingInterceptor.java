package com.tf.vegout.sharding.dao.interceptor;

import com.tf.vegout.sharding.annotation.Sharding;
import com.tf.vegout.sharding.dao.sqlProcessor.SqlProcessor;
import com.tf.vegout.sharding.dao.sqlProcessor.impl.SelectSqlProcessor;
import com.tf.vegout.sharding.dao.strategy.StrategyFactory;
import com.tf.vegout.sharding.utils.DruidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

@Component
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}))
@Slf4j
public class ShardingInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, reflectorFactory);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String id = mappedStatement.getId();
        //sql语句类型 select/delete/insert/update
        String sqlCommandType = mappedStatement.getSqlCommandType().toString();
        id = id.substring(0, id.lastIndexOf("."));
        Class cls = Class.forName(id);
        Sharding segmentTable = (Sharding) cls.getAnnotation(Sharding.class);
        if (segmentTable != null) {
            String sql = (String) metaObject.getValue("delegate.boundSql.sql");
            BoundSql boundSql = statementHandler.getBoundSql();
            if (sqlCommandType.equalsIgnoreCase("insert") || sqlCommandType.equalsIgnoreCase("delete") || sqlCommandType.equalsIgnoreCase("update")) {
//                String tableKey = StrategyFactory.createShareStrategy(segmentTable.shareType()).setSharding(segmentTable).setBoundSql(boundSql).getRouteValue();
//                metaObject.setValue("delegate.boundSql.sql",sql.replaceFirst(segmentTable.tableName(),segmentTable.tableName()+tableKey));
            } else {
                String tableName = DruidUtil.getTableName(sql);
                Map<String, Object> params = DruidUtil.getParamsMap(sql);
                if (params.size() == 0) {
                    String mysql = new SelectSqlProcessor().process(sql, segmentTable);
                    log.info("\n自定义分表插件处理之后的sql:\n{}",mysql);
                    metaObject.setValue("delegate.boundSql.sql", mysql);
                }
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler){
            return Plugin.wrap(target,this);
        }else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
