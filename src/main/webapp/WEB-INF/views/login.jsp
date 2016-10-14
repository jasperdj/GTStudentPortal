<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Get There - Studenten Portal | Login</</title>
    <%@include file="../includes/header.jsp"%>
</head>
<body>
<%@include file="../includes/navbar.jsp"%>

<div class="ui main text container padded">
	<h3>Welkom op de Get There Studenten Portal!</h3>
	<c:if test="${error.isPresent()}">
		<div class="ui negative message transition">
		  <i class="close icon"></i>
		  <p>The email or password you have entered is invalid, try again.</p>
		 </div>
	</c:if>
	<form class="ui form" role="form" action="/login<c:if test="${redirect.length() > 0}">?redirect=${redirect}</c:if>" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <div class="field">
	        <label for="email">Email address</label>
	        <input type="email" name="email" id="email" required autofocus>
	    </div>
	    <div class="field">
	        <label for="password">Password</label>
	        <input type="password" name="password" id="password" required>
	    </div>
	    <div class="field">
	        <label for="remember-me">Remember me</label>
	        <input type="checkbox" name="remember-me" id="remember-me">
	    </div>
	    <button type="submit" class="ui button">Sign in</button>
	</form>
</div>

<%@include file="../includes/footer.jsp"%>
</body>
</html>
