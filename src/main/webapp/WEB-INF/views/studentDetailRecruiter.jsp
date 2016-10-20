<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../includes/header.jsp" %>

    <style>
        .addMessage .header {
            margin-bottom: 10px;
        }

        .addMessage input.submitButton {
            margin-top: 10px;
        }

        .addMessage form p {
            padding:0px;
            margin-bottom:5px !important;
        }

        .addMessage form textarea, .addMessage form input {
            width:100%;
        }

    </style>
</head>
<body ng-app="studentForm" ng-controller="studentFormController as vm" ng-cloak>
<%@include file="../includes/navbar.jsp" %>


    <div class="ui grid">
        <div class="two wide column"></div>
        <div class="four wide column">
            <div id="comments">
                <div class="field">
                    <div class="ui message addMessage">
                        <form>
                            <div class="header">Voeg commentaar toe</div>
                            <p>Commentaar:</p>
                            <textarea ng-model="vm.comment"></textarea>

                            <p>Herinner mij op:</p>
                            <input ng-model="vm.reminder" type="date" name="date"/>
                            <br>
                            <input type="button" value="Voeg commentaar toe!" class="ui icon button submitButton" ng-click="vm.addComment()">
                        </form>
                    </div>
                    <div class="ui message" ng-repeat="studentComment in vm.studentComments">
                        <i class="close icon"></i>
                        <div class="header">
                            {{ studentComment['comment'] }}
                        </div>
                        <p ng-show="tudentComment['comment'] != null">
                            {{ studentComment['comment'].created.dayOfWeek}},
                            {{studentComment['comment'].created.month}}
                            {{studentComment['comment'].created.dayOfMonth }}</p>
                    </div>
                    <br/>
                </div>
            </div>

        </div>



    <%@include file="../includes/footer.jsp" %>
    <script src="<c:url value="/resources/js/pages/studentForm.js" />"></script>
</body>
</html>