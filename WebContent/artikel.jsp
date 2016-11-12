<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.Artikel" %>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="./resources/css/artikel.css">
<title>Partyshop</title>
</head>
<body>
<% 
Artikel art = (Artikel) request.getAttribute("artikel");
DecimalFormat df = new DecimalFormat("#.00");
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
			<div class="headerlogo">
			<%
			if(session.getAttribute("user") == null)
			{
				out.println("<a class=\"user\" href=\"registrieren.jsp\" >	</a>");
				out.println("<div class=\"headerdesc\">");
				out.println("<span class=\"headerdesc\">Login</span>");
				out.println("</div>");
				out.println("");
			}
			else
			{
				out.println("<a class=\"user\" href=\"\">	</a>");
				out.println("<div class=\"headerdesc\">");
				out.println("<span class=\"headerdesc\">Mein Konto</span>");
				out.println("</div>");
				out.println("");
			}
			
			%>
				
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
	<div class="articleimg">
		<img src="resources/images/beispiel2.jpg">
	</div>
	<div class="generalinfo">
		<div class="articlename">
			<span class="articlename">
				<%out.println(art.getBezeichnung()); %>
			</span>
		</div>
		<span class="information">
			Artikelnummer: <%out.println(art.getArtikelid()); %>
		</span>
		<div class="price">
			<span class="price">
				EUR <%out.println(df.format(art.getPreis())); %>
			</span>
			<br>
			<span class="information">
				inkl Mwst, keine Versandkosten
			</span>
		</div>
		
		<div class="stock">
			<span class="stock">
				Auf Lager
			</span>
		</div>
		<div class="addToCart">
			<form action="AddToCart">
				<input type="hidden" name="id" value="<%out.print(art.getArtikelid());%>">
				<input class="add" type="submit" value="In den Warenkorb">
			</form>
		</div>
	</div>
	<div class="desc">
		<span class="headline">
			Produktbeschreibung
		</span><br>
		<span class="proddesc">
			<%out.println(art.getBeschreibung()); %>	
		</span>
	</div>
</div>







</body>
</html>