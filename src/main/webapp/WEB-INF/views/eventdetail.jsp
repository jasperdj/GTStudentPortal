<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
</head>
<body ng-app="eventDetailModule">
	<%@include file="../includes/status.jsp"%>

	<div ng-controller="eventDetailController as vm">
		<div class="ui vertical masthead center aligned segment">
			<%@include file="../includes/navbar.jsp"%>

			<div class="ui container">
				<h1 class="ui header">{{vm.event.title}}</h1>
				<h4>{{vm.event.attendees.length}} mensen hebben zich
					ingeschreven.</h4>
				<br> <br>

			</div>
		</div>

		<div class="ui vertical stripe segment">
			<div class="ui middle aligned stackable grid container">
				<div class="row">
					<div class="eight wide left floated column">
						<iframe id="gmap" frameborder="0" style="border:0"
							src="{{vm.gmapurl}}" allowfullscreen> </iframe>
					</div>
					<div class="eight wide column">
						<h3 class="ui header">{{vm.event.title}}</h3>
						<p>{{vm.event.description}}</p>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script
		src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-route.js"></script>
	<script
		src="<c:url value="/resources/js/pages/eventDetailModule.js" />"></script>
	<script
		src="<c:url value="/resources/js/pages/eventDetailController.js" />"></script>
</body>
</html>