package world.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import world.db.DBConnection;
import world.domain.Login;
public class LoginDAO
{
	static Connection conn = null;
	static ResultSet rs = null;  
	public static boolean validateLogin(Login bean) 
	{
		Statement stmt = null;
		boolean valid=false;
		String username = bean.getEmail();    
		String password = bean.getPassword();
		String searchQuery ="select * from logindetail where email='"+ username+ "' AND password='"+ password + "'";     
		try 
		{
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			if (!more) 
			{
				valid=false;
			} 
			else if (more) 
			{	
				valid=true;
			}
		} 
		catch (Exception ex) 
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		return valid;
	}

}
