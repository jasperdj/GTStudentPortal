/**
 * Created by jasper.dejong on 11-10-2016.
 */
(function(){
    "use strict";

    var app = angular.module("eventOverview", []);

    //TODO replace jquery children counter with proper eventGroupFilter
    /*app.filter("eventGroupFilter", function(){
        return function(eventGroup, eventThemeFilter, eventTypeFilter, eventRelationFilter, userId) {
             var newGroup = eventGroup.clone();
             newGroup.events = andereFilter(eg.events);
             if(dat is null) { return null; }
             return newGroup;
        };
    });*/

    app.filter("eventFilter", function(){
        return function(item, eventThemeFilter, eventTypeFilter, eventRelationFilter, userId) {

            var event = item[0];
            if (eventThemeFilter === null && eventTypeFilter===null && eventRelationFilter === null) {
                return item;
            }
            if (eventRelationFilter === 1) {
                if(!_.find(event.attendees, { userId : userId })){
                    return null;
                }
            }

            if (eventThemeFilter !== null) {
                if(!_.find(event.eventThemes, { name: eventThemeFilter.name } )){
                    return null;
                }
            }

            if (eventTypeFilter !== null) {
                if(!_.find(event.eventTypes, { name: eventTypeFilter.name } )){
                    return null;
                }
            }

            return item;
        };
    });

})();