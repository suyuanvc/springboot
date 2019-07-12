package com.cc.ssm.person.service;

import com.cc.ssm.person.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2019-07-03
 */
@Component
public interface IPersonService{

    public void add(Person person);

    public void delete(int id);

    public Person getOne(int id);

    public  void update(Person person);

    public List<Person> all();

}
