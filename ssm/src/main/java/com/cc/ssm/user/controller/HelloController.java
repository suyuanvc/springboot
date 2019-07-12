package com.cc.ssm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello (Model model) throws Exception{
        model.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
       int flag = 3/0;
        return "hello";
    }
}
