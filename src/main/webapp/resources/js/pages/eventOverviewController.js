/**
 * Created by jasper.dejong on 11-10-2016.
 */

(function(){
    "use strict";

    angular.module("eventOverview").controller("eventOverviewController", eventOverviewController);
    eventOverviewController.inject = ['$http', '$location'];

    function eventOverviewController($http, $location) {
        var vm = this;
        setupController();

        function setupController(){

            vm.eventThemeFilterItems = {};
            vm.eventTypeFilterItems = {}

            vm.eventTypeFilter = null;
            vm.eventThemeFilter = null;
            vm.eventRelationFilter = null;

            var url = $location.absUrl();

            $http.get('/api/getEventThemes').then(function(response){
                vm.eventThemeFilterItems = response.data;

                var eventTheme_Regex = /eventTheme=([\w\%]+)/;
                var eventTheme_regexResult = eventTheme_Regex.exec(url);
                if (eventTheme_regexResult !== null) {
                    var eventThemeName = eventTheme_regexResult[1].replace("%20", " ");
                    if(_.find(vm.eventThemeFilterItems, { name: eventThemeName } )) {
                        vm.eventThemeFilter = {'name': eventThemeName};
                    }
                }
            });

            $http.get('/api/getEventTypes').then(function(response){
                vm.eventTypeFilterItems = response.data;

                var eventType_Regex = /eventType=([\w\%]+)/;
                var eventType_regexResult = eventType_Regex.exec(url);
                if (eventType_regexResult !== null) {
                    var eventTypeName = eventType_regexResult[1].replace("%20", " ");
                    if(_.find(vm.eventTypeFilterItems, { name: eventTypeName } )) {
                        vm.eventTypeFilter = {'name': eventTypeName};
                    }
                }
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