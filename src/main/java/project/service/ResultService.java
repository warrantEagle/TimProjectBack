package project.service;

import project.model.Point;
import project.model.Result;

import java.util.List;

public interface ResultService {

    void delete(Result result);
    List<Result> findAll();
    Result create(Result result);
    List<Result> findByLoginPerson(String loginPerson);
    Point createPoints(Point[] point);
    Result getResultByResultId(int idResult);
}
