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

@WebServlet("/ServletAdminBereich")
public class AdminBereichServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBereichServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextJSP = "/adminBereich.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		
		
		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("Artikel anlegen")) {

			 nextJSP = "/ServletArtikelErstellen";
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);

		
		
	} else if (act.equals("Artikel ändern")) {

			nextJSP = "/ServletArtikelAendern";
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Artikel löschen")) {

		nextJSP = "/ServletArtikelLoeschen";
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kategorie anlegen")) {

		nextJSP = "/ServletKategorieErstellen";
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kategorie ändern")) {

		nextJSP = "/ServletKategorieAendern";
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kategorie verbergen")) {

		nextJSP = "/ServletKategorieUnsichtbar";
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kategorie sichtbar machen")) {

		nextJSP = "/ServletKategorieSichtbar";
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kunden verwalten")) {

		nextJSP = "/ServletKundenVerwalten";
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	}

}
