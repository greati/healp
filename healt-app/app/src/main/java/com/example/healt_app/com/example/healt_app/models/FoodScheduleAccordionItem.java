package com.example.healt_app.com.example.healt_app.models;

import com.sysdata.widget.accordion.Item;

import java.util.ArrayList;
import java.util.Objects;

public class FoodScheduleAccordionItem extends Item {

    private String title;
    private String description;


    public ArrayList<FoodScheduleItem> getFoodSchedItems() {
        return foodSchedItems;
    }

    public void setFoodSchedItems(ArrayList<FoodScheduleItem> foodSchedItem) {
        this.foodSchedItems = foodSchedItem;
    }

    private ArrayList<FoodScheduleItem> foodSchedItems;

    FoodScheduleAccordionItem(String title, String description, ArrayList<FoodScheduleItem> items) {
        this.title = title;
        this.description = description;
        foodSchedItems = items;
    }

    public static FoodScheduleAccordionItem create(String title, String description, ArrayList<FoodScheduleItem> items) {
        return new FoodScheduleAccordionItem(title, description, items);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getUniqueId() {
        return hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodScheduleAccordionItem that = (FoodScheduleAccordionItem) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }
}
