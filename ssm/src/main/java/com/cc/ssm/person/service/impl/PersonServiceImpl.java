package com.cc.ssm.person.service.impl;

import com.cc.ssm.person.entity.Person;
import com.cc.ssm.person.mapper.PersonMapper;
import com.cc.ssm.person.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2019-07-03
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public void add(Person person) {
        personMapper.add(person);
    }

    @Override
    public void delete(int id) {
        personMapper.delete(id);
    }

    @Override
    public Person getOne(int id) {
        return personMapper.getOne(id);
    }

    @Override
    public void update(Person person) {
        personMapper.update(person);
    }

    @Override
    public List<Person> all() {
        return personMapper.all();
    }
}
