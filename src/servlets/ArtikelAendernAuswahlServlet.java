package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Artikel;
import classes.Kategorie;
import classes.SqlConnection;

/**
 * Servlet implementation class ArtikelAendernAuswahlServlet
 */
@MultipartConfig
@WebServlet("/ArtikelAendernAuswahl")
public class ArtikelAendernAuswahlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArtikelAendernAuswahlServlet() {
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
		String s = (String) request.getAttribute("SuccessMessage");
		if(s == null);
		{
		request.setAttribute("SuccessMessage", "");
		}
		request.setAttribute("bezeichnung", "");
		
		String nextJSP = "/artikelAendernAuswahl.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String act = request.getParameter("actChoose");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("anzeigen")) {

			String bezeichnung = request.getParameter("bezeichnung");

			try {
				SqlConnection con = new SqlConnection();
				Artikel a = con.artikelMitBezeichnungLiefern(bezeichnung);
				request.setAttribute("artikel", a);
				Kategorie kat = con.kategorienLiefernMitId(a.getKategorie());
				String katBez = kat.getBezeichnung();
				request.setAttribute("katBez", katBez);
				response.sendRedirect("ArtikelAendern?artikel="+a.getArtikelid()+"&katBez="+katBez);
				
				
			} catch (Exception e) {
				request.setAttribute("ErrorMessage", "Artikel wurde nicht gefunden!");
				request.setAttribute("SuccessMessage", "");
				request.setAttribute("bezeichnung", "");
				
				String nextJSP = "/artikelAendernAuswahl.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);

				

			}
		} 

	}

}
