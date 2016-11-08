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

	<form action="ServletArticleChanging" method="doGet">
	
	    Artikel-ID: <input type="text" name="artikelid" /> <br>

		Bezeichnung: <input type="text" name="bezeichnung" /> <br>

		Beschreibung: <input type="text" name="beschreibung" /> <br>

		Preis: <input type="text" name="preis" /> <br> 
		
		Kategorie: 
		<!--<select>
			<%
				ArrayList<Kategorie> kategorien = (ArrayList<Kategorie>) request.getAttribute("kategorien");
				for (int i = 0; i < kategorien.size(); i++) {
					String option = (String) kategorien.get(i).getBezeichnung();
			%>
			<option value="<%=option%>"><%=option%></option>
			<%
				}
			%>
		</select>-->
		

	</form>




</body>
</html>