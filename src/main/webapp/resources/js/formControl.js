$(document).ready(function () {
	//show first form part and set as current
	$("#person").toggle();
	var currentPart = $("#person");
	var currentCrumb = $("#personCrumb");
	currentCrumb.addClass("active");
	
	// handle next click
	$("#nextPart").click(function(){
		if(currentPart.next().hasClass("formPart")){
			currentPart.toggle();
			currentPart = currentPart.next();
			currentPart.toggle();
			
			var crumbName = "#" + currentPart.attr("id") + "Crumb";
			currentCrumb.removeClass("active");
			currentCrumb = $(crumbName);
			currentCrumb.addClass("active");
		}
	});
	
	// handle previous click
	$("#prevPart").click(function(){
		if(currentPart.prev().hasClass("formPart")){
			currentPart.toggle();
			currentPart = currentPart.prev();
			currentPart.toggle();
			
			var crumbName = "#" + currentPart.attr("id") + "Crumb";
			currentCrumb.removeClass("active");
			currentCrumb = $(crumbName);
			currentCrumb.addClass("active");
		}
	});
	
	// Handle breadcrumb clicks
	$(".section").click(function(){
		// clean old part + crumb
		currentPart.toggle();
		currentCrumb.removeClass("active");
		
		// set new part
		var sectionName = "#" + $(this).attr("id");
		currentPart = $(sectionName.slice(0, -5));
		currentPart.toggle();
		
		// set new crumb
		currentCrumb = $(sectionName);
		currentCrumb.addClass("active");
	});
});