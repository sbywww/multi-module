package com.ssoop.blog.dao;

import com.ssoop.blog.domain.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonDao {
    void save(Person person);
    Person getPerson(Integer id);
    List<Person> getPersonList();
    void update(Person person);
}
