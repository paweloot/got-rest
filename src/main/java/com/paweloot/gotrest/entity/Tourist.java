package com.paweloot.gotrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "turysci")
public class Tourist {

    @Id
    @OneToOne
    @JoinColumn(name = "id_uzytk")
    private User user;

    @Column(name = "punkty_got")
    private int gotPoints;

    public Tourist() {
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
