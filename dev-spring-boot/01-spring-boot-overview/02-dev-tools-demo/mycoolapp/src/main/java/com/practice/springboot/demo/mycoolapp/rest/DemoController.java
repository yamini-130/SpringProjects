package com.practice.springboot.demo.mycoolapp.rest;

import com.practice.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//    define a private field for dependency
    private Coach myCoach;

//define a constructor for dependency injection
    @Autowired // autowired tells the spring to inject dependency
    public DemoController(@Qualifier("trackCoach") Coach theCoach) {
        myCoach = theCoach;
    }

//   setter injection
/*    @Autowired
 public void setCoach(Coach theCoach){
     myCoach = theCoach;
 }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
