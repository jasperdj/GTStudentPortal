<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
</head>
<body>
	<%@include file="../includes/navbar.jsp"%>

	<div class="ui main text container padded">
		<%@include file="../includes/status.jsp"%>
		<h3>Persoonsgegevens</h3>
		<table class="ui very basic table">
			<tr>
				<td class="eight wide">Naam:</td>
				<td class="eight wide">${student.firstName } ${student.lastName }</td>
			</tr>
			<tr>
				<td class="eight wide">Geboortedatum:</td>
				<td class="eight wide"><c:choose>
						<c:when test="${empty student.dateOfBirth }">-</c:when>
						<c:otherwise>${student.dateOfBirth }</c:otherwise>
					</c:choose></td>
			</tr>
		</table>

		<h3>Contactgegevens</h3>
		<table class="ui very basic table">
			<tr>
				<td class="eight wide">Email:</td>
				<td class="eight wide">${student.email }</td>
			</tr>
			<tr>
				<td class="eight wide">Telefoon:</td>
				<td class="eight wide"><c:choose>
						<c:when test="${empty student.phone }">-</c:when>
						<c:otherwise>${student.phone }</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
		<h3>Studiegegevens</h3>
		<table class="ui very basic table">
			<tr>
				<td class="eight wide">Opleiding:</td>
				<td class="eight wide"><c:choose>
						<c:when test="${empty student.education }">-</c:when>
						<c:otherwise>${student.education.name }, ${student.education.university.name }</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="eight wide">Begonnen:</td>
				<td class="eight wide"><c:choose>
						<c:when test="${empty student.startEducation }">-</c:when>
						<c:otherwise>${student.startEducation }</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="eight wide">Einde:</td>
				<td class="eight wide"><c:choose>
						<c:when test="${empty student.endEducation }">-</c:when>
						<c:otherwise>${student.endEducation }</c:otherwise>
					</c:choose></td>
			</tr>
		</table>

		<h3>Instellingen</h3>
		<table class="ui very basic table">
			<tr>
				<td class="eight wide"></td>
				<td class="eight wide"></td>
			</tr>
		</table>
		<a href="/editprofile" class="ui button">Wijzig gegevens</a>
	</div>

</body>
</html>