package com.paweloot.gotrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "turysci")
public class Tourist {

    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_uzytk")
    @MapsId
    private User user;

    @Column(name = "punkty_got")
    private int gotPoints;

    public Tourist() {
    }

    public Tourist(User user, int gotPoints) {
        this.user = user;
        this.gotPoints = gotPoints;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getGotPoints() {
        return gotPoints;
    }

    public void setGotPoints(int gotPoints) {
        this.gotPoints = gotPoints;
    }
}
