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
 * Servlet implementation class MitarbeiterErstellenServlet
 */
@WebServlet("/MitarbeiterErstellen")
public class MitarbeiterErstellenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("ErrorMessage", "");
		request.setAttribute("SuccessMessage", "");
		request.setAttribute("mail", "");
		request.setAttribute("pw", "");
		request.setAttribute("pw2", "");
		request.setAttribute("vn", "");
		request.setAttribute("nn", "");
		request.setAttribute("str", "");
		request.setAttribute("hn", "");
		request.setAttribute("plz", "");
		request.setAttribute("ort", "");
		
		String nextJSP = "/mitarbeiterErstellen.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mail = request.getParameter("mail").toLowerCase();
		String vname = request.getParameter("vn");
		String nname = request.getParameter("nn");
		String pass1 = request.getParameter("pw");
		String pass2 = request.getParameter("pw2");
		String rolle = "mitarbeiter";
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
		} else if (act.equals("anlegen")) {

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
								
								request.setAttribute("ErrorMessage", "");
								request.setAttribute("SuccessMessage", "Mitarbeiter wurde angelegt!");
								request.setAttribute("mail", "");
								request.setAttribute("pw", "");
								request.setAttribute("pw2", "");
								request.setAttribute("vn", "");
								request.setAttribute("nn", "");
								request.setAttribute("str", "");
								request.setAttribute("hn", "");
								request.setAttribute("plz", "");
								request.setAttribute("ort", "");
								
								String nextJSP = "/mitarbeiterErstellen.jsp";
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
								dispatcher.forward(request, response);


							} catch (Exception ex) {
								ex.printStackTrace();
							}
						} else {
							request.setAttribute("ErrorMessage", "Passwörter stimmen nicht überein!");
							request.setAttribute("SuccessMessage", "");
							request.setAttribute("mail", mail);
							request.setAttribute("pw", "");
							request.setAttribute("pw2", "");
							request.setAttribute("vn", "");
							request.setAttribute("nn", "");
							request.setAttribute("str", "");
							request.setAttribute("hn", "");
							request.setAttribute("plz", "");
							request.setAttribute("ort", "");
							
							String nextJSP = "/mitarbeiterErstellen.jsp";
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
							dispatcher.forward(request, response);
						}

					} else {
						request.setAttribute("ErrorMessageReg", "Postleitzahl ungültig!");
						request.setAttribute("mail", mail);
						request.setAttribute("pw", "");
						request.setAttribute("pw2", "");
						request.setAttribute("vn", vname);
						request.setAttribute("nn", nname);
						request.setAttribute("str", strasse);
						request.setAttribute("hn", hausnummer);
						request.setAttribute("plz","");
						request.setAttribute("ort", ort);
						
						String nextJSP = "/mitarbeiterErstellen.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("ErrorMessage", "Mailadresse wird schon verwendet!");
					request.setAttribute("mail", mail);
					request.setAttribute("pw", "");
					request.setAttribute("pw2", "");
					request.setAttribute("vn", vname);
					request.setAttribute("nn", nname);
					request.setAttribute("str", strasse);
					request.setAttribute("hn", hausnummer);
					request.setAttribute("plz","");
					request.setAttribute("ort", ort);
					
					String nextJSP = "/mitarbeiterErstellen.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request, response);

				}
			} else {
				request.setAttribute("ErrorMessage", "Bitte alle Felder ausfüllen!");
				request.setAttribute("mail", mail);
				request.setAttribute("pw", "");
				request.setAttribute("pw2", "");
				request.setAttribute("vn", vname);
				request.setAttribute("nn", nname);
				request.setAttribute("str", strasse);
				request.setAttribute("hn", hausnummer);
				request.setAttribute("plz","");
				request.setAttribute("ort", ort);
				
				String nextJSP = "/mitarbeiterErstellen.jsp";
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
