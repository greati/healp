package com.example.healt_app.com.example.healt_app.models;

import java.io.Serializable;
import java.util.Date;

public class ChatMessage implements Serializable {

    private String text;
    private Date sendDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public ChatMessage(User user, String text, Date date) {
        this.text = text;
        this.sendDate = date;
        this.user = user;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
