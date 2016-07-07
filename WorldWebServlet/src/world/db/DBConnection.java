package world.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import world.service.PropertyManager;
public class DBConnection 
{
	public static Connection getConnection() 
	{
		Connection con = null;
		try 
		{
			Class.forName(PropertyManager.getProperty("DB_DRIVER"));
			con = DriverManager.getConnection(PropertyManager.getProperty("DB_URL"),PropertyManager.getProperty("DB_USERNAME"),PropertyManager.getProperty("DB_PASSWORD"));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println("Connection Error : " +e.toString());
		}
	return con;
	}
}
