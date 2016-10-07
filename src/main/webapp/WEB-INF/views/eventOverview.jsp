<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp"%>

    <script>
        function printEvents(event) {
            var output = "";
            $.each(event, function(key, value) {
                output +=
                        "<a href='<c:url value="event"/>/"+value.id+"'><div class='ui segment event'>" +
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
        });
    </script>
    <style>
        #eventOverview {
            width:500px;
        }

        #eventOverview .eventGroup {
            width:500px;
        }

        .eventGroup .title {
            font-size:16pt;
            font-weight:bold;
            text-transform: lowercase;
            margin-top:20px;
        }

        .ui .segment .title {
            font-size:12pt;
            font-weight:normal;
            margin-top:0px;
            color:black;
        }

        .ui .segment:hover {
            background-color:rgba(0,0,0,.1);
        }

        .ui .segment:active {
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
    </style>
</head>
<body>
<%@include file="../includes/navbar.jsp"%>
<h3>Overview events</h3>

<div class="ui container padded">
    <div id="eventOverview">

    </div>
</div>
</body>
</html>
