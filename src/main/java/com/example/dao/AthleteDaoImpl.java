package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.example.model.Athlete;

public class AthleteDaoImpl extends JdbcDaoSupport implements AthleteDao {

	@Autowired
	DataSource dataSource;
	RetrieveUserByEmail retrieveUserByEmail = new RetrieveUserByEmail();;
	
	public Athlete retrieveByEmail(String emailAddress){
		return retrieveUserByEmail.retrieveAthlete(emailAddress);
	}
	
	public void create(){
		//TODO do stuff
	}
	
	private abstract class AbstractLoginQuery extends MappingSqlQuery {
		protected AbstractLoginQuery(String aQuery){
			super(dataSource, aQuery);
		}
		
		public Athlete mapRow(ResultSet rs, int rowNum) throws SQLException{
			Athlete athlete = new Athlete();
			athlete.setAthleteID(rs.getLong("ATHLETE_ID"));
			athlete.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
			athlete.setFullName(rs.getString("FULL_NAME"));
			athlete.setGivenName(rs.getString("GIVEN_NAME"));
			athlete.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
			athlete.setCity(rs.getString("CITY"));
			athlete.setCountryCode(rs.getString("COUNTRY"));
			athlete.setPassword(rs.getString("PASSWORD"));
			athlete.setSalt(rs.getString("SALT"));
			//TODO Activated/retry count
			return athlete;
		}
	}
	
	private class RetrieveUserByEmail extends AbstractLoginQuery{
		
		protected RetrieveUserByEmail(){
			super("SELECT * from tblAthlete WHERE upper(emailAddress) = upper(?)");
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}
		
		public Athlete retrieveAthlete(String email){
			Athlete athlete = (Athlete)findObject(email);
			return athlete;
		}
	}

}
