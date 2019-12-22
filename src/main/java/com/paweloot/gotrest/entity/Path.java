package com.paweloot.gotrest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "odcinki")
public class Path {

    @EmbeddedId
    private PathId id;

    @Column(name = "dlugosc")
    private int length;

    @Column(name = "roznica_wysokosci")
    private int heightDiff;

    @Column(name = "punkty_got")
    private int gotPoints;

    @Column(name = "punkty_got_powrot")
    private int gotPointsReturn;

    public Path() {

    }

    public Path(int idFrom, int idTo, int length, int heightDiff, int gotPoints, int gotPointsReturn) {
        this.id = new PathId(idFrom, idTo);
        this.length = length;
        this.heightDiff = heightDiff;
        this.gotPoints = gotPoints;
        this.gotPointsReturn = gotPointsReturn;
    }

    public PathId getId() {
        return id;
    }

    public void setId(PathId id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeightDiff() {
        return heightDiff;
    }

    public void setHeightDiff(int heightDiff) {
        this.heightDiff = heightDiff;
    }

    public int getGotPoints() {
        return gotPoints;
    }

    public void setGotPoints(int gotPoints) {
        this.gotPoints = gotPoints;
    }

    public int getGotPointsReturn() {
        return gotPointsReturn;
    }

    public void setGotPointsReturn(int gotPointsReturn) {
        this.gotPointsReturn = gotPointsReturn;
    }
}
