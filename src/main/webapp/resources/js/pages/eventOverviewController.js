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
            vm.eventThemeFilterItems = {};
            vm.eventTypeFilterItems = {}

            vm.eventTypeFilter = null;
            vm.eventThemeFilter = null;
            vm.eventRelationFilter = null;

            $http.get('/api/getEventThemes').then(function(response){
                vm.eventThemeFilterItems = response.data;
            });

            $http.get('/api/getEventTypes').then(function(response){
                vm.eventTypeFilterItems = response.data;
            });

            $http.get('/api/getEvents?from=0&to=365').then(function(response){
                vm.eventGroups = _.groupBy(response.data, 'start.dayOfYear');
                window.mydata = vm.eventGroups;
            });

        }

        vm.setEventRelationFilter = function(eventRelation) {
            vm.eventRelationFilter = eventRelation;
        }

        vm.setEventTypeFilter = function(eventType) {
            vm.eventTypeFilter = eventType;
        };

        vm.setEventThemeFilter = function(eventTheme) {
            vm.eventThemeFilter = eventTheme;
        };
    }
})();