package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.dao.AthleteDao;
import com.example.model.Athlete;
import com.example.model.RegistrationDetails;

public class AthleteDetailsService implements UserDetailsService{
	
	@Autowired
	private AthleteDao athleteDao;

	@Override
	public Athlete loadUserByUsername(String userName) throws UsernameNotFoundException {
		Athlete athlete = athleteDao.retrieveByEmail(userName);
		//Do stuff with Roles? Not sure yet. 
		return athlete;
	}
	
	public void createUser(RegistrationDetails registrationDetails){
		//TODO Pass Details into DAO
		athleteDao.create();
	}

}
