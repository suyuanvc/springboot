package com.cc.ssm.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 分页
 */
@Configuration
public class PageHelperConfig {
    /**
     * offsetAsPageNum:设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用.
     * rowBoundsWithCount:设置为true时，使用RowBounds分页会进行count查询.
     * reasonable：启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页.
     */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
