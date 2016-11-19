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
 * Servlet implementation class ArtikelLoeschenServlet
 */
@WebServlet("/ArtikelLoeschen")
public class ArtikelLoeschenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArtikelLoeschenServlet() {
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

		String nextJSP = "/artikelLoeschen.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SqlConnection conn;
		try {
			conn = new SqlConnection();
			ArrayList<Kategorie> kategorien = conn.kategorienLiefern();
			request.setAttribute("kategorien", kategorien);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String bezeichnung = request.getParameter("bezeichnung");

		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("loeschen")) {

			try {
				SqlConnection con = new SqlConnection();
				Artikel a = con.artikelMitBezeichnungLiefern(bezeichnung);

				if (a.getArtikelid() != null) {
					con.artikelLoeschen(a.getArtikelid());

					request.setAttribute("ErrorMessage", "");
					request.setAttribute("SuccessMessage", "Artikel wurde entfernt!");
					request.setAttribute("bezeichnung", "");

					String nextJSP = "/artikelLoeschen.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("ErrorMessage", "Artikel wurde nicht gefunden!");
					request.setAttribute("SuccessMessage", "");
					request.setAttribute("bezeichnung", "");

					String nextJSP = "/artikelLoeschen.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
