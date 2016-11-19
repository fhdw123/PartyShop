 package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Artikel;
import classes.Kategorie;
import classes.SqlConnection;
import classes.User;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
        	ArrayList<Kategorie> kategorien = conn.kategorienLiefern();
        	ArrayList<Artikel> neu = conn.neuesteZehnArtikelLiefern();
        	ArrayList<Artikel> best = conn.meistegkaufteZehnArtikelLiefern();
        	conn.closeConnection();
        	request.setAttribute("kategorien", kategorien);
        	request.setAttribute("neu", neu);
        	request.setAttribute("best", best);
        	String nextJSP = "/index.jsp";
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        	dispatcher.forward(request,response);  
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();        
        }
        

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
