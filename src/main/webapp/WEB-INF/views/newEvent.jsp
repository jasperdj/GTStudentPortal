<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Get There - Studenten Portal | Login</</title>
    <%@include file="../includes/header.jsp" %>

    <script>
        function functionName(string) {
            return string.charAt(0).toUpperCase() + string.slice(1);
        }

        function setEventData(type) {
            $.get("/api/get" + functionName(type), function (elements) {
                $.each(elements, function (key, value) {
                    $("#"+type).append($("<option></option>")
                            .attr("value", value.id)
                            .text(value.name));
                });
            });
        }

        $(function () {
            setEventData("eventThemes");
            setEventData("eventTypes");
        });
    </script>
</head>
<body>
<%@include file="../includes/navbar.jsp" %>

<div class="ui main text container padded">
    <h3>Maak een nieuw event aan</h3>

    <form:form class="ui form" role="form" method="post">
        <div>
            <label for="title">Title</label>
            <input type="text" name="title" id="title" required autofocus>
        </div>
        <div>
            <label for="start">Event start</label>
            <input type="datetime-local" name="start" id="start" required>
        </div>
        <div>
            <label for="end">Event end</label>
            <input type="datetime-local" name="end" id="end" required>
        </div>
        <div>
            <label for="description">Description</label>
            <textarea name="description" id="description" cols=10></textarea>
        </div>
        <div>
            <label for="eventTypes">Event type</label>
            <select id="eventTypes" name="eventTypes" multiple="true">
                <option class="noneOption">None</option>
            </select>
        </div>
        <div>
            <label for="eventThemes">Event theme</label>
            <select id="eventThemes" name="eventThemes" multiple="true">
                <option class="noneOption">None</option>
            </select>
        </div>

        <button type="submit">Create event</button>
    </form:form>
</div>

</body>
</html>