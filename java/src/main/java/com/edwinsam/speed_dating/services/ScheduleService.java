package com.edwinsam.speed_dating.services;

import com.edwinsam.speed_dating.model.User;

import java.util.List;

public class ScheduleService {

    public void printUsers(List<User> users) {
        for (User user : users) {
            System.out.printf("%-10s | %s%n", user.getName(), getReturningPlayerStatusString(user));
        }
    }

    public String getReturningPlayerStatusString(User user) {
        if (user.isReturningPlayer() == true) {
            return "Returning";
        } else {
            return "New";
        }
    }

}
