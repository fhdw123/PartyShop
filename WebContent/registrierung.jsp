<%@page import="servlets.RegistrationServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registriere dich beim Partyshop</title>
</head>
<body> 

<form action="ServletRegistration" method="post">

			E-Mail:	
			<input type="text" name="mail"/><br>		
		
			Passwort:
			<input type="password" name="pw"/><br>		
			
			Passwort wiederholen:
			<input type="password" name="pw2"/><br>		
			
			Vorname:
			<input type="text" name="vn"/><br>		
			
			Nachname:
			<input type="text" name="nn"/><br>		
			
			Straße:
			<input type="text" name="str"/><br>		
			
			Hausnummer:
			<input type="text" name="hn"/><br>		
			
			PLZ:
			<input type="text" name="plz"/><br>		
			
			Ort:
			<input type="text" name="ort"/><br>	<br>		
			
			<input type="submit" name="act" value="registrieren"><br>		
		
		
		
		</form>
 
 </body>


</html>