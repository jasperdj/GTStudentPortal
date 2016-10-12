(function(){
  "use strict";

  angular.module("eventDetailModule").controller("eventDetailController", eventDetailController);

  eventDetailController.$inject = ["$http", "$location", "$sce"];

  function eventDetailController($http, $location, $sce){
    var vm = this;
    
    activate();
    function activate(){
      vm.event = [];
      vm.gmapurl = "";
      vm.id = $location.path().slice(-1);
      $http.get("/api/events/" + vm.id).then(function(response){
        vm.event = response.data;
        console.log(vm.event);
        vm.gmapurl = $sce.trustAsResourceUrl("https://www.google.com/maps/embed/v1/place?key=AIzaSyAm5BhArLbRFa1MTHUTVbfUT8QS-OJFtgo&q=" + vm.event.location.replace(/\s+/g, '%20'));
        console.log(vm.gmapurl);
      });
    };
  };
})();
