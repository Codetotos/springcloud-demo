package com.example.service;

import com.example.entity.Dept;

import java.util.List;

public interface DeptService {

    boolean insertDept(Dept dept);

    List<Dept> findAllDepts();

    Dept findDeptById(Integer deptno);
}
