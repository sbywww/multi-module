package com.ssoop.blog.dto;

import com.ssoop.blog.domain.Person;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonDTO {
    private Integer id;
    private String name;
    private Integer age;

    public static PersonDTO of(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .age(person.getAge())
                .build();
    }

    public static List<PersonDTO> of(List<Person> list) {
        return list.stream().map(PersonDTO::of).collect(Collectors.toList());
    }
}
