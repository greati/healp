package com.example.healt_app.com.example.healt_app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Patient implements Serializable {

    private User user;
    private String name;
    private Date date;
    private int imageId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Patient(String name, Date date, int imageId, User user) {
        this.name = name;
        this.date = date;
        this.imageId = imageId;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(user, patient.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
