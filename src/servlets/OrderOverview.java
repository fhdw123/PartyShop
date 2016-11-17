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

import classes.Bestellung;
import classes.SqlConnection;
import classes.User;

/**
 * Servlet implementation class OrderOverview
 */
@WebServlet("/MeineBestellungen")
public class OrderOverview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderOverview() {
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
			User user = (User) session.getAttribute("user");
			ArrayList<Bestellung> bestellungen = (ArrayList<Bestellung>) conn.bestellungenVonUserLiefern(user.getUserid());
			request.setAttribute("bestellungen", bestellungen);
			
			conn.closeConnection();
	        String nextJSP = "/bestellungen.jsp";
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
		doGet(request, response);
	}

}
