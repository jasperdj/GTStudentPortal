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

		<a href="#" ng-click="vm.showNewEvent()" class="ui green button"><i
			class="plus icon"></i>Nieuw Event</a>

		<table class="ui striped table">
			<thead>
				<tr>
					<th>Titel</th>
					<th>Start</th>
					<th>Eind</th>
					<th>Inschrijvingen</th>
					<th>Plek(over)</th>
					<th>Plek(totaal)</th>
					<th></th>
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
					<td><a href="#" ng-click="vm.updateEvent(event)"><i
							class="write icon"></i></a> <a href="#"
						ng-click="vm.removeEvent(event)"><i class="remove icon"></i></a></td>
				</tr>
			</tbody>
		</table>

		<div class="ui modal">
			<div class="ui main text container padded">
				<h3>Cre&euml;er nieuw event</h3>
				<form class="ui form" ng-model="newEvent"
					enctype="multipart/form-data">
					<div>
						<label for="title">Titel</label> <input ng-model="newEvent.title"
							type="text" name="title" id="title" required autofocus>
					</div>
					<div>
						<label for="image">Achtergrond</label> <input type="file"
							name="image" ng-model="image" id="image">
					</div>
					<div>
						<label for="location">Locatie</label> <input
							ng-model="newEvent.location" type="text" name="location"
							id="location" required>
					</div>
					<div>
						<label for="vacany">Plekken</label> <input
							ng-model="newEvent.vacancy" type="text" name="vacancy"
							id="vacancy" required>
					</div>
					<div>
						<label for="start">Startdatum + tijd</label> <input
							type="datetime-local" name="start" ng-model="start" id="start"
							required>
					</div>
					<div>
						<label for="end">Einddatum + tijd</label> <input ng-model="end"
							type="datetime-local" name="end" id="end" required>
					</div>
					<div>
						<label for="description">Beschrijving</label>
						<textarea ng-model="newEvent.description" name="description"
							id="description" cols=10></textarea>
					</div>
					<div>
						<label for="eventTypes">Soort event</label> <select
							ng-model="newEvent.eventTypes" id="eventTypes" name="eventTypes"
							multiple="true"
							ng-options="eventType as eventType.name for eventType in vm.eventTypes">
							<option class="noneOption"></option>
						</select>
					</div>
					<div>
						<label for="eventThemes">Thema's</label> <select
							ng-model="newEvent.eventThemes" id="eventThemes"
							name="eventThemes" multiple="true"
							ng-options="eventTheme as eventTheme.name for eventTheme in vm.eventThemes">
							<option class="noneOption"></option>
						</select>
					</div>
					<br>
					<button ng-click="vm.addEvent(newEvent, start, end)"
						class="ui positive right labeled icon button" type="submit">
						<i class="plus icon"></i>Cre&euml;er event
					</button>
					<br>
				</form>
				<br>
			</div>
		</div>
	</div>

	</div>
	<%@include file="../includes/footer.jsp"%>

	<script src="<c:url value="/resources/js/pages/recruiterModule.js" />"></script>
	<script
		src="<c:url value="/resources/js/pages/recruiterEventController.js" />"></script>
	<script src="<c:url value="/resources/js/moments.js" />"></script>
</body>
</html>