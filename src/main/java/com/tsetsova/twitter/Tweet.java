package com.tsetsova.twitter;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


class Tweet {

    String status;
    String timestamp;


    Tweet(String status) {
        this.status = status;
        this.timestamp = time();
    }


    String time() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }


}
