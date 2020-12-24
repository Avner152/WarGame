package com.example.avners.utils;

public class Score {
    private String name1, name2;
    private int score1, score2;
    private long time;

    public Score(){
        score1 = score2 = 0;
        time = 0;
    }

    public Score(int s1, int s2, long time){
        score1 = s1;
        score2 = s2;
        this.time = time;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public long getTime() {
        return time;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
