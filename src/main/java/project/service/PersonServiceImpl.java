package project.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Person;
import project.model.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }




    @Override
    public void delete(Person person){
        personRepository.delete(person);
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }
    @Override
    public List<Person> findAllPeople(){

        return personRepository.findAll();
    }

    @Override
    public Person findByLogin(String login) {
        return personRepository.findByLogin(login);
    }


}
