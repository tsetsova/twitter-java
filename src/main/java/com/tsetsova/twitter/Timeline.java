package com.tsetsova.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class Timeline {

    private final String username;
    private List<Tweet> tweets;

    Timeline(String username) {
        this.username = username;
        this.tweets = new ArrayList<>();
    }

    List<String> display() {

        return tweets.stream()
              .map( tweet -> format(tweet.status, tweet.timestamp) )
              .collect(Collectors.toList());
    }

    void save(String status) {
        Tweet tweet = new Tweet(status, this.username);
        tweets.add(tweet);
    }

    private String format(String status, String timestamp) {
        return String.format("%s @%s said '%s'", timestamp, this.username, status);
    }


}
