package com.tsetsova.twitter;

import java.util.*;

class User {

    String username;
    private Timeline timeline;
    List<User> following = new ArrayList<>();
    List<Tweet> tweets = new ArrayList<>();

    User(String username) {
        this.username = username;
        this.timeline = new Timeline(username, tweets);
    }

    String name() {
        return username;
    }

    List<String> timeline() {
        return timeline.display();
    }


    void tweet(String tweet) {
        save(tweet);
    }

    void save(String status) {
        Tweet tweet = new Tweet(status);
        tweets.add(tweet);
    }

     void follow(User user) {
          if (!following.contains(user)) {
                following.add(user);
            }
//        timeline.add(user.tweets);
    }
}
