
<c:choose>
    <c:when test="${not empty error}">
        <div class="ui negative message transition">
		  <i class="close icon"></i>
		  <div class="header">
		    Oops! Daar ging iets mis.
		  </div>
		  <p>${error }</p>
		 </div>
    </c:when>
    <c:when test="${not empty status}">
        <div class="ui message transition">
		  <i class="close icon"></i>
		  <p>${status }</p>
		</div>
    </c:when>
</c:choose>