<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp"%>

    <script>
        function printEvents(event) {
            var output = "";
            $.each(event, function(key, value) {
                var hasAccepted = "";
                $.each(value.attendees, function(key, value){
                    if (value.userId == ${userId}) hasAccepted = "hasAccepted";
                });

                output +=
                        "<a href='<c:url value="events"/>/"+value.eventId+"'>" +
                            "<div class='ui segment event "+hasAccepted+"' idEvent='"+value.eventId+"'>" +
                            "<div class='time'>" + value.start.hour + ":" +value.start.minute+ "</div>"+
                            "<div class='title'>"+value.title+"</div>" +
                        "</div></a>";
            });
            return output;
        }

        function printEventGroups(array) {
            $.each(array, function(key, value){
                $("#eventOverview").append(
                        "<div class='eventGroup'>" +
                        "   <div class='title'>"+value[0].start.dayOfWeek+", "+value[0].start.month+" "+
                                value[0].start.dayOfMonth +"</div>" +
                                "<div class='ui raised segments'>"+printEvents(value)+"</div>" +
                        "</div>"
                );
            });
        }

        $( document ).ready(function() {
            $.get("<c:url value="/api/getEvents" />?from=0&to=30", function(events){
                events = _.groupBy(events, 'start.dayOfYear');
                printEventGroups(events);
            });

            $("#myEventsFilter").click(function(){
                $("#myEventsFilter").addClass("selected");
                $("#allEventsFilter").removeClass("selected");
                $(".event").not(".hasAccepted").hide();

                $("#eventOverview").children().each(function( eventGroup){
                    var deleteGroup = true;
                    eventGroup.children().each(function(event){
                        if (event.not(".hasAccepted") == true ) {
                            deleteGroup = false;
                        }
                    });
                    if (deleteGroup) eventGroup.hide();

                });
                $(".eventGroup").children('div').each(function( index ) {
                    alert(index);
                    var children = $.find(index, ".hasAccepted");
                    if (children.length === 0) {
                        index.parent().hide();
                    }
                });
            });

            $("#allEventsFilter").click(function(){
                $("#myEventsFilter").removeClass("selected");
                $("#allEventsFilter").addClass("selected");
                $(".event").show();
            });
        });
    </script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/pages/eventOverview.css"/>"> </link>
</head>
<body ng-app="eventOverview" ng-controller="eventOverviewController as vm">
<%@include file="../includes/navbar.jsp"%>

<div class="ui container padded">
    <h2>Overview events</h2>
    <div class="ui grid container">
        <div class="twelve wide column">
            <div id="eventOverview">

            </div>
        </div>
        <div class="four wide column">
            <div id="eventRelationFilter" class="ui red segment filter">
                <div id="allEventsFilter" class="item selected">All events</div>
                <div id="myEventsFilter" class="item">My events</div>
            </div>
            <div id="eventThemeFilter" class="ui red segment filter">
                <div class="item selected">All themes</div>
                <div class="item" ng-repeat="item in vm.eventThemeFilter">{{ item.name }}</div>
            </div>
            <div id="eventThemeType" class="ui red segment filter">
                <div class="item selected">All event types</div>
                <div class="item" ng-repeat="item in vm.eventTypeFilter">{{ item.name }}</div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/pages/eventOverviewModule.js" />" ></script>
<script src="<c:url value="/resources/js/pages/eventOverviewController.js" />" ></script>

</body>
</html>
