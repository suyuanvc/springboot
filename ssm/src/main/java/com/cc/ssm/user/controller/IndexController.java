package com.cc.ssm.user.controller;

import com.cc.ssm.user.entity.User;
import com.cc.ssm.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class IndexController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

   // @GetMapping("/login")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "index";
    }
    //@PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession httpSession, Model model) throws Exception{
        User user = userService.login(username,password);
        if(user != null){
            //log.debug(user.getNickname()+"登陆成功！");
            log.info(user.getNickname()+"登陆成功！");
            httpSession.setAttribute("user",user);
            model.addAttribute("user",user);
            return "login";
        }
        return "index";
    }

}
