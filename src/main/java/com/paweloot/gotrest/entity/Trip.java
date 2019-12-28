package com.paweloot.gotrest.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trasy")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_uzytk")
    private Tourist tourist;

    @Column(name = "data")
    private Date date;

    @Column(name = "punkty_got")
    private int gotPoints;

    @Column(name = "zatwierdzona")
    private boolean isApproved;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_trasy")
    private List<TripPoint> tripPoints;

    public Trip() {
    }

    public int getId() {
        return id;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGotPoints() {
        return gotPoints;
    }

    public void setGotPoints(int gotPoints) {
        this.gotPoints = gotPoints;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public List<TripPoint> getTripPoints() {
        return tripPoints;
    }

    public void setTripPoints(List<TripPoint> tripPoints) {
        this.tripPoints = tripPoints;
    }
}
