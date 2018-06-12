package project.model;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NodeEntity
public class Person {

    @Id
    private String login;

    private String name, surname,sex,password;
    private int weight, height,age;

    private Person() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public Person(String login, String name, String surname, String sex, String password, int weight, int height, int age) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "Training", direction = Relationship.UNDIRECTED)
    public Set<Result> training;

    public void Training(Result result) {
        if (training == null) {
            training = new HashSet<>();
        }
        training.add(result);
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
