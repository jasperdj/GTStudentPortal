(function() {
  "use strict";

  angular.module("recruiterModule").controller("recruiterStudentController",
  recruiterStudentController);

  recruiterStudentController.$inject = [ "$http" ];

  function recruiterStudentController($http){
    var vm = this;

    vm.showNewStudent = function(){
      $('.ui.modal')
      .modal('show');
    }

    vm.hideNewStudent = function(){
      $('.ui.modal')
      .modal('hide');
    }

    vm.addStudent = function(newStudent, start, end, dateOfBirth){
      if(newStudent === undefined){
        return;
      }
      console.log(newStudent);
      newStudent.startEducation = start.toISOString().substring(0, 10);
      newStudent.endEducation = end.toISOString().substring(0, 10);
      newStudent.dateOfBirth = dateOfBirth.toISOString().substring(0, 10);

      $http.post("/recruiterapi/students/", newStudent)
      .then(function (response) {
        console.log(response);
        vm.students.push(response.data);
        vm.hideNewStudent();
        setupMomentsJS(vm.students);
      },
      function(){
        alert('Kon student niet aanmaken!');
      }
    );
  }

  vm.removeStudent = function(student){
    $http.delete("/recruiterapi/students/" + student.id).then(function (response){
      console.log(response);
      vm.students.splice(vm.students.indexOf(student),1);
    });
  }

  vm.updateStudent = function(){
    alert("NYI");
  }

  activate()
  function activate(){
    vm.students = [];
    vm.universities = [];
    vm.educations = [];
    vm.eventTypes = [];
    vm.eventThemes = [];

    $http.get("/recruiterapi/students/").then(function(response){
      vm.students = response.data;
      setupMomentsJS(vm.students);
    });

    $http.get("/api/getEventTypes").then(function(response){
      vm.eventTypes = response.data;
    });

    $http.get("/api/getEventThemes").then(function(response){
      vm.eventThemes = response.data;
    });

    $http.get("/recruiterapi/universities/").then(function(response){
      vm.universities = response.data;
    });

    $http.get("/recruiterapi/educations/").then(function(response){
      vm.educations = response.data;
    });
  }


  ///////////////////////
  // HELPER FUNCTIONS //
  //////////////////////
  function setupMomentsJS(students){
    // Setup time
    for (var i = 0; i < students.length; i++) {
      var s = students[i].startEducation;
      var e = students[i].endEducation;
      var d = students[i].dateOfBirth;

      console.log(students[i]);
      if(s !== null || e !== null){
        var startDate = new Date(s.year, s.monthValue-1, s.dayOfMonth);
        var endDate = new Date(e.year, e.monthValue-1, e.dayOfMonth);

        students[i].startFormatted = moment(startDate).locale("nl").format("DD-MMM-YYYY");
        students[i].endFormatted = moment(endDate).locale("nl").format("DD-MMM-YYYY");
      }

      if(d !== null){
        var dateOfBirth = new Date(d.year, d.monthValue-1, d.dayOfMonth);
        students[i].dateOfBirthFormatted = moment(dateOfBirth).locale("nl").format("DD-MMM-YYYY");
      }

    }
  }
}
})();
