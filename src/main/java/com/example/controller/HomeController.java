package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Work on 10/06/2016.
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Yes boi!!!";
    }
}
