package com.cc.ssm.user.dao;

import com.cc.ssm.user.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public User login(@Param("username") String username, @Param("password") String password);

    public List<User> findAll();

    @Select("select * from T_user;")
    public  List<User> findAll1();

    public User getUser(@Param("id") Integer id);

    @Insert("insert into T_user(nickname,username,password) values( #{nickname}, #{username}, #{password} )")
    public int save(User user);

    @Delete("delete from T_user where id = #{id}")
    public void delete(int id);

    @Select("select * from T_user where id = #{id}")
    public User get(int id);

    @Update("update T_user set nickname = #{nickname} where id = #{id}")
    public void update(User user);
}
