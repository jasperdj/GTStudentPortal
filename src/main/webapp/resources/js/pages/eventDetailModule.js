(function() {
	"use strict";

	angular.module("eventDetailModule", [], function($locationProvider) {
		$locationProvider.html5Mode({
			enabled : true,
			requireBase : false
		})
	});

})();
