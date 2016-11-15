<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kunden entsperren</title>
</head>
<body>

<%
		final String errorMessage = (String) request.getAttribute("ErrorMessage");
	%>
	<%
		final String successMessage = (String) request.getAttribute("SuccessMessage");
	%>
	<%
		final String mail = (String) request.getAttribute("mail");
	%>

	<form action="KundenEntsperren" method="post">

		Mail: <input type="text" name="mail" value="<%=mail%>"/> <br>
		
		<input type="submit" name="act" value="entsperren"><br><br>
		
		<%=errorMessage%><br>
		<%=successMessage%><br>

	</form>


	

</body>
</html>