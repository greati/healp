package com.example.healt_app.com.example.healt_app.models;

public class Recommendation {

    public enum Type {
        FOOD,
        WATER,
        HEALTH
    };

    public Recommendation(String title, Type type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private String title;

    private Type type;


}
