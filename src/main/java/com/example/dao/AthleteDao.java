package com.example.dao;

import com.example.model.Athlete;

public interface AthleteDao {
	
	public Athlete retrieveByEmail(String userName);
	
	public void create();

}
