package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import classes.Artikel;
import classes.Kategorie;
import classes.SqlConnection;

/**
 * Servlet implementation class KategorieUnsichtbarServlet
 */
/**
 * 
 * @author Jannik Reiffer
 *
 */
@MultipartConfig
@WebServlet("/KategorieSichtbar")
public class KategorieSichtbarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KategorieSichtbarServlet() {
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
		
		String nextJSP = "/kategorieSichtbar.jsp";
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
		} else if (act.equals("sichtbar machen")) {

			String bezeichnung = request.getParameter("bezeichnung");

			try {
				SqlConnection con = new SqlConnection();
				Kategorie k = con.kategorienUnsichtbarLiefernMitBezeichnung(bezeichnung);
				if(k != null)
				{
					con.kategorieSichtbar(k.getKategorieid());
				request.setAttribute("ErrorMessage", "");
				request.setAttribute("SuccessMessage", "Kategorie ist jetzt sichtbar!");
				request.setAttribute("bezeichnung", "");
				
				String nextJSP = "/kategorieUnsichtbar.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				}
				else
				{
					request.setAttribute("ErrorMessage", "Kategorie nicht vorhanden!");
					request.setAttribute("SuccessMessage", "");
					request.setAttribute("bezeichnung", bezeichnung);
					
					String nextJSP = "/kategorieSichtbar.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);
					
				}
				
				con.closeConnection();
				
				
			} catch (Exception e) {
				e.printStackTrace();

				

			}
			
			
		} 

	}

}
