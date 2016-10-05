// configureer JQuery om csrf-token mee te sturen
$(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
});

// status messages
$(document).ready(function() {
	$('.message .close').on('click', function() {
		$(this).closest('.message').transition('fade');
	});

	$(":input").blur(function() {
		var element = this;
		$(element).removeClass("clean");

		$.post('/jvalid', {
			value : $(element).val()
		}, function(validationResult) {
			console.log(validationResult);

//			$(":input").each(function() {
//				if (!$(this).hasClass("clean")) {
//
//				}
//			});

		});
	});

	// TODO Create seperate thing.
	// var byEmail = document.getElementById("byEmail");
	// var form = document.getElementById("registrationForm");
	// form.style.display = "none";
	//	
	// byEmail.onclick = function(){
	// form.style.display = "block";
	// byEmail.style.display = "none";
	// }
});