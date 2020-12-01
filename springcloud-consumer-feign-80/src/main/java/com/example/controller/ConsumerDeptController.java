package com.example.controller;

import com.example.entity.Dept;
import com.example.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerDeptController {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("add")
    public Boolean insertDept(Dept dept) {
        return deptClientService.insertDept(dept);
    }

    @RequestMapping("list")
    public List findAllDepts() {
        return deptClientService.findAllDepts();
    }

    @RequestMapping("/findDeptById/{deptno}")
    public Dept findDeptById(@PathVariable("deptno") Integer deptno) {
        return deptClientService.findDeptById(deptno);
    }
}
