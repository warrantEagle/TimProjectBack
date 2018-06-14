package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Person;
import project.model.Point;
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

    /*@GetMapping
    public List findAll(){
        return resultServiceImpl.findAll();
    }*/
    @GetMapping(value={"findAllResult"})
    public ResponseEntity<?>  findAll(){
        return new ResponseEntity<>(resultServiceImpl.findAll(),HttpStatus.OK);
    }




    @PostMapping(value={"/createResult"})
    public ResponseEntity<?>  create(@RequestBody Result result){

        return new ResponseEntity<>(resultServiceImpl.create(result),HttpStatus.OK);
    }
    @PostMapping(value={"/createPoints"})
    public ResponseEntity<?>  createPoints(@RequestBody Point[] point){

        if ((point!=null))
            return new ResponseEntity<>(resultServiceImpl.createPoints(point),HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping(value ={"/{result}"})
    public ResponseEntity<?>  deleteResultById(@PathVariable int id){
        Result result = resultServiceImpl.findById(id);
        if(result != null)
        return new ResponseEntity<>(true,HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
