package com.tsetsova.twitter;


import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        assertEquals(time() + " @Spike said 'typeof(NaN) is a number because... javascript..'", user.timeline().get(0));

    }

    String time() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

}
