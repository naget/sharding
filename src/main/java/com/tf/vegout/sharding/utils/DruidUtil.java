package com.tf.vegout.sharding.utils;

import ch.qos.logback.core.status.OnPrintStreamStatusListenerBase;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLLimit;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.*;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DruidUtil {
    public static String getTableName(String sql){
        String tableName = "";
        StringBuilder out = new StringBuilder();
        MySqlOutputVisitor visitor = new MySqlOutputVisitor(out);
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        List<SQLStatement> sqlStatements = parser.parseStatementList();
        SQLStatement sqlStatement = sqlStatements.get(0);//假设字符串sql只含有一条sql语句
        if (sqlStatement instanceof SQLSelectStatement){//查询语句
            SQLSelectStatement sqlSelectStatement = (SQLSelectStatement) sqlStatement;
            SQLSelectQuery sqlSelectQuery = sqlSelectStatement.getSelect().getQuery();

            if (sqlSelectQuery instanceof SQLSelectQueryBlock){//非union查询语句
                SQLSelectQueryBlock sqlSelectQueryBlock = (SQLSelectQueryBlock) sqlSelectQuery;
                //字段列表
                List<SQLSelectItem> selectItems = ((SQLSelectQueryBlock) sqlSelectQuery).getSelectList();
                //表名
                SQLTableSource table = sqlSelectQueryBlock.getFrom();
                tableName = table.toString();
                log.info("tableName:{}",table.toString());
            }else if (sqlSelectQuery instanceof SQLUnionQuery){//union查询语句

            }


        }else if (sqlStatement instanceof SQLInsertStatement){//插入语句

        }else if (sqlStatement instanceof SQLUpdateStatement){//更新语句

        }else if (sqlStatement instanceof SQLDeleteStatement){//删除语句

        }
        return tableName;
    }


    public static SQLLimit getLimit(String sql){
        StringBuilder out = new StringBuilder();
        MySqlOutputVisitor visitor = new MySqlOutputVisitor(out);
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        List<SQLStatement> sqlStatements = parser.parseStatementList();
        SQLStatement sqlStatement = sqlStatements.get(0);//假设字符串sql只含有一条sql语句
        if (sqlStatement instanceof SQLSelectStatement){//查询语句
            SQLSelectStatement sqlSelectStatement = (SQLSelectStatement) sqlStatement;
            SQLSelectQuery sqlSelectQuery = sqlSelectStatement.getSelect().getQuery();

            if (sqlSelectQuery instanceof SQLSelectQueryBlock){//非union查询语句
                SQLSelectQueryBlock sqlSelectQueryBlock = (SQLSelectQueryBlock) sqlSelectQuery;
                SQLLimit limit = sqlSelectQueryBlock.getLimit();
                return limit;
            }else if (sqlSelectQuery instanceof SQLUnionQuery){//union查询语句

            }


        }else if (sqlStatement instanceof SQLInsertStatement){//插入语句

        }else if (sqlStatement instanceof SQLUpdateStatement){//更新语句

        }else if (sqlStatement instanceof SQLDeleteStatement){//删除语句

        }
        return null;
    }

    public static Map<String, Object> getParamsMap(String sql){
        Map<String,Object> params = new HashMap<>();
        StringBuilder out = new StringBuilder();
        MySqlOutputVisitor visitor = new MySqlOutputVisitor(out);
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        List<SQLStatement> sqlStatements = parser.parseStatementList();
        SQLStatement sqlStatement = sqlStatements.get(0);//假设字符串sql只含有一条sql语句
        if (sqlStatement instanceof SQLSelectStatement){//查询语句
            SQLSelectStatement sqlSelectStatement = (SQLSelectStatement) sqlStatement;
            SQLSelectQuery sqlSelectQuery = sqlSelectStatement.getSelect().getQuery();

            if (sqlSelectQuery instanceof SQLSelectQueryBlock){//非union查询语句
                SQLSelectQueryBlock sqlSelectQueryBlock = (SQLSelectQueryBlock) sqlSelectQuery;
                //字段列表
                List<SQLSelectItem> selectItems = ((SQLSelectQueryBlock) sqlSelectQuery).getSelectList();
                //表名
                SQLTableSource table = sqlSelectQueryBlock.getFrom();

                log.info("tableName:{}",table.toString());

                SQLExpr where =sqlSelectQueryBlock.getWhere();
                if (where instanceof SQLBinaryOpExpr){//二元表达式
                    List<SQLBinaryOpExpr> wheres = new ArrayList<>();
                    processWhere(where,wheres);
                    wheres.forEach(sqlBinaryOpExpr -> {
                        if (sqlBinaryOpExpr.getOperator()==SQLBinaryOperator.Equality){
                            String key = sqlBinaryOpExpr.getLeft().toString();
                            String value = sqlBinaryOpExpr.getRight().toString();
                            params.put(key,value);
                        }
                    });
                    System.out.println();
                }else if (where instanceof SQLInSubQueryExpr){//子查询

                }
            }else if (sqlSelectQuery instanceof SQLUnionQuery){//union查询语句

            }


        }else if (sqlStatement instanceof SQLInsertStatement){//插入语句

        }else if (sqlStatement instanceof SQLUpdateStatement){//更新语句

        }else if (sqlStatement instanceof SQLDeleteStatement){//删除语句

        }
        return params;
    }
    //将where中的表达式装入params中,目前只装入了相等表达式
    private static void processWhere(SQLExpr where,List<SQLBinaryOpExpr> params){
        if (where instanceof SQLBinaryOpExpr){
            SQLBinaryOpExpr sqlBinaryOpExpr = (SQLBinaryOpExpr) where;
            if (sqlBinaryOpExpr.getOperator()==SQLBinaryOperator.BooleanAnd||sqlBinaryOpExpr.getOperator()==SQLBinaryOperator.BooleanOr){
                processWhere(sqlBinaryOpExpr.getLeft(),params);
                processWhere(sqlBinaryOpExpr.getRight(),params);
            }else if (sqlBinaryOpExpr.getOperator()==SQLBinaryOperator.Equality){
                params.add(sqlBinaryOpExpr);
            }
        }
    }
}
