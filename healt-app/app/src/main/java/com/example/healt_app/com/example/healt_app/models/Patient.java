package com.example.healt_app.com.example.healt_app.models;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable {


    private String name;
    private Date date;
    private int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Patient(String name, Date date, int imageId) {
        this.name = name;
        this.date = date;
        this.imageId = imageId;
    }

}
