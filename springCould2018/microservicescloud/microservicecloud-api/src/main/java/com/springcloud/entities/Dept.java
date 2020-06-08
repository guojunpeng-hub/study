package com.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data  // 此为setget的注解
@Accessors(chain = true)
public class Dept implements Serializable {
//  Dept(Entity) orm mysql->Dept(table) 关系映射
    private Long deptno;// 主键
    private  String dname; // 部门名称
    private String db_source;// 来自哪个数据库，因为微服务架构可以一个微服务对应一个数据库，同一个信息被存储到不同的数据库

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDname("小郭").setDeptno(111l).setDb_source("mysql");
    }
}
