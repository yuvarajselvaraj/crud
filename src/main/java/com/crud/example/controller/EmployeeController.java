package com.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.exception.RecordNotFoundException;
import com.crud.example.model.EmployeeEntity;
import com.crud.example.service.EmployeeService;
@RestController

public class EmployeeController
{
    @Autowired
    EmployeeService service;
    
 
    @RequestMapping(value="/employees", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
 
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @RequestMapping(value="/employees", method = RequestMethod.POST)
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
    	
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    	
    }
 
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}