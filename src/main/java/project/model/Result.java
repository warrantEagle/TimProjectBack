package project.model;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import project.controller.PersonController;

import java.util.*;
import java.util.stream.Collectors;

@NodeEntity
public class Result {

    @Id
    @GeneratedValue
    private Long id;


    private int kcal, length,time;
    private String loginPerson;
    private Date date;
    private Point[] points;

    public Result() {
    }

    public Result(int kcal, int length, int time, String loginPerson, Date date, Point[] points) {
        this.kcal = kcal;
        this.length = length;
        this.time = time;
        this.loginPerson = loginPerson;
        this.date = date;
        this.points = points;
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "Training", direction = Relationship.INCOMING)
    public Set<Person> training;

    public void Training(Person person) {
        if (training == null) {
            training = new HashSet<>();
        }
        training.add(person);
    }

    @Override
    public String toString() {
        return "Result{" +
                "ide=" + id +
                ", kcal=" + kcal +
                ", length=" + length +
                ", time=" + time +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLoginPerson() {
        return loginPerson;
    }

    public void setLoginPerson(String loginPerson) {
        this.loginPerson = loginPerson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
}
