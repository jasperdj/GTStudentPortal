<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	<!-- firstName, lastName, email, phone, password, LocalDate.now(), education, startEducation, endEducation, dateOfBirth -->

	<div class="ui main text container padded">
		<p>${status}</p>
		<form class="ui form">
		  <h4 class="ui dividing header">Nieuwe Student</h4>
		  <div class="field">
		    <label>Naam</label>
		    <div class="two fields">
		      <div class="field">
		        <input name="student[firstName]" placeholder="Voornaam" type="text">
		      </div>
		      <div class="field">
		        <input name="student[lastName]" placeholder="Achternaam" type="text">
		      </div>
		    </div>
		  </div>
		  <div class="field">
		  	<label>Contact</label>
		  	<div class="two fields">
		  		<div class="field">
		        	<input name="student[email]" placeholder="Email" type="text">
		      	</div>
		      	<div class="field">
		        	<input name="student[phone]" placeholder="Telefoon" type="text">
		      	</div>
		  	</div>
		  </div>
		  <div class="field">
		  	<div class="fields">
		  		<div class="six wide field">
		  		<label>School</label>
		        	 <select name="student[school]" class="ui fluid dropdown">
		        	 	<option value="Rijksuniversiteit Groningen">Rijksuniversiteit Groningen</option>
		        	 	<option value="Hanzehogeschool Groningen">Hanzehogeschool Groningen</option>
		        	 	<option value="Stenden Hogeschool">Stenden Hogeschool</option>
		        	 </select>
		      	</div>
		      	<div class="six wide field">
		      	<label>Opleiding</label>
		        	<select name="student[education]" class="ui fluid dropdown">
		        	 	<option value="">Opl 1</option>
		        	 	<option value="">Opl 2</option>
		        	 	<option value="">Opl 3</option>
		        	 </select>
		      	</div>
		  	</div>
		  </div>
		  
		  <div class="ui button" tabindex="0">Cre&euml;er student</div>
		</form>
	</div>	
		
</body>
</html>