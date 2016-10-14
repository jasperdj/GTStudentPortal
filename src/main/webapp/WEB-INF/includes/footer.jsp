<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-json/2.6.0/jquery.json.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="<c:url value="/resources/js/semantic.js" />"></script>
<script src="<c:url value="/resources/js/visibility.js" />"></script>
<script src="<c:url value="/resources/js/sidebar.js" />"></script>
<script src="<c:url value="/resources/js/transition.js" />"></script>
<script src="<c:url value="/resources/js/studentportal.js" />"></script>
<%-- Lodash: Library for manipulating data(GroupBy, Filter, reduce etc.) --%>
<script src="https://cdn.jsdelivr.net/g/lodash@4.16.4(lodash.min.js+lodash.core.min.js+lodash.fp.min.js+lodash.core.js+lodash.fp.js+lodash.js+mapping.fp.js)"></script>

<script>
    $(function(){var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });});
</script>