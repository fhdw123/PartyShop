<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="ServletArticleCreation" method="doGet">

		Bezeichnung: <input type="text" name="bezeichnung" /> <br>
		
		Beschreibung: <input type="text" name="beschreibung" /> <br>
		
		Preis: <input type="text" name="preis" /> <br> 
		
		Kategorie: <input type="text" name="kategorie" /> <br>

	</form>


	<form action="ServletArticleCreation" method="doGet"
		enctype="multipart/form-data">
		<input type="file" name="file" />
		
		<input type="submit" name="act" value="anlegen"><br>	

	</form>


</body>
</html>