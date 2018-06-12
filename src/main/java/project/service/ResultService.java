package project.service;

import project.model.Result;

import java.util.List;

public interface ResultService {

    Result findById(int id);
    void delete(Result result);
    List<Result> findAll();
    Result create(Result result);
}
