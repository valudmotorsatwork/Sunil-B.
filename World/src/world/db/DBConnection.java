package world.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection 
{
	public static Connection getConnection() 
	{
		Properties props = new Properties();
		FileInputStream fis = null;
		Connection con = null;
		try 
		{
			fis = new FileInputStream("./resources/world.config");
			props.load(fis);
			Class.forName(props.getProperty("DB_DRIVER"));
			con = DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USERNAME"),props.getProperty("DB_PASSWORD"));
			System.out.println("Connection type is : " + con.getClass());
			System.out.println("Connection Created");
		} 
		catch (IOException | ClassNotFoundException | SQLException e) 
		{
			System.out.println("Connection Error : " +e.toString());
		}
	return con;
	}
//	public static void main(String [] args)
//	{
//		getConnection();
//	}
}
