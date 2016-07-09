App.controller('TipController', [
    '$scope',
    '$window',
    '$http',
    '$uibModal',
    '$log',
    '$sce',
    'tipService',
    'baseUrlTips',

    function($scope, $window, $http, $uibModal, $log, $sce, tipService,
        baseUrlTips) {

      /*
       * Init Var
       */

      /** init self * */
      var self = this;

      /** init classify * */
      self.tip = [];

      /*
       * Contructor
       */

      /** funtion for load detai Tips by userID * */
      self.loadTipByID = function(tipID) {
        if (tipID !== null) {
          tipService.loadTipByID(tipID).then(function(d) {

            self.tip = d
            console.log(self.tip);
          }, function(errResponse) {
            console.error('Error while fetching Currencies');
          });
        }
      };

      $scope.getSession = function(tipID) {

        if (tipID !== null) {
          self.loadTipByID(tipID);
        }
      };

    } ]);
