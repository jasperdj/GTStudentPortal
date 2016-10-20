<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="ui container">
	<div class="ui large secondary pointing menu">
		</a> <a href="/" class="item">Home</a>
		<sec:authorize url="/events">
			<a href="/events" class="item">Events</a>
		</sec:authorize>
		<sec:authorize url="/detail">
			<a href="/detail" class="item">Detail</a>
		</sec:authorize>
		<sec:authorize url="/recruiter/**">
			<div class="ui simple dropdown item">
				Recruiter <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="/recruiter/students/">Students</a> 
					<a class="item" href="/recruiter/events/">Events</a>
					
				</div>
			</div>
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