App.controller('RightController', [
    '$scope',
    '$window',
    '$http',
    '$uibModal',
    '$log',
    '$sce',
    'eventsService',
    'baseUrlEvents',

    function($scope, $window, $http, $uibModal, $log, $sce, eventsService,
        baseUrlEvents) {

      /*
       * Init Var
       */
      /** init self * */
      var self = this;

      /** init list Tips * */
      self.listEvents = [];

      /** funtion for load detai activities by userID * */
      self.loadEvent = function() {
        eventsService.loadEventsList().then(function(d) {
          angular.forEach(d, function(value, key) {
            self.listEvents.push(value);
          });
          console.log(self.listEvents);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });

      };

      /*
       * Contructor
       */
      $scope.getInit = function() {
        self.loadEvent();
      };

    } ]);
