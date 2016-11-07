package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Article;
import classes.Category;
import classes.SqlConnection;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Suche")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{

			SqlConnection conn = new SqlConnection();
			ArrayList<Category> kategorien = conn.showKategorien();
			request.setAttribute("kategorien", kategorien);
			ArrayList<Article> artikel = conn.showAllArtikels();
			
			
			
			String[] kategorieFilter;
			if((kategorieFilter = request.getParameterValues("kat")) != null)
			{
				HashMap<String, String> kategorienIds = new HashMap<String, String>();
				for(Category kategorie: kategorien)
				{
					kategorienIds.put(kategorie.getKategorieid(), kategorie.getBezeichnung());
				}
			
				ArrayList<Article> artikelCopy = new ArrayList<Article>();
				for(Article art: artikel)
				{
					boolean contains = false;
					for(String filter: kategorieFilter)
					{
						
						if(kategorienIds.get(art.getKategorie()).equals(filter))
						{
							contains = true;
						}
					}
					if(contains)
					{
						artikelCopy.add(art);
					}
					
				}
				for(String filter: kategorieFilter)
				{
					request.setAttribute(filter + "checked", "checked=\"checked\"");
				}
				artikel = artikelCopy;

				
			}
			request.setAttribute("artikel", artikel);
			conn.closeConnection();
			
			
			String nextJSP = "/search.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
