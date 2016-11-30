package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminBereichServlet
 */

/**
 * 
 * @author Jannik Reiffer
 *
 */
@WebServlet("/AdminBereich")
public class AdminBereichServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
    public AdminBereichServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextJSP = "/adminBereich.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("Artikel anlegen")) {

			response.sendRedirect("ArtikelErstellen");
		
	} else if (act.equals("Artikel ändern")) {

		response.sendRedirect("ArtikelAendernAuswahl");
	}
		
	else if (act.equals("Artikel löschen")) {

		response.sendRedirect("ArtikelLoeschen");
	}
		
	else if (act.equals("Kategorie anlegen")) {

		response.sendRedirect("KategorieErstellen");
	}
		
	else if (act.equals("Kategorie verbergen")) {

		response.sendRedirect("KategorieUnsichtbar");
	}
		
	else if (act.equals("Kategorie sichtbar machen")) {

		response.sendRedirect("KategorieSichtbar");
	}
		
		
	else if (act.equals("Mitarbeiter anlegen")) {

		response.sendRedirect("MitarbeiterErstellen");
	}
		
	else if (act.equals("Mitarbeiter loeschen")) {

		response.sendRedirect("MitarbeiterLoeschen");
	}
		
	else if (act.equals("Kunden sperren")) {

		response.sendRedirect("KundenSperren");
	}
		
	else if (act.equals("Kunden entsperren")) {

		response.sendRedirect("KundenEntsperren");
	}
		
	}

}
