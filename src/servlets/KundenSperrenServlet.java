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
 * Servlet implementation class KundenSperrenServlet
 */
@WebServlet("/ServletKundenSperren")
public class KundenSperrenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KundenSperrenServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("/kundenSperren.jsp");
		
		
		String mail = request.getParameter("mail");
		
		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("sperren")) {
			
			try{
				SqlConnection con = new SqlConnection();
				con.userSperren(mail);
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
