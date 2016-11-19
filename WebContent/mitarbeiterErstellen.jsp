<%@page import="servlets.MitarbeiterErstellenServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css"
	href="./resources/css/mitarbeiterErstellen.css">
<title>Mitarbeiter erstellen</title>
</head>
<body>

	<%
		final String errorMessage = (String) request.getAttribute("ErrorMessage");
	%>
	<%
		final String successMessage = (String) request.getAttribute("SuccessMessage");
	%>
	<%
		final String mail = (String) request.getAttribute("mail");
	%>
	<%
		final String pw = (String) request.getAttribute("pw");
	%>
	<%
		final String pw2 = (String) request.getAttribute("pw2");
	%>
	<%
		final String vn = (String) request.getAttribute("vn");
	%>
	<%
		final String nn = (String) request.getAttribute("nn");
	%>
	<%
		final String str = (String) request.getAttribute("str");
	%>
	<%
		final String hn = (String) request.getAttribute("hn");
	%>
	<%
		final String plz = (String) request.getAttribute("plz");
	%>
	<%
		final String ort = (String) request.getAttribute("ort");
	%>


	<form action="MitarbeiterErstellen" method="post">

		<header class="standard">
		<div class="header-logo">
			<a href="/Partyshop/AdminBereich"> <img class="logo"
				src="resources/images/logo.png">
			</a>
		</div>

		</header>

		<div class="data">

			<div class="element">
				<div class="name">E-Mail:</div>
				<input type="text" name="mail" value="<%=mail%>" />
			</div>


			<div class="element">
				<div class="name">Passwort:</div>
				<input type="password" name="pw" value="<%=pw%>" />
			</div>

			<div class="element">
				<div class="name">Passwort wiederholen:</div>
				<input type="password" name="pw2" value="<%=pw2%>" />
			</div>

			<div class="element">

				<div class="name">Vorname:</div>
				<input type="text" name="vn" value="<%=vn%>" />
			</div>
			<div class="element">

				<div class="name">Nachname:</div>
				<input type="text" name="nn" value="<%=nn%>" />
			</div>
			<div class="element">

				<div class="name">Straße:</div>
				<input type="text" name="str" value="<%=str%>" />
			</div>
			<div class="element">

				<div class="name">Hausnummer:</div>
				<input type="text" name="hn" value="<%=hn%>" />
			</div>
			<div class="element">
				<div class="name">PLZ:</div>
				<input type="text" name="plz" value="<%=plz%>" />
			</div>
			
		
		<div class="element">

			<div class="name">
				Ort: </div><input type="text" name="ort" value="<%=ort%>" /></div> <input
					type="submit" name="act" value="anlegen">



			


			<br><br><span class="errmsg"> <%=errorMessage%><br>
			</span> <span class="sucmsg"> <%=successMessage%><br>
			</span>
	</form>

</body>


</html>