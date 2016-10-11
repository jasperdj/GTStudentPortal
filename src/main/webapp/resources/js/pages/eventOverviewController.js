/**
 * Created by jasper.dejong on 11-10-2016.
 */

(function(){
    "use strict";

    angular.module("eventOverview").controller("eventOverviewController", eventOverviewController);
    eventOverviewController.inject = ['$http'];

    function eventOverviewController($http) {
        var vm = this;


        setupController();

        function setupController(){
            vm.eventThemeFilter = {};
            $http.get('/api/getEventThemes').then(function(response){
                vm.eventThemeFilter = response.data;
            });

            $http.get('/api/getEventTypes').then(function(response){
                vm.eventTypeFilter = response.data;
            });

            $http.get('/api/getEvents?from=0&to=365').then(function(response){
                vm.eventGroups = _.groupBy(response.data, 'start.dayOfYear');
                console.log('response events', vm.eventGroups);
            });

        }

        function fillEventThemeFilter() {
            $http({
                method: "get",
                url: ""
            }).success(function(data, status, header, config){
                vm.eventThemeFilter = data;
            }).error(function(){

            });
        }

    }
})();