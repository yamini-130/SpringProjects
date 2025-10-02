package com.practice.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that return "hello world"
    @GetMapping
    public String SayHello() {
        return "Hello World";
    }
}
