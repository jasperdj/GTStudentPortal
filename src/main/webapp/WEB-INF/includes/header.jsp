<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get There - Studenten Portal</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/semantic.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/studentportal.css"/>">

<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/semantic.js" />"></script>
<script src="<c:url value="/resources/js/studentportal.js" />"></script>
<script>
    $(function(){var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });});
</script>

<sec:csrfMetaTags></sec:csrfMetaTags>

