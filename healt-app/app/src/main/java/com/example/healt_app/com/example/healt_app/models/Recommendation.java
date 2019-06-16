package com.example.healt_app.com.example.healt_app.models;

public class Recommendation {

    public enum Type {
        FOOD("Alimentação"),
        WATER("Água"),
        HEALTH("Saúde");

        String name;

        Type(String s) {
            this.name = s;
        }

        @Override
        public String toString() {
            return this.name;
        }

    };

    public enum Direction {
        INCREASE,
        DECREASE
    }

    public Recommendation(String title, Type type) {
        this.title = title;
        this.type = type;
    }

    public Recommendation(String title, Type type, Double qtd) {
        this.title = title;
        this.type = type;
        this.qtd = qtd;
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

    private Direction direction;

    private Double qtd = -1.0;

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {

        if (qtd < 0.0)
            return title;

        return title.replace("#", String.valueOf(qtd));
    }
}
