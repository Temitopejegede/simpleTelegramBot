package com.temi.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Answers {

    HashMap<String, String> populate(){
        DateFormat format = new SimpleDateFormat("hh:mm aa");
        String date = format.format(new Date());

        HashMap<String, String> commonAnswers = new HashMap<>();
        commonAnswers.put("hello", "Hey!");
        commonAnswers.put("how are you", "I'm good, you?");
        commonAnswers.put("what are you doing", "I am waiting for my next instruction");
        commonAnswers.put("what day of the week is it today?", Calendar.getInstance().getTime().toString().substring(0,3)+"day");
        commonAnswers.put("what time is it?", "It is "+ date);
        commonAnswers.put(".", ".");
        return commonAnswers;
    }

    public Answers(){
    }
}
