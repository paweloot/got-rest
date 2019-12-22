package com.paweloot.gotrest.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PathId implements Serializable {

    @Column(name = "id_punkt_z")
    private int idFrom;

    @Column(name = "id_punkt_do")
    private int idTo;

    public PathId() {
    }

    public PathId(int idFrom, int idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    public int getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(int idFrom) {
        this.idFrom = idFrom;
    }

    public int getIdTo() {
        return idTo;
    }

    public void setIdTo(int idTo) {
        this.idTo = idTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathId pathId = (PathId) o;
        return idFrom == pathId.idFrom &&
                idTo == pathId.idTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFrom, idTo);
    }
}
