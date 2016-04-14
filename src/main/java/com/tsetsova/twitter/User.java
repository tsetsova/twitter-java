package com.tsetsova.twitter;

import java.util.*;

 class User {

     private String username;
     private ArrayList<String> tweets = new ArrayList<>();

     User(String username) {
        this.username = username;
    }

     public String name() { return username; }

     public List<String> timeline() { return tweets; }

     public void tweet(String status) {tweets.add(status); }
 }
