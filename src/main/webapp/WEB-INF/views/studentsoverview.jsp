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
	
	<div class="ui container padded">
		<%@include file="../includes/status.jsp"%>
		
		<form action="/student">
		    <input type="submit" class="ui icon button" value="Nieuwe student" ></input>
		</form>
		
		<table class="ui celled table">
	 	<thead>
		 	<tr>
	 			<th>Voornaam</th>
	 			<th>Achternaam</th>
	 			<th>Email</th>
	 			<th>Telefoon</th>
	 			<th>Geboortedatum</th>
	 			<th colspan="2">Studie</th>
	 		</tr>
	 	</thead>
			<tbody>
				<c:forEach items="${students}" var="s">
					<tr>
						<td>${s.firstName}</td>
						<td>${s.lastName }</td>
						<td>${s.email }</td>
						<td>${s.phone }</td>
						<td>${s.dateOfBirth }</td>
						<td>${s.education.name } ${s.education.degree}</td>
						<td><a href="/student/${s.id }">wijzig</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>