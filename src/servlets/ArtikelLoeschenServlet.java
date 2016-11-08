package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ArtikelServlet
 */
@WebServlet("/ServletArtikelDeletion")
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
		
		SqlConnection conn;
		try {
			conn = new SqlConnection();
			ArrayList<Kategorie> kategorien = conn.kategorienLiefern();
			request.setAttribute("kategorien", kategorien);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String artikelid = request.getParameter("artikelid");
		
		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("loeschen")) {
			
			try{
				SqlConnection con = new SqlConnection();
				con.artikelLoeschen(artikelid);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
