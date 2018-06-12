package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.model.Person;
import project.model.Result;
import project.model.ResultRepository;
import project.service.PersonServiceImpl;
import project.service.ResultServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/result"})
public class ResultController {

    @Autowired
    private ResultServiceImpl resultServiceImpl;

    @GetMapping
    public List findAll(){
        return resultServiceImpl.findAll();
    }

    @PostMapping
    public Result create(@RequestBody Result result){
        return resultServiceImpl.create(result);
    }


    @DeleteMapping(value ={"/{result}"})
    public void deleteResultById(@PathVariable int id){
        Result result = resultServiceImpl.findById(id);
        if(result != null)
            resultServiceImpl.delete(result);
        //else logger
    }
}
