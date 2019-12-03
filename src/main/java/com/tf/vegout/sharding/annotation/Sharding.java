package com.tf.vegout.sharding.annotation;

import com.tf.vegout.sharding.enums.ShareType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sharding {
    /**
     * 表名称
     * @return
     */
    String tableName()  default "";


    /**
     * 分表策略
     * @return
     */
    ShareType shareType() default ShareType.MOD;


    /**
     * 分表数量
     * @return
     */
    int tableNum() default 0;

    /**
     * 分表字段名称
     * @return
     */
    String shareBy() default "";

}
