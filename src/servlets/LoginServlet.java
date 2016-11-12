package servlets;

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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextJSP = "/loginregister.jsp";
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
    	dispatcher.forward(request,response);

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
				System.out.println(user.getNachname());
				con.closeConnection();
				
				if (user.getGesperrt() == 0) {
					PasswortVerschluesselung pv = new PasswortVerschluesselung();


						String hashPasswort = pv.SHA512(user.getPasswort());
						if (hashPasswort.equals(pass)) {

							if (user.getRolle().equals("kunde")) {



								HttpSession session = request.getSession(false);
								session.setAttribute("user", user);

								response.sendRedirect("/Partyshop");

							} else if (user.getRolle().equals("mitarbeiter")) {
								
								response.sendRedirect("/Partyshop/MitarbeiterBereichServlet");

							} else if (user.getRolle().equals("administrator")) {
								
								response.sendRedirect("/Partyshop/AdminBereichServlet");

							}

						

					}
						else
						{
							System.out.println("pw stimmt nicht");
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
		else if(act.equals("registrieren"))
		{
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
									User user = new User(mail, vname, nname, pv.SHA512(pass1), rolle, 0, strasse, hausnummer,
											Integer.parseInt(plz), ort);
									user.userAnlegen();


									if (rolle.equals("kunde")) {

										SqlConnection con = new SqlConnection();

										HttpSession session = request.getSession(false);
										session.setAttribute("user", user);

										response.sendRedirect("/Partyshop");

									} else if (rolle.equals("mitarbeiter")) {
										
										response.sendRedirect("MitarbeiterBereichServlet");

									} else if (rolle.equals("administrator")) {
										
										response.sendRedirect("AdminBereichServlet");

									}

								} catch (Exception ex) {
									ex.printStackTrace();
								}
							} else {
								// Ausgabe: Passwörter stimmen nicht überein
							}

						} else {
							// Ausgabe: Postleitzahl ungültig
						}
					} else {
						// Ausgabe: bitte eine gültige Mailadresse angeben

					}
				} else {
					// Ausgabe: Daten fehlen
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
