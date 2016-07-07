package world.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import world.dao.CityDAO;
import world.domain.City;
import world.domain.Country;

/**
 * Servlet implementation class CityController
 */
@WebServlet("/CityController")
public class CityController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    CityDAO cityDao;   
 
    public CityController() {
        super();
        cityDao = new CityDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<City> cities = cityDao.loadAllCity();
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(cities));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			if(request.getParameter("action").equals("Create"))
				cityDao.saveRecord(parseRequest(request));
			else if(request.getParameter("action").equals("Update"))
				cityDao.updateRecord(parseRequest(request));
			if(request.getParameter("action").equals("Delete"))
				cityDao.deleteRecord(request.getParameter("cityId"));
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	// Retrieve and set data to City object from jsp page
	public City parseRequest(HttpServletRequest request)
	{
		City city = new City();
		city.setCityId(request.getParameter("cityId"));
		city.setCityName(request.getParameter("cityName"));
		city.setCityCountryCode(request.getParameter("cityCountryCode"));
		city.setCityDistrict(request.getParameter("cityDistrict"));
		city.setCityPopulation(request.getParameter("cityPopulation"));
		return city;
	}
}
