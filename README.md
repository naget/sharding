# How To 分库分表

这个项目仅仅以记录思路为目标，作为一个演示而存在。将以**不同分支代表不同阶段**的方式来记录分库分表的历程，比如master分支是一个单库单表的操作示例，version2分支展现的是使用**mybatis插件**来扩充自己的逻辑，完成分表操作；version3分支是使用**sharding-jdbc**来完成分表操作。未来分库，以及使用其他分库分表组件的示例会有对应新的分支的出现。

### 本地演示demo
1. clone项目
2. 拉取对应分支（各个demo与分支对应关系详见文末）
3. 执行resources/sql/dump.sql，初始化本地mysql数据
4. 执行测试用例

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


### sql初始化文件
resources/sql/dump.sql

### 各个分支与demo对应关系
|分支|demo|
|--|--|
|master|单库单表操作|
|version2|使用mybatis插件实现分表|
|versinn3|使用sharding-jdbc实现分表|
|version4|使用shardingsphere实现分表|
