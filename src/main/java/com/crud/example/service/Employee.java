package com.crud.example.service;

import java.util.List;

import com.crud.example.exception.RecordNotFoundException;
import com.crud.example.model.EmployeeEntity;

public interface Employee {
	public List<EmployeeEntity> getAllEmployees();
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException;
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException;
	public void deleteEmployeeById(Long id) throws RecordNotFoundException;
	
}
