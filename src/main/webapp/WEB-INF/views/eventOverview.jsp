<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp"%>

    <script>
        $(document).ready(function(){
            $("body").on("click", function(){
                hideEventGroups();
            });

            setTimeout( function(){
                hideEventGroups();
            }  , 100);
        });

        function hideEventGroups() {
            var totalChildren = 0;
            $(".eventGroup").each(function(eventGroup){
                var children = 0;
                $(this).find(".segments").children().each(function(child){
                    children += 1;
                    totalChildren += 1;
                });

                children == 0 ? $(this).hide() : $(this).show();
            });

            if (totalChildren == 0) {
                if ($("#eventOverview #noEventsFound").length == 0) {
                    $("#eventOverview").prepend('' +
                            '<div id="noEventsFound" ng-show="vm.eventGroups">' +
                            '<div class="ui warning message">' +
                            '<div class="header">Geen evenementen gevonden!</div>' +
                            'Probeer eens een andere filter.' +
                            '</div>' +
                            '</div>');
                } else {
                    $("#eventOverview #noEventsFound").show();
                }
            } else {
                $("#eventOverview #noEventsFound").hide();
            }
        }
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
                <div class='eventGroup' ng-repeat="eventGroup in vm.eventGroups">
                   <div class='title'>{{eventGroup[0].start.dayOfWeek}}, {{eventGroup[0].start.month}}
                    {{eventGroup[0].start.dayOfMonth}} </div>
                    <div class='ui raised segments'>
                        <a href='<c:url value="{{ event.eventId }}" />'
                           ng-repeat="event in eventGroup | eventFilter:vm.eventThemeFilter:vm.eventTypeFilter:vm.eventRelationFilter:${userId}">
                            <div class='ui segment event' idEvent='{{ event.eventId }}'>
                                <div class='time'>{{event.start.hour}}:{{event.start.minute}}</div>
                                <div class='title'>{{event.title}}</div>
                                <div id="tags">
                                    <div class='tag eventType' ng-repeat="eventType in event.eventTypes">{{ eventType.name }}</div>
                                    <div class='tag eventTheme' ng-repeat="eventTheme in event.eventThemes">{{ eventTheme.name }}</div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="four wide column">
            <div style="height:20px;"> </div>
            <div id="eventRelationFilter" class="ui red segment filter" ng-show="${{userId}} != -1">
                <div id="allEventsFilter" class="item" ng-click="vm.setEventRelationFilter(null)"
                     ng-class="{ 'selected': vm.eventRelationFilter == null}" >All events</div>
                <div id="myEventsFilter" class="item" ng-click="vm.setEventRelationFilter(1)"
                     ng-class="{ 'selected': vm.eventRelationFilter == 1}" >My events</div>
            </div>
            <div id="eventThemeFilter" class="ui red segment filter">
                <div class="item selected" ng-click="vm.setEventThemeFilter(null)"
                     ng-class="{ 'selected': vm.eventThemeFilter == null}">All themes</div>
                <div class="item" ng-repeat="item in vm.eventThemeFilterItems"
                     ng-click="vm.setEventThemeFilter(item)"
                     ng-class="{ 'selected': vm.eventThemeFilter.name == item.name}">{{ item.name }}</div>
            </div>
            <div id="eventTypeFilter" class="ui red segment filter">
                <div class="item selected" ng-click="vm.setEventTypeFilter(null)"
                     ng-class="{ 'selected': vm.eventTypeFilter == null}">All event types</div>
                <div class="item" ng-repeat="item in vm.eventTypeFilterItems"
                     ng-click="vm.setEventTypeFilter(item)"
                     ng-class="{ 'selected': vm.eventTypeFilter.name == item.name}">{{ item.name }}</div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/pages/eventOverviewModule.js" />" ></script>
<script src="<c:url value="/resources/js/pages/eventOverviewController.js" />" ></script>

</body>
</html>
