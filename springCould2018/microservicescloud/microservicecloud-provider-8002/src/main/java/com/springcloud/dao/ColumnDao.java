package com.springcloud.dao;

import com.springcloud.entities.Column;
import com.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ColumnDao {


    public boolean addDept(Column column);

    public  Column findById(@Param("id") String id);

    public List<Column> findAll();

    public int update(Column cl);

    public int delete(Column column);


}
