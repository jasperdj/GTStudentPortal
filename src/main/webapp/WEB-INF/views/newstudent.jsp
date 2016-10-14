<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
</head>
<body>
	<%@include file="../includes/navbar.jsp"%>
	
	<div class="ui main text container padded">
		<%@include file="../includes/status.jsp"%>
		<form:form method="post" modelAttribute="newStudent" cssClass="ui form">
			<div class="field">
				<label>Naam <form:errors path="firstName" cssClass="form-error" /> <form:errors path="lastName" cssClass="form-error" /></label>
				<div class="two fields">
					<div class="field">
						<form:input path="firstName" placeholder="Voornaam"/>
					</div>
					<div class="field">
						<form:input path="lastName" placeholder="Achternaam"/>
					</div>		
				</div>
			</div>
			
			<div class="field">
				<label>Contact <form:errors path="email" cssClass="form-error" /> <form:errors path="phone" cssClass="form-error" /></label>
				<div class="two fields">
					<div class="field">
						<form:input path="email" placeholder="Email"/>
					</div>
					<div class="field">
						<form:input path="phone" placeholder="Telefoonnummer"/>
					</div>
				</div>
			</div>
			
			<div class="field">
				<label>Geboortedatum <form:errors path="dateOfBirth" cssClass="form-error" /></label>
				<form:input type="date" path="dateOfBirth"/>
			</div>
			
			<div class="fields">
				<div class="five wide field">
					<label>School</label>
					<form:select path="">
						<c:forEach items="${universities}" var="u">
							<option value="${u.id}">${u.name}</option>
						</c:forEach>
					</form:select>
				</div>
				<div class="five wide field">
					<label>Opleiding <form:errors path="education" cssClass="form-error" /></label>
					<form:select path="education">
						<c:forEach items="${educations}" var="e">
							<option value="${e.id}">${e.name}</option>
						</c:forEach>
					</form:select>
				</div>
				<div class="three wide field">
					<label>Begin<form:errors path="startEducation" cssClass="form-error" /></label>
					<form:input type="date" path="startEducation"/>
				</div>
				<div class="three wide field">
					<label>Eind<form:errors path="endEducation" cssClass="form-error" /></label>
					<form:input type="date" path="endEducation"/>
				</div>
			</div>	
			
			<div class="two fields">
				<div class="field">
					<label>Bron</label>
					<form:input path="contactOrigin" placeholder="Bron"/>
				</div>
				<div class="field">
					<label>LinkedIn status</label>
					<form:input path="linkedInConnectionStatus" placeholder="Status"/>
				</div>
			</div>
			
			<div class="field">
				<label>Events? <form:errors path="isInterestedInEvents" cssClass="form-error" /></label>
				<form:checkbox path="isInterestedInEvents"/>
			</div>
			<button type="submit" class="ui button">Submit</button>
		</form:form>
	</div>
	<%@include file="../includes/footer.jsp"%>
</body>
</html>