package com.edwinsam.speed_dating;

import com.edwinsam.speed_dating.model.User;
import com.edwinsam.speed_dating.services.ScheduleService;
import com.edwinsam.speed_dating.services.UserService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    private Menu menu;
    private UserService userService;
    private ScheduleService scheduleService;

    private final String MAIN_MENU_ADD_NEW_USER = "Add New User";
    private final String MAIN_MENU_PRINT_TABLE_SCHEDULES = "Print Table Schedules";
    private final String MAIN_MENU_PRINT_ROUND_SCEDULES = "Print Round Schedules";
    private final String MAIN_MENU_PRINT_USER_SCHEDULES = "Print User Schedules";
    private final String[] MENU_OPTIONS = {MAIN_MENU_ADD_NEW_USER, MAIN_MENU_PRINT_USER_SCHEDULES,MAIN_MENU_PRINT_ROUND_SCEDULES, MAIN_MENU_PRINT_TABLE_SCHEDULES};

    private final List<User> ATTENDEES = new ArrayList<>(List.of(
            new User("Person A", false),
            new User("Person B", false),
            new User("Person C", false),
            new User("Person D", false),
            new User("Person E", false),
            new User("Person F", false),
            new User("Person G", false),
            new User("Person H", false),
            new User("Person I", false),
            new User("Person J", false),
            new User("Person K", false),
            new User("Person L", false),
            new User("Person M", false),
            new User("Person N", false),
            new User("Person O", true),
            new User("Person P", true),
            new User("Person Q", true),
            new User("Person R", true),
            new User("Person S", true),
            new User("Person T", true),
            new User("Person U", true),
            new User("Person V", true),
            new User("Person W", true),
            new User("Person X", true),
            new User("Person Y", true),
            new User("Person Z", true),
            new User("Person AA", true),
            new User("Person BB", true)
    ));


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        printGreeting();
        List<User> users = new ArrayList<>();

        while(true) {
            String choice = (String) menu.getChoiceFromOptions(MENU_OPTIONS);

            if (choice == MAIN_MENU_ADD_NEW_USER) {
                String name = userService.getUserName();
                boolean hasUniqueName = true;

                for (User user : users) {
                    if (user.getName().equals(name)) {
                        hasUniqueName = false;
                    }
                }


                if (hasUniqueName) {
                    User user = new User();

                    user.setName(name);
                    user.setReturningPlayer(userService.getReturningPlayerStatus(name));

                    users.add(user);

                    System.out.println();
                    System.out.println("Successfully added " + name);
                } else {
                    System.out.println();
                    System.out.println("Duplicate name. Unable to add user");
                }

            } else if (choice == MAIN_MENU_PRINT_USER_SCHEDULES) {


            } else if (choice == MAIN_MENU_PRINT_ROUND_SCEDULES) {
                int numRounds = userService.getNumRounds(ATTENDEES);

                scheduleService.printRoundSchedules(ATTENDEES, numRounds);

                System.out.println("Thank you for playing");
                System.out.println();
            } else if (choice == MAIN_MENU_PRINT_TABLE_SCHEDULES) {
                int numRounds = userService.getNumRounds(ATTENDEES);

                scheduleService.printTableSchedule(ATTENDEES, numRounds);

                System.out.println("Thank you for playing");
                System.out.println();
            }


        }



    }

    public App() {
        this.menu = new Menu(System.in, System.out);
        this.userService = new UserService();
        this.scheduleService = new ScheduleService();
    }



    public void printGreeting() {
        System.out.println("Welcome to Speed Dating!");
        System.out.println();
    }

}
