package world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import world.db.DBConnection;
import world.domain.City;
import world.domain.Country;

public class CityDAO 
{

	Connection conn=null;
	// Loading all cities
	public List<City> loadAllCity() 
	{
		List<City> results = new ArrayList<City>();
		try 
		{
			conn=DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CITY");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			results.add(resultToCity(rs));
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}
	
	// return count from city table
	public int getCount()
	{
		conn=DBConnection.getConnection();
		int total=0;
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS TOTAL FROM CITY");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				total=rs.getInt(1);
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return total; 
	}
	
	//loading all cities with limit for server side pagination
	public List<City> loadAllCity(int take,int skip) 
	{
		List<City> results = new ArrayList<City>();
		try 
		{
			conn=DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CITY LIMIT ?,?");
			pstmt.setInt(1, take);
			pstmt.setInt(2, skip);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			results.add(resultToCity(rs));
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}
	//setting result to city object
	private City resultToCity( ResultSet rs ) 
	{
		City city = new City();
		try 
		{
			city.setCityId(rs.getString("id"));
			city.setCityName(rs.getString("name"));
			city.setCityDistrict(rs.getString("district"));
			city.setCityPopulation(rs.getString("population"));
			city.setCityCountryCode(rs.getString("countrycode"));
		}
		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
		}
		return city;
	}
	//method for saveing data
	public void saveRecord(City city) throws SQLException 
	{
		try 
		{
			conn=DBConnection.getConnection();				
			String sql = "INSERT INTO city (name,countrycode,district,population) VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city.getCityName());
			pstmt.setString(2, city.getCityCountryCode());
			pstmt.setString(3, city.getCityDistrict());
			pstmt.setString(4, city.getCityPopulation());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		catch (Exception sqle) 
		{
			sqle.printStackTrace();
		}
	}
	//method for delete data
	public void deleteRecord(String value) throws SQLException 
	{
		try 
		{
			conn=DBConnection.getConnection();
			Statement pstmt = conn.createStatement();
			pstmt = conn.createStatement();
			pstmt.execute("DELETE FROM CITY WHERE ID ="+Integer.parseInt(value));
			pstmt.close();
			conn.close();
		}
		catch (Exception sqle) 
		{
			sqle.printStackTrace();
		}
	}
	//method for update data
	public void updateRecord(City city) throws SQLException 
	{
		try 
		{
			
			conn=DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE CITY SET name = ?, countrycode = ?,district=?, population=? WHERE id = ?");
		    ps.setString(1,city.getCityName());
		    ps.setString(2, city.getCityCountryCode());
		    ps.setString(3, city.getCityDistrict());
		    ps.setString(4,city.getCityPopulation());
		    ps.setString(5,city.getCityId());
		    ps.executeUpdate();
		    ps.close();
		    conn.close();
		}
		catch (Exception sqle) 
		{
			sqle.printStackTrace();
		}
	}
	//load all countries
	public List<Country> loadAllCountry() 
	{
		List<Country> results = new ArrayList<Country>();
		try 
		{
			conn=DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM COUNTRY");
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
	
	//setting result to country object
		private Country resultToCountry(ResultSet rs) 
		{
			Country city = new Country();
			try 
			{
				city.setCountryCode(rs.getString("code"));
				city.setCountryName(rs.getString("name"));
			}
			catch (SQLException sqle) 
			{
				sqle.printStackTrace();
			}
			return city;
		}
}
