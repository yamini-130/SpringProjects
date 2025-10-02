package com.practice.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run a daily 5k!";
    }
}
