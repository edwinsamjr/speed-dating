package com.edwinsam.speed_dating.model;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private int tableNum;
    private List<Round> rounds;

    public Table() {
        this.rounds = new ArrayList<>();
    }

    public Table(int tableNum) {
        this.tableNum = tableNum;
        this.rounds = new ArrayList<>();
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public void addRound(Round round) {
        this.rounds.add(round);
    }
}
