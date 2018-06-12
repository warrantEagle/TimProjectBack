package project.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {

    Result findById(int id);
    void delete(Result result);
    List<Result> findAll();
    Result save(Result result);
}
