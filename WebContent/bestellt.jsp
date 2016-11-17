<%-- 
    Document   : index
    Created on : 04.10.2016
    Author     : Leon
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<%@ page import="classes.Artikel" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="./resources/css/index.css">
<title>Partyshop</title>
</head>
<body>

	<header class="standard">
		<div class="header-logo">
			<a href="/Partyshop"> <img class="logo"
				src="resources/images/logo.png">
			</a>
		</div>
		<div class="header-logo-mobile">
			<a href="/Partyshop"> <img class="logo"
				src="resources/images/mlogo.png">
			</a>
		</div>

		<div class="headerlogos">
			
			<%
			if(session.getAttribute("user") == null)
			{
				out.println("<div class=\"headerlogo\">");
				out.println("<a class=\"user\" href=\"login\" >	</a>");
				out.println("<div class=\"headerdesc\">");
				out.println("<span class=\"headerdesc\">Login</span>");
			
			}
			else
			{
				out.println("<div class=\"headerlogo\" id=\"account\">");
				out.println("<a class=\"user\" href=\"#\"></a>");
				out.println("<div class=\"headerdesc\">");
				out.println("<span class=\"headerdesc\">Mein Konto</span>");
			
			}
			
			%>
			</div>
			<div class="dropdown">
				<div class="dropdownelement">
					<span class="drop">
						Meine persönlichen Daten
					</span>
				</div>
				<div class="dropdownelement">
					<span class="drop">
						Meine Bestellungen
					</span>
				</div>
				
				<div class="dropdownelement">
				<a href="login?act=logout">
					<span class="drop">
						Abmelden
					</span>
					</a>
				</div>
				
			
			
			</div>
				
			</div>
			<div class="headerlogo">
				<a class="cart" href="/Partyshop/Warenkorb"></a>
				<div class="headerdesc">
					<span class="headerdesc">
						Warenkorb
					</span>
				</div>
			</div>
			
		</div>
		<form action="Suche">
			<div class="search">
				

				<div class="searchbar">
					<input class="searchbar" placeholder="Suchen" type="text"
						name="searchtext">
				</div>

				<div class="searchlogo">
					<input class="searchlogo" type="submit" value="">
				</div>
			</div>
		</form>


	</header>



	<div class="content">
		<div class="content2">
		<h1>Vielen Dank für ihre Bestellung</h1><br>
		<a href="/Partyshop">
			<span class="headerdesc">
				Zurück zur Startseite
			</span>
		</a>
		
		</div>
	</div>
	<div class="footer">
		<a href="">Impressum</a>
		<a href="">FAQ</a>
		<a href="">Ananas</a>
	</div>
</body>
</html>
