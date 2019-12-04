# How To 分库分表

这个项目仅仅以记录思路为目标，作为一个演示而存在。将以**不同分支代表不同阶段**的方式来记录分库分表的历程，比如master分支是一个单库单表的操作示例，version2分支展现的是使用**mybatis插件**来扩充自己的逻辑，完成分表操作；version3分支是使用**sharding-jdbc**来完成分表操作。


### 开发环境：

 - 组件：springboot+mybatisplus+mysql
 - ide：idea


|组件|版本  |
|--|--|
| jdk |1.8  |
|springboot|2.2.1.RELEASE|
|mybatis-plus|3.2.0|
|mysql|8.0.18|
|mysql-connector-java|5.1.48|
|sharding-jdbc-spring-boot-starter|3.0.0.M1|
|druid|1.1.20|

