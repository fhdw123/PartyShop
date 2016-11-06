<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Position"%>
<%@ page import="classes.Artikel"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css"
	href="./resources/css/warenkorb.css">
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
			<div class="headerlogo">
				<img src="resources/images/user.png">
			</div>
			<div class="headerlogo">
				<img src="resources/images/cart.png">
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
	<h1>Warenkorb</h1>
		<div class="main">
			

			<div class="articles">

				<div class="headlines">

					<div class="headline-articlename" style="margin-left: 300px">
						<span class="articlename-bold">Artikel</span>
					</div>
					<div class="headline-price">
						<span class="price-bold">Preis</span>
					</div>
					<div class="headline-amount">
						<span class="price-bold">Menge</span>
					</div>

				</div>
				<%
				ArrayList<Position> positionen = (ArrayList<Position>) request.getAttribute("cart");
				DecimalFormat df = new DecimalFormat("#.00");
				for(Position pos: positionen)
				{
					out.println("<div class=\"lineitem\">");
					out.println("<div class=\"lineitem-img\">");
					out.println("<img src=\"resources/images/beispiel2.jpg\"></div>");
					out.println("<div class=\"lineitem-articlename\">");
					out.println("<span class=\"articlename\">" + pos.getArtikelbezeichnung() + "</span></div>" );
					out.println("<div class=\"lineitem-price\">");
					out.println("<span class=\"price\">" + df.format(pos.getPreis()) + "€</span></div>");
					out.println("<div class=\"lineitem-amount\">");
					out.println("<input type=\"text\" value=\""+ pos.getMenge() + "\">");
					out.println("</div>");
					out.println("<div class=\"lineitem-delete\">delete</div>");
					out.println("</div>");
					out.println("");
				}
				
				
				%>
				<!--  
				<div class="lineitem">
					<div class="lineitem-img">
						<img src="resources/images/beispiel2.jpg">
					</div>
					<div class="lineitem-articlename">
						<span class="articlename">Beliebiger ARtikelname für
							artikel</span>
					</div>
					<div class="lineitem-price">
						<span class="price">25,99€</span>
					</div>
				</div>
			</div>
	 -->

		</div>
	</div>
	<div class="order">dies das</div>



</body>
</html>