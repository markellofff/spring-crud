package com.example.first_gradle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_gradle.entity.Users;
import com.example.first_gradle.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
  
  @Autowired
  private UserService userService;

  @GetMapping("/allUsers")
  public ResponseEntity<List<Users>> getAllUsers () {
    List <Users> users = null;
    try {
      users = userService.getAllUSers();
    } catch (Exception e) {
      e.getMessage();
    }
    return ResponseEntity.ok(users);
  }

  @GetMapping("/getById/{id}")
  public ResponseEntity<Users> getUserById (@PathVariable("id") int userId) {
    Users user = null;
    user = userService.getUserById(userId);
    return ResponseEntity.ok(user);
  }

  @PostMapping("/createOrUpdate")
  public ResponseEntity<Users> createOrUpdate(@RequestBody Users user) {
    Users newUser = null;
    try {
      newUser = userService.addOrUpdateUser(user);
    } catch (Exception e) {
      return (ResponseEntity<Users>) ResponseEntity.unprocessableEntity();
    }
    return ResponseEntity.ok(newUser);
  }


  @DeleteMapping("/deleteById/{id}")

  public ResponseEntity<Users> deleteUserById (@PathVariable("id") int userId) {
    Users user = null;
    try {
      user = userService.deleteUser(userId);
    } catch (Exception e) {
      return (ResponseEntity<Users>) ResponseEntity.unprocessableEntity();
    }
    return ResponseEntity.ok(user);
  }
}
