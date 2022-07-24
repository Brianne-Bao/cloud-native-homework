# 概述

时间：7.16

地点：线上

内容：大作业目标、难点、分工以及第一阶段任务。

# 先知

1.  我们大作业的仓库地址https://gitee.com/keep-healthy/cloud-native-h.git。

   本来想用github的，但是太卡了，用这个好一点，刚好我们的百度也要求用这个。

2. 我们数据库的地址是106.14.220.67:3306,可以用自己的数据库管理软件连接试试，现在还没建表。

3. 后天开始正式写作业，王慧可以先去了解一下Jmeter的使用。包泽原可以先去了解一下Guava库中如何做到接口限流。

# 会议记录

+ 技术栈：Jekins持续集成，Prometheus metrics， Grafana,，go语言，kubebuilder，Rolling Update CRD，k8s HPA
+ 分工：
  + Jenkins持续集成和部署          练健恒 包泽原
  + 普罗米修斯和grafana部署     王慧     练健恒
  + rolling update crd                  包泽原 练健恒



+ 第一阶段：SpringBoot 开发

目标：提供两个接口，一个是 查询，一个是添加

实体类： cloud Player 

| 标签名      | 类别          | 约束          |
| -------- | ----------- | ----------- |
| id       | int         | primary key |
| name     | varchar(10) | not null    |
| position | varchar(10) | not null    |
| number   | int         | 无           |



| 名称                                       | 全限定名                                     |
| ---------------------------------------- | ---------------------------------------- |
| PlayerController.getPlayer(int id)       | public Object getPlayer(@PathVariable int id) |
| PlayerController.addPlayer(Player player) | public String addPlayer(@RequestBody Player player) |





