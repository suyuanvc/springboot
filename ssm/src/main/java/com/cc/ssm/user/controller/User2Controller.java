package com.cc.ssm.user.controller;

import com.cc.ssm.user.entity.User;
import com.cc.ssm.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user2")
public class User2Controller {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<User> getUserAll(@RequestParam(value = "start", defaultValue = "0") int start,
                                 @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id desc");
        List<User> users = userService.findAll();
        PageInfo<User> page = new PageInfo<>(users);
        return page.getList();
    }
    //@RequestMapping(value = "/see",method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public Object getUser(@PathVariable("id") Integer id){
        User user = userService.getUser(id);
        return user;
    }
    @PutMapping("user")
    public void addUser(@RequestBody User user)throws  Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据：" + user);
    }

}
