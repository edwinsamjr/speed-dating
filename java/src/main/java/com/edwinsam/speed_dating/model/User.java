package com.edwinsam.speed_dating.model;

import java.util.List;

public class User {
    private String name;
    private List<Date> userDates;
    private boolean isReturningPlayer;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Date> getUserDates() {
        return userDates;
    }

    public void setUserDates(List<Date> userDates) {
        this.userDates = userDates;
    }

    public boolean isReturningPlayer() {
        return isReturningPlayer;
    }

    public void setReturningPlayer(boolean returningPlayer) {
        isReturningPlayer = returningPlayer;
    }
}
