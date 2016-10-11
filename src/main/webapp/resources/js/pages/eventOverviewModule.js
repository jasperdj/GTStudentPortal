/**
 * Created by jasper.dejong on 11-10-2016.
 */
(function(){
    "use strict";

    var app = angular.module("eventOverview", []);

    app.filter("eventFilter", function(){
        return function(item, eventThemeFilter, eventTypeFilter, eventRelationFilter) {

            var keep = false;

            if (eventThemeFilter === null && eventTypeFilter===null && eventRelationFilter === null) {
                keep = true;
            } else {
                angular.forEach(item[0].eventThemes, function (value) {
                    if (value.name === eventThemeFilter.name) {
                        keep = true;
                    }
                });

                angular.forEach(item[0].eventTypes, function (value) {
                    if (value.name === eventTypeFilter.name) {
                        keep = true;
                    }
                });
            }

            if (keep) {
                return item;
            }
            else {
                return null;
            }
        };
    });

})();