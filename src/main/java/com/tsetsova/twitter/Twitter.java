package com.tsetsova.twitter;

import java.util.*;

public class Twitter {

    List<User> users = new ArrayList<>();
    List<String> commands = Arrays.asList("tweet", "timeline", "find", "follow", "sign out", "exit");
    User current_user;
    Scanner reader = new Scanner(System.in).useDelimiter("\\n");
    String newLine = System.getProperty("line.separator");

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
                case "follow":
                    follow();
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


    private void login() {
        System.out.println("Hi, to tweet, please enter your username:");
        String username = reader.next().replaceAll("\\s", "");
        current_user = findOrCreateUser(username);
        System.out.println("Hello " + username + newLine);
    }

    private User findOrCreateUser(String username) {
        return searchUser(username)
                .orElse(createUser(username));
    }


    private Optional<User> searchUser(String username) {
        return users.stream()
                .filter(user -> user.username.equalsIgnoreCase(username))
                .findFirst();
    }

    private User createUser(String username) {
        User user = new User(username);
        users.add(user);
        return user;
    }

    private String userCommand() {
        printCommands();
        return reader.next();
    }

    private void printCommands() {
        System.out.println("The commands I understand are:");
        commands.forEach(System.out::println);
        System.out.println("---" + newLine);
    }

    private void timeline(User user) {
        if (user.timeline().isEmpty()) {
            System.out.println("No tweets yet! Say 'tweet' to tweet!");
        }
        user.timeline().forEach(System.out::println);
    }

    private void tweet() {
        System.out.println("What's on your mind?");
        String status = reader.next();
        current_user.tweet(status);
        String tweet = String.format("@%s said '%s'", current_user.username, status);
        System.out.println(tweet);
    }

    private void find() {
        System.out.println("Please type in a username");
        String username = reader.next();
        if (searchUser(username).isPresent()) {
            User foundUser = searchUser(username).get();
            System.out.println("Here is " + username + "'s timeline");
            timeline(foundUser);
            System.out.println("To follow " + username + " write follow");
        } else {
            System.out.println(username + " not found");
        }
    }

    private void follow() {
        System.out.println("Which user would you like to follow?");
        String username = reader.next();
        if (searchUser(username).isPresent()) {
            User foundUser = searchUser(username).get();
            current_user.follow(foundUser);
            System.out.println(username + " followed!");
        } else {
            System.out.println(username + " not found");
        }
    }

    private void signOut() {
        System.out.println("Signed out, your tweets have been saved.");
        System.out.println("---" + newLine);
        user_interaction();
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


}
