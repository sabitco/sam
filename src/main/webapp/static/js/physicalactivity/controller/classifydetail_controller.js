App.controller('ClassifyDetailController', [
    '$scope',
    '$window',
    '$http',
    '$uibModal',
    '$log',
    'viewService',
    'baseUrlView',
    'userService',
    'baseUrlUsers',
    'sportsService',
    'baseUrlSports',
    'classifyDetailService',
    'baseUrlClassifyDetail',

    function($scope, $window, $http, $uibModal, $log, viewService, baseUrlView,
        userService, baseUrlUsers, sportsService, baseUrlSports,
        classifyDetailService, baseUrlClassifyDetail) {

      /*
       * Init Var
       */

      /** init self * */
      var self = this;

      /** init classify * */
      self.classify = {};

      /** Url Success * */
      var urlsuccess = "/physicalactivity/Goals";

      /** funtion for load detai Morris by userID * */
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

      /** funtion for load detail user by userID * */
      self.loadClassifyByUser = function(userID, userUsername, userName,
          userSurname, userEmail, userIdentityDocument, userAge, userHeight,
          userWeight, userProgress) {

        if (userID !== null) {
          self.classify = {
            id : userID,
            username : userUsername,
            name : userName,
            surname : userSurname,
            email : userEmail,
            identityDocument : userIdentityDocument,
            age : userAge,
            height : userHeight,
            weight : userWeight,
            progress : userProgress
          };
          console.log(self.classify);
        }
      };

      /** funtion for load detai activities by userID * */
      self.loadSportsCheckedListByUser = function(userID) {
        sportsService.loadSportsCheckedListByUser(userID).then(function(d) {
          $scope.listSportsCheckedSelect = d;
          console.log($scope.listSportsCheckedSelect);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      /** funtion for Create(save) from Signon * */
      self.nextClassify = function(classify) {
        classifyDetailService.classify(self.classify).then(
            function(successResponse) {
              console.log(successResponse);
              if (successResponse.status === 201) {
                self.open('lg', successResponse.message, 'SUCCESS');
              } else {
                self.open('lg', successResponse.detail, 'ERROR');
                console.error('Error En Datos');
              }
            }, function(errResponse) {
              self.open('lg', errResponse, 'ERROR');
              console.error('Error while creating preclassify');
            });
      };

      /*
       * Function Submit
       */
      self.submit = function() {

        self.classifyOne = {
          id : self.classify.id,
          activities : $scope.listSportsCheckedSelect
        };
        self.nextClassify(self.classifyOne);
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
      $scope.listSportsCheckedSelect = {};

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
          self.loadSportsCheckedListByUser(userID);
          self.loadMorris(userProgress);

        }
      };

    } ]);
