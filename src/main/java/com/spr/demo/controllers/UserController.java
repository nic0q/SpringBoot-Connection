package com.spr.demo.controllers;

import com.spr.demo.dao.UserDao;
import com.spr.demo.models.User;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {
  @Autowired
  private UserDao userDao;
  // @RequestMapping("/user/{id}")
  //   public User getUser(@PathVariable  int id){
  //     return users;
  // }
  @RequestMapping("/users")
    public List<User> getUsers(){
      return userDao.getUsers();
  }
}
