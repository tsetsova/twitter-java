package com.tsetsova.twitter;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldReturnName(){

        User spike = new User("Spike");
        assertEquals("Spike", spike.name() );

    }



}
