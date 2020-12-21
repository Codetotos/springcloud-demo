package com.example.controller;

import com.example.entity.Dept;
import com.example.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cursh
 */

// 提供Restful服务
@RestController
@RequestMapping("/provider")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixFindDeptById")
    @RequestMapping("/findDeptById/{deptno}")
    public Dept findDeptById(@PathVariable(value = "deptno") Integer deptno) {
        Dept dept = deptService.findDeptById(deptno);
        if (dept == null) {
            throw new RuntimeException("deptno=>" + deptno + ",不存在该用户,或信息无法找到!");
        }
        return dept;
    }

    public Dept hystrixFindDeptById(@PathVariable(value = "deptno") Integer deptno) {
        return new Dept()
                .setDeptno(deptno)
                .setDeptname("没有对应的对象,null --> @Hystrix")
                .setDbSource("no this database in MySQL");
    }
}
