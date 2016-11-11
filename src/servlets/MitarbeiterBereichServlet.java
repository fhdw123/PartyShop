package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MitarbeiterBereichServlet
 */

@WebServlet("/ServletMitarbeiterBereich")
public class MitarbeiterBereichServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MitarbeiterBereichServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextJSP = "/mitarbeiterBereich.jsp";
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

			response.sendRedirect("/ServletArtikelErstellen");
		
	} else if (act.equals("Artikel ändern")) {

		response.sendRedirect("/ServletArtikelAendern");
	}
		
	else if (act.equals("Artikel löschen")) {

		response.sendRedirect("/ServletArtikelLoeschen");
	}
		
	else if (act.equals("Kategorie anlegen")) {

		response.sendRedirect("/ServletKategorieAnlegen");
	}
		
	else if (act.equals("Kategorie ändern")) {

		response.sendRedirect("/ServletKategorieAendern");
	}
		
	else if (act.equals("Kategorie verbergen")) {

		response.sendRedirect("/ServletKategorieUnsichtbar");
	}
		
	else if (act.equals("Kategorie sichtbar machen")) {

		response.sendRedirect("/ServletKategorieSichtbar");
	}

		
	else if (act.equals("Kunden sperren")) {

		response.sendRedirect("/ServletKundenSperren");
	}
		
	else if (act.equals("Kunden entsperren")) {

		response.sendRedirect("/ServletKundenEntsperren");
	}
		
	}

}
