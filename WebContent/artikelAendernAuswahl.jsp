<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel ändern</title>
</head>
<body>

<%
		final String errorMessage = (String) request.getAttribute("ErrorMessage");
final String successMessage = (String) request.getAttribute("SuccessMessage");

		
	%>
	<%
		final String bezeichnung = (String) request.getAttribute("bezeichnung");
	%>

	<form action="ArtikelAendernAuswahl" method="post">

		Bezeichnung: <input type="text" name="bezeichnung" value="<%=bezeichnung%>"/> <br>
		
			<input type="submit" name="actChoose" value="anzeigen"><br><br>
			
			<%=errorMessage%><br>
			<%=successMessage%><br>

</form>
	


</body>
</html>