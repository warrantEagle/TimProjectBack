package project.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@Getter
@Setter
@NodeEntity
public class Point {

    @Id
    @GeneratedValue
    private Long id;


    private int idResult;
    private int index;
    private double longitude;
    private double latitude;

    public Point() {
    }

    public Point(double longitude, double latitude, int index) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.index = index;
    }

/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }*/
}
