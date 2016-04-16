package com.tsetsova.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Twitter {

   List<User> users = new ArrayList<>();


   public static void main(String[] arguments) {
       new Twitter().user_interaction();
       System.out.println("See you later!");
   }

    private void user_interaction() {
        Scanner reader = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Hi, to tweet, please enter your username:");
        String username = reader.next().replaceAll("\\s","");
        User user = new User(username);
        users.add(user);
        System.out.println("Hello " + username);
        System.out.println("The commands I understand are:'tweet', 'timeline','users','sign out', 'exit'");
        String command = reader.next();


        while (!command.equalsIgnoreCase("quit")) {
            switch(command) {
                case "timeline":
                    if (user.timeline().isEmpty()) {System.out.println("No tweets yet! Say 'tweet' to tweet!");}
                    user.timeline().forEach(System.out::println);
                    break;
                case "tweet":
                    System.out.println("What's on your mind?");
                    String status = reader.next();
                    user.tweet(status);
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
