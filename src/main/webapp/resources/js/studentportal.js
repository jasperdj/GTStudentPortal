
// status messages
$(document).ready(function () {
	$('.message .close')
	  .on('click', function() {
	    $(this)
	      .closest('.message')
	      .transition('fade')
	    ;
	  })
	;
	
	var byEmail = document.getElementById("byEmail");
	var form = document.getElementById("registrationForm");
	form.style.display = "none";
	
	byEmail.onclick = function(){
		form.style.display = "block";
		byEmail.style.display = "none";
	}
});