package project.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Vector;

public interface PersonRepository extends CrudRepository<Person, String> {

    Person findByLogin(String login);
    List<Person> findAll();
    Person save(Person person);
    void delete(Person person);


}
