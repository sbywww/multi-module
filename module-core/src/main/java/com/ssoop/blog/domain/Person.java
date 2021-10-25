package com.ssoop.blog.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Person {
    private Integer id;
    private String name;
    private Integer age;

    @Builder
    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void updatePerson(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
