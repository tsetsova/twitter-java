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
                .sorted((tweet1, tweet2) -> tweet1.timestamp
                        .compareTo(tweet2.timestamp))
                .map(tweet -> format(tweet.status, tweet.username, tweet.timestamp))
                .collect(Collectors.toList());
    }

    private String format(String status, String username, String timestamp) {
        return String.format("%s @%s said '%s'", timestamp, username, status);
    }


    public void add(List<Tweet> otherTweets) {
        otherTweets.forEach(tweet -> tweets.add(tweet));
    }
}
