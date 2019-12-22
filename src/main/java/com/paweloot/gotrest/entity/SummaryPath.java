package com.paweloot.gotrest.entity;


public class SummaryPath {

    private String from;

    private String to;

    private int points;

    public SummaryPath(String from, String to, int points) {
        this.from = from;
        this.to = to;
        this.points = points;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
