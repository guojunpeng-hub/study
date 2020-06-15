package com.springcloud.controller;

import com.springcloud.entities.Column;
import com.springcloud.entities.Dept;
import com.springcloud.service.ColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "Server")
@RestController
@RequestMapping(value = "/column")
public class ColumnController {


    @Autowired
    private ColumnService columnService;

    @PostMapping(value = "/add")
    public  boolean add(@RequestBody Column column){
        return columnService.addDept(column);
    }

    @PostMapping(value = "/update")
    public  int update(@RequestBody Column column){
        return columnService.update(column);
    }
    @PostMapping(value = "/delete")
    public  int delete(@RequestBody Column column){
        return columnService.delete(column);
    }
    @PostMapping(value = "/findAll")
    public List<Column> findAll(){
        return columnService.findAll();
    }
}
