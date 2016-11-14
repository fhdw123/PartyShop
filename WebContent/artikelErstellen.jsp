<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel erstellen</title>
</head>
<body>

	<form action="ArtikelErstellen" method="post" enctype="multipart/form-data">

		Bezeichnung: <input type="text" name="bezeichnung" /> <br>

		Beschreibung: <br>
		<textarea cols="50" rows="10" name="beschreibung"></textarea><br>

		Preis: <input type="text" name="preis" /> <br> 
		
		Kategorie: <select name="kategorie">
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