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
				<nav>

					<a href="#" id="menu-icon"><img class="threelines"
						src="resources/images/threelines.png"></a>

					<ul>
						<li class="headline"> Alle Kategorien </span>
						<%
							ArrayList<Kategorie> kats = (ArrayList<Kategorie>) request.getAttribute("kategorien");
							for (Kategorie kat : kats) {
								out.println("<li class=\"categories\"><a href=\"/Partyshop/Kategorie?id=" + kat.getKategorieid() + "\">"
										+ kat.getBezeichnung() + "</a></li>");
							}
						%>

					</ul>

				</nav>

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

		<div class="categories">
			<ul class="categories">
				<li class="categories"><a class="title">Kategorien</a></li>
				<%
					for (Kategorie kat : kats) {
						out.println("<li class=\"categories\"><a href=\"/Partyshop/Kategorie?id=" + kat.getKategorieid() + "\">"
								+ kat.getBezeichnung() + "</a></li>");
					}
				%>
			</ul>
		</div>


		<div class="content2">
			<div class="articles">
				<h1 class="article">Neuheiten</h1>

				<%
				ArrayList<Artikel> neu = (ArrayList<Artikel>) request.getAttribute("neu");
				for(int i = 0; i < 3; i++)
				{
					Artikel a = neu.get(i);
					out.println("<div class=\"article1\">");
					out.println("<a href=\"/Partyshop/Artikel?id=" + a.getArtikelid() + "\">");
					out.println("<img src=\"resources/images/" + a.getBild().getName()  + "\">");
					out.println("</a>");
					out.println("<div class=\"desc\">");
					out.println(a.getBezeichnung());
					out.println("</div>");
					out.println("</div>");
				}
				%>
				

			</div>
			
			<div class="articles">
				<h1 class="article">Bestseller</h1>

				<%
				ArrayList<Artikel> best = (ArrayList<Artikel>) request.getAttribute("best");
				for(int i = 0; i < 3; i++)
				{
					Artikel a = neu.get(i);
					out.println("<div class=\"article1\">");
					out.println("<a href=\"/Partyshop/Artikel?id=" + a.getArtikelid() + "\">");
					out.println("<img src=\"resources/images/" + a.getBild().getName()  + "\">");
					out.println("</a>");
					out.println("<div class=\"desc\">");
					out.println(a.getBezeichnung());
					out.println("</div>");
					out.println("</div>");
				}
				%>


				
			</div>

		</div>
	</div>
	<div class="footer">
		<a href="">Impressum</a>
		<a href="">FAQ</a>
		<a href="">Ananas</a>
	</div>

</body>
</html>
