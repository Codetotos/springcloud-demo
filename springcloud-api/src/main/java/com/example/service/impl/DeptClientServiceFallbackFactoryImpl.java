package com.example.service.impl;

import com.example.entity.Dept;
import com.example.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

// 熔断降级类
@Component
public class DeptClientServiceFallbackFactoryImpl implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            // 配置降级方法
            @Override
            public Dept findDeptById(Integer deptno) {
                return new Dept()
                        .setDeptno(deptno)
                        .setDeptname("没有对应的信息,服务降级,当前服务已经关闭")
                        .setDbSource("没有数据");
            }

            @Override
            public boolean insertDept(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> findAllDepts() {
                return null;
            }
        };
    }
}
