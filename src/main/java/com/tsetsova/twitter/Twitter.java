package com.tsetsova.twitter;

import java.util.Scanner;

public class Twitter {

   public static void main(String[] arguments) {
       Scanner reader = new Scanner(System.in).useDelimiter("\\n");
       System.out.println("Hello, please register.");


       System.out.println("Please enter a username:");
       String username = reader.next();
       User user = new User(username);
       System.out.println("Hello " + username);
       System.out.println("Write 'tweet' to share what's on your mind :)");
       String command = reader.next();

       switch (command) {
           case "timeline":
               System.out.println(user.timeline());
               break;
           case "tweet":
               String status = reader.next();
               user.tweet(status);
               String tweet = String.format("@%s said '%s'", username, status);
               System.out.println(tweet);
               break;
           default:
               System.out.println("Sorry, I only understand: tweet and timeline currently");
               break;
       }
   }
}
