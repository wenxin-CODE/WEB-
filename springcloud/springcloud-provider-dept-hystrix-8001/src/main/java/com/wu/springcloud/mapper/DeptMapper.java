package com.wu.springcloud.mapper;

import com.wu.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    //添加部门
    boolean addDept(Dept dept);

    //根据ID查询部门
    Dept queryById(@Param("deptno") long id);

    //查询全部部门
    List<Dept> queryall();
}
