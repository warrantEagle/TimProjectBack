package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import project.model.Person;
import project.service.PersonServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class PersonController {

    @Autowired
    private PersonServiceImpl personServiceImpl;


    @GetMapping
    public List findAll(){
        return personServiceImpl.findAllPeople();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personServiceImpl.create(person);
    }
    @DeleteMapping(value ={"/{login}"})
    public void deletePersonByLogin(@PathVariable String login){
        Person person = personServiceImpl.findByLogin(login);
        if(person != null)
            personServiceImpl.delete(person);
        //else logger
    }
    @GetMapping(value="/{login}")
    public Person getPersonByPesel(@PathVariable String login){
        return this.personServiceImpl.findByLogin(login);
    }
    @GetMapping("/hi")
    public String hi() {
        return "Hello World from dupadupa API";
    }
    @GetMapping("/")
    public String home(){
        System.out.println("adwaduuioawd");
        return "adwaduuioawd";
    }


}
