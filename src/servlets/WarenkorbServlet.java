package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class CartServlet
 */
@WebServlet("/Warenkorb")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarenkorbServlet() {
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
			HttpSession session=request.getSession(false);  
	        if(session!=null) 
	        {
	        	ArrayList<Position> cart = new ArrayList<Position>();
	        	if(session.getAttribute("cart") != null)
	        	{
	        		cart = (ArrayList<Position>) session.getAttribute("cart");
	        		request.setAttribute("cart", cart);
	        	}
	        	else
	        	{
	        		request.setAttribute("cart", cart);
	        	}
	        	
	        }
	        String nextJSP = "/warenkorb.jsp";
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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false); 
		ArrayList<Position> cart = (ArrayList<Position>) session.getAttribute("cart");
		String action = request.getParameter("act");
		if(action.equals("delete"))
		{
			Position delete;
			try {
				delete = new Position("?", "?", 1, 2.0);
			
			for(Position pos: cart)
			{
				if(pos.getArtikelbezeichnung().equals(request.getParameter("name")))
				{
					delete = pos;
				}
			}
			cart.remove(delete);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("refresh"))
		{
			for(Position pos: cart)
			{
				if(pos.getArtikelbezeichnung().equals(request.getParameter("name")))
				{
					pos.setMenge(Integer.parseInt(request.getParameter(pos.getArtikelbezeichnung())));;
				}
			}
		}
		session.setAttribute("cart", cart);
		doGet(request, response);
	}

}
