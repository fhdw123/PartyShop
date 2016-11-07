package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.PasswortVerschluesselung;
import classes.User;
/**
 * Servlet implementation class RegistrierungServlet
 */
@WebServlet("/ServletRegistration")
public class RegistrierungServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String mail = request.getParameter("mail").toLowerCase();
		String vname = request.getParameter("vn");
		String nname = request.getParameter("nn");
		String pass1 = request.getParameter("pw");
		String pass2 = request.getParameter("pw2");
		String rolle = "kunde";
		String strasse = request.getParameter("str");
		;
		String hausnummer = request.getParameter("hn");
		;
		String plz = request.getParameter("plz");
		String ort = request.getParameter("ort");
		;

		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("registrieren")) {

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

								HttpSession session = request.getSession(false);
								session.setAttribute("user", user);

								String nextJSP = "/index.jsp";
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
								dispatcher.forward(request, response);

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
