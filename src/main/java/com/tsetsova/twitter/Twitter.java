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

       System.out.println("Share what's on your mind :)");
       String status = reader.next();
       user.tweet(status);
       String tweet = String.format("@%s said '%s'", username, status);
       System.out.println(tweet);
    }
}
