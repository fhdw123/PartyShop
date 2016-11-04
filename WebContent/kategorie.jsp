<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<%@ page import="classes.Artikel" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css"
	href="./resources/css/kategorie.css">
<title>Partyshop</title>
</head>
<body>
	<header class="standard">
	<div class="header-logo">
		<a href="/Partyshop"> <img class="logo" src="resources/images/logo.png">
		</a>
	</div>
	<div class="header-logo-mobile">
		<a href="/Partyshop"> <img class="logo" src="resources/images/mlogo.png">
		</a>
	</div>

	<div class="headerlogos">
		<div class="headerlogo">
			<img src="resources/images/user.png">
		</div>
		<div class="headerlogo">
			<img src="resources/images/cart.png">
		</div>
	</div>
	<form action="SearchServlet">
		<div class="search">
			<nav> <a href="#" id="menu-icon"><img class="threelines"
				src="resources/images/threelines.png"></a>

			<ul>
				<%
					ArrayList<Kategorie> kats = (ArrayList<Kategorie>) request.getAttribute("kategorien");
					for (Kategorie kat : kats) 
					{
						out.println("<li class=\"categories\"><a href=\"\">" + kat.getBezeichnung() + "</a></li>");
					}
				%>
			</ul>

			</nav>

			<div class="searchbar">
				<input class="searchbar" placeholder="Suchen" type="text"
					name="searchtext">
			</div>

			<div class="searchlogo">
				<input class="searchlogo" type="image"
					src="resources/images/lupe.png" alt="Submit">
			</div>
		</div>
	</form>


	</header>


	<div class="content">

		<div class="categories">
			<ul class="categories">
				<li class="categories"><a class="title">Kategorien</a></li>

				<%
					for (Kategorie kat : kats) 
					{
						out.println("<li class=\"categories\"><a href=\"\">" + kat.getBezeichnung() + "</a></li>");
					}
				%>

			</ul>
		</div>

		<div class="content2">
		
		
		<%
			
			ArrayList<Artikel> artikel = (ArrayList<Artikel>) request.getAttribute("artikel");
			for(Artikel art: artikel)
			{
				DecimalFormat df = new DecimalFormat("#.00");
				out.println("<div class=\"articles\">");
				out.println("<div class=\"single-article\">");
				out.println("<img src=\"resources/images/beispiel2.jpg\">");
				out.println("<div class=\"articlename\">");
				out.println("<span class=\"articlename\">" + art.getBezeichnung() + "</span>");
				out.println("</div>");
				out.println("<div class=\"price\">");
				out.println("<span class=\"price\">" + df.format(art.getPreis()) +"€</span>");
				out.println("</div></div></div>");
			}
		
		
		%>
			
			
				

			</div>
		</div>

</body>
</html>
