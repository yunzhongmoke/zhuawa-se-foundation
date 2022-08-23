package com.w.mhl.service;

import com.w.mhl.dao.EmployeeDAO;
import com.w.mhl.domain.Employee;

/**
 * @author blue
 * @version 1.0
 * 该类完成对employee表的各种操作(通过调用EmployeeDAO对象完成)
 */
public class EmployeeService {

    //定义一个EmployeeDAO 属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //根据empId 和 pwd 返回一个Employee对象
    //如果查询不到就返回null
    public Employee getEmployeeByIdAndPwd(String empId, String pwd){
        Employee employee = employeeDAO.querySingle("select empId, pwd from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
        return  employee;
    }
}
