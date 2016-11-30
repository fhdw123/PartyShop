package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

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

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServlet
 */
/**
 * 
 * @author Jannik Reiffer
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("act") != null && request.getParameter("act").equals("logout"))
		{
			HttpSession session=request.getSession(false); 
			session.setAttribute("user", null);
			response.sendRedirect("/Partyshop");
			return;
		}


		request.setAttribute("ErrorMessageReg", "");
		request.setAttribute("ErrorMessageLog", "");
		request.setAttribute("mail", "");
		request.setAttribute("pw", "");
		request.setAttribute("pw2", "");
		request.setAttribute("vn", "");
		request.setAttribute("nn", "");
		request.setAttribute("str", "");
		request.setAttribute("hn", "");
		request.setAttribute("plz", "");
		request.setAttribute("ort", "");
		request.setAttribute("maillog", "");

		
		String nextJSP = "/loginregister.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pw");

		String act = request.getParameter("act");
		System.out.println(act);
		if (act.equals("login")) {

			try {

				SqlConnection con = new SqlConnection();
				User user = con.userMitMailLiefern(mail);
				con.closeConnection();

				if (user.getGesperrt() == 0) {
					PasswortVerschluesselung pv = new PasswortVerschluesselung();

					String hashPasswort = pv.SHA512(pass);
					if (hashPasswort.equals(user.getPasswort())) {

						if (user.getRolle().equals("kunde")) {
							

							HttpSession session = request.getSession(false);
							session.setAttribute("user", user);
							if(request.getParameter("redirect") != null)
							{
								response.sendRedirect("Warenkorb");
							}
							else
							{
								response.sendRedirect("/Partyshop");
							}
							
						} else if (user.getRolle().equals("mitarbeiter")) {
							
							HttpSession session = request.getSession(false);
							session.setAttribute("user", user);

							response.sendRedirect("/Partyshop/AdminBereich");

						} else if (user.getRolle().equals("administrator")) {
							
							HttpSession session = request.getSession(false);
							session.setAttribute("user", user);

							response.sendRedirect("/Partyshop/AdminBereich");

						}

					} else {
						request.setAttribute("ErrorMessageReg", "");
						request.setAttribute("ErrorMessageLog", "Passwort nicht korrekt!");
						request.setAttribute("maillog", mail);
						request.setAttribute("mail", "");
						request.setAttribute("pw", "");
						request.setAttribute("pw2", "");
						request.setAttribute("vn", "");
						request.setAttribute("nn", "");
						request.setAttribute("str", "");
						request.setAttribute("hn", "");
						request.setAttribute("plz", "");
						request.setAttribute("ort", "");
						
						String nextJSP = "/loginregister.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
						dispatcher.forward(request, response);
					}

				} else {
					request.setAttribute("ErrorMessageReg", "");
					request.setAttribute("ErrorMessageLog", "Sie wurden gesperrt!");
					request.setAttribute("mail", "");
					request.setAttribute("pw", "");
					request.setAttribute("pw2", "");
					request.setAttribute("vn", "");
					request.setAttribute("nn", "");
					request.setAttribute("str", "");
					request.setAttribute("hn", "");
					request.setAttribute("plz", "");
					request.setAttribute("ort", "");

					String nextJSP = "/loginregister.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);
				}

				int i = 1;
			} catch (Exception ex) {
				request.setAttribute("ErrorMessageReg", "");
				request.setAttribute("ErrorMessageLog", "Mailadresse unbekannt!");
				request.setAttribute("maillog", mail);
				request.setAttribute("mail", "");
				request.setAttribute("pw", "");
				request.setAttribute("pw2", "");
				request.setAttribute("vn", "");
				request.setAttribute("nn", "");
				request.setAttribute("str", "");
				request.setAttribute("hn", "");
				request.setAttribute("plz", "");
				request.setAttribute("ort", "");
				
				String nextJSP = "/loginregister.jsp";
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		    	dispatcher.forward(request,response);
			}

		} else if (act.equals("registrieren")) {
			mail = request.getParameter("mail").toLowerCase();
			String vname = request.getParameter("vn");
			String nname = request.getParameter("nn");
			String pass1 = request.getParameter("pw");
			String pass2 = request.getParameter("pw2");
			String rolle = "kunde";
			String strasse = request.getParameter("str");
			String hausnummer = request.getParameter("hn");
			String plz = request.getParameter("plz");
			String ort = request.getParameter("ort");

			if (!mail.isEmpty() && !vname.isEmpty() && !nname.isEmpty() && !pass1.isEmpty() && !pass2.isEmpty()
					&& !rolle.isEmpty() && !strasse.isEmpty() && !hausnummer.isEmpty() && !plz.isEmpty()
					&& !ort.isEmpty()) {

				if (mail.contains("@") && mail.contains(".")) {

					if (isPlz(plz)) {

						if (pass1.equals(pass2)) {

							try {

								PasswortVerschluesselung pv = new PasswortVerschluesselung();
								User user = new User(mail, vname, nname, pv.SHA512(pass1), rolle, 0, strasse,
										hausnummer, Integer.parseInt(plz), ort);
								user.userAnlegen();

								SqlConnection con = new SqlConnection();

								HttpSession session = request.getSession(false);
								session.setAttribute("user", user);

								if(request.getParameter("redirect") != null)
								{
									response.sendRedirect("Warenkorb");
								}
								else
								{
									response.sendRedirect("/Partyshop");
								}

							} catch (Exception ex) {
								ex.printStackTrace();
							}
						} else {
							request.setAttribute("ErrorMessageReg", "Passwörter stimmen nicht überein!");
							request.setAttribute("ErrorMessageLog", "");
							request.setAttribute("mail", mail);
							request.setAttribute("pw", "");
							request.setAttribute("pw2", "");
							request.setAttribute("vn", vname);
							request.setAttribute("nn", nname);
							request.setAttribute("str", strasse);
							request.setAttribute("hn", hausnummer);
							request.setAttribute("plz",plz);
							request.setAttribute("ort", ort);
						}

					} else {

						request.setAttribute("ErrorMessageReg", "Postleitzahl ungültig!");
						request.setAttribute("ErrorMessageLog", "");
						request.setAttribute("mail", mail);
						request.setAttribute("pw", "");
						request.setAttribute("pw2", "");
						request.setAttribute("vn", vname);
						request.setAttribute("nn", nname);
						request.setAttribute("str", strasse);
						request.setAttribute("hn", hausnummer);
						request.setAttribute("plz","");
						request.setAttribute("ort", ort);

						String nextJSP = "/loginregister.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("ErrorMessageReg", "Mailadresse ungültig!");
					request.setAttribute("ErrorMessageLog", "");
					request.setAttribute("mail", "");
					request.setAttribute("pw", "");
					request.setAttribute("pw2", "");
					request.setAttribute("vn", vname);
					request.setAttribute("nn", nname);
					request.setAttribute("str", strasse);
					request.setAttribute("hn", hausnummer);
					request.setAttribute("plz",plz);
					request.setAttribute("ort", ort);
					String nextJSP = "/loginregister.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);

				}
			} else {
				request.setAttribute("ErrorMessageReg", "Bitte alle Felder ausfüllen!");
				request.setAttribute("ErrorMessageLog", "");
				request.setAttribute("mail", mail);
				request.setAttribute("pw", "");
				request.setAttribute("pw2", "");
				request.setAttribute("vn", vname);
				request.setAttribute("nn", nname);
				request.setAttribute("str", strasse);
				request.setAttribute("hn", hausnummer);
				request.setAttribute("plz",plz);
				request.setAttribute("ort", ort);

				String nextJSP = "/loginregister.jsp";
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
