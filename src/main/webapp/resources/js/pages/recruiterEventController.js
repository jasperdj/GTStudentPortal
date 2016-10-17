(function() {
  "use strict";

  angular.module("recruiterModule").controller("recruiterEventController",
  recruiterEventController);

  recruiterEventController.$inject = [ "$http" ];

  function recruiterEventController($http){
    var vm = this;

    vm.addEvent = function(){
      alert("NYI");
    }

    vm.removeEvent = function(){
      alert("NYI");
    }

    vm.updateEvent = function(){
      alert("NYI");
    }

    activate()
    function activate(){
      vm.events = []

      $http.get("/recruiterapi/events/").then(function(response){
        vm.events = response.data;
        setupMomentsJS(vm.events);
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
