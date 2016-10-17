<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
</head>
<body ng-app="recruiterModule">
	<%@include file="../includes/navbar.jsp"%>

	<div ng-controller="recruiterEventController as vm"
		class="ui container padded">
		<%@include file="../includes/status.jsp"%>
		<button ng-click="vm.addEvent()" class="ui green button"><i class="plus icon"></i>Nieuw Event</button>
		<table class="ui striped table">
			<thead>
				<tr>
					<th>Titel</th>
					<th>Start</th>
					<th>Eind</th>
					<th>Inschrijvingen</th>
					<th>Plek(over)</th>
					<th>Plek(totaal)</th>
					<th> </th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="event in vm.events">
					<td>{{ event.title }}</td>
					<td>{{ event.startFormatted }}</td>
					<td>{{ event.endFormatted }}</td>
					<td>{{ event.attendees.length }}</td>
					<td>{{ event.vacancy - event.attendees.length }}</td>
					<td>{{ event.vacancy }}</td>
					<td><a ng-click="vm.updateEvent()"><i class="write icon"></i></a> <a ng-click="vm.removeEvent()"><i class="remove icon"></i></a></td>
				</tr>
			</tbody>
		</table>

	</div>
	<%@include file="../includes/footer.jsp"%>
	<script src="<c:url value="/resources/js/pages/recruiterModule.js" />"></script>
	<script src="<c:url value="/resources/js/pages/recruiterEventController.js" />"></script>
	<script src="<c:url value="/resources/js/moments.js" />"></script>
</body>
</html>