package com.example.avners.utils;

public class Record {
    private String name;
    private int score;
    private double lon, lat;


    public Record() {
    name = "Avner";
    }

    public Record(String winnerName, int winnerScore, double x, double y) {
    name = winnerName;
    score = winnerScore;
    lon = x;
    lat = y;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return  name + ", Score: " + score ;
    }
}

