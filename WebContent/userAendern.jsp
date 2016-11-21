<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="classes.User"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="./resources/css/userAendern.css">
<title>Kundendaten ändern</title>
</head>
<body>
	<%
	
	HttpSession sessionAkt = request.getSession(false);
	User user = (User) session.getAttribute("user");
	
		final String errorMessage = (String) request.getAttribute("ErrorMessage");
		final String successMessage = (String) request.getAttribute("SuccessMessage");
		final String mail = (String) user.getMail();
		final String pw = (String) request.getAttribute("pw");
		final String pw2 = (String) request.getAttribute("pw2");
		final String vn = (String) user.getVorname();
		final String nn = (String) user.getNachname();
		final String str = (String) user.getStrasse();
		final String hn = (String) user.getHausnummer();
		final String plz = (int) user.getPostleitzahl()+"";
		final String ort = (String) user.getOrt();;

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

	<form action="UserAendern" method="post">
		<div class="data">
				<div class="element">
					<div class="text">E-Mail:</div>

					<input type="text" name="mail" value="<%=mail%>" />
				</div>
				<div class="element">
					<div class="text">Passwort:</div>
					<input type="password" name="pw" value="<%=pw%>" />
				</div>

				<div class="element">
					<div class="text">Passwort wiederholen:</div>
					<input type="password" name="pw2" value="<%=pw2%>" />
				</div>

				<div class="element">
					<div class="text">Vorname:</div>

					<input type="text" name="vn" value="<%=vn%>" />
				</div>

				<div class="element">
					<div class="text">Nachname</div>

					<input type="text" name="nn" value="<%=nn%>" />
				</div>

				<div class="element">
					<div class="text">Straße</div>

					<input type="text" name="str" value="<%=str%>" />
				</div>

				<div class="element">
					<div class="text">Hausnummer:</div>

					<input type="text" name="hn" value="<%=hn%>" />
				</div>

				<div class="element">
					<div class="text">PLZ:</div>

					<input type="text" name="plz" value="<%=plz%>" />
				</div>

				<div class="element">
					<div class="text">Ort:</div>

					<input type="text" name="ort" value="<%=ort%>" />
				</div>

				 <div class="element">
					<input type="submit" name="act" value="Daten ändern">
				</div>

				<span class="errmsg">
				<%=errorMessage%><br>
				</span>
				<span class="errmsg">
				<%=successMessage%><br>
				</span>
				</div>
			</form>
		
	
</body>
</html>