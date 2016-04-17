package com.tsetsova.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Twitter {

   List<User> users = new ArrayList<>();
   List<String>commands = Arrays.asList("tweet", "timeline","search <username>","sign out", "exit");
   User current_user;

    public static void main(String[] arguments) {
       new Twitter().user_interaction();
       System.out.println("See you later!");
   }

    private void user_interaction() {
        Scanner reader = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Hi, to tweet, please enter your username:");
        String username = reader.next().replaceAll("\\s","");

        List<String> usernames = users.stream()
                                      .map(user -> user.username)
                                      .collect(Collectors.toList());


        current_user = users.stream()
                            .filter(user -> user.username.equalsIgnoreCase(username) )
                            .findFirst()
                            .orElse(new User(username));

        if (!usernames.contains(username)) {
            users.add(current_user);
        }

        System.out.println("Hello " + username);
        System.out.println("The commands I understand are:");
        commands.forEach(System.out::println);
        String command = reader.next();


        while (!command.equalsIgnoreCase("quit")) {
            switch(command) {
                case "timeline":
                    if (current_user.timeline().isEmpty()) {
                        System.out.println("No tweets yet! Say 'tweet' to tweet!");
                    }
                    current_user.timeline().forEach(System.out::println);
                    break;
                case "tweet":
                    System.out.println("What's on your mind?");
                    String status = reader.next();
                    current_user.tweet(status);
                    String tweet = String.format("@%s said '%s'", username, status);
                    System.out.println(tweet);
                    break;
                case "sign out":
                    System.out.println("Signed out, your tweets have been saved.");
                    user_interaction();
                case "exit":
                    System.out.println("Are you sure? All your tweets will be lost. Say 'Yes' to confirm exit.");
                    String exitResponse = reader.next();
                    if (exitResponse.equalsIgnoreCase("Yes")) {
                        return;
                    }
                    else {
                        System.out.println("Back to safety.");
                    }
                    break;
                default:
                    System.out.println("Sorry, I only understand: tweet, timeline, and exit currently");
            }
            command = reader.next();
        }
    }
}
