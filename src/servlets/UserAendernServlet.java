package servlets;

import java.io.IOException;

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
@WebServlet("/UserAendern")
public class UserAendernServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

		 request.setAttribute("ErrorMessage", "");
		 request.setAttribute("SuccessMessage", "");
		request.setAttribute("pw", "");
		request.setAttribute("pw2", "");

		

		
		String nextJSP = "/userAendern.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mail");
		String pass1 = request.getParameter("pw");
		String pass2 = request.getParameter("pw2");
		String vname = request.getParameter("vn");
		String nname = request.getParameter("nn");
		String strasse = request.getParameter("str");
		String hausnr = request.getParameter("hn");
		String plz = request.getParameter("plz");
		String ort = request.getParameter("ort");

		String act = request.getParameter("act");
		System.out.println(act);
		
		if (act.equals("Daten aendern")) {


			if (!mail.isEmpty() && !vname.isEmpty() && !nname.isEmpty() && !pass1.isEmpty() && !pass2.isEmpty()
					&& !strasse.isEmpty() && !hausnr.isEmpty() && !plz.isEmpty()
					&& !ort.isEmpty()) {

				if (mail.contains("@") && mail.contains(".")) {

					if (isPlz(plz)) {

						if (pass1.equals(pass2)) {

							try {

								PasswortVerschluesselung pv = new PasswortVerschluesselung();
								HttpSession session = request.getSession(false);
								User user = (User) session.getAttribute("user");
								

								SqlConnection con = new SqlConnection();
								con.userAktualisieren(user.getUserid(), mail, vname, nname, pv.SHA512(pass1), strasse, hausnr, Integer.parseInt(plz), ort);

								User usr = con.userMitMailLiefern(mail);
								
								session = request.getSession(false);
								session.setAttribute("user", user);
								
								String nextJSP = "/userAendern.jsp";
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
								dispatcher.forward(request, response);


							} catch (Exception ex) {
								ex.printStackTrace();
							}
						} else {
							request.setAttribute("ErrorMessage", "Passwörter stimmen nicht überein!");
							request.setAttribute("SuccessMessage", "");
							request.setAttribute("pw", "");
							request.setAttribute("pw2", "");

							
							String nextJSP = "/userAendern.jsp";
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
							dispatcher.forward(request, response);
						}

					} else {

						request.setAttribute("ErrorMessage", "Postleitzahl ungültig!");
						request.setAttribute("SuccessMessage", "");
						request.setAttribute("pw", "");
						request.setAttribute("pw2", "");
						
						String nextJSP = "/userAendern.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("ErrorMessage", "Mailadresse ungültig!");
					request.setAttribute("SuccessMessage", "");
					request.setAttribute("pw", "");
					request.setAttribute("pw2", "");

					
					String nextJSP = "/userAendern.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);

				}
			} else {
				request.setAttribute("ErrorMessage", "Bitte alle Felder ausfüllen!");
				request.setAttribute("SuccessMessage", "");
				request.setAttribute("pw", "");
				request.setAttribute("pw2", "");

				
				String nextJSP = "/userAendern.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request, response);
			}
		}
		

	}
	
	
	

	/**
	 * 
	 * @param i
	 * @return
	 */
	public boolean isPlz(String i) {
		try {
			int num = Integer.parseInt(i);
			if (i.length() == 5) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			return false;
		}

	}

}
