package com.tsetsova.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Twitter {

    List<User> users = new ArrayList<>();
    List<String> commands = Arrays.asList("tweet", "timeline", "search <username>", "sign out", "exit");
    User current_user;
    Scanner reader = new Scanner(System.in).useDelimiter("\\n");

    public static void main(String[] arguments) {
        new Twitter().user_interaction();
        System.out.println("See you later!");
    }

    private void user_interaction() {

        login();
        String command = userCommand();

        while (!command.equalsIgnoreCase("quit")) {
            switch (command) {
                case "timeline":
                    timeline(current_user);
                    break;
                case "tweet":
                    tweet();
                    break;
                case "find":
                    find();
                    break;
                case "sign out":
                    signOut();
                    break;
                case "exit":
                    if (exit()) return;
                    break;
                default:
                    System.out.println("Sorry did you mean one of these commands?");
                    printCommands();
            }
            command = reader.next();
        }
    }

    private void find() {
        System.out.println("Please type in a username");
        String username = reader.next();
        User foundUser = searchUser(username);
        System.out.println("Here is " + username + "'s timeline");
        timeline(foundUser);
    }

    private boolean exit() {
        System.out.println("Are you sure? All your tweets will be lost. Say 'Yes' to confirm exit.");
        String exitResponse = reader.next();
        if (exitResponse.equalsIgnoreCase("Yes")) {
            return true;
        } else {
            System.out.println("Back to safety.");
        }
        return false;
    }

    private void timeline(User user) {
        if (user.timeline().isEmpty()) {
            System.out.println("No tweets yet! Say 'tweet' to tweet!");
        }
        user.timeline().forEach(System.out::println);
    }

    private void signOut() {
        System.out.println("Signed out, your tweets have been saved.");
        user_interaction();
    }

    private void tweet() {
        System.out.println("What's on your mind?");
        String status = reader.next();
        current_user.tweet(status);
        String tweet = String.format("@%s said '%s'", current_user.username, status);
        System.out.println(tweet);
    }


    private String userCommand() {
        printCommands();
        return reader.next();
    }

    private void printCommands() {
        System.out.println("The commands I understand are:");
        commands.forEach(System.out::println);
    }

    private void login() {
        System.out.println("Hi, to tweet, please enter your username:");
        String username = reader.next().replaceAll("\\s", "");

        current_user = searchUser(username);

        System.out.println("Hello " + username);
    }

    private User searchUser(String username) {
        return users.stream()
                .filter(user -> user.username.equalsIgnoreCase(username))
                .findFirst()
                .orElse(createUser(username));
    }

    private User createUser(String username) {
        User user = new User(username);
        users.add(user);
        return user;
    }

}
