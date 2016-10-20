<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Todo: Add visual error handling to form -->
<title>Get There - Studenten Portal | Login</title>
<%@include file="../includes/header.jsp"%>


</head>
<body>
	<%@include file="../includes/navbar.jsp"%>

	<div class="ui main text container padded">

		<form:form class="ui form" modelAttribute="event" role="form"
			method="post" enctype="multipart/form-data">
			<div>
				<label for="title">Title</label>
				<form:errors cssClass="form-error" path="title" />
				<form:input type="text" path="title" name="title" id="title"
					required="required" autofocus="autofocus" />
			</div>
			<div>
				<label for="title">Images</label> <input type="file" name="image"
					id="image">
			</div>
			<div>
				<label for="start">Location</label>
				<form:errors cssClass="form-error" path="location" />
				<form:input type="text" path="location" name="location"
					id="location" required="required" />
			</div>
			<div>
				<label for="start">Vacancy</label>
				<form:errors cssClass="form-error" path="vacancy" />
				<form:input type="number" path="vacancy" name="vacancy" id="vacancy" />
			</div>
			<div>
				<label for="start">Event start</label>
				<form:errors cssClass="form-error" path="start" />
				<form:input type="datetime-local" path="start" name="start"
					id="start" required="required" />
			</div>
			<div>
				<label for="end">Event end</label>
				<form:errors cssClass="form-error" path="end" />
				<form:input type="datetime-local" path="end" name="end" id="end"
					required="required" />
			</div>
			<div>
				<label for="description">Description</label>
				<form:errors cssClass="form-error" path="description" />
				<form:textarea path="description" name="description"
					id="description" cols="10"></form:textarea>
			</div>
			<div>
				<label for="eventTypes">Event type</label>
				<form:errors cssClass="form-error" path="eventTypes" />
				<form:select id="eventTypes" path="eventTypes" name="eventTypes"
					multiple="true">
					<option class="noneOption"></option>
				</form:select>
			</div>
			<div>
				<label for="eventThemes">Event theme</label>
				<form:errors cssClass="form-error" path="eventThemes" />
				<form:select id="eventThemes" path="eventThemes" name="eventThemes"
					multiple="true">
					<option class="noneOption"></option>
				</form:select>
			</div>
			<br>
			<button class="ui green button" type="submit">
				<i class="plus icon"></i>Update event
			</button>
		</form:form>
	</div>
	<%@include file="../includes/footer.jsp"%>

	<script>
		function functionName(string) {
			return string.charAt(0).toUpperCase() + string.slice(1);
		}

		function setEventData(type) {
			$.get("/api/get" + functionName(type), function(elements) {
				$.each(elements, function(key, value) {
					$("#" + type).append(
							$("<option></option>").attr("value", value.id)
									.text(value.name));
				});
			});
		}

		$(function() {
			setEventData("eventThemes");
			setEventData("eventTypes");
		});
	</script>
</body>
</html>