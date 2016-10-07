<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
</head>
<body>

	<div class="ui vertical masthead center aligned segment">
		<%@include file="../includes/navbar.jsp"%>

		<div class="ui container">
			<h1 class="ui header">${event.title }</h1>
			<br> <br> 
			<a href="/event/${event.eventId}/signin" class="ui huge primary button">
				Schrijf je in! </a>
		</div>
	</div>
	<div class="ui main text container padded">
		<%@include file="../includes/status.jsp"%>

		<div>
			<div></div>
			<div>
				<h4>${event.title }</h4>
				<p>${event.description }</p>
			</div>
		</div>

	</div>

</body>
</html>