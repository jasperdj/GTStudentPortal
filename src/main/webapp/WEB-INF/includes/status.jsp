
<c:if test="${not empty error}">
  <div class="ui negative message transition">
  <i class="close icon"></i>
  <div class="header">
    Oops! Daar gaat iets mis.
  </div>
  <p>${error }</p></div>
</c:if>


<c:if test="${not empty status}">
	<div class="ui message transition">
	  <i class="close icon"></i>
	  <p>${status }</p>
	</div>
</c:if>
