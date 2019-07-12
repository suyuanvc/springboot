package com.cc.ssm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SessionConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new SessionInterceptor());
        /**
         * 添加拦截的路径
         * /为根路径
         * /*为一级路径
         * /** 为所有路径包括多级
         */
        interceptor.addPathPatterns("/**");

        //排除不拦截的，包括自己登录的页面不用拦截
        interceptor.excludePathPatterns("/login/login");
    }
}
