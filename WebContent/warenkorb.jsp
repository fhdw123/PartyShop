<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Position"%>
<%@ page import="classes.Artikel"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.File" %>
<%@ page import="classes.SqlConnection" %>
<%
/**
 * Darstellung des Warenkorbs
 * Alle Positionen werden hier angezeigt. Der Gesamtpreis wird dynamisch in diesem JSP berechnet
 */
%>
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
					DecimalFormat df = new DecimalFormat("0.00");
					double summe = 0;
					int anzArtikel = 0;
					if(positionen == null || positionen.size() == 0)
					{
						out.println("<h2>Ihr Warenkorb ist zur Zeit leer</h2>");
					}
					else
					{
						
						SqlConnection conn = new SqlConnection();
						summe = 0;
						
						for (Position pos : positionen) {
							
							summe += pos.getPreis() * pos.getMenge();
							anzArtikel += pos.getMenge();
							out.println("<div class=\"lineitem\">");
							out.println("<div class=\"lineitem-img\">");
							out.println("<img src=\"resources/images/" +conn.artikelMitBezeichnungLiefern(pos.getArtikelbezeichnung()).getBild().getName() + "\"></div>");
							out.println("<div class=\"lineitem-articlename\">");
							out.println("<span class=\"articlename\">" + pos.getArtikelbezeichnung() + "</span></div>");
							out.println("<div class=\"lineitem-price\">");
							out.println("<span class=\"price\">" + df.format(pos.getPreis()) + "€</span></div>");
							out.println("<div class=\"lineitem-amount\">");
							out.println("<form action=\"Warenkorb\" method=\"post\">");
							out.println("<input type=\"number\" min=\"1\" max=\"99\" name=\"" + pos.getArtikelbezeichnung() + "\" value=\"" + pos.getMenge() + "\">");
							out.println("<input class=\"refresh\" type=\"submit\" value=\"\" title=\"Aktualisieren\">");
							out.println("<input type=\"hidden\" name=\"act\" value=\"refresh\">");
							out.println("<input type=\"hidden\" name=\"name\" value=\"" + pos.getArtikelbezeichnung() + "\">");
							out.println("</form>");
							out.println("</div>");
							out.println("<form action=\"Warenkorb\" method=\"post\">");
							out.println("<div class=\"lineitem-delete\">");
							out.println("<input type=\"hidden\" name=\"act\" value=\"delete\">");
							out.println("<input type=\"hidden\" name=\"name\" value=\"" + pos.getArtikelbezeichnung() + "\">");
							out.println("<input class=\"trash\" type=\"submit\" value=\"\" title=\"Aus dem Warenkorb löschen\">");
							out.println("</div>");
							out.println("</form>");
							out.println("</div>");
						
						}
						conn.closeConnection();
					}
				%>

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
						out.println(anzArtikel);
					%> Artikel
				</span>
			</div>
			<%
				if(positionen != null && positionen.size() != 0)
				{
					out.println("<form action=\"bestellen\" method=\"post\">");
					out.println("<input type=\"hidden\" name=\"act\" value=\"order\">");
					out.println("<input class=\"order-button\" type=\"submit\" value=\"Zur Kasse\"></div>");					
					out.println("</form>");				
				}
			
			%>
			
		</div>
		</div>
		<div class="footer">
		<a href="">Impressum</a>
		<a href="">FAQ</a>
		<a href="">Ananas</a>
	</div>
</body>
</html>