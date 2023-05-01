package com.example.first_gradle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.first_gradle.entity.Users;

@Repository
public interface UserRepository  extends CrudRepository<Users, Integer>{
  
}
