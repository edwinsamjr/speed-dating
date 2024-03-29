package com.edwinsam.speed_dating.services;

import com.edwinsam.speed_dating.Menu;
import com.edwinsam.speed_dating.model.User;

import java.util.List;
import java.util.Scanner;

public class UserService {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu(System.in, System.out);

    private final String NEW_PLAYER = "New Player";
    private final String RETURNING_PLAYER = "Returning Player";
    private final String[] NEW_OR_RETURNING_PLAYER_OPTIONS = {NEW_PLAYER, RETURNING_PLAYER};

    public String getUserName() {

        System.out.println();
        System.out.print("Please enter user's name >>> ");
        String userInput = scanner.nextLine();

        return userInput;
    }

    public boolean getReturningPlayerStatus(String name) {
        System.out.println();
        System.out.printf("Is %s a new or returning player?", name);

        String choice = (String) menu.getChoiceFromOptions(NEW_OR_RETURNING_PLAYER_OPTIONS);

        if (choice == NEW_PLAYER) {
            return false;
        } else {
            return true;
        }

    }

    public int getNumRounds(List<User> attendees) {
        while (true) {
            int maxRounds = attendees.size() / 2;

            System.out.println();
            System.out.println("How many rounds would you like to play?");
            System.out.printf("Please enter a number between 1 and %d >>>", maxRounds);

            String userInput = scanner.nextLine();

            String errorMessage = "Please enter a valid number";
            try {
                int numRounds = Integer.parseInt(userInput);
                if (numRounds <= maxRounds && numRounds > 0) {
                    return numRounds;
                } else {
                    System.out.println(errorMessage);
                }
            } catch(NumberFormatException e) {
                System.out.println(errorMessage);
            }






        }

    }
}
