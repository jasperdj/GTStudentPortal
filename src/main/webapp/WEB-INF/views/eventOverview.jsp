<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp"%>

    <script>
        function printEvents(event) {
            var output = "";
            $.each(event, function(key, value) {
                var hasAccepted = false;
                $.each(value.attendiesAccepted, function(key, value){


                })
                output +=
                        "<a href='<c:url value="event"/>/"+value.id+"'><div class='ui segment event' idEvent='"+value.id+"'>" +
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

            });

            $("#allEventsFilter").click(function(){
                $("#myEventsFilter").removeClass("selected");
                $("#allEventsFilter").addClass("selected");
            });
        });
    </script>
    <style>
        .eventGroup .title {
            font-size:16pt;
            font-weight:bold;
            text-transform: lowercase;
            margin-top:20px;
        }

        .eventGroup:first-child .title {
            margin-top:0px;
        }

        .ui .segment .title {
            font-size:12pt;
            font-weight:normal;
            margin-top:0px;
            color:black;
        }

        .ui .event.segment:hover {
            background-color:rgba(0,0,0,.1);
        }

        .ui .event.segment:active {
            background-color:rgba(0,0,0,.2);
        }

        #eventOverview .event .time {
            float:left;
            margin-right:10px;
            color:rgba(0,0,0,.6);
        }

        .padded {
            padding-top:30px;
        }

        .ui.red.segment.filter:first-child {
            margin-top:33px;
            padding:0px;
        }

        .ui.red.segment.filter:first-child .item {
            padding:10px;
        }

        .filter #title {
            font-size:14pt;
            font-weight:bold;
        }

        .filter .item:hover {
            cursor:pointer;
        }

        .filter .item.selected {
            background-color: rgb(255, 229, 222);
            font-weight:bold;
        }
    </style>
</head>
<body>
<%@include file="../includes/navbar.jsp"%>
<h3>Overview events</h3>

<div class="ui container padded">
    <div class="ui grid container">
        <div class="twelve wide column">
            <div id="eventOverview">

            </div>
        </div>
        <div class="four wide column">
            <div class="ui red segment filter">
                <div id="allEventsFilter" class="item selected">All events</div>
                <div id="myEventsFilter" class="item">My events</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
