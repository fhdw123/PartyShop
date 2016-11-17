<%@page import="servlets.MitarbeiterErstellenServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mitarbeiter erstellen</title>
</head>
<body> 

    <%
		final String errorMessage = (String) request.getAttribute("ErrorMessage");
	%>
	<%
		final String successMessage = (String) request.getAttribute("ErrorMessage");
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
	

<form action="MitarbeiterErstellen" method="post">

			E-Mail:	
			<input type="text" name="mail" value="<%=mail%>"/><br>		
		
			Passwort:
			<input type="password" name="pw" value="<%=pw%>"/><br>		
			
			Passwort wiederholen:
			<input type="password" name="pw2" value="<%=pw2%>"/><br>		
			
			Vorname:
			<input type="text" name="vn" value="<%=vn%>"/><br>		
			
			Nachname:
			<input type="text" name="nn" value="<%=nn%>"/><br>		
			
			Straße:
			<input type="text" name="str" value="<%=str%>"/><br>		
			
			Hausnummer:
			<input type="text" name="hn" value="<%=hn%>"/><br>		
			
			PLZ:
			<input type="text" name="plz" value="<%=plz%>"/><br>		
			
			Ort:
			<input type="text" name="ort" value="<%=ort%>"/><br>	<br>		
			
			<input type="submit" name="act" value="anlegen"><br><br>
			
			<%=errorMessage%><br>	
			<%=successMessage%><br>		
		
		
		
		</form>
 
 </body>


</html>