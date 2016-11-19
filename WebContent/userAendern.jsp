<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="classes.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="./resources/css/userAendern.css">
<title>Kundendaten ‰ndern</title>
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
			<a href="AdminBereich"> <img class="logo"
				src="resources/images/logo.png">
			</a>
		</div>

		</header>

	
		<div class="data">
			<form action="UserAendern" method="post">
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
					<div class="text">Straﬂe</div>

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
					<input type="submit" name="act" value="Daten aendern">
				</div>

				<span class="errmsg">
				<%=errorMessage%><br>
				</span>
				<span class="errmsg">
				<%=successMessage%><br>
				</span>

			</form>
		</div>
	</div>
</body>
</html>