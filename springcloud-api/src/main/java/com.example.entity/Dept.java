package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Integer deptno;


    private String deptname;

    private String dbSource ;

    public Dept(String deptname) {
        this.deptname = deptname;
    }


}

