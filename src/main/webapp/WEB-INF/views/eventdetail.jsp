<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
</head>
<body ng-app="eventDetailModule">
	<%@include file="../includes/status.jsp"%>

	<div ng-controller="eventDetailController as vm">
		<div id="event_header"
			class="ui inverted vertical masthead center aligned segment">
			<%@include file="../includes/invertednavbar.jsp"%>

			<div class="ui container">
				<h1 class="ui inverted header event_head_text">{{vm.event.title}}</h1>
				<h4 class="event_head_text">{{vm.event.location}}</h4>
				<c:if test="${user.userId != null}">
					<c:set var="contains" value="false" />
					<c:forEach var="item" items="${event.attendees}">
						<c:if test="${item.userId eq user.userId}">
							<c:set var="contains" value="true" />
						</c:if>
					</c:forEach>
				</c:if>
				<br><br>
				<button ng-if="${contains}" ng-click="vm.signinToggle()"
					class="massive ui active red button">
					<i class="checkmark box icon"></i>Schrijf je uit
				</button>
				<button ng-if="${!contains} && vm.event.attendees.length < vm.event.vacancy" ng-click="vm.signinToggle()"
					class="massive ui red button">
					<i class="square outline icon"></i>Schrijf je in
				</button>

				<%@include file="../includes/loginrequestmodal.jsp"%>

			</div>
		</div>
		<div class="ui segment">
			<div class="ui middle aligned stackable grid container">
				<div class="row">
					<div class="four wide left floated column">
						<p class="event_info">
							Begin: <strong>{{vm.startFormatted}}</strong>
						</p>
					</div>
					<div class="four wide left floated column">
						<p class="event_info">
							Eind: <strong>{{vm.endFormatted}}</strong>
						</p>
					</div>
					<div class="four wide left floated column">
						<p class="event_info">Vind plaats {{vm.countdown}}.</p>
					</div>
					<div class="four wide left floated column">
						<p class="event_info" ng-if="vm.event.vacancy > 0 && vm.event.attendees.length < vm.event.vacancy">Nog {{vm.event.vacancy -
							vm.event.attendees.length}} van de {{vm.event.vacancy}} plekken
							beschikbaar.</p>
							
						<p class="event_info" ng-if="vm.event.vacancy === vm.event.attendees.length">Er is geen plek meer!</p>
					</div>
				</div>
			</div>
		</div>
		<div class="ui vertical stripe segment">
			<div class="ui middle aligned stackable grid container">
				<div class="row">
					<div class="eight wide left floated column">
						<iframe id="gmap" src="{{vm.gmapurl}}"></iframe>
					</div>
					<div class="eight wide column">
						<h3 class="ui header">{{vm.event.title}}</h3>
						<p>{{vm.event.description}}</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="<c:url value="/resources/js/pages/eventDetailModule.js" />"></script>
	<script
		src="<c:url value="/resources/js/pages/eventDetailController.js" />"></script>
	<script src="<c:url value="/resources/js/moments.js" />"></script>
</body>
</html>