package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Artikel;
import classes.SqlConnection;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/Artikel")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			SqlConnection conn = new SqlConnection();
			Artikel artikel = conn.artikelMitIdLiefern(request.getParameter("id"));
			request.setAttribute("artikel", artikel);
			
			
			conn.closeConnection();
			String nextJSP = "/artikel.jsp";
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	        dispatcher.forward(request,response);
		}
		catch(Exception e)
		{
			response.getWriter().println("Error dies das");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
