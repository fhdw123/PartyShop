<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css"
	href="./resources/css/loginregister.css">
<title>Partyshop</title>
</head>
<body>
	<%
		final String errorMessageReg = (String) request.getAttribute("ErrorMessageReg");
	%>
	<%
		final String errorMessageLog = (String) request.getAttribute("ErrorMessageLog");
	%>
	<%
		final String mail = (String) request.getAttribute("mail");
	%>
	<%
		final String pw = (String) request.getAttribute("pw");
	%>
	<%
		final String pw2 = (String) request.getAttribute("pw2");
	%>
	<%
		final String vn = (String) request.getAttribute("vn");
	%>
	<%
		final String nn = (String) request.getAttribute("nn");
	%>
	<%
		final String str = (String) request.getAttribute("str");
	%>
	<%
		final String hn = (String) request.getAttribute("hn");
	%>
	<%
		final String plz = (String) request.getAttribute("plz");
	%>
	<%
		final String ort = (String) request.getAttribute("ort");
	%>


	<div class="logo">
		<a href="/Partyshop"> <img src="resources/images/mlogo.png">
		</a>
	</div>
	<div class="full">
		<div class="half">
			<form action="login" method="post">
				<div class="headline">
					<span class="headline"> Login </span>
				</div>
				<div class="element">
					<div class="text">E-Mail:</div>

					<input type="text" name="mail" />
				</div>
				<div class="element">
					<div class="text">Passwort:</div>
					<input type="password" name="pw" />
				</div>



				<br> <input type="submit" name="act" value="login"><br>
				<br>

				<%=errorMessageLog%><br>

			</form>
		</div>
		<div class="half2">
			<form action="login" method="post">
				<div class="headline">
					<span class="headline"> Registrieren </span>
				</div>
				<div class="element">
					<div class="text">E-Mail:</div>

					<input type="text" name="mail" value="<%=mail%>" />
				</div>
				<div class="element">
					<div class="text">Passwort:</div>
					<input type="password" name="pw" value="<%=pw%>" />
				</div>

				<div class="element">
					<div class="text">Passwort:</div>
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

				<input type="submit" name="act" value="registrieren"><br>
				<br>

				<%=errorMessageReg%><br> <br>

			</form>
		</div>
	</div>
</body>
</html>