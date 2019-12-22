package com.paweloot.gotrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "punkty")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa_punktu")
    private String name;

    @Column(name = "wysokosc")
    private int height;

    @ManyToOne
    @JoinColumn(name = "id_grupy")
    private MtnGroup mtnGroup;

    public Point() {

    }

    public Point(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public MtnGroup getMtnGroup() {
        return mtnGroup;
    }

    public void setMtnGroup(MtnGroup mtnGroup) {
        this.mtnGroup = mtnGroup;
    }
}
