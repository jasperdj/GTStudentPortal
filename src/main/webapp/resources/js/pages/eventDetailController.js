(function() {
	"use strict";

	angular.module("eventDetailModule").controller("eventDetailController",
			eventDetailController);

	eventDetailController.$inject = [ "$http", "$location", "$sce" ];

	function eventDetailController($http, $location, $sce) {
		var vm = this;

		vm.signinToggle = function() {
			$http.put("/api/events/" + vm.id).then(function(response) {
				if (response.data == "200") {
					window.location.reload(false);
				} else if (response.data == "403") {
					$('.ui.basic.modal').modal('show');
				}else{
					console.log(response)
				}
			});
		};

		activate();
		function activate() {
			vm.event = [];
			vm.gmapurl = "";
			var myRegexp = /\/(\d+)/g;
			var match = myRegexp.exec($location.absUrl());
			vm.id = match[1];
			$http
					.get("/api/events/" + vm.id)
					.then(
							function(response) {
								vm.event = response.data;
								vm.gmapurl = $sce
										.trustAsResourceUrl("https://www.google.com/maps/embed/v1/place?key=AIzaSyAm5BhArLbRFa1MTHUTVbfUT8QS-OJFtgo&q="
												+ vm.event.location.replace(
														/\s+/g, '%20'));
							});
		}
		;
	}
	;
})();
