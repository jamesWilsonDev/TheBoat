package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.RegistrationDetails;
import com.example.service.AthleteDetailsService;

@Controller
public class RegistrationController {
	
	@Autowired
	private AthleteDetailsService athleteDetailsService;
	
    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@RequestBody RegistrationDetails registrationDetails){
    	athleteDetailsService.createUser(registrationDetails);
    	
		return "home";
	}
}
