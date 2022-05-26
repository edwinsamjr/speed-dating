package com.edwinsam.speed_dating.services;

import com.edwinsam.speed_dating.model.Round;
import com.edwinsam.speed_dating.model.Table;
import com.edwinsam.speed_dating.model.User;

import java.util.ArrayList;
import java.util.List;

public class ScheduleService {

    public void printTableSchedule(List<User> users) {
        printTables(fillTables(users));

    }

    public String getReturningPlayerStatusString(User user) {
        if (user.isReturningPlayer() == true) {
            return "Returning";
        } else {
            return "New";
        }
    }

    public List<Table> createTables(List<User> users, int numRounds) {
        List<Table> tables = new ArrayList<>();
        int numTables = users.size() / 2;

        for (int i = 1; i <= numTables; i++) {
            Table table = new Table(i, numRounds);
            tables.add(table);
        }

        return tables;
    }

    public List<Table> fillTables(List<User> users) {
        List<User> newPlayers = new ArrayList<>();
        List<User> returningPlayers = new ArrayList<>();

        for (User user : users) {
            if (user.isReturningPlayer()) {
                returningPlayers.add(user);
            } else {
                newPlayers.add(user);
            }
        }

        List<Table> tables = createTables(users, 2);

        //First Round
        for (int i = 0; i < tables.size(); i++) {
            Table curTable = new Table();
            curTable.setTableNum(i + 1);

            Round round = new Round();
            List<User> roundAttendees = new ArrayList<>();

            roundAttendees.add(newPlayers.get(i));
            roundAttendees.add(returningPlayers.get(i));
            round.setAttendees(roundAttendees);
            round.setRoundNum(1);

            curTable.addRound(round);
            tables.set(i, curTable);
        }

        //Second Round
        for (int i = 0; i < tables.size(); i++) {
            int numToOffset = 1;
            int returningPlayerIdx = i;
            int newPlayerIdx = i + numToOffset;

            if (newPlayerIdx > newPlayers.size() - 1) {
                newPlayerIdx = newPlayerIdx - newPlayers.size();
            }

            Round round = new Round();
            List<User> roundAttendees = new ArrayList<>();

            roundAttendees.add(newPlayers.get(newPlayerIdx));
            roundAttendees.add(returningPlayers.get(returningPlayerIdx));
            round.setAttendees(roundAttendees);
            round.setRoundNum(2);
            Table curTable = tables.get(i);
            curTable.addRound(round);
            tables.set(i, curTable);

        }

        return tables;
    }

    public void printTables(List<Table> tables) {
        System.out.println("Printing tables...");
        System.out.println();

        for (Table table : tables) {
            System.out.println("Table #" + table.getTableNum());
            for (Round round : table.getRounds()) {
                int roundNum = round.getRoundNum();
                String attendeeOne = round.getAttendees().get(0).getName();
                String attendeeTwo = round.getAttendees().get(1).getName();
                System.out.printf("Round #%d: %s and %s%n", roundNum, attendeeOne, attendeeTwo);
            }
            System.out.println();
            System.out.println();
        }
    }

    /*

    Four users (Two new, two returning)
    Two tables
    two rounds

    Person A, Person B, Person C, Person D

    Table 1:
    Round 1 - Person A, Person C
    Round 2 - Person A, Person D

    Table 2:
    Round 1 - Person B, Person D
    Round 2 = Person B, Person C

     */

}
