package com.spr.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spr.demo.models.User;
import com.spr.demo.dao.UserDao;

@RestController
public class AuthController {
  
  @Autowired
  private UserDao userDao;
  @PostMapping("api/login") 
  public boolean verify_credentials(@RequestBody User user){
    return userDao.verify_credentials(user);
  }
}
