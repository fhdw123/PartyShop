<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="classes.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css"
	href="./resources/css/adminBereich.css">
<title>Administratorenbereich</title>
</head>
<body> 

<header class="standard">
	<div class="header-logo">
		<a href="/Partyshop/AdminBereich"> <img class="logo"
			src="resources/images/logo.png">
		</a>
		</div>
		
		<div class="abmelden" style="margin-top: 50px;margin-right: 30px;">
		<a style="color: black;" href="login?act=logout">
					<span class="drop">
						Abmelden
					</span>
					</a>
					</div>
	

	</header>

<form action="AdminBereich" method="post">

<%
  User user = (User) session.getAttribute("user");
  String rolle = user.getRolle();

%>

<div class="data">
			
			<div class="element1">
			<input type="submit" name="act" value="Artikel anlegen"></div>
			
			<div class="element1">
			<input type="submit" name="act" value="Artikel ändern"></div>
			
			<div class="element1">
			<input type="submit" name="act" value="Artikel löschen"></div>
			
			<div class="element2">
			<input type="submit" name="act" value="Kategorie anlegen"></div>
			
			<div class="element2">
			<input type="submit" name="act" value="Kategorie verbergen"></div>
			
			<div class="element2">
			<input type="submit" name="act" value="Kategorie sichtbar machen"></div>
	
	        <div class="element3">
			<input type="submit" name="act" value="Kunden sperren"></div>
			
			<div class="element3">
			<input type="submit" name="act" value="Kunden entsperren"></div>
			
			
			<%
			
			
			if(rolle.equals("administrator"))
			{
			
			%>
			<div class="element4">
			<input type="submit" name="act" value="Mitarbeiter anlegen"></div>
			
			<div class="element4">
			<input type="submit" name="act" value="Mitarbeiter loeschen"></div>
			<% 
			}

			%>
			
			
			</div>
		
		
		</form>
 
 </body>


</html>