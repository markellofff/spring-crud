package com.example.first_gradle.service.implimentations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_gradle.entity.Users;
import com.example.first_gradle.repository.UserRepository;
import com.example.first_gradle.service.UserService;

@Service
public class UserServiceImplimentations implements UserService{

  @Autowired
  private UserRepository userRepository;
  @Override
  public List<Users> getAllUSers() {
    return (List<Users>) userRepository.findAll();
  }
  
  @Override
  public Users getUserById(long userId) {
    return userRepository.findById((int) userId).orElse(null);
  }

  @Override
  public Users addOrUpdateUser(Users user) {
    return userRepository.save(user);
  }
  
  @Override
  public Users deleteUser(long userId) throws Exception{
    Users deletedUser = null;
    try {
      deletedUser = userRepository.findById((int) userId).orElse(null);
      if (deletedUser != null) {
        userRepository.deleteById((int) userId);
      } else {
        throw new Exception("User Not found for userId: " + userId);
      }
    } catch (Exception e) {
      throw e;
    }
    return deletedUser;
  }
}
