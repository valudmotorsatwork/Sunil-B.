package world.app;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import world.dao.CityDAO;
import world.domain.City;
import world.domain.DataSourceResult;

/**
 * City Browser Web Application With CRUD (Server Side Pagination)
 * @ Sunil Birute
 */
@WebServlet("/CityPaginateController")
public class CityPaginateController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    CityDAO cityDao;   
 
    public CityPaginateController() {
        super();
        cityDao = new CityDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int take= request.getParameter("take")==null ? 5: Integer.parseInt(request.getParameter("take")); 
		int skip= request.getParameter("skip")==null ? 0: Integer.parseInt(request.getParameter("skip"));
		DataSourceResult result = new DataSourceResult();
		result.setData(cityDao.loadAllCity(skip,take));
		result.setTotal(cityDao.getCount());
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(result));
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
		System.out.println(city.getCityName());
		return city;
	}
}
