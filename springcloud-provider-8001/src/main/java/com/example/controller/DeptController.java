package com.example.controller;

import com.example.entity.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/insertDept")
    public boolean insertDept(Dept dept) {
        return deptService.insertDept(dept);
    }

    @RequestMapping("/findAllDepts")
    public List<Dept> findAllDepts() {
        return deptService.findAllDepts();
    }

    @RequestMapping("/findDeptById")
    public Dept findDeptById(Integer deptno) {
        System.out.println("deptno = " + deptno);
        return deptService.findDeptById(deptno);
    }

}
