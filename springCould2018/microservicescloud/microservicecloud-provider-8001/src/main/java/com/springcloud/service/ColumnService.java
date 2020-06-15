package com.springcloud.service;

import com.springcloud.entities.Column;

import java.util.List;

public interface ColumnService {
    public boolean addDept(Column column);

    public  Column findById(String id);

    public List<Column> findAll();

    public int update(Column cl);

    public int delete(Column column);
}
