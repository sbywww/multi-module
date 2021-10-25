package com.ssoop.blog.service;

import com.ssoop.blog.dao.PersonDao;
import com.ssoop.blog.domain.Person;
import com.ssoop.blog.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonDao personDao;

    @Transactional
    public void addPerson(PersonDTO personDTO) {
        Person person = Person.builder()
                .name(personDTO.getName())
                .age(personDTO.getAge())
                .build();
        personDao.save(person);
    }

    @Transactional(readOnly = true)
    public PersonDTO getPerson(Integer id) {
        Person person = personDao.getPerson(id);
        return PersonDTO.of(person);
    }

    @Transactional(readOnly = true)
    public List<PersonDTO> getPersonList() {
        List<Person> people = personDao.getPersonList();
        return PersonDTO.of(people);
    }

    @Transactional
    public void updatePerson(Integer personId, PersonDTO personDTO) {
        Person person = personDao.getPerson(personId);
        if (person == null) throw new IllegalArgumentException();

        person.updatePerson(personDTO.getId(), personDTO.getName(), personDTO.getAge());
        personDao.update(person);
    }
}
