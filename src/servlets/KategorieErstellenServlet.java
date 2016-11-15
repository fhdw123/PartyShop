package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import classes.Artikel;
import classes.Kategorie;
import classes.SqlConnection;

/**
 * Servlet implementation class KategorieErstellenServlet
 */
@WebServlet("/KategorieErstellen")
public class KategorieErstellenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KategorieErstellenServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("ErrorMessage", "");
		request.setAttribute("SuccessMessage", "");
		request.setAttribute("bezeichnung", "");
		
		String nextJSP = "/kategorieErstellen.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
String bezeichnung = request.getParameter("bezeichnung");
		
		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("anlegen")) {
			
			try{
				
				Kategorie kategorie = new Kategorie(bezeichnung);
				kategorie.kategorieErzeugen();
				
				request.setAttribute("ErrorMessage", "");
				request.setAttribute("SuccessMessage", "Kategorie angelegt!");
				request.setAttribute("bezeichnung", "");
				
				String nextJSP = "/kategorieErstellen.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
			}
			catch(Exception ex)
			{
				request.setAttribute("ErrorMessage", "Kategorie existiert bereits!");
				request.setAttribute("SuccessMessage", "");
				request.setAttribute("bezeichnung", bezeichnung);
				
				String nextJSP = "/kategorieErstellen.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
			}
			
			
			
		}

	}

}
