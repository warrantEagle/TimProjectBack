package project.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRepository extends CrudRepository<Point, String> {

    Point[] findByIdResult(int idResult);
    Point save (Point point);
}
