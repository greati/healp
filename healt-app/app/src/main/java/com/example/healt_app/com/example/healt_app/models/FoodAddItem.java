package com.example.healt_app.com.example.healt_app.models;

public class FoodAddItem {

    private String name;
    private Double qtd;

    public FoodAddItem(String name, Double qtd) {
        this.name = name;
        this.qtd = qtd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return name;
    }
}
