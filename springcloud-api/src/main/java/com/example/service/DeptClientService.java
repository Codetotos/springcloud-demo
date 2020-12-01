package com.example.service;

import com.example.entity.Dept;
import com.example.service.impl.DeptClientServiceFallbackFactoryImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * value:配置负载均衡下面的名称
 * fallback: 配置单个回调方法
 * fallbackFactory: 配置一批回调方法
 */
@FeignClient(value = "SPRINGCLOUD-DEMO-PROVIDER/provider/",fallbackFactory = DeptClientServiceFallbackFactoryImpl.class)
@Component
public interface DeptClientService {

    @RequestMapping("/add")
    boolean insertDept(Dept dept);

    @RequestMapping("/list")
    List findAllDepts();

    @RequestMapping("/findDeptById/{deptno}")
    Dept findDeptById(@PathVariable("deptno") Integer deptno);

}
