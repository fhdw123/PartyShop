package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.PasswortVerschluesselung;
import classes.SqlConnection;
import classes.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ServletLogin")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextJSP = "/login.jsp";
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
    	dispatcher.forward(request,response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("login")) {

			try {

				SqlConnection con = new SqlConnection();

				User user = con.userMitMailLiefern(mail);
				con.closeConnection();
				
				if (user.getGesperrt() == 0) {
					PasswortVerschluesselung pv = new PasswortVerschluesselung();


						String hashPasswort = pv.SHA512(user.getPasswort());
						if (hashPasswort.equals(pass)) {

							if (user.getRolle().equals("kunde")) {



								HttpSession session = request.getSession(false);
								session.setAttribute("user", user);

								response.sendRedirect("/indexServlet");

							} else if (user.getRolle().equals("mitarbeiter")) {
								
								response.sendRedirect("/MitarbeiterBereichServlet");

							} else if (user.getRolle().equals("administrator")) {
								
								response.sendRedirect("/AdminBereichServlet");

							}

						

					}

			
			
				} else {
					// Ausgabe: User ist gesperrt
				}

				int i = 1;
			} catch (Exception ex) {
				// Mail Adresse nicht vorhanden
				ex.printStackTrace();
			}
	

		}

	}

}
