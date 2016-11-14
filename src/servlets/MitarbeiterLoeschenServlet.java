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
 * Servlet implementation class MitarbeiterLoeschenServlet
 */
@WebServlet("/MitarbeiterLoeschen")
public class MitarbeiterLoeschenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MitarbeiterLoeschenServlet() {
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
		request.setAttribute("mail", "");

		String nextJSP = "/mitarbeiterLoeschen.jsp";
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
		} else if (act.equals("loeschen")) {

			try {
				SqlConnection con = new SqlConnection();
				User user = con.mitarbeiterMitMailLiefern(mail);
				if (user != null) {
					con.mitarbeiterLoeschen(mail);

					request.setAttribute("ErrorMessage", "Mitarbeiter wurde gelöscht!");
					request.setAttribute("mail", "");

					String nextJSP = "/mitarbeiterLoeschen.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);

				} else {
					request.setAttribute("ErrorMessage", "Mitarbeiter wurde nicht gefunden!");
					request.setAttribute("mail", "");

					String nextJSP = "/mitarbeiterLoeschen.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

}
