package com.spr.demo.controllers;

import com.spr.demo.dao.UserDao;
import com.spr.demo.models.User;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
  @Autowired
  private UserDao userDao;
  @GetMapping("api/users")
  public List<User> getUsers(){
    return userDao.get_users();
  }
  @GetMapping("api/users/{id}")
  public User get_user(@PathVariable int id){
    return userDao.get_user(id);
  }
  @PostMapping("api/create_user") 
  public String create_User(@RequestBody User user){
    return userDao.create_user(user);
  }
  @PutMapping("api/edit_user/{id}")
  public User edit_User(@PathVariable int id){
    return userDao.edit_user(id); 
  }
  @DeleteMapping("api/delete_user/{id}")
  public String delete_user(@PathVariable int id){
    return userDao.delete_user(id); 
  }
}
