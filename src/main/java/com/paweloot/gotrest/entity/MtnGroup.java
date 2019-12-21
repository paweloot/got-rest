package com.paweloot.gotrest.entity;

import javax.persistence.*;

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
}
