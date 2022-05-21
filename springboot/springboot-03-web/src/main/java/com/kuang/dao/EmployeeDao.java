package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
//这是因为该注解的作用不只是将类识别为Bean，同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型。
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    //自动导入
    private DepartmentDao departmentDao;

//    这个在类创建时首先被加载
    static {
        employees = new HashMap<Integer,Employee>();

        employees.put(1001,new Employee(1001,"AA","111@qq.com",0,new Department(101,"education")));
        employees.put(1002,new Employee(1002,"bb","111@qq.com",1,new Department(102,"market")));
        employees.put(1003,new Employee(1003,"cc","111@qq.com",0,new Department(103,"research")));
        employees.put(1004,new Employee(1004,"dd","111@qq.com",1,new Department(104,"run")));
        employees.put(1005,new Employee(1005,"ee","111@qq.com",0,new Department(105,"food")));
    }

//    主键自增
    private static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }


}
