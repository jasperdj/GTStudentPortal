<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../includes/header.jsp"%>
</head>
<body>
	<%@include file="../includes/navbar.jsp"%>
	
	<!-- firstName, lastName, email, phone, password, LocalDate.now(), education, startEducation, endEducation, dateOfBirth -->
	<div class="ui main text container padded">
		<form:form method="post" modelAttribute="student" cssClass="ui form">
			<div class="field">
				<label>Naam</label>
				<div class="two fields">
					<div class="field">
						<form:input path="firstName"/>
					</div>
					<div class="field">
						<form:input path="lastName"/>
					</div>		
				</div>
			</div>
			
			<div class="field">
				<label>Contact</label>
				<div class="two fields">
					<div class="field">
						<form:input path="email"/>
					</div>
					<div class="field">
						<form:input path="phone"/>
					</div>
				</div>
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
					<label>Opleiding</label>
					<form:select path="">
						<option value="1">Opl 1</option>
						<option value="2">Opl 2</option>
					</form:select>
				</div>
				<div class="three wide field">
					<label>Begin</label>
					<form:input path="startEducation"/>
				</div>
				<div class="three wide field">
					<label>Eind</label>
					<form:input path="endEducation"/>
				</div>
			</div>	
			
			<div class="field">
				<label>Geboortedatum</label>
				<form:input path="dateOfBirth"/>
			</div>		
			
			<div class="field">
				<label>Events?</label>
				<form:checkbox path="isInterestedInEvents"/>
			</div>
			
			<div class="ui button" tabindex="0">Cre&euml;er student</div>
		</form:form>
	</div>
	
</body>
</html>