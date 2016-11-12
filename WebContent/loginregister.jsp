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
	<div class="logo">
		<img src="resources/images/mlogo.png">
	</div>
	<div class="full">
		<div class="half">
			<form action="ServletLogin" method="post">
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





				<input type="submit" name="act" value="login">



			</form>
		</div>
		<div class="half2">
			<form action="register" method="post">
			<div class="headline">
					<span class="headline"> Registrieren </span>
				</div>
				<div class="element">
					<div class="text">E-Mail:</div>

					<input type="text" name="mail" />
				</div>
				<div class="element">
					<div class="text">Passwort:</div>
					<input type="password" name="pw" />
				</div>	
				
				<div class="element">
					<div class="text">Passwort:</div>
					<input type="password" name="pw2" />
				</div>		
			
				<div class="element">
					<div class="text">Vorname:</div>

					<input type="text" name="vn" />
				</div>
			
				<div class="element">
					<div class="text">Nachname</div>

					<input type="text" name="nn" />
				</div>	
			
				<div class="element">
					<div class="text">Straﬂe</div>

					<input type="text" name="str" />
				</div>	
			
				<div class="element">
					<div class="text">Hausnummer:</div>

					<input type="text" name="hn" />
				</div>	
			
				<div class="element">
					<div class="text">PLZ:</div>

					<input type="text" name="plz" />
				</div>
			
				<div class="element">
					<div class="text">Ort:</div>

					<input type="text" name="ort" />
				</div>
			
				<input type="submit" name="act" value="registrieren">	
			</form>
		</div>
	</div>
</body>
</html>