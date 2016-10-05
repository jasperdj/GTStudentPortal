<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../includes/header.jsp"%>
<sec:csrfMetaTags />
</head>
<body>
	<div class="ui main text container padded">
		<a href="#" id="concatter">klik</a>
		<form:form method="post" id="registrationForm" modelAttribute="user"
			cssClass="ui form">
			<div class="field">
				<label>Naam <form:errors path="firstName"
						cssClass="form-error" /> <form:errors path="lastName"
						cssClass="form-error" /></label>
				<div class="two fields">
					<div class="field">
						<form:input path="firstName" placeholder="Voornaam" cssClass="clean"/>
					</div>
					<div class="field">
						<form:input path="lastName" placeholder="Achternaam" cssClass="clean"/>
					</div>
				</div>
			</div>

			<div class="field">
				<label>Contact <form:errors path="email"
						cssClass="form-error" /></label>
				<div class="field">
					<form:input path="email" placeholder="Email" cssClass="clean"/>
				</div>
			</div>

			<div class="field">
				<label>Wachtwoord <form:errors path="password"
						cssClass="form-error" /></label>
				<form:input type="password" path="password" cssClass="clean"/>
			</div>

			<button type="submit" class="ui button">Registreer</button>
		</form:form>
	</div>
</body>
</html>