package world.app;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import world.dao.LoginDAO;
import world.domain.Login;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{	    
			Login user = new Login();
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			boolean valid = LoginDAO.validateLogin(user);		    
			if (valid)
			{       
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser",user); 
				response.sendRedirect("worlddetail.jsp");       		
			}      
			else 
				response.sendRedirect("login.jsp");  
		} 
		catch (Throwable theException) 	    
		{
			System.out.println(theException); 
		}
	}
}