package com.tsetsova.twitter;

import java.util.Scanner;

public class Twitter {

   public static void main(String[] arguments) {
       Scanner reader = new Scanner(System.in).useDelimiter("\\n");
       System.out.println("Hi, to tweet, please enter your username:");
       String username = reader.next().replaceAll("\\s","");
       User user = new User(username);
       System.out.println("Hello " + username);
       System.out.println("The commands I understand are:'tweet', 'timeline','exit'");
       String command = reader.next();


       while (!command.equalsIgnoreCase("quit")) {
           switch(command) {
               case "timeline":
                   System.out.println(user.timeline());
                   break;
               case "tweet":
                   System.out.println("What's on your mind?");
                   String status = reader.next();
                   user.tweet(status);
                   String tweet = String.format("@%s said '%s'", username, status);
                   System.out.println(tweet);
                   break;
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
