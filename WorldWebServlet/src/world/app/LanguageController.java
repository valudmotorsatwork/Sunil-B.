package world.app;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import world.dao.LanguageDAO;
import world.domain.CountryLanguage;

/**
 * Servlet implementation class LanguageController
 */
@WebServlet("/LanguageController")
public class LanguageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 LanguageDAO langDao;

   public LanguageController() {
       super();
       langDao = new LanguageDAO();
   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CountryLanguage> lang = langDao.loadAllLanguages();
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(lang));
		response.setContentType("application/json");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
