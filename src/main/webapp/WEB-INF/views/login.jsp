<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get There - Studenten Portal | Login</</title>
    <%@include file="../includes/header.jsp"%>
</head>
<body>
<div class="ui main text container padded">
	<h3>Welkom op de Get There Studenten Portal!</h3>
	<form class="ui form" role="form" action="/login" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <div>
	        <label for="email">Email address</label>
	        <input type="email" name="email" id="email" required autofocus>
	    </div>
	    <div>
	        <label for="password">Password</label>
	        <input type="password" name="password" id="password" required>
	    </div>
	    <div>
	        <label for="remember-me">Remember me</label>
	        <input type="checkbox" name="remember-me" id="remember-me">
	    </div>
	    <button type="submit">Sign in</button>
	</form>
</div>

<c:if test="${error.isPresent()}">
    <p>The email or password you have entered is invalid, try again.</p>
</c:if>
</body>
</html>
