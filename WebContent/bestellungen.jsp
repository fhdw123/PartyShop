<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="classes.User"%>
<%@ page import="classes.Position"%>
<%@ page import="classes.Bestellung"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.DecimalFormat" %>
<%
/**
 * Darstellung der vorherigen Bestellungen eines Users
 * Hier werden alle Besttelungen strukturiert dargestellt. 
 * Der Gesamtpreis, das Datum und alle Positionen der Bestellung werden angezeigt
 */
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css"
	href="./resources/css/bestellungen.css">
<title>Partyshop</title>
</head>
<body>
	<%
		ArrayList<Bestellung> bestellungen = (ArrayList<Bestellung>) request.getAttribute("bestellungen");
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
				<a href="MeineDaten">
					<span class="drop">
						Meine persönlichen Daten
					</span>
					</a>
			</div>
			<div class="dropdownelement">
				<a href="MeineBestellungen"><span class="drop"> Meine Bestellungen 
				</span></a>
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
	<%
		DecimalFormat df = new DecimalFormat("0.00");
		if(bestellungen == null || bestellungen.size() == 0)
		{
			out.println("<h1>Sie haben noch nicht bei uns bestellt</h1>");
		}
		for(Bestellung b: bestellungen)
		{
			ArrayList<Position> positionen = b.getPositionen();
	%>
			
			<div class="order">
			<div class="order-header">
				<div class="line">
					<div class="date">
						<span class="information"> Bestellt am </span>
					</div>

					<div class="sum">
						<span class="information"> Summe </span>
					</div>
					<div class="line">
						<div class="date">
							<span class="general"><%=b.getDatum()%></span>
						</div>
						<div class="sum">
							<span class="general"><%out.print(df.format(b.getPreis()));%>€</span>
						</div>
					</div>
				</div>
			</div>
			<div class="order-body">
				<div class="body-headlines">
					<div class="lineitem-articlename"><span class="general">Artikel</span></div>
					<div class="lineitem-price"><span class="general">Preis</span></div>
					<div class="lineitem-amount"><span class="general">Menge</span></div>
				</div>
			
		<%
			for(Position pos: positionen)
			{
		%>		
				
				<div class="lineitem">
					<div class="lineitem-articlename">
					<span class="general">
						<%=pos.getArtikelbezeichnung() %>
						</span>
					</div>
					<div class="lineitem-price">
						<span class="general"><%=df.format(pos.getPreis())%>€</span>
					</div>
					<div class="lineitem-amount">
					<span class="general">
						<%=pos.getMenge() %>
						</span>
					</div>
				</div>
				
				
				
	<%			
			}
		out.println("</div>");
		out.println("</div>");
		}
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
	
	%>
	</div>
	
	
	
	
	



	<div class="footer">
		<a href="">Impressum</a> <a href="">FAQ</a> <a href="">Ananas</a>
	</div>

</body>
</html>