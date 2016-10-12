<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.css" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/pages/index.css" />" />
</head>
<body>
	<%@include file="../includes/hidden_nav.jsp"%>
	<div class="pusher">
		<%@include file="../includes/navbar.jsp"%>
		<div id="videoWrapper">
			<div id="videoContent" class="ui center aligned segment">
				<h3>Wat inspireert jou?</h3>
				<h4>Beleef je passie bij Get There</h4>

				<button id="signup" class="ui huge red button"
						onclick="location.href='<c:url value="/registration" />'">Schrijf in!</button>
			</div>
			<video src="https://a248.e.akamai.net/secure.meetupstatic.com/s/img/457419671895069178/guest_home/video.mp4"
				   autoplay="" loop=""></video>
		</div>

		<script>
			$(document).ready(function(){
				$(".featuredTheme").on("click", function(){
					window.location.replace("/events/?eventTheme="+$(this).text());
				})
			});
		</script>
		<div class="ui grid align centered" id="featuredThemes">
			<div class="three wide column"><div class="ui center aligned segment featuredTheme">${eventThemes[0].name}</div></div>
			<div class="three wide column"><div class="ui center aligned segment featuredTheme">${eventThemes[1].name}</div></div>
			<div class="three wide column"><div class="ui center aligned segment featuredTheme">${eventThemes[2].name}</div></div>
			<div class="three wide column"><div class="ui center aligned segment featuredTheme">${eventThemes[3].name}</div></div>
		</div>

			<style>
				#featured_events {
					background: url('http://efese.eu/wp-content/uploads/2016/01/test-events.jpg');
					background-size: 100% 100%;
					background-color:rgba(0,0,0,0.3);
					background-blend-mode: darken;
				}

				#featured_events:hover {
					background-color:rgba(0,0,0,0.5);
					background-blend-mode: darken;
				}

				#featured_internship {
					background: url('<c:url value="https://www.youngcapital.nl/public_images/Image/142.jpg" />');
					background-size: 100% 100%;
					background-color:rgba(0,0,0,0.3);
					background-blend-mode: darken;
					padding-top: 67px;
				}

				#featured_internship:hover {
					background-color:rgba(0,0,0,0.5);
					background-blend-mode: darken;
				}

				#featured_traineeship {
					background: url('<c:url value="/resources/img/traineeship.JPG" />');
					background-size: 100% 100%;
					background-color:rgba(0,0,0,0.3);
					background-blend-mode: darken;
				}

				#featured_traineeship:hover {
					background-color:rgba(0,0,0,0.5);
					background-blend-mode: darken;
				}

				.ui.center.aligned.segment.featuredItem {
					height:200px;
					color:white;
					padding-top:80px;
					font-size:20pt;
					text-shadow: 0px 2px black;
					line-height:28px;
					text-align-all: center;
					cursor:pointer;
				}



				.ui.divider {
					margin-top:30px !important;
					margin-bottom:30px !important;
				}

				.ui.vertical.stripe {
					padding-top:0px;
				}


			</style>
		<div class="ui divider"></div>

		<div class="ui grid align centered" id="featured">
			<div class="four wide column"><a href="/events/"><div id="featured_events" class="ui center aligned segment featuredItem">Evenementen</div></a></div>
			<div class="four wide column"><a href="#"><div id="featured_traineeship" class="ui center aligned segment featuredItem">Traineeship</div></a></div>
			<div class="four wide column"><a href="#"><div id="featured_internship" class="ui center aligned segment featuredItem">Stage / Afstudeerstage</div></a></div>
		</div>

		<div class="ui divider"></div>

		<div class="ui grid align centered" id="featuredThemes">

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