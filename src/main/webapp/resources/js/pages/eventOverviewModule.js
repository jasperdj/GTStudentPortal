/**
 * Created by jasper.dejong on 11-10-2016.
 */
(function(){
    "use strict";

    var app = angular.module("eventOverview", []);

    app.filter("eventGroup", function(){

    });

    app.filter("eventFilter", function(){
        return function(item, eventThemeFilter, eventTypeFilter, eventRelationFilter, userId) {

            var keep = true;

            if (eventThemeFilter === null && eventTypeFilter===null && eventRelationFilter === null) {
                keep = true;
            } else {
                if (eventRelationFilter !== null) {
                    angular.forEach(item[0].attendees, function(value){
                        if (value.userId !== userId && keep === true) {
                            keep = false;
                        }
                    });
                }

                if (eventThemeFilter !== null) {
                    var tempKeep = keep;
                    angular.forEach(item[0].eventThemes, function (value) {
                        if (value.name !== eventThemeFilter.name && keep === true && tempKeep !== true) {
                            tempKeep = false;
                        }
                    });
                }

                if (eventTypeFilter !== null) {
                    angular.forEach(item[0].eventTypes, function (value) {
                        if (value.name !== eventTypeFilter.name && keep === true) {
                            keep = false;
                        }
                    });
                }
            }

            return keep ? item : null;
        };
    });

})();