package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import classes.Artikel;
import classes.Kategorie;
import classes.SqlConnection;

/**
 * Servlet implementation class ArtikelAendernServlet
 */
@MultipartConfig
@WebServlet("/ArtikelAendern")
public class ArtikelAendernServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArtikelAendernServlet() {
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
		request.setAttribute("bezeichnung", "");
		

			SqlConnection conn;
			try {
				conn = new SqlConnection();
				ArrayList<Kategorie> kategorien = conn.kategorienLiefern();
				request.setAttribute("kategorien", kategorien);
			} catch (Exception e) {
				e.printStackTrace();
			}

			String nextJSP = "/artikelAendern.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String artikelid = request.getParameter("artikelid");
		String bezeichnung = request.getParameter("bezeichnung");
		String beschreibung = request.getParameter("beschreibung");
		String preisStr = request.getParameter("preis");
		String kategorie = request.getParameter("kategorie");

		

		String act = request.getParameter("act");
		if (act == null) {
			// no button has been selected
		} else if (act.equals("aendern")) {

			try {

				String kategorieid = "";
				
					SqlConnection con = new SqlConnection();
					kategorieid = con.kategorienLiefernMitBezeichnung(kategorie).getKategorieid();
				
					
				Part filePart = request.getPart("file");
				InputStream fileContent = filePart.getInputStream();

				String tmp_Dir = System.getProperty("java.io.tmpdir");
				File file = new File(tmp_Dir + "/" + bezeichnung + ".jpg");
				
				if(filePart!=null)
				{

				OutputStream out = new FileOutputStream(file);
				byte[] buf = new byte[1024];
				int len;
				while ((len = fileContent.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.close();
				fileContent.close();
				
				}

				Double preis = Double.parseDouble(preisStr);
				con.artikelAktualisieren(artikelid, bezeichnung, beschreibung, preis, kategorieid, file);
				con.closeConnection();
				request.setAttribute("ErrorMessage", "");
				request.setAttribute("SuccessMessage", "Artikel erfolgreich geändert!");
				
				response.sendRedirect("ArtikelAendernAuswahl");
				
			} catch (Exception ex) {
				request.setAttribute("ErrorMessage", "Änderung fehlgeschlagen!");
				request.setAttribute("SuccessMessage", "");
				
				response.sendRedirect("ArtikelAendernAuswahl");
			}

		}

	}

}
