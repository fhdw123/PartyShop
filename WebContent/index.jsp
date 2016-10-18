<%-- 
    Document   : index
    Created on : 04.10.2016
    Author     : Leon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="./resources/css/index.css">
<title>Partyshop</title>
</head>
<body>

	<header>
		<div class="header-logo">
			<a href=""> <img class="logo" src="resources/images/logo.png">
			</a>
		</div>

		<div class="searchbar">
			<input class="searchbar" placeholder="Suchen" type="text"
				name="search">
		</div>

		<div class="searchlogo">
			<input class="searchlogo" type="image"
				src="resources/images/lupe.png" alt="Submit">
		</div>

		<div class="headerlist">
			<ul class="header">
				<li class="header"><a href="login.jsp">Anmelden</a></li>
				<li class="header"><a href="registrieren.jsp">neu hier?</a></li>
				<li class="header"><a href="">Warenkorb</a></li>
			</ul>
		</div>

	</header>

	<div class="content">

		<div class="categories">
			<ul class="categories">
				<li class="categories"><a class="title">Kategorien</a></li>
				<li class="categories"><a href="">Geburtstag</a></li>
				<li class="categories"><a href="">Hochzeit</a></li>
				<li class="categories"><a href="">Weihnachten</a></li>
				<li class="categories"><a href="">Einfach so</a></li>
				<li class="categories"><a href="">Mottoparty</a></li>
				<li class="categories"><a href="">Ostern</a></li>
				<li class="categories"><a href="">Beerdigung</a></li>
			</ul>
		</div>


		<div class="content2">
			<div class="articles">
				<h1 class="article">Aktuelle Angebote</h1>

				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel1.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>

				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel2.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>


				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel3.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>

			</div>
			<div class="articles">
				<h1 class="article">Bestseller</h1>

				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel4.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>

				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel1.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>

				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel3.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>
			</div>
			<div class="articles">
				<h1 class="article">Bestseller</h1>

				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel4.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>

				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel1.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>

				<div class="article1">
					<a target="_blank" href=""> <img
						src="resources/images/beispiel3.jpg" alt="">
					</a>
					<div class="desc">beschreibung</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>
