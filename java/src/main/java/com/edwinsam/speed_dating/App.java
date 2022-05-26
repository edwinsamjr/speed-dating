package com.edwinsam.speed_dating;

import com.edwinsam.speed_dating.model.User;
import com.edwinsam.speed_dating.services.ScheduleService;
import com.edwinsam.speed_dating.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class App {
    private Menu menu;
    private UserService userService;
    private ScheduleService scheduleService;

    private final String MAIN_MENU_ADD_NEW_USER = "Add New User";
    private final String MAIN_MENU_PRINT_USER_SCHEDULES = "Print User Schedules";
    private final String[] MENU_OPTIONS = {MAIN_MENU_ADD_NEW_USER, MAIN_MENU_PRINT_USER_SCHEDULES};


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
                User personA = new User("Person A", true);
                User personB = new User("Person B", true);
                User personC = new User("Person C", false);
                User personD = new User("Person D", false);

                List<User> fakeUsers = new ArrayList<>();
                fakeUsers.add(personA);
                fakeUsers.add(personB);
                fakeUsers.add(personC);
                fakeUsers.add(personD);



                scheduleService.printTableSchedule(fakeUsers);
                System.out.println("Thank you for playing");
                break;
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
