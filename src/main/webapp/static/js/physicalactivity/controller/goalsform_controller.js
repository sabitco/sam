App.controller('GoalsformController', [
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
      self.goals = {};

      /** Url Success * */
      var urlsuccess = "/physicalactivity/home";

      /** funtion for load detail user by userID * */
      self.loadClassifyByUser = function(userID, userUsername, userName,
          userSurname, userEmail, userIdentityDocument, userAge, userHeight,
          userWeight, userProgress) {

        if (userID !== null) {
          self.goals = {
            id : userID
          };
        }
      };

      /** funtion for load detai activities by userID * */
      self.loadGoalsListByUser = function(userID) {
        goalsService.loadGoalsSelectListByUser(userID).then(function(d) {
          $scope.listGoalsSelect = d;
          console.log($scope.listGoalsSelect);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      /** funtion for Create(save) from Classify detail * */
      self.nextGoals = function(goalsOne) {
        usergoalsService.updateGoals(goalsOne).then(function(successResponse) {
          console.log(successResponse);
          if (successResponse.status === 201) {
            self.open('lg', successResponse.message, 'SUCCESS');
          } else {
            self.open('lg', successResponse.detail, 'ERROR');
            console.error('Error En Datos');
          }
          console.error('guardo');
        }, function(errResponse) {
          self.open('lg', errResponse, 'ERROR');
          console.error('Error while creating preclassify');
        });
      };

      /*
       * Function Submit
       */
      self.submit = function() {

        self.goalsOne = {
          id : self.goals.id,
          goals : $scope.listGoalsSelect
        };
        console.log(self.goalsOne);
        // self.nextGoals(self.goalsOne);
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
          self.loadClassifyByUser(userID, userUsername, userName, userSurname,
              userEmail, userIdentityDocument, userAge, userHeight, userWeight,
              userProgress);
          self.loadGoalsListByUser(userID);
        }
      };

    } ]);
