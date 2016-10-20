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

        vm.addComment = function(){
            var studentComment = {'comment': vm.comment, 'reminder': null, 'created': new Date().toISOString().replace("Z", "")} ;
            var studentClone = JSON.parse(JSON.stringify(vm.student));
            studentClone['studentComments'].push(studentComment);

            $http({
                method: 'PUT',
                url: '/gApi/students/'+vm.studentId,
                headers: {
                    'Content-Type': 'application/json'
                },
                data: studentClone
            }).success(function(data, status){
                vm.student.push(studentComment);
            }).error(function(error){
                alert('Error: commentaar kon niet worden toegevoegd. Probeer later opnieuw.');
            });


        };

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
