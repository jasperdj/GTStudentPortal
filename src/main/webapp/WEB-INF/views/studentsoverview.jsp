<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get There - Studenten Portal</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/semantic.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/studentportal.css"/>">
<script src="<c:url value="/js/semantic.js"/>"></script>
</head>
<body>
	<div class="ui fixed menu">
	   <div class="ui container">
	     <a href="#" class="header item">
	       <img class="logo" src="img/logo.png">
	       GT Student Portal
	     </a>
	     <a href="#" class="item">Home</a>
	   </div>
	 </div>
	 
	 <div class="ui container padded">
	 	<table class="ui celled table">
		 	<thead>
			 	<tr>
		 			<th>Voornaam</th>
		 			<th>Achternaam</th>
		 			<th>Email</th>
		 			<th>Telefoon</th>
		 			<th>Studie</th>
		 		</tr>
		 	</thead>
	 		<tbody>
	 			<c:forEach items="${students}" var="s">
	 			<tr>
	 				<td>${s.firstName}</td>
	 				<td>${s.lastName }</td>
	 				<td>${s.email }</td>
	 				<td>${s.phone }</td>
	 				<td>${s.education.name } (s.education.degree)</td>
	 			</tr>
			</c:forEach>
	 		</tbody>
	 	</table>
	 </div>
</body>
</html>