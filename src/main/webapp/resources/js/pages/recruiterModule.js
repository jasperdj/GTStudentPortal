(function() {
  "use strict";

  angular.module("recruiterModule", []).config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.headers.post['Content-Type'] = 'multipart/form-data; charset=utf-8; boundary="--4242"';
  }]);

})();
