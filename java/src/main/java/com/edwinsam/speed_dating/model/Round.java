package com.edwinsam.speed_dating.model;

import java.util.List;

public class Round {
    private int roundNum;
    private List<User> attendees;

    public int getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
}
