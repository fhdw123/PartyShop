package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Artikel;
import classes.Position;
import classes.SqlConnection;

/**
 * Servlet implementation class InWarenkorbLegen
 */
@WebServlet("/AddToCart")
public class InWarenkorbLegen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InWarenkorbLegen() {
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
			System.out.println(artikel.getBezeichnung());
			HttpSession session=request.getSession(false);  
	        if(session!=null) 
	        {
	        	ArrayList<Position> cart = new ArrayList<Position>();
	        	if(session.getAttribute("cart") != null)
	        	{
	        		cart = (ArrayList<Position>) session.getAttribute("cart");
	        		System.out.println(cart.size());
	        	}
	        	cart.add(new Position("?", artikel.getBezeichnung(), 1, artikel.getPreis() ));
	        	session.setAttribute("cart", cart);
	        }
	        response.sendRedirect("/Partyshop/Artikel?id=" + request.getParameter("id"));
	        
		}
		catch(Exception e)
		{
			response.getWriter().println("Error und so");
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
