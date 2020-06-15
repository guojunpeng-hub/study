package com.springcloud.service.impl;

import com.springcloud.dao.ColumnDao;
import com.springcloud.entities.Column;
import com.springcloud.service.ColumnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ColumnServiceImpl implements ColumnService {

    @Resource
    private ColumnDao columnDao;


    @Override
    public boolean addDept(Column column) {
        column.setId(UUID.randomUUID().toString());
//        新增后进行排序，防止插入排序
        List<Column> list = findAll();
        for (Column column1:list){
            if(column1.getColumnOrder() >= column.getColumnOrder()){
                column1.setColumnOrder(column1.getColumnOrder()+1);
                update(column1);
            }
        }
        return columnDao.addDept(column);
    }

    @Override
    public Column findById(String id) {
        return columnDao.findById(id);
    }

    @Override
    public List<Column> findAll() {
        return columnDao.findAll();
    }

    @Override
    public int update(Column cl) {
        //        修改前进行排序
        List<Column> list = findAll();
//        移除相等的数据
        int begin = 0;
        int end = 0; //初始化最终位置 + 为后，-为前
        for (int i=0;i<list.size();i++) {
            if(list.get(i).getId().equals(cl.getId())){
//                  < 相后挪动    >向前挪动
                   begin = list.get(i).getColumnOrder();
                   end = cl.getColumnOrder();
                   break;
            }
            }
        if(begin<end){
            for(int i = begin;i<end;i++){
                columnDao.update(list.get(i).setColumnOrder(list.get(i).getColumnOrder()-1));
            }
        }else {
            for(int j=end;j<begin;j++){
                columnDao.update(list.get(j).setColumnOrder(list.get(j).getColumnOrder()+1));
            }
        }
        return columnDao.update(cl);
    }

    @Override
    public int delete(Column column) {
        //        删除前进行排序
        List<Column> list = findAll();
        for(Integer i=0;i<list.size();i++){
            if(!list.get(i).getId().equals(column.getId()) && list.get(i).getColumnOrder() > column.getColumnOrder()){
                columnDao.update(list.get(i).setColumnOrder(list.get(i).getColumnOrder()-1));
            };
        }
        return columnDao.delete(column);
    }
}
