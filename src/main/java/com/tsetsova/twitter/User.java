package com.tsetsova.twitter;

import java.util.*;

class User {

    String username;
    private Timeline timeline;

    User(String username) {
        this.username = username;
        this.timeline = new Timeline(this.username);
    }

    String name() {
        return username;
    }

    List<String> timeline() {
        return timeline.display();
    }

    void tweet(String tweet) {
        timeline.save(tweet);
    }

}
