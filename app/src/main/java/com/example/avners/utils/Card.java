package com.example.avners.utils;

public class Card {
    private String name;
    private int id;
    private int power;

    public Card(int id, int power, String name){
       this.id = id;
       this.power = power;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPower() {
        return power;
    }
}
