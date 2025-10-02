package com.practice.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Speed 30 minutes in batting practice";
    }
}
