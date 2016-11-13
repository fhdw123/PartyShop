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
import classes.User;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCart")
public class InDenWarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InDenWarenkorbServlet() {
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
			HttpSession session=request.getSession(false);  
	        if(session!=null) 
	        {
	        	ArrayList<Position> cart = new ArrayList<Position>();
	        	if(session.getAttribute("cart") != null)
	        	{
	        		cart = (ArrayList<Position>) session.getAttribute("cart");
	        	}
	        	boolean contains = false;
	        	for(Position pos: cart)
	        	{
	        		System.out.println(pos.getArtikelbezeichnung() + " " + artikel.getBezeichnung() );
	        		if(pos.getArtikelbezeichnung().equals(artikel.getBezeichnung()))
	        		{
	        			contains = true;
	        		}
	        	}
	        	if(!contains)
	        	{
	        		cart.add(new Position("?", artikel.getBezeichnung(), 1, artikel.getPreis() ));
	        	}
	        	
	        	session.setAttribute("cart", cart);
	        }
	        conn.closeConnection();
	        response.sendRedirect("/Partyshop/Warenkorb");
	        
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
