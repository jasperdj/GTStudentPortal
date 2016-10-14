<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.css" />
</head>
<body>
	<%@include file="../includes/hidden_nav.jsp"%>
	<div class="pusher">
		<div class="ui vertical masthead center aligned segment">
			<%@include file="../includes/navbar.jsp"%>

			<div class="ui negative message transition">

				<div class="header">Oops.</div>
				<p>Hier is iets mis gegaan. Controleer de aub de URL.</p>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.min.js"></script>
	<script src="<c:url value="/resources/js/carousel.js" />"></script>
</body>
</html>