package com.edwinsam.speed_dating.model;

import java.util.List;

public class Date {
    private int tableId;
    private List<User> singles;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public List<User> getSingles() {
        return singles;
    }

    public void setSingles(List<User> singles) {
        this.singles = singles;
    }
}
