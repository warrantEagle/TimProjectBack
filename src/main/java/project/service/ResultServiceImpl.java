package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.*;

import java.util.List;
import java.util.Vector;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private final ResultRepository resultRepository;
    @Autowired
    private final PointRepository pointRepository;
    private int idResult;

    public ResultServiceImpl(ResultRepository resultRepository, PointRepository pointRepository) {
        this.resultRepository = resultRepository;
        this.pointRepository = pointRepository;
    }

    @Override
    public Result getResultByResultId(int idResult) {
        return resultRepository.findByIdResult(idResult);
    }

    @Override
    public Point[] getPointsByResultId(int idResult) {
        return pointRepository.findByIdResult(idResult);
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
        int a = -1;
        List<Result> results = findAll();
        if (results.size() > 0) {
            Vector<Integer> ids = new Vector<Integer>();
            for (int i = 0; i < results.size(); i++)
                ids.add(results.get(i).getIdResult());

            a = ids.get(0);
            for (int i = 0; i < ids.size(); i++) {

                if (ids.get(i) > a)
                    a = ids.get(i);
            }
        }
        result.setIdResult(a + 1);
        Result res = resultRepository.save(result);
        idResult = res.getIdResult();
        return null;
    }

    @Override
    public Point createPoints(Point[] point) {

        for (int i = 0; i < point.length; i++) {
            point[i].setIdResult(this.idResult);
            this.pointRepository.save(point[i]);
        }

        return null;
    }

    @Override
    public List<Result> findByLoginPerson(String loginPerson) {
        return resultRepository.findByLoginPerson(loginPerson);
    }
}
