package com.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.example.model.EmployeeEntity;
 
@Repository
public interface EmployeeRepository
        extends JpaRepository<EmployeeEntity, Long> {
 
}
