package com.paweloot.gotrest.trip;

import java.util.Date;
import java.util.List;

public class PostTripBody {

    private int userId;
    private Date date;
    private int gotPoints;
    private List<Integer> pointsIds;

    public PostTripBody() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public List<Integer> getPointsIds() {
        return pointsIds;
    }

    public void setPointsIds(List<Integer> pointsIds) {
        this.pointsIds = pointsIds;
    }
}
