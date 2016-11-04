<%-- 
    Document   : login
    Created on : 04.10.2016
    Author     : jannik
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="servlets.IndexServlet"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="classes.Kategorie" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="./resources/css/index.css">
<title>Partyshop</title>
</head>
<body>
	<form action="ServletLogin" method="post">

			E-Mail:	
			<input type="text" name="mail"/><br>		
		
			Passwort:
			<input type="password" name="pw"/><br>		
			
			
			
			<input type="submit" name="act" value="login"><br>		
		
		
		
		</form>


	


	
</body>
</html>
