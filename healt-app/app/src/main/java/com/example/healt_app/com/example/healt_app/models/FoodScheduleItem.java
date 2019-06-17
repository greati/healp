package com.example.healt_app.com.example.healt_app.models;

import com.sysdata.widget.accordion.Item;

import java.util.ArrayList;
import java.util.Objects;

public class FoodScheduleItem extends Item {

    private String time;
    private String name;
    private ArrayList<String> components;

    public FoodScheduleItem(String time, String name, ArrayList<String> components) {
        this.time = time;
        this.name = name;
        this.components = components;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<String> components) {
        this.components = components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodScheduleItem that = (FoodScheduleItem) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(name, that.name) &&
                Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, name, components);
    }

    @Override
    public int getUniqueId() {
        return hashCode();
    }
}
