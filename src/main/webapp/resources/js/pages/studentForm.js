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

        vm.addComment(function(){
            alert('works');
            var studentComment = {'comment': vm.comment, 'reminder': vm.reminder, 'created': new Date().toISOString()} ;

            $http
                .put('/gApi/students/'+vm.studentId, vm.student['studentComments'].push(studentComment))
                .success(function(data, status){
                    alert('yeay');
                 });

            $http({
                method: 'PUT',
                url: '/gApi/students/'+vm.studentId
            }).success(function(data, status){

            });


        });

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
