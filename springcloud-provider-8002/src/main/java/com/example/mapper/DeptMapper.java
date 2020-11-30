package com.example.mapper;

import com.example.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    boolean insertDept(Dept dept);

    List<Dept> findAllDepts();

    Dept findDeptById(Integer deptno);

}
