package com.crud.example.repository;
import org.springframework.data.repository.CrudRepository;

import com.crud.example.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}