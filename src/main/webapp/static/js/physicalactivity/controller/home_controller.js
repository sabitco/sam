App.controller('HomeController', [
    '$scope',
    '$window',
    '$http',
    '$uibModal',
    '$log',
    'goalsService',
    'baseUrlGoals',
    'usergoalsService',
    'baseUrlUserGoals',

    function($scope, $window, $http, $uibModal, $log, goalsService,
        baseUrlGoals, usergoalsService, baseUrlUserGoals) {

      /*
       * Init Var
       */

      /** init self * */
      var self = this;

      /** init classify * */
      self.home = {};

      /** init listGoals * */
      self.listGoals = {};

      /** init mirror * */
      self.chartColors = [ "#31C0BE", "#c7254e" ];
      self.myFormatter = function(input) {
        return input + '%';
      };

      /** Url Success * */
      var urlsuccess = "/physicalactivity/home";

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

        // goalsService.loadGoalsListByUser(userID).then(function(d) {
        // $scope.listGoalsSelect = d;
        // console.log($scope.listGoalsSelect);
        // }, function(errResponse) {
        // console.error('Error while fetching Currencies');
        // });

        /** init classify * */
        self.listGoals = [ {
          activity : [ {
            label : "Caminar",
            value : 60
          }, {
            label : "Te Falta Caminar",
            value : 40
          } ],
          name : "Caminar",
          totalsemanaminutes : 80,
          totalmesminutes : 120
        }, {
          activity : [ {
            label : "Correr",
            value : 65
          }, {
            label : "Te Falta Correr",
            value : 35
          } ],
          name : "Correr",
          totalsemanaminutes : 100,
          totalmesminutes : 200
        }, {
          activity : [ {
            label : "Nadar",
            value : 30
          }, {
            label : "Te Falta Nadar",
            value : 70
          } ],
          name : "Nadar",
          totalsemanaminutes : 20,
          totalmesminutes : 260
        }, {
          activity : [ {
            label : "Bailar",
            value : 10
          }, {
            label : "Te Falta Bailar",
            value : 90
          } ],
          name : "Bailar",
          totalsemanaminutes : 70,
          totalmesminutes : 280
        } ];
      };

      /** funtion for load detai Tips by userID * */
      self.loadTipsListByUser = function(userID) {

      };

      /** funtion for load detai Advantages by userID * */
      self.loadAdvantagesListByUser = function(userID) {

      };

      /** funtion for load detai Alerts by userID * */
      self.loadAlertsListByUser = function(userID) {

      };

      /** funtion for load detai Myths by userID * */
      self.loadMythsListByUser = function(userID) {

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

      $scope.listGoalsSelect = {};

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
