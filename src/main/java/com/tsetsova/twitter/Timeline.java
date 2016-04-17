package com.tsetsova.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class Timeline {

    private final String username;
    private List<Tweet> tweets;

    Timeline(String username, List<Tweet> tweets) {
        this.username = username;
        this.tweets = tweets;

    }

    List<String> display() {

        return tweets.stream()
              .map( tweet -> format(tweet.status, tweet.timestamp) )
              .collect(Collectors.toList());
    }



    private String format(String status, String timestamp) {
        return String.format("%s @%s said '%s'", timestamp, this.username, status);
    }


//    public void add(List<String> otherTweets) {
//
//    }
}
