package world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import world.db.DBConnection;
import world.domain.Country;
import world.domain.CountryLanguage;

public class LanguageDAO 
{
	Connection conn=null;
	//load all Languages
	public List<CountryLanguage> loadAllLanguages() 
	{
		List<CountryLanguage> results = new ArrayList<CountryLanguage>();
		try 
		{
			conn=DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from countrylanguage");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			results.add(resultToLanguage(rs));
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}
	
	//setting result to Languages object
		private CountryLanguage resultToLanguage(ResultSet rs) 
		{
			CountryLanguage city = new CountryLanguage();
			try 
			{
				city.setCountryCode(rs.getString("countrycode"));
				city.setCountryLanguage(rs.getString("language"));
			}
			catch (SQLException sqle) 
			{
				sqle.printStackTrace();
			}
			return city;
		}
}
