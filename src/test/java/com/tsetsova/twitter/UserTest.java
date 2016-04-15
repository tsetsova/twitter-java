package com.tsetsova.twitter;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user;

    @Before public void setUp() {
        user = new User("Spike");
    }

    @Test
    public void shouldReturnUserName(){
        assertEquals("Spike", user.name() );
    }

    @Test
    public void canTweet() {
        user.tweet("typeof(NaN) is a number because... javascript..");
        assertEquals("typeof(NaN) is a number because... javascript..", user.timeline().get(0));

    }

}
