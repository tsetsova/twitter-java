package com.tsetsova.twitter;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Before public void initialize() {

    }

    @Test
    public void shouldReturnUserName(){
        User spike = new User("Spike");
        assertEquals("Spike", spike.name() );
    }

    @Test
    public void canTweet() {
        User spike = new User("Spike");
        spike.tweet("typeof(NaN) is a number because... javascript..");
        assertEquals("typeof(NaN) is a number because... javascript..", spike.timeline().get(0));

    }

}
