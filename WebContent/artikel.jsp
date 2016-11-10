<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.Artikel" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Artikel art = (Artikel) request.getAttribute("artikel");
out.println(art.getBezeichnung());
out.println(art.getPreis());
%>


<form action="ServletInWarenkorbLegen">
	<input type="hidden" name="id" value="<%out.print(art.getArtikelid());%>">
	<input type="submit" value="Add to cart">
</form>
</body>
</html>