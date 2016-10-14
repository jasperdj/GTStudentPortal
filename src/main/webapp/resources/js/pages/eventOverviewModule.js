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
            var itemCopy = [];
            for (var b = 0; b<item.length; b++) {
                itemCopy[b] = item[b];
            }

            if (eventThemeFilter === null && eventTypeFilter===null && eventRelationFilter === null) {
                return itemCopy;
            }

            var spliced = 0;

            for(var i = 0; i < item.length; i++) {
                var event = item[i];

                if (eventRelationFilter === 1) {
                    if(!_.find(event.attendees, { userId : userId })){
                        itemCopy.splice(i-spliced, 1);
                        spliced++;
                    }
                }

                if (eventThemeFilter !== null) {
                    if(!_.find(event.eventThemes, { name: eventThemeFilter.name } )){
                        itemCopy.splice(i-spliced, 1);
                        spliced++;
                    }
                }

                if (eventTypeFilter !== null) {
                    if(!_.find(event.eventTypes, { name: eventTypeFilter.name } )){
                        itemCopy.splice(i-spliced, 1);
                        spliced++;
                    }
                }
            }
            return itemCopy;
        };
    });

})();