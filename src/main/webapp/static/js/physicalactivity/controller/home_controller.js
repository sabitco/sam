App.controller('HomeController', [
    '$scope',
    '$window',
    '$http',
    '$uibModal',
    '$log',
    '$sce',
    'homeService',
    'baseUrlHomeTips',
    'baseUrlHomeAdvantages',
    'baseUrlHomeAlerts',
    'baseUrlHomeMyths',
    'goalsMorrisService',
    'baseUrlGoalsMorris',

    function($scope, $window, $http, $uibModal, $log, $sce, homeService,
        baseUrlHomeTips, baseUrlHomeAdvantages, baseUrlHomeAlerts,
        baseUrlHomeMyths, goalsMorrisService, baseUrlGoalsMorris) {

      /*
       * Init Var
       */

      /** init self * */
      var self = this;

      /** init list Tips * */
      self.listTips = [];

      /** init list Advantages * */
      self.listAdvantages = [];

      /** init list Alerts * */
      self.listAlerts = [];

      /** init list Myths * */
      self.listMyths = [];

      /** init list Myths * */
      self.listGoalsMorrisSelect = [];

      /** init mirror * */
      self.chartColors = [ "#31C0BE", "#c7254e" ];
      self.myFormatter = function(input) {
        return input + '%';
      };

      /** funtion for load detail user by userID * */
      self.loadHomeByUser = function(userID, userUsername, userName,
          userSurname, userEmail, userIdentityDocument, userAge, userHeight,
          userWeight, userProgress) {
        if (userID !== null) {
          self.home = {
            id : userID
          };
        }
      };

      /** funtion for load detai diseases by userID * */
      self.loadMorris = function(userProgress) {
        if (userProgress !== null) {
          self.chartData = [ {
            label : "Tú Avance",
            value : userProgress
          }, {
            label : "Te Falta",
            value : 100 - userProgress
          } ];
          self.chartColors = [ "#31C0BE", "#c7254e" ];
          self.myFormatter = function(input) {
            return input + '%';
          };
        }
      };

      /** funtion for load detai activities by userID * */
      self.loadGoalsHomeListByUser = function(userID) {

        goalsMorrisService.loadGoalsListForMorrisByUser(userID).then(
            function(d) {
              angular.forEach(d, function(value, key) {
                self.listGoalsMorrisSelect.push(value);
              });
              console.log(self.listGoalsMorrisSelect);
            }, function(errResponse) {
              console.error('Error while fetching Currencies');
            });

      };

      /** funtion for load detai Tips by userID * */
      self.loadTipsListByUser = function(userID) {
        homeService.loadTips().then(function(d) {
          angular.forEach(d, function(value, key) {
            value.name = $sce.trustAsHtml(value.name);
            self.listTips.push(value);
          });
          console.log(self.listTips);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      /** funtion for load detai Advantages by userID * */
      self.loadAdvantagesListByUser = function(userID) {
        homeService.loadAdvantages().then(function(d) {
          angular.forEach(d, function(value, key) {
            value.name = $sce.trustAsHtml(value.name);
            self.listAdvantages.push(value);
          });
          console.log(self.listAdvantages);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      /** funtion for load detai Alerts by userID * */
      self.loadAlertsListByUser = function(userID) {
        homeService.loadAlerts().then(function(d) {
          angular.forEach(d, function(value, key) {
            value.name = $sce.trustAsHtml(value.name);
            self.listAlerts.push(value);
          });
          console.log(self.listAlerts);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      /** funtion for load detai Myths by userID * */
      self.loadMythsListByUser = function(userID) {
        homeService.loadMyths().then(function(d) {
          angular.forEach(d, function(value, key) {
            value.name = $sce.trustAsHtml(value.name);
            self.listMyths.push(value);
          });
          console.log(self.listMyths);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };
      /*
       * Function Model
       */
      self.open = function(size, msn, typeMsn) {
        var template = '';
        if (typeMsn === 'ERROR') {
          template = "modalContentError.html";
        } else if (typeMsn === 'SUCCESS') {
          template = "modalContent.html";
        }

        var modalInstance = $uibModal.open({
          keyboard : false,
          animation : true,
          templateUrl : template,
          controller : 'ModalInstanceCtrl',
          backdrop : false,
          size : size,
          resolve : {
            msn : function() {
              return msn
            },
            urlsuccess : function() {
              return urlsuccess
            }
          }
        });
      };

      /*
       * Contructor
       */

      $scope.sessionUserID = $window.sessionUserID;
      $scope.sessionUserUsername = $window.sessionUserUsername;
      $scope.sessionUserName = $window.sessionUserName;
      $scope.sessionUserSurname = $window.sessionUserSurname;
      $scope.sessionUserEmail = $window.sessionUserEmail;
      $scope.sessionUserIdentityDocument = $window.sessionUserIdentityDocument;
      $scope.sessionUserAge = $window.sessionUserAge;
      $scope.sessionUserHeight = $window.sessionUserHeight;
      $scope.sessionUserWeight = $window.sessionUserWeight;
      $scope.sessionUserProgress = $window.sessionUserProgress;

      $scope.getSession = function(userID, userUsername, userName, userSurname,
          userEmail, userIdentityDocument, userAge, userHeight, userWeight,
          userProgress) {
        if (userID !== null) {
          self.loadHomeByUser(userID, userUsername, userName, userSurname,
              userEmail, userIdentityDocument, userAge, userHeight, userWeight,
              userProgress);
          self.loadMorris(userProgress)
          self.loadGoalsHomeListByUser(userID);
          self.loadTipsListByUser(userID);
          self.loadAdvantagesListByUser(userID);
          self.loadAlertsListByUser(userID);
          self.loadMythsListByUser(userID);
        }
      };

    } ]);
