package com.kuang.dao;

import com.kuang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    //模拟数据库

    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer,Department>();

        departments.put(101,new Department(101,"education"));
        departments.put(102,new Department(102,"market"));
        departments.put(103,new Department(103,"research"));
        departments.put(104,new Department(104,"run"));
        departments.put(105,new Department(105,"food"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
