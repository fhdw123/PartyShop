<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Position"%>
<%@ page import="classes.Artikel"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="classes.User" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css"
	href="./resources/css/bestellen.css">
<title>Partyshop</title>
</head>
<body>
<%
User u = (User) request.getAttribute("user");
%>
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
				if (session.getAttribute("user") == null) {
					out.println("<div class=\"headerlogo\">");
					out.println("<a class=\"user\" href=\"login\" >	</a>");
					out.println("<div class=\"headerdesc\">");
					out.println("<span class=\"headerdesc\">Login</span>");

				} else {
					out.println("<div class=\"headerlogo\" id=\"account\">");
					out.println("<a class=\"user\" href=\"#\"></a>");
					out.println("<div class=\"headerdesc\">");
					out.println("<span class=\"headerdesc\">Mein Konto</span>");

				}
			%>
		</div>
		<div class="dropdown">
			<div class="dropdownelement">
				<span class="drop"> Meine persönlichen Daten </span>
			</div>
			<div class="dropdownelement">
				<span class="drop"> Meine Bestellungen </span>
			</div>

			<div class="dropdownelement">
				<a href="login?act=logout"> <span class="drop"> Abmelden
				</span>
				</a>
			</div>



		</div>

		</div>
		<div class="headerlogo">
			<a class="cart" href="/Partyshop/Warenkorb"></a>
			<div class="headerdesc">
				<span class="headerdesc"> Warenkorb </span>
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
		<h1>Bestellung bestätigen</h1>
		<div class="main">


			<div class="articles">

				<div class="headlines">

					<div class="headline-articlename">
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
					double summe = 0;
					
						summe = 0;
						for (Position pos : positionen) {
							summe += pos.getPreis() * pos.getMenge();
							out.println("<div class=\"lineitem\">");
							out.println("<div class=\"lineitem-articlename\">");
							out.println("<span class=\"articlename\">" + pos.getArtikelbezeichnung() + "</span></div>");
							out.println("<div class=\"lineitem-price\">");
							out.println("<span class=\"price\">" + df.format(pos.getPreis()) + "€</span></div>");
							out.println("<div class=\"lineitem-amount\">");
							out.println("<span class=\"articlename\">" + pos.getMenge() + "</span>" );
							out.println("</div>");
							out.println("</div>");
						
						
						}
				%>

			</div>
			<div class="address">
				
				<div class="headline">
					<span class="address">
					Lieferadresse
				</span>
				</div>
				
				<div class="element">
				<div class="text">
					Vorname
				</div>
				<div class="text2">
					<%=u.getVorname() %>
				</div></div>
				<div class="element"><div class="text">
					Nachname
				</div>
				<div class="text2">
					<%=u.getNachname() %>
				</div></div>
				<div class="element"><div class="text">
					Straße
				</div>
				<div class="text2">
					<%=u.getStrasse() %>
				</div></div>
				<div class="element"><div class="text">
					Hausnummer
				</div>
				<div class="text2">
					<%=u.getHausnummer() %>
				</div></div>
				<div class="element"><div class="text">
					Postleitzahl
				</div>
				<div class="text2">
					<%=u.getPostleitzahl() %>
				</div></div>
				<div class="element"><div class="text">
					Ort
				</div>
				<div class="text2">
					<%=u.getOrt() %>
				</div></div>
			</div>
		</div>
		<div class="order">
			<div class="order2">
				<span class="sum">Summe: <%
				if(summe != 0)
					out.println(df.format(summe));
				else
					out.println("0");
				%>€</span>
			</div>
			<div class="order2">
				<span class="articles">
					<%
						out.println(positionen.size());
					%> Artikel
				</span>
			</div>
			<%
				if(positionen != null && positionen.size() != 0)
				{
					out.println("<input class=\"order-button\" value=\"Bestätigen\">");
				}
			
			%>
			
		</div>
</body>
</html>