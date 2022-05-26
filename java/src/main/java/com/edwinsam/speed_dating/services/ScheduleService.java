package com.edwinsam.speed_dating.services;

import com.edwinsam.speed_dating.model.Round;
import com.edwinsam.speed_dating.model.Table;
import com.edwinsam.speed_dating.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleService {

    public void printTableSchedule(List<User> users, int numRounds) {
        printTables(fillTables(users, numRounds));

    }

    public void printRoundSchedules(List<User> users, int numRounds) {
        printRounds(fillTables(users, numRounds));
    }

    public void printUsersSchedules() {

    }


    public List<Table> createTables(List<User> users) {
        List<Table> tables = new ArrayList<>();
        int numTables = users.size() / 2;

        for (int i = 1; i <= numTables; i++) {
            Table table = new Table(i);
            tables.add(table);
        }

        return tables;
    }

    public List<Table> fillTables(List<User> users, int numRounds) {
        List<User> newPlayers = new ArrayList<>();
        List<User> returningPlayers = new ArrayList<>();

        for (User user : users) {
            if (user.isReturningPlayer()) {
                returningPlayers.add(user);
            } else {
                newPlayers.add(user);
            }
        }

        List<Table> tables = createTables(users);

        //First Round
//        for (int i = 0; i < tables.size(); i++) {
//            Table curTable = new Table();
//            curTable.setTableNum(i + 1);
//
//            Round round = new Round();
//            List<User> roundAttendees = new ArrayList<>();
//
//            roundAttendees.add(newPlayers.get(i));
//            roundAttendees.add(returningPlayers.get(i));
//            round.setAttendees(roundAttendees);
//            round.setRoundNum(1);
//
//            curTable.addRound(round);
//            tables.set(i, curTable);
//        }

        //Second Round
        for (int i = 0; i < numRounds; i++) {
            int numToOffset = i;

            for (int j = 0; j < tables.size(); j++) {

                int returningPlayerIdx = j;
                int newPlayerIdx = j + numToOffset;

                if (newPlayerIdx > newPlayers.size() - 1) {
                    newPlayerIdx -= newPlayers.size();
                }

                Round round = new Round();
                List<User> roundAttendees = new ArrayList<>();

                roundAttendees.add(newPlayers.get(newPlayerIdx));
                roundAttendees.add(returningPlayers.get(returningPlayerIdx));
                round.setAttendees(roundAttendees);
                round.setRoundNum(i + 1);

                Table curTable = tables.get(j);
                curTable.addRound(round);
                tables.set(j, curTable);

            }

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

    public void printRounds(List<Table> tables) {
        System.out.println("Printing rounds...");
        System.out.println();

        int numRounds = tables.get(0).getRounds().size();

        for (int i = 0; i < numRounds; i++) {
            System.out.printf("Round #%d%n", i + 1);

            for(Table table : tables) {
                String retPlayerName = table.getRounds().get(i).getAttendees().get(0).getName();
                String newPlayerName = table.getRounds().get(i).getAttendees().get(1).getName();

                System.out.printf("Table #%d: %s and %s%n", table.getTableNum(), retPlayerName, newPlayerName);
            }
            System.out.println();
        }
    }

    public void printUserSchedule(List<Table> tables) {
        String name = "Ava Gibson";
        Map<Integer, String> schedule = new HashMap<>();

        for (Table table : tables) {

            table.getRounds().get(0).getAttendees().contains(name);

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
