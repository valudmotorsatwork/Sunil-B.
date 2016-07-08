package world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import world.db.DBConnection;
import world.domain.City;
import world.domain.Country;
import world.domain.CountryLanguage;

public class CountryDAO 
{
	Connection conn=null;
	//load all Languages
	public List<Country> loadAllCountries() 
	{
		List<Country> results = new ArrayList<Country>();
		try 
		{
			conn=DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from country");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			results.add(resultToCountry(rs));
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}
	
	//setting result to Languages object
		private Country resultToCountry(ResultSet rs) 
		{
			Country cntry = new Country();
			try 
			{
				cntry.setCountryCode(rs.getString("code"));
				cntry.setCountryName(rs.getString("name"));
				cntry.setCountryContinent(rs.getString("continent"));
				cntry.setCountryRegion(rs.getString("region"));
				cntry.setCountryPopulation(rs.getString("population"));
				cntry.setCountryHeadOfState(rs.getString("headofstate"));
				cntry.setCountryCapital(rs.getString("capital"));	
				System.out.println(" "+rs.getString("code"));
			}
			catch (SQLException sqle) 
			{
				sqle.printStackTrace();
			}
			return cntry;
		}
		
		public List<?> listProducts()
		{
			List<Country> country = new ArrayList<Country>();
			try 
			{
				conn=DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select c.Code,c.Name,c.Region,c.Population,c.continent,c.HeadOfState,c.Capital,ci.ID,ci.name,cl.CountryCode,cl.language  from country c LEFT OUTER join city ci on c.Code=ci.CountryCode LEFT OUTER join countrylanguage cl on c.Code=cl.CountryCode");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
				country.add(setToCountry(rs));
				rs.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			return country;
		}
		//setting result to Languages object
	private Country setToCountry(ResultSet rs) 
	{
		Country cntry = new Country();
		try 
		{
			cntry.setCountryCode(rs.getString("c.Code"));
			cntry.setCountryName(rs.getString("c.Name"));
			cntry.setCountryRegion(rs.getString("c.Region"));
			cntry.setCountryPopulation(rs.getString("c.Population"));
			cntry.setCountryContinent(rs.getString("c.continent"));
			cntry.setCountryHeadOfState(rs.getString("c.HeadOfState"));
			cntry.setCountryCapital(rs.getString("c.Capital"));	
			cntry.setCity(new City(rs.getString("ci.ID"),rs.getString("ci.name")));
			cntry.setLanguage(new CountryLanguage(rs.getString("cl.CountryCode"),rs.getString("cl.language")));
		}
		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
		}
		return cntry;
	}
}
