package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Person;
import project.model.PersonRepository;
import project.model.Result;
import project.model.ResultRepository;

import java.util.List;
@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private final ResultRepository resultRepository;

    @Autowired
    private final PersonRepository personRepository;

    public ResultServiceImpl(ResultRepository resultRepository, PersonRepository personRepository) {
        this.resultRepository = resultRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Result findById(int id) {
        return resultRepository.findById(id);
    }

    @Override
    public void delete(Result result) {
        this.resultRepository.delete(result);
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result create(Result result) {
        /*Result res = resultRepository.save(result);
        Person person = personRepository.findByLogin(result.getLoginPerson());
        res.Training(person);*/
        return resultRepository.save(result);
    }
}
