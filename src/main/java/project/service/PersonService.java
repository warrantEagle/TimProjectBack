package project.service;

import project.model.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);
    List<Person> findAllPeople();
    Person findByLogin(String login);
    void delete(Person person);
}
