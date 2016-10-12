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
	<%@include file="../includes/status.jsp"%>
	<div class="ui vertical masthead center aligned segment">
		<%@include file="../includes/navbar.jsp"%>

		<div class="ui container">
			<h1 class="ui header">${event.title }</h1>
			<img src="/event_images/${event.imageUrl }">
			<h4>${event.attendees.size() }mensen hebben zich ingeschreven.
				Er zijn nog ${event.vacancy - event.attendees.size() } plekken over!</h4>
		<div ng-controller="eventDetailController as vm" class="ui container">
			<h1 class="ui header">{{vm.event.title}}</h1>
			<h4>{{vm.event.attendees.size()}} mensen hebben zich ingeschreven.</h4>
			<br> <br>
			
		</div>
	</div>

	<div class="ui vertical stripe segment">
		<div class="ui middle aligned stackable grid container">
			<div class="row">
				<div class="eight wide left floated column">
					<iframe id="gmap" frameborder="0" style="border:0"
						src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAm5BhArLbRFa1MTHUTVbfUT8QS-OJFtgo&q=${event.location }"
						allowfullscreen> </iframe>
				</div>
				<div class="eight wide column">
					<h3 class="ui header">{{vm.event.title}}</h3>
					<p>{{vm.event.description}}</p>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>