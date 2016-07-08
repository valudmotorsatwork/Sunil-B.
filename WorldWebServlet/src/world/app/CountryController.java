package world.app;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import world.dao.CountryDAO;
import world.domain.Country;
@WebServlet("/CountryController")
public class CountryController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    CountryDAO cdao;
    public CountryController() {
        super();
        cdao = new CountryDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			List<Country> countries = (List<Country>) cdao.listProducts();	
			Gson gson = new Gson();
			response.setContentType("application/json");
			response.getWriter().write(gson.toJson(countries));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
	}
	
}
