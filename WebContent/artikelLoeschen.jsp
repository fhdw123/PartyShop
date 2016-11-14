<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel löschen</title>
</head>
<body>

	<form action="ArtikelLoeschen" method="doGet">

		Bezeichnung: <input type="text" name="bezeichnung" /> <br>
		
		<input type="submit" name="act" value="loeschen">

	</form>


	

</body>
</html>