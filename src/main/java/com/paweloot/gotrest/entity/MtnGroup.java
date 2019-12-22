package com.paweloot.gotrest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupy_gorskie")
public class MtnGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kod_grupy")
    private String code;

    @Column(name = "nazwa_grupy")
    private String name;

    @OneToMany(mappedBy = "mtnGroup", fetch = FetchType.EAGER)
    private List<Point> points;

    public MtnGroup() {

    }

    public MtnGroup(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        if (points == null) {
            points = new ArrayList<>();
        }

        points.add(point);
        point.setMtnGroup(this);
    }
}
