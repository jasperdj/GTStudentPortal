<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp"%>

    <script>
        function printEvents(array) {
            $.each(array, function(key, value){
                $("ul").append("<li>" + value.title + "</li>")
            });
        }

        $( document ).ready(function() {
            $.get("<c:url value="/api/getEvents" />?from=0&to=30", function(events){
                events = _.groupBy(events, 'start.dayOfYear');
                alert($.toJSON(events));
                //printEvent(events);
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
            font-size:20pt;
            font-weight:bold;
        }

        .ui .segment .title {
            font-size:12pt;
            font-weight:normal;
        }

        #eventOverview .event p {
            float:left;
        }
    </style>
</head>
<body>
<%@include file="../includes/navbar.jsp"%>
<h3>Overview events</h3>

<div class="ui container padded">
    <div class="ui raised segments">
        <div class="ui segment">
            <p>Top</p>
        </div>
        <div class="ui segment">
            <p>Middle</p>
        </div>
        <div class="ui segment">
            <p>Bottom</p>
        </div>
    </div>

    <div id="eventOverview">
        <div class="eventGroup">
            <div class="title">Thursday, October 7</div>
            <div class="ui raised segments">
                <div class="ui segment event">
                    <p>
                    <div class="time">8:00</div>
                    <div class="title">Breakfast session</div>
                    </p>
                </div>
                <div class="ui segment event">
                    <p>
                    <div class="time">8:00</div>
                    <div class="title">Breakfast session</div>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
