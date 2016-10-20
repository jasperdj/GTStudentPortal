(function() {
  "use strict";

  angular.module("recruiterModule").controller("recruiterStudentController",
  recruiterStudentController);

  recruiterStudentController.$inject = [ "$http" ];

  function recruiterStudentController($http){
    var vm = this;

    vm.showNewStudent = function(){
      $('.ui.modal.newstudent')
      .modal('show');
    }

    vm.showUpdateStudent = function(student){
      if(student.startEducation != null){
        convertDateForJavascript(student.startEducation);
      }
      if(student.endEducation != null){
        convertDateForJavascript(student.startEducation);
      }
      if(student.dateOfBirth != null){
        convertDateForJavascript(student.startEducation);
      }
      vm.currentStudent = student;

      $('.ui.modal.updatestudent')
      .modal('show');
    }

    vm.hideNewStudent = function(){
      $('.ui.modal')
      .modal('hide');
    }

    vm.addStudent = function(newStudent, startEducation, endEducation, dateOfBirth){
      console.log("Not yet implemented.");
    //   if(newStudent === undefined){
    //     console.log("newStudent is null of undefined.");
    //     return;
    //   }
    //   if(startEducation != null){
    //     convertDateForJava(startEducation);
    //     newStudent.startEducation = startEducation;
    //   }
    //   if(endEducation != null){
    //     convertDateForJava(endEducation);
    //     newStudent.endEducation = endEducation;
    //   }
    //   if(dateOfBirth != null){
    //     convertDateForJava(dateOfBirth);
    //     newStudent.dateOfBirth = dateOfBirth;
    //   }
    //
    //   $http.post("/recruiterapi/students/", newStudent)
    //   .then(function (response) {
    //     vm.students.push(response.data);
    //     console.log(response);
    //     vm.hideNewStudent();
    //     setupMomentsJS(vm.students);
    //     $( '#newStudentForm' ).each(function(){
    //       this.reset();
    //     });
    //   },
    //   function(response){
    //     console.log("Foutje met het aanmaken van een student:", response);
    //   }
    // );
  }

  vm.removeStudent = function(student){
    $http.delete("/recruiterapi/students/" + student.id).then(function (response){
      if(response.data !== 200){
        alert('Kon student niet verwijderen!');
      }else{
          vm.students.splice(vm.students.indexOf(student),1);
      }
    },function(){
      alert('Kon student niet verwijderen!')
    });
  }

  vm.updateStudent = function(student, startEducation, endEducation, dateOfBirth){
    console.log("Not yet implemented.");
    // if(startEducation != null){
    //   convertDateForJava(startEducation);
    //   student.startEducation = startEducation;
    // }
    // if(endEducation != null){
    //   convertDateForJava(endEducation);
    //   student.endEducation = endEducation;
    // }
    // if(dateOfBirth != null){
    //   convertDateForJava(dateOfBirth);
    //   student.dateOfBirth = dateOfBirth;
    // }
    //
    // $http.put("/recruiterapi/students/" + student.id, student).then(function(response){
    //   vm.currentStudent = "";
    //   $( '#updateStudentForm' ).each(function(){
    //     this.reset();
    //   });
    //   vm.hideNewStudent();
    // });
  }

  activate()
  function activate(){
    vm.students = [];
    vm.currentStudent = "";
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
  // function dateConvertForJava(student){
  //   try {
  //     if(student.startEducation != null && student.endEducation != null){
  //       console.log("dateConvertForJava: converting education dates...");
  //       student.startEducation = new Date(student.startEducation.toISOString().substring(0, 10));
  //       student.endEducation = new Date(student.endEducation.toISOString().substring(0, 10));
  //     }
  //     if(student.dateOfBirth != null){
  //       console.log("dateConvertForJava: converting birth date...");
  //       console.log("\t\t\t - " + student.dateOfBirth.toISOString().substring(0, 10));
  //       student.dateOfBirth = new Date(student.dateOfBirth.toISOString().substring(0, 10));
  //     }
  //   } catch (e) {
  //     console.log("dateConvertForJava - ERROR:", e);
  //   }
  // }

  function convertDateForJava(date){
    try{
      date = new Date(date.toISOString().substring(0, 10));
      console.log("convertDateForJava, converted date to " + date);
    }catch(e){
      console.log("convertDateForJava, error:", e);
    }
  }

  function convertDateForJavascript(date){
    try{
      date = new Date(date.year+"-"+date.monthValue+"-"+date.dayOfMonth);
      console.log("convertDateForJavascript, converted date to " + date);
    }catch(e){
      console.log("convertDateForJavascript, error:", e);
    }
  }

  // function dateConvertForJavascript(student){
  //   if(student.startEducation != null && student.endEducation != null){
  //     console.log("dateConvertForJavascript: converting education dates...");
  //     student.startEducation = new Date(student.startEducation.year+"-"+student.startEducation.monthValue+"-"+student.startEducation.dayOfMonth);
  //     student.endEducation = new Date(student.endEducation.year+"-"+student.endEducation.monthValue+"-"+student.endEducation.dayOfMonth);
  //   }
  //
  //   if(student.dateOfBirth != null){
  //     console.log("dateConvertForJavascript: converting birth date...");
  //     console.log("\t\t\t - " + student.dateOfBirth.year+"-"+student.dateOfBirth.monthValue+"-"+student.dateOfBirth.dayOfMonth);
  //     student.dateOfBirth = new Date(student.dateOfBirth.year+"-"+student.dateOfBirth.monthValue+"-"+student.dateOfBirth.dayOfMonth);
  //   }
  // }

  function setupMomentsJS(students){
    // Setup time
    for (var i = 0; i < students.length; i++) {
      var s = students[i].startEducation;
      var e = students[i].endEducation;
      var d = students[i].dateOfBirth;

      if(s != null || e != null){
        var startDate = new Date(s.year, s.monthValue-1, s.dayOfMonth);
        var endDate = new Date(e.year, e.monthValue-1, e.dayOfMonth);

        students[i].startFormatted = moment(startDate).locale("nl").format("DD-MMM-YYYY");
        students[i].endFormatted = moment(endDate).locale("nl").format("DD-MMM-YYYY");
      }

      if(d != null){
        var dateOfBirth = new Date(d.year, d.monthValue-1, d.dayOfMonth);
        students[i].dateOfBirthFormatted = moment(dateOfBirth).locale("nl").format("DD-MMM-YYYY");
      }

    }
  }
}
})();
