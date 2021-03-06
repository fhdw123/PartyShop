package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Artikel;
import classes.Kategorie;
import classes.SqlConnection;

/**
 * Hier werden die ben�tigten Daten aus der Datenbank geholt, um eine Produktsammlung aus einer Kategorie anzuzeigen
 * Danach werden die Daten dem zugeh�rigen JSP �bermittelt
 */
@WebServlet("/Kategorie")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

			SqlConnection conn = new SqlConnection();
			ArrayList<Kategorie> kategorien = conn.kategorienLiefern();
			request.setAttribute("kategorien", kategorien);
			ArrayList<Artikel> artikel = conn.artikelInKategorieLiefern(request.getParameter("id"));
			request.setAttribute("artikel", artikel);
			conn.closeConnection();
			for(Kategorie kat: kategorien)
			{
				if(request.getParameter("id").equals(kat.getKategorieid()))
				{
					request.setAttribute("kategoriename", kat.getBezeichnung());
				}
					
			}
			conn.closeConnection();
			String nextJSP = "/kategorie.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
		}
		catch(Exception e)
		{
			String error = e.getMessage();
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
