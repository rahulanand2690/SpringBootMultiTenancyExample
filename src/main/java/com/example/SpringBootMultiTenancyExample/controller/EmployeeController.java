package com.example.SpringBootMultiTenancyExample.controller;

import com.example.SpringBootMultiTenancyExample.dao.EmployeeDAO;
import com.example.SpringBootMultiTenancyExample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "emploeeList")
    public java.util.List<Employee> emploeeList() {
        return employeeDAO.findAll();
    }

    @PostConstruct
    public void addAdmissionsData() {
        employeeDAO.saveAll(Stream.of(
                new Employee(100, "Emp_Tenent_Init", "Init_Role"))
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "emploeeList", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Employee employee) {
        Employee tempEmployee = new Employee();
        tempEmployee.setEmployeeId(employee.getEmployeeId());
        tempEmployee.setEmployeeName(employee.getEmployeeName());
        tempEmployee.setEmployeeRole(employee.getEmployeeRole());
        employeeDAO.save(tempEmployee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
