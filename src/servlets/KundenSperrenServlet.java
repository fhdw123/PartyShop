package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.SqlConnection;
import classes.User;

/**
 * Servlet implementation class KundenEntsperrenServlet
 */
/**
 * 
 * @author Jannik Reiffer
 *
 */
@WebServlet("/KundenSperren")
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
		
		request.setAttribute("ErrorMessage", "");
		request.setAttribute("SuccessMessage", "");
		request.setAttribute("mail", "");
		
		String nextJSP = "/kundenSperren.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

String mail = request.getParameter("mail");
		
		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("sperren")) {
			
			try{
								
				SqlConnection con = new SqlConnection();
				
				User user = con.userMitMailLiefern(mail);
				
				if(user!=null)
				{
				con.userEntsperren(mail);
				request.setAttribute("ErrorMessage", "");
				request.setAttribute("SuccessMessage", "Kunde wurde gesperrt!");
				request.setAttribute("mail", "");
				
				String nextJSP = "/kundenSperren.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
				}
				else
				{
					request.setAttribute("ErrorMessage", "Kunde nicht vorhanden!");
					request.setAttribute("SuccessMessage", "");
					request.setAttribute("mail", "");
					
					String nextJSP = "/kundenSperren.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);
					
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
		}
		
	}

}
