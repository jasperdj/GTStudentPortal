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
		<p>
		 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vitae aliquam elit, nec efficitur lorem. Sed at sagittis turpis. Etiam ut tincidunt lacus, vitae tempus mauris. Aliquam eu orci tellus. Quisque lorem nisi, lobortis ac facilisis ut, vehicula et urna. Morbi ut odio gravida dui iaculis mattis id a mauris. Morbi eu hendrerit metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
		</p>
	
		<%@include file="../includes/status.jsp"%>
		<form:form method="post" modelAttribute="user" cssClass="ui form">
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
				<label>Contact <form:errors path="email" cssClass="form-error" /></label>
				<div class="field">
					<form:input path="email" placeholder="Email"/>
				</div>
			</div>
			
			<div class="field">
				<label>Wachtwoord <form:errors path="password" cssClass="form-error" /></label>
				<form:input type="password" path="password"/>
			</div>
			
			<button type="submit" class="ui button">Registreer</button>
		</form:form>
	</div>
	
</body>
</html>