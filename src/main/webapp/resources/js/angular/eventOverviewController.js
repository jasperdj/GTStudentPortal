/**
 * Created by jasper.dejong on 11-10-2016.
 */

(function(){
    "use strict";

    angular.module("eventOverview").controller("eventOverviewController", eventOverviewController);

    function eventOverviewController() {
        var vm = this;

        vm.print = function() {
            return "hello god.";
        };

    }
})();