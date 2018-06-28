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
    @GeneratedValue()
    private Long id;

    private int idResult;
    private double kcal;
    private double length;

    public double getPace() {
        return pace;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    private double pace;
    long time;
    private String loginPerson;
    private long date;

    public Result() {
    }

    public Result(double kcal, double length,double pace, long time, long date, String loginPerson) {
        this.kcal = kcal;
        this.length = length;
        this.time = time;
        this.loginPerson = loginPerson;
        this.date = date;
        this.pace = pace;
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

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLoginPerson() {
        return loginPerson;
    }

    public void setLoginPerson(String loginPerson) {
        this.loginPerson = loginPerson;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

}
