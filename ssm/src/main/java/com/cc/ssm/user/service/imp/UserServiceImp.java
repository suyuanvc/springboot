package com.cc.ssm.user.service.imp;

import com.cc.ssm.user.dao.UserMapper;
import com.cc.ssm.user.entity.User;
import com.cc.ssm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username , String password) {
        return userMapper.login(username,password);
    }

    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }
}
