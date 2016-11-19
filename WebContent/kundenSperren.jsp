<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css"
	href="./resources/css/kundenSperren.css">
<title>Kunden sperren</title>
</head>
<body>

	<header class="standard">
	<div class="header-logo">
		<a href="/Partyshop/AdminBereich"> <img class="logo"
			src="resources/images/logo.png">
		</a>
	</div>

	</header>

	<%
		final String errorMessage = (String) request.getAttribute("ErrorMessage");
	%>

	<%
		final String successMessage = (String) request.getAttribute("SuccessMessage");
	%>
	<%
		final String mail = (String) request.getAttribute("mail");
	%>

	<form action="KundenSperren" method="post">

		<div class="data">

			<div class="element">
				<div class="name">Mail:</div>
				<input type="text" name="mail" value="<%=mail%>" />
			</div>

			<div class="element">
				<input type="submit" name="act" value="sperren"><br>
			</div>

			<div class="element">
				<span class="errmsg"> <%=errorMessage%><br>
				</span> <span class="sucmsg"> <%=successMessage%><br>
				</span>
			</div>
		</div>

	</form>




</body>
</html>