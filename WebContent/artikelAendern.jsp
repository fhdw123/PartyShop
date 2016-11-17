<%@page import="classes.SqlConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<%@ page import="classes.Artikel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel ändern</title>
</head>
<body>

	<form action="ArtikelAendern" method="post"
		enctype="multipart/form-data">

		<%
			String artikelid = request.getParameter("artikel");

			SqlConnection con = new SqlConnection();
			Artikel a = con.artikelMitIdLiefern(artikelid);
			
			Kategorie aktKat = con.kategorienLiefernMitId(a.getKategorie());
			
			con.closeConnection();
		%>

		Artikel-Id: <input type="text" name="artikelid"
			value="<%out.print(a.getArtikelid());%>" readonly/> <br> Bezeichnung: <input
			type="text" name="bezeichnung"
			value="<%out.print(a.getBezeichnung());%>" /> <br> Beschreibung: <br>
		<textarea cols="50" rows="10" name="beschreibung" ><%out.print(a.getBeschreibung());%></textarea><br>
			 <br> Preis: <input
			type="text" name="preis" value="<%out.print(a.getPreis());%>" /> <br>
			
			aktuelle Kategorie:
		<input type="text" name="aktKategorie" value="<%out.print(aktKat.getBezeichnung());%>" readonly /><br>

		neue Kategorie: <select name="kategorie"
			value="<%out.print(a.getKategorie());%>">
			<%
				ArrayList<Kategorie> kategorien = (ArrayList<Kategorie>) request.getAttribute("kategorien");
				for (int i = 0; i < kategorien.size(); i++) {
					String option = (String) kategorien.get(i).getBezeichnung();
					String aktuell = "";
					if(kategorien.get(i).getBezeichnung().equals(aktKat.getBezeichnung()))
					{
						aktuell = "selected=\"selected\"";
					}
			%>
			<option <%=aktuell%> value="<%=option%>"><%=option%></option>
			<%
				aktuell="";
				}
			%>
		</select>
		 <input type="file" name="file"> <input type="submit"
			name="act" value="aendern">

	</form>



</body>
</html>