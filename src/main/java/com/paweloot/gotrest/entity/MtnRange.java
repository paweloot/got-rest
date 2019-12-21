package com.paweloot.gotrest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pasma_gorskie")
public class MtnRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa_pasma")
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pasma")
    private List<MtnGroup> mtnGroups;

    public MtnRange() {

    }

    public MtnRange(String name, String url) {
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MtnGroup> getMtnGroups() {
        return mtnGroups;
    }

    public void setMtnGroups(List<MtnGroup> mtnGroups) {
        this.mtnGroups = mtnGroups;
    }
}
