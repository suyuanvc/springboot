package com.cc.ssm.person.mapper;

import com.cc.ssm.person.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2019-07-03
 */
@Mapper
@Repository
public interface PersonMapper{

    public void add(Person person);

    public void delete( int id);

    public Person getOne(int id);

    public  void update(Person person);

    public List<Person> all();

}
