<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<%@ page import="classes.SqlConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css"
	href="./resources/css/artikelErstellen.css">
<title>Artikel erstellen</title>
</head>
<body>

	<%
		final String errorMessage = (String) request.getAttribute("ErrorMessage");
	    final String successMessage = (String) request.getAttribute("SuccessMessage");

		
	%>
	<%
		final String bezeichnung = (String) request.getAttribute("bezeichnung");
	%>
	<%
		final String beschreibung = (String) request.getAttribute("beschreibung");
	%>
	<%
		final String preis = (String) request.getAttribute("preis");
	%>


	<form action="ArtikelErstellen" method="post"
		enctype="multipart/form-data">

		Bezeichnung: <input type="text" name="bezeichnung"
			value="<%=bezeichnung%>" /> <br> Beschreibung: <br>
		<textarea cols="50" rows="10" name="beschreibung"
			value="<%=beschreibung%>"></textarea>
		<br> Preis: <input type="text" name="preis" value="<%=preis%>" />
		<br> Kategorie: <select name="kategorie">
			<%
			SqlConnection conn;
			ArrayList<Kategorie> kategorien = new ArrayList<Kategorie>();
			try {
				conn = new SqlConnection();
				kategorien = conn.kategorienLiefern();

			} catch (Exception e) {
				e.printStackTrace();
			}
				for (int i = 0; i < kategorien.size(); i++) {
					String option = (String) kategorien.get(i).getBezeichnung();
			%>
			<option value="<%=option%>"><%=option%></option>
			<%
				}
			%>
		</select> <input type="file" name="file"> <input type="submit"
			name="act" value="anlegen">  
			<br>
		<br>

		<%=errorMessage%><br>
		<%=successMessage%><br>	

	</form>



</body>
</html>