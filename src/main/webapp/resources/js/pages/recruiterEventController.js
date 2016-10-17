(function() {
  "use strict";

  angular.module("recruiterModule").controller("recruiterEventController",
  recruiterEventController);

  recruiterEventController.$inject = [ "$http" ];

  function recruiterEventController($http){
    var vm = this;

    vm.showNewEvent = function(){
      $('.ui.modal')
      .modal('show');
    }

    vm.hideNewEvent = function(){
      $('.ui.modal')
      .modal('hide');
    }

    vm.addEvent = function(newEvent, start, end){
      if(newEvent === undefined){
        return;
      }
      newEvent.start = start.toLocaleString();
      newEvent.end = end.toLocaleString();
      $http.post("/recruiterapi/events/", newEvent)
      .then(function (response) {
        console.log(response);
        vm.events.push(response.data);
        vm.hideNewEvent();
      },
      function(){
        alert('Kon event niet aanmaken!');
      }
    );
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
