<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<%@ page import="classes.Artikel"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.Enumeration" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css"
	href="./resources/css/kategorie.css">
<title>Partyshop</title>
</head>
<body>
<%
String url=(String) request.getAttribute("javax.servlet.forward.request_uri") +"?";
Enumeration<String> paramNames = request.getParameterNames();
while (paramNames.hasMoreElements())
{
    String paramName = paramNames.nextElement();
    String[] paramValues = request.getParameterValues(paramName);
    for (int i = 0; i < paramValues.length; i++) 
    {
        String paramValue = paramValues[i];
        if(!paramName.equals("page"))
        {
        	url=url + paramName + "=" + paramValue;
        	url=url+"&";
        }
    }
    
}
url = url.substring(0, url.length() -1);
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
				<nav>
					<a href="#" id="menu-icon"><img class="threelines"
						src="resources/images/threelines.png"></a>

					<ul>
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
			<h1>
				Kategorie:
				<%
				out.println(request.getAttribute("kategoriename"));
			%>
			</h1>

			<%
				String pagenr = request.getParameter("page");
				int pagenumber;
				if (pagenr == null) {
					pagenumber = 1;
				} else {
					pagenumber = Integer.parseInt(pagenr);
				}
				ArrayList<Artikel> artikel = (ArrayList<Artikel>) request.getAttribute("artikel");

				for (int i = (pagenumber - 1) * 9; i < pagenumber * 9; i++) {
					if (artikel.size() <= i) {
						break;
					}

					Artikel art = artikel.get(i);
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

		
			<div class="changepage">
				<div class="prev<%if(pagenumber==1){out.print("-inactive");} %>">
					<%if(pagenumber!=1){out.print("<a class=\"change\" href=\"" +url +"&page="+ (pagenumber-1) + "\">");}%>
					<span class="prev"></span> Vorherige Seite
					<%if(pagenumber!=1){out.print("</a>");}%>
					
				</div>
				<div class="next<%if(artikel.size()<pagenumber*9){out.print("-inactive");}%>">
					<%if(artikel.size()>=pagenumber*9){out.print("<a class=\"change\" href=\"" +url +"&page="+ (pagenumber+1) + "\">");}%>
					<span class="next"> </span>Nächste Seite
					<%if(artikel.size()>=pagenumber*9){out.print("</a>");}%>
				</div>
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