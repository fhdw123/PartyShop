<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<%@ page import="classes.Artikel"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="./resources/css/suche.css">
<title>Partyshop</title>
</head>
<body>

<%
String searchterm = request.getParameter("searchtext");
if(searchterm == null)
{
	searchterm = "";
}
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
				out.println("<a class=\"user\" href=\"login\" >	</a>");
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
				<nav>
					<a href="#" id="menu-icon"><img class="threelines"
						src="resources/images/threelines.png"></a>

					<ul>
					<li> Filtern nach Kategorie: </li>
						<%
							ArrayList<Kategorie> kats = (ArrayList<Kategorie>) request.getAttribute("kategorien");
							String checked;
							for (Kategorie kat : kats) {
								if (request.getAttribute(kat.getBezeichnung() + "checked") == null) {
									checked = "";
								} else {
									checked = request.getAttribute(kat.getBezeichnung() + "checked").toString();
								}

								out.println("<li><input type=\"checkbox\" name=\"kat\" value=\"" + kat.getBezeichnung() + "\"" + checked
										+ ">   "  + kat.getBezeichnung() + "<br></li>");
							}
						%>
						<li><input style="width: 55%; height: 80px; font-size: 40px" type="submit" value="Filter anwenden"></li>
					</ul>

				</nav>

				<div class="searchbar">
					<input class="searchbar" placeholder="Suchen" type="text"
						name="searchtext" value="<%=searchterm%>">
				</div>

				<div class="searchlogo">
					<input class="searchlogo" type="submit" value="">
				</div>
			</div>
		</form>


	</header>


	<div class="content">
		<form action="Suche" method="get">
			<div class="filter">
				<h2 class="filter">Filtern nach:</h2>
				<p class="filter">Kategorie</p>

				<%
					kats = (ArrayList<Kategorie>) request.getAttribute("kategorien");
					for (Kategorie kat : kats) {
						if (request.getAttribute(kat.getBezeichnung() + "checked") == null) {
							checked = "";
						} else {
							checked = request.getAttribute(kat.getBezeichnung() + "checked").toString();
						}

						out.println("<input type=\"checkbox\" name=\"kat\" value=\"" + kat.getBezeichnung() + "\"" + checked
								+ ">" + "<span class=\"filter\">" + kat.getBezeichnung() + "</span><br>");
					}
				%>
				<input type="submit" value="Filter anwenden">


			</div>
		</form>
		<div class="content2">


			<%
				ArrayList<Artikel> artikel = (ArrayList<Artikel>) request.getAttribute("artikel");
				for (Artikel art : artikel) {
					DecimalFormat df = new DecimalFormat("0.00");
					out.println("<div class=\"articles\">");
					out.println("<div class=\"single-article\">");
					out.println("<a href=\"/Partyshop/Artikel?id=" + art.getArtikelid() + "\">");
					out.println("<img src=\"resources/images/" + art.getBild().getName()  + "\">");
					out.println("</a>");
					out.println("<div class=\"articlename\">");
					out.println("<span class=\"articlename\">" + art.getBezeichnung() + "</span>");
					out.println("</div>");
					out.println("<div class=\"price\">");
					out.println("<span class=\"price\">" + df.format(art.getPreis()) + "€</span>");
					out.println("</div></div></div>");
				}
			%>




		</div>
	</div>

</body>
</html>