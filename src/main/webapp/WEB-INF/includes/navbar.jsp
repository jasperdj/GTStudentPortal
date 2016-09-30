
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="ui fixed menu">
  <div class="ui container">
    <a href="/" class="header item">
      <img class="logo" src="resources/img/logo.png">
      GT Student Portal
    </a>
    <a href="/" class="item">Home</a>
    <sec:authorize url="/students">
    <a href="/students" class="item">Studenten</a>
    </sec:authorize>
    <sec:authorize url="/detail">
      <a href="/detail" class="item">Detail</a>
    </sec:authorize>
    <sec:authorize access="!isFullyAuthenticated()">
    <a href="/registration" class="item">Registration</a>
    </sec:authorize>
    <sec:authorize access="isFullyAuthenticated()">
    <a href="/logout" class="item align-right">Logout</a>
    </sec:authorize>
    <sec:authorize access="!isFullyAuthenticated()">
      <a href="/login" class="item align-right">Login</a>
    </sec:authorize>
  </div>
</div>