package com.example.service;

import com.example.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-DEMO-PROVIDER/provider/")
public interface DeptClientService {

    @RequestMapping("/insertDept")
    public boolean insertDept(Dept dept);

    @RequestMapping("/findAllDepts")
    public List<Dept> findAllDepts() ;

    @RequestMapping("/findDeptById")
    public Dept findDeptById(Integer deptno) ;

}
