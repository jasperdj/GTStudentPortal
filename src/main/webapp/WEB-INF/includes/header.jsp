<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
>>>>>>> refs/heads/master
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get There - Studenten Portal</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/semantic.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/reset.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/site.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/container.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/grid.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/header.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/image.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/menu.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/divider.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/dropdown.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/segment.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/button.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/list.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/icon.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/sidebar.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/transition.css"/>">
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/components/icon.min.css'>


<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/studentportal.css"/>">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/semantic.js" />"></script>
<<<<<<< HEAD
<script src="<c:url value="/resources/js/visibility.js" />"></script>
<script src="<c:url value="/resources/js/sidebar.js" />"></script>
<script src="<c:url value="/resources/js/transition.js" />"></script>
<script src="<c:url value="/resources/js/studentportal.js" />"></script>
=======
<script src="<c:url value="/resources/js/studentportal.js" />"></script>
<script>
    $(function(){var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });});
</script>

<sec:csrfMetaTags></sec:csrfMetaTags>

>>>>>>> refs/heads/master
