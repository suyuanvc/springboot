package com.cc.ssm.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常捕获类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request ,Exception e)throws Exception{
        ModelAndView view = new ModelAndView();
        view.addObject("exception",e);
        view.addObject("url",request.getRequestURL());
        view.setViewName("errorPage");
        return view;
    }
}
