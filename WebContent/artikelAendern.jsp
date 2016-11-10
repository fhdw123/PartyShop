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

	<form action="ServletArtikelAendern" method="post" enctype="multipart/form-data">

<%
				Artikel a = (Artikel) request.getAttribute("artikel");

			%>

		Artikel-Id: <input type="text" name="artikelid" value="<%out.print(a.getArtikelid());%>"/> <br>
		
		Bezeichnung: <input type="text" name="bezeichnung" value="<%out.print(a.getBezeichnung());%>"/> <br>

		Beschreibung: <input type="text" name="beschreibung" value="<%out.print(a.getBeschreibung());%>"/> <br>

		Preis: <input type="text" name="preis" value="<%out.print(a.getPreis());%>"/> <br> 
		
		Kategorie: <select name="kategorie" value="<%out.print(a.getKategorie());%>">
			<%
				ArrayList<Kategorie> kategorien = (ArrayList<Kategorie>) request.getAttribute("kategorien");
				for (int i = 0; i < kategorien.size(); i++) {
					String option = (String) kategorien.get(i).getBezeichnung();
			%>
			<option value="<%=option%>"><%=option%></option>
			<%
				}
			%>
		</select>
		
		
					<input type="file" name="file"> 
			<input type="submit" name="act" value="anlegen">

</form>
	


</body>
</html>