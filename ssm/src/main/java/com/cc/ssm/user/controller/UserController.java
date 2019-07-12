package com.cc.ssm.user.controller;

import com.cc.ssm.user.dao.UserMapper;
import com.cc.ssm.user.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/add")
    public String addUser(User user)throws Exception{
        System.out.println(user.getNickname());
        userMapper.save(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) throws Exception{
        userMapper.delete(id);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/get/{id}")
    public String getUser(@PathVariable("id") Integer id, Model model) throws Exception{
        User user = userMapper.get(id);
        model.addAttribute("user",user);
        return "user";
    }

    @RequestMapping("/update")
    public String updateUser(User user) throws Exception{
        userMapper.update(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findAll")
    public String listUser (Model model, @RequestParam(value = "start",defaultValue = "0") int start,
                            @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id desc");
        List<User> users = userMapper.findAll();
        PageInfo<User> page = new PageInfo<>(users);
        model.addAttribute("page",page);
        return "userList";
    }
}
