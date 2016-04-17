package com.tsetsova.twitter;


import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user;
    private String userStatus;
    private String userTweet;

    private String otherUserStatus;
    private User otherUser;
    private String otherUserTweet;

    @Before public void setUp() {
        user = new User("Spike");
        userStatus = user.tweet("typeof(NaN) is a number because... javascript..");
        userTweet = time() + " @Spike said 'typeof(NaN) is a number because... javascript..'";
        otherUser = new User("Leo");
        otherUserStatus = otherUser.tweet("What would Thoughtbot do?");
        otherUserTweet = time() + " @Leo said 'What would Thoughtbot do?'";
    }

    @Test
    public void shouldReturnUserName(){
        assertEquals("Spike", user.name());
    }

    @Test
    public void canTweet() {
        assertEquals(userStatus, user.tweets.get(0).status);
    }

    @Test
    public void hasATimeline() {
        assertEquals(userTweet, user.timeline().get(0));
    }

    @Test
    public void canFollowOtherUsers() {
        user.follow(otherUser);
        assertEquals(otherUser, user.following.get(0));
    }

    @Test
    public void cantFollowTheSameUserTwice() {
        user.follow(otherUser);
        user.follow(otherUser);
        assertEquals(1, user.following.size());
    }

    @Test
    public void canSeeAnAggregatedTimeline() {
        user.follow(otherUser);
        assertEquals(true, user.timeline().contains(otherUserTweet));
    }

    String time() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

}
