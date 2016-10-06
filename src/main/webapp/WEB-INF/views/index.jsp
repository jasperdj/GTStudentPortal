<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get There - Studenten Portal</title>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.css"/>
</head>
<body>
	<%@include file="../includes/hidden_nav.jsp"%>
	<div class="pusher">
		<div class="ui vertical masthead center aligned segment">
			<%@include file="../includes/navbar.jsp"%>

			<%@include file="../includes/carousel.jsp"%>
		</div>

		<div class="ui vertical stripe segment">
			<div class="ui middle aligned stackable grid container">
				<div class="row">
					<div class="eight wide column">
						<h3 class="ui header">Welkom bij de Get There Student Portal!</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Duis at sodales est, eu consequat metus. Proin neque eros,
							tincidunt suscipit arcu maximus, hendrerit efficitur nibh. Ut
							pellentesque libero sit amet ultricies placerat.</p>
					</div>
					<div class="six wide right floated column">
						<img src="<c:url value="/resources/img/gt.png"/>"
							class="ui large bordered rounded image">
					</div>
				</div>
				<div class="row">
					<div class="center aligned column">
						<a class="ui huge button">Text hier!</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	
	<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.min.js"></script>
	<script src="<c:url value="/resources/js/carousel.js" />"></script>
</body>
</html>