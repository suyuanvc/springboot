package com.cc.ssm.person.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 *
 * @author cc
 * @since 2019-07-03
 */
public class Person implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   // @DateTimeFormat(pattern="yyyy-MM-dd")//set
   // @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")//get
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    //@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")//get
    public Date getBirthday() {
        return birthday;
    }
   // @DateTimeFormat(pattern="yyyy-MM-dd")//set
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
        "id=" + id +
        ", name=" + name +
        ", age=" + age +
        ", birthday=" + birthday +
        "}";
    }
}
