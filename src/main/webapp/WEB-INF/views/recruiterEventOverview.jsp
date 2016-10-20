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

		<a href="/recruiter/events/new"  class="ui green button"><i
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
					<td><a href="/recruiter/events/{{event.eventId}}/"><i
							class="write icon"></i></a> <a href="#"
						ng-click="vm.removeEvent(event)"><i class="remove icon"></i></a></td>
				</tr>
			</tbody>
		</table>

		<div class="ui modal">
			<div class="ui main text container padded">
				<h3>Cre&euml;er nieuw event</h3>
				<form:form class="ui form" role="form" method="post"
					enctype="multipart/form-data">
					<div>
						<label for="title">Title</label> <input type="text" name="title"
							id="title" required autofocus>
					</div>

					<div>
						<label for="title">Images</label> <input type="file" name="image"
							id="image">
					</div>
					<div>
						<label for="start">Location</label> <input type="text"
							name="location" id="location" required>
					</div>
					<div>
						<label for="start">Vacancy</label> <input type="text"
							name="vacancy" id="vacancy" required>
					</div>
					<div>
						<label for="start">Event start</label> <input
							type="datetime-local" name="start" id="start" required>
					</div>
					<div>
						<label for="end">Event end</label> <input type="datetime-local"
							name="end" id="end" required>
					</div>
					<div>
						<label for="description">Description</label>
						<textarea name="description" id="description" cols=10></textarea>
					</div>
					<div>
						<label for="eventTypes">Event type</label> <select id="eventTypes"
							name="eventTypes" multiple="true">
							<option class="noneOption"></option>
						</select>
					</div>
					<div>
						<label for="eventThemes">Event theme</label> <select
							id="eventThemes" name="eventThemes" multiple="true">
							<option class="noneOption"></option>
						</select>
					</div>
					<br>
					<button class="ui green button" type="submit">
						<i class="plus icon"></i>Cre&euml;er event
					</button>
				</form:form>
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