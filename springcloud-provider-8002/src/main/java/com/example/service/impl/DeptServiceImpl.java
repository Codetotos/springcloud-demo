package com.example.service.impl;

import com.example.entity.Dept;
import com.example.mapper.DeptMapper;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired(required = false)
    private DeptMapper deptMapper;


    @Override
    public boolean insertDept(Dept dept) {
        return deptMapper.insertDept(dept);
    }

    @Override
    public List<Dept> findAllDepts() {
        DeptMapper deptMapper = this.deptMapper;
        List<Dept> allDepts = deptMapper.findAllDepts();
        return allDepts;
    }

    @Override
    public Dept findDeptById(Integer deptno) {
        return deptMapper.findDeptById(deptno);
    }
}
