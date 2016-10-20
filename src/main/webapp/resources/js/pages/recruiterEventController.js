(function() {
  "use strict";

  angular.module("recruiterModule").controller("recruiterEventController",
  recruiterEventController);

  recruiterEventController.$inject = [ "$http" ];

  function recruiterEventController($http){
    var vm = this;

    vm.removeEvent = function(event){
      $http.delete("/recruiterapi/events/" + event.eventId).then(function (response){
        console.log(response);
        vm.events.splice(vm.events.indexOf(event),1);
      });
    }

    activate()
    function activate(){
      vm.events = [];
      vm.eventTypes = [];
      vm.eventThemes = [];

      $http.get("/recruiterapi/events/").then(function(response){
        vm.events = response.data;
        setupMomentsJS(vm.events);
      });

      $http.get("/api/getEventTypes").then(function(response){
        vm.eventTypes = response.data;
      });

      $http.get("/api/getEventThemes").then(function(response){
        vm.eventThemes = response.data;
      });
    }

    ///////////////////////
    // HELPER FUNCTIONS //
    //////////////////////
    function setupMomentsJS(events){
      // Setup time
      for (var i = 0; i < events.length; i++) {
        var s = events[i].start;
        var e = events[i].end

        var startDate = new Date(s.year, s.monthValue-1, s.dayOfMonth, s.hour, s.minute, s.second, s.nano);
        var endDate = new Date(e.year, e.monthValue-1, e.dayOfMonth, e.hour, e.minute, e.second, e.nano);

        events[i].startFormatted = moment(startDate).locale("nl").format("DD-MMM-YYYY HH:mm");
        events[i].endFormatted = moment(endDate).locale("nl").format("DD-MMM-YYYY HH:mm");
        events[i].countdown = moment(startDate).locale("nl").startOf("hour").fromNow();
      }
    }
  }
})();
