<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css"
	href="./resources/css/kategorieSichtbar.css">
<title>Kategorie verbergen</title>
</head>
<body>

<header class="standard">
		<div class="header-logo">
			<a href="/Partyshop/AdminBereich"> <img class="logo"
				src="resources/images/logo.png">
			</a>
		</div>

		</header>

<%
		final String errorMessage = (String) request.getAttribute("ErrorMessage");
	%>
	<%
		final String successMessage = (String) request.getAttribute("SuccessMessage");
	%>
	<%
		final String bezeichnung = (String) request.getAttribute("bezeichnung");
	%>

	<form action="KategorieSichtbar" method="post">

		<div class="data">

			<div class="element">
				<div class="name">Bezeichnung: </div><input type="text" name="bezeichnung" value="<%=bezeichnung%>"/> </div>
		
		<div class="element">
			<input type="submit" name="actChoose" value="sichtbar machen"><br><br>
			</div>
			
			
			<div class="element">
				<span class="errmsg"> <%=errorMessage%><br>
				</span> <span class="sucmsg"> <%=successMessage%><br>
				</span>
			</div>
			
			
			</div>

</form>
	


</body>
</html>