package com.example.first_gradle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="temp_users")
public class Users {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private long id;

  @Column(name="name")
  private String name;

  @Column(name="email")
  private String email;

  @Column(name="age")
  private int age;

  @Column(name="salary")
  private double salary;



  public Users(){
    super();
  }

  public Users(int id, String name, String email, int age, double salary){
    super();
    this.id = id;
    this.email = email;
    this.age = age;
    this.salary = salary;

  }

  public long getId(){
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Users [id=" + id + ", email=" + email + ", age=" + age + ", salary=" + salary + "]";
  }
}

