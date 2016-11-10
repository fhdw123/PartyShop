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
		
		response.sendRedirect("/adminBereich.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("Artikel anlegen")) {

			 String nextJSP = "/ServletArtikelErstellen";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
		
	} else if (act.equals("Artikel ändern")) {

		String nextJSP = "/ServletArtikelAendern";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Artikel löschen")) {

		String nextJSP = "/ServletArtikelLoeschen";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kategorie anlegen")) {

		String nextJSP = "/ServletKategorieErstellen";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kategorie ändern")) {

		String nextJSP = "/ServletKategorieAendern";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kategorie verbergen")) {

		String nextJSP = "/ServletKategorieUnsichtbar";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kategorie sichtbar machen")) {

		String nextJSP = "/ServletKategorieSichtbar";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	else if (act.equals("Kunden verwalten")) {

		String nextJSP = "/ServletKundenVerwalten";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
		
	}

}
