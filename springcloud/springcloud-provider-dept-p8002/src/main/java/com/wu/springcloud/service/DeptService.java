package com.wu.springcloud.service;

import com.wu.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryById(long id);

    List<Dept> queryall();

}

