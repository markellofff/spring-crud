package com.example.first_gradle.service;

import java.util.List;

import com.example.first_gradle.entity.Users;

public interface UserService {
  
  public List<Users> getAllUSers();
  public Users getUserById(long userId);
  public Users addOrUpdateUser(Users user);
  public Users deleteUser(long userId) throws Exception;
}
