<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="ui container">
	<div class="ui inverted large secondary pointing menu">
		</a> <a href="/" class="item">Home</a>
		<sec:authorize url="/students">
			<a href="/students" class="item">Studenten</a>
		</sec:authorize>
		<sec:authorize url="/events">
			<a href="/events" class="item">Events</a>
		</sec:authorize>
		<sec:authorize url="/detail">
			<a href="/detail" class="item">Detail</a>
		</sec:authorize>
		<div class="right item">
			<sec:authorize access="!isFullyAuthenticated()">
				<a href="/login" class="item black basic button">Login</a>
			</sec:authorize>
			<sec:authorize access="isFullyAuthenticated()">
				<a href="/logout" class="item black basic button">Logout</a>
			</sec:authorize>
			<sec:authorize access="!isFullyAuthenticated()">
				<a href="/registration" class="item black basic button">Registration</a>
			</sec:authorize>
		</div>
	</div>
</div>