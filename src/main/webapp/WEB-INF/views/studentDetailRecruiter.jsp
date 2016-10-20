<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body ng-app="studentDetailRecruiter" ng-controller="studentDetailRecruiterController as vm" ng-cloak>
<%@include file="../includes/navbar.jsp" %>

<div class="ui segment addComment">
    <textarea></textarea>
    <input type="date" name=""/>
    <input type="submit" value="Add comment!" />
</div>

<div class="ui segments">
    <div class="ui segment" ng-repeat="studentComment in vm.studentComments">
        <p>{{ studentComment['comment'] }}</p>
        <p class="date">{{ studentComment['comment'].created.dayOfWeek}}, {{studentComment['comment'].created.month}}
            {{studentComment['comment'].created.dayOfMonth }}</p>
    </div>
</div>

<%@include file="../includes/footer.jsp" %>
<script src="<c:url value="/resources/js/pages/studentForm.js" />"></script>
</body>
</html>