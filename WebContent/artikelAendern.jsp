<%@page import="classes.SqlConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="classes.Kategorie"%>
<%@ page import="classes.Artikel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css"
	href="./resources/css/artikelAendern.css">
<title>Artikel ändern</title>
</head>
<body>

	<form action="ArtikelAendern" method="post"
		enctype="multipart/form-data">


		<header class="standard">
		<div class="header-logo">
			<a href="/AdminBereich"> <img class="logo"
				src="resources/images/logo.png">
			</a>
		</div>

		</header>

		<%
			String artikelid = request.getParameter("artikel");

			SqlConnection con = new SqlConnection();
			Artikel a = con.artikelMitIdLiefern(artikelid);

			Kategorie aktKat = con.kategorienLiefernMitId(a.getKategorie());

			con.closeConnection();
		%>

		<div class="data">

			<div class="element">
				<div class="name">Artikel-Id:</div>
				<input type="text" name="artikelid"
					value="<%out.print(a.getArtikelid());%>" readonly />
			</div>
			<div class="element">
				<div class="name">Bezeichnung:</div>
				<input type="text" name="bezeichnung"
					value="<%out.print(a.getBezeichnung());%>" />
			</div>
			<div class="element">
				<div class="name">Beschreibung:</div>
				<textarea cols="50" rows="10" name="beschreibung">
					<%
						out.print(a.getBeschreibung());
					%>
				</textarea>
			</div>
			<br>
			<div class="element">
				<div class="name">Preis:</div>
				<input type="text" name="preis" value="<%out.print(a.getPreis());%>" />
			</div>



			<div class="element">
				<div class="name">neue Kategorie:</div>
				<select name="kategorie" value="<%out.print(a.getKategorie());%>">
					<%
						ArrayList<Kategorie> kategorien = (ArrayList<Kategorie>) request.getAttribute("kategorien");
						for (int i = 0; i < kategorien.size(); i++) {
							String option = (String) kategorien.get(i).getBezeichnung();
							String aktuell = "";
							if (kategorien.get(i).getBezeichnung().equals(aktKat.getBezeichnung())) {
								aktuell = "selected=\"selected\"";
							}
					%>
					<option <%=aktuell%> value="<%=option%>"><%=option%></option>
					<%
						aktuell = "";
						}
					%>
				</select>
			</div>

			<div class="element">
				<input type="file" name="file"> <input type="submit"
					name="act" value="aendern">
			</div>


		</div>

	</form>



</body>
</html>