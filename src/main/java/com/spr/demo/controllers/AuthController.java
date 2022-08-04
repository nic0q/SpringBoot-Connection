package com.spr.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spr.demo.models.User;
import com.spr.demo.utilities.JWT;
import com.spr.demo.dao.UserDao;

@RestController
public class AuthController {
  
  @Autowired
  private UserDao userDao;
  @Autowired
  private JWT jwtutil;

  @PostMapping("api/login") 
  public String get_credentials(@RequestBody User user){
    if( userDao.verify_credentials(user) == null){
      String token = jwtutil.create(String.valueOf(user.getId()), user.getEmail());
      return token;
    }
    return null;
  }
}
