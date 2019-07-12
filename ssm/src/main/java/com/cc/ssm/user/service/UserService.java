package com.cc.ssm.user.service;

import com.cc.ssm.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

   public User login(String username, String password);

   public List<User> findAll();

   public User getUser(Integer id);

}
