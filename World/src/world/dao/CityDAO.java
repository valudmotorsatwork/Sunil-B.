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

public class CityDAO 
{
	Connection conn=DBConnection.getConnection();
	public List<City> findByName(String name) 
	{
		List<City> results = new ArrayList<City>();
		if(name==null)
		return results;
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement( "SELECT * FROM CITY WHERE NAME=?" );
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery( );
			while (rs.next())
			results.add(resultToCity(rs));
			rs.close();
		} catch (SQLException sqle) {
			throw new RuntimeException( sqle );
		}
		return results;
	}
	/**
	 * Copy current ResultSet row into a City object.
	 * @param rs  ResultSet with a current row
	 * @return a City object containing resultSet data for one row
	 */
	private City resultToCity( ResultSet rs ) 
	{
		City city = new City();
		try 
		{
			city.setCityId(rs.getInt("id"));
			city.setCityName(rs.getString("name"));
			city.setCityDistrict(rs.getString("district"));
			city.setCityPopulation(rs.getInt("population"));
			city.setCityCountryCode(rs.getString("countrycode"));
		}
		catch (SQLException sqle) 
		{
			throw new RuntimeException( sqle );
		}
		return city;
	}

	public List<City> loadCities() 
	{
		List<City> results = new ArrayList<City>();
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement( "SELECT * FROM CITY");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			results.add(resultToCity(rs));
			rs.close();
		}
		catch (SQLException sqle) 
		{
			throw new RuntimeException( sqle );
		}
		return results;
	}
	
	public void save(City city) throws SQLException 
	{
		try 
		{
//			String sql = "INSERT INTO CITY (name,countrycode,district,population) VALUES('"+city.getCityName()+"','"+city.getCityCountryCode()+"','"+city.getCityDistrict()+"',"+city.getCityPopulation()+")";
//			int key=0;
			String maxId="select max(id) from city";
			PreparedStatement pstmt = conn.prepareStatement(maxId);
			ResultSet rs=pstmt.executeQuery();
			int maxCityId=0;
			if(rs.next()){
				maxCityId = rs.getInt(1);
				}
			rs.close();
						
			String sql = "INSERT INTO city (id,name,countrycode,district,population) VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxCityId+1);
			pstmt.setString(2, city.getCityName());
			pstmt.setString(3, city.getCityCountryCode());
			pstmt.setString(4, city.getCityDistrict());
			pstmt.setInt(5, city.getCityPopulation());
			pstmt.executeUpdate();
//			String sql = "INSERT INTO city (name,district,countrycode,population) VALUES(?,?,?,?)";
//			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		}
		catch (Exception sqle) 
		{
			throw new RuntimeException(sqle);
		}
	}
	public void delete(int value) throws SQLException 
	{
		try 
		{
			Statement pstmt = conn.createStatement();
			pstmt = conn.createStatement();
			pstmt.execute("DELETE FROM CITY WHERE ID ="+value);
		}
		catch (Exception sqle) 
		{
			throw new RuntimeException(sqle);
		}
	}
	
	public void update(City city) throws SQLException 
	{
		try 
		{
			PreparedStatement ps = conn.prepareStatement("UPDATE CITY SET name = ?, countrycode = ?,district=?, population=? WHERE id = ?");
		    ps.setString(1,city.getCityName());
		    ps.setString(2, city.getCityCountryCode());
		    ps.setString(3, city.getCityDistrict());
		    ps.setInt(4,city.getCityPopulation());
		    ps.setInt(5,city.getCityId());
	
		    // call executeUpdate to execute our sql update statement
		    ps.executeUpdate();
				    
		}
		catch (Exception sqle) 
		{
			throw new RuntimeException(sqle);
		}
	}
}
