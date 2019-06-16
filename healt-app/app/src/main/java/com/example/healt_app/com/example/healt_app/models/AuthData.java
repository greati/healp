package com.example.healt_app.com.example.healt_app.models;

public class AuthData {

    private static User loggedUser;

    public static void setLoggedUser(User u) {
        loggedUser = u;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }
}
