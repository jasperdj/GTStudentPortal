<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get There - Studenten Portal</title>
<%@include file="../includes/header.jsp"%>
</head>
<body>
	<%-- <%@include file="../includes/navbar.jsp"%>--%>
	<div class="ui inverted vertical masthead center aligned segment">
		<div class="ui container">
			<div class="ui large secondary inverted pointing menu">
				<a class="toc item"> <i class="sidebar icon"></i>
				</a> <a class="active item">Home</a> <a class="item">Work</a> <a
					class="item">Company</a> <a class="item">Careers</a>
				<div class="right item">
					<a class="ui inverted button">Log in</a> <a
						class="ui inverted button">Sign Up</a>
				</div>
			</div>
		</div>

		<div class="ui text container">
			<h1 class="ui inverted header">Event</h1>
			<h2>Beschrijving van het event.</h2>
			<div class="ui huge primary button">
				Schrijf je in!</i>
			</div>
		</div>
	</div>
	<div class="ui container padded">
		<h3>Welkom op de Get There Studenten Portal!</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis
			at sodales est, eu consequat metus. Proin neque eros, tincidunt
			suscipit arcu maximus, hendrerit efficitur nibh. Ut pellentesque
			libero sit amet ultricies placerat. Mauris id pretium dolor. Aliquam
			ullamcorper faucibus vehicula. Maecenas viverra lorem nec tincidunt
			sollicitudin. Vivamus rhoncus, est eu ullamcorper rhoncus, elit eros
			vehicula nunc, at accumsan quam lacus vel ipsum.</p>
		<%@include file="../includes/cards.jsp"%>
	</div>
	</div>
</body>
</html>