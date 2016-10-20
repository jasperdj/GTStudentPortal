/**
 * Created by jasper.dejong on 19-10-2016.
 */
(function() {
    "use strict";

    var module = angular.module('studentForm',[]);

    module.controller("studentFormController", eventOverviewController);
    eventOverviewController.inject = ['$http', '$location'];

    function eventOverviewController($http, $location) {
        var vm = this;
        vm.studentId = null;
        vm.student = null;
        vm.studentComments = null;



        setupController();
        function setupController() {
            var url = $location.absUrl();
            var studentId_Regex = /\/([\d]+)/;
            var studentId_regexResult = studentId_Regex.exec(url);
            if (studentId_regexResult !== null) {
                vm.studentId = studentId_regexResult[1];
            }

            getStudent();
        }

        function getStudent() {
            $http.get('/gApi/students/'+vm.studentId).then(function(response) {
                vm.student = response.data;
                vm.studentComments = vm.student['studentComments'];
            });
        }
    }
})();
