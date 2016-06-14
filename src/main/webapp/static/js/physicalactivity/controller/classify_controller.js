App
    .controller(
        'ClassifyController',
        [
            '$scope',
            '$window',
            '$http',
            '$uibModal',
            '$log',
            'viewService',
            'baseUrlView',
            'userService',
            'baseUrlUsers',
            'diseasesService',
            'baseUrlDiseases',
            'sportsService',
            'baseUrlSports',
            'preclassifyService',
            'baseUrlPreclassifies',

            function($scope, $window, $http, $uibModal, $log, viewService,
                baseUrlView, userService, baseUrlUsers, diseasesService,
                baseUrlDiseases, sportsService, baseUrlSports,
                preclassifyService, baseUrlPreclassifies) {

              /*
               * Init Var
               */

              /** init self * */
              var self = this;

              /** init classify * */
              self.classify = {};

              self.chartData = [ {
                label : "Tú Avance",
                value : 35
              }, {
                label : "Te Falta",
                value : 65
              } ];
              self.chartColors = [ "#31C0BE", "#c7254e" ];
              self.myFormatter = function(input) {
                return input + '%';
              };

              /** funtion for load detai diseases by userID * */
              self.loadClassifyByUser = function(userID, userUsername,
                  userName, userSurname, userEmail, userIdentityDocument,
                  userAge, userHeight, userWeight) {

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
                    diseases : {},
                    activities : {},
                    otherDiseases : "",
                    otherActivities : ""
                  };
                  // console.log(self.classify);
                }
              };

              /** funtion for load detai diseases by userID * */
              self.loadDiseasesListByUser = function(userID) {
                diseasesService.loadDiseasesListByUser(userID).then(
                    function(d) {
                      $scope.listDiseasesSelect = d;
                      console.log($scope.listDiseasesSelect);
                    }, function(errResponse) {
                      console.error('Error while fetching Currencies');
                    });
              };

              /** funtion for load detai diseases by userID * */
              self.loadSportsListByUser = function(userID) {
                sportsService.loadSportsListByUser(userID).then(function(d) {
                  $scope.listSportsSelect = d;
                  console.log($scope.listSportsSelect);
                }, function(errResponse) {
                  console.error('Error while fetching Currencies');
                });
              };

              /** funtion for Create(save) from Signon * */
              self.nextClassify = function(classify) {

                if (null !== classify.otherActivities) {
                  $scope.listSportsSelect.push({
                    "name" : classify.otherActivities,
                    "selected" : true
                  })
                }
                if (null !== classify.otherDiseases) {
                  $scope.listDiseasesSelect.push({
                    "name" : classify.otherDiseases,
                    "selected" : true
                  })
                }

                self.classifyOne = {
                  id : classify.id,
                  name : classify.name,
                  height : classify.height,
                  weight : classify.weight,
                  activities : $scope.listSportsSelect,
                  diseases : $scope.listDiseasesSelect
                };

                preclassifyService.preclassify(self.classifyOne).then(
                    function(successResponse) {
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
                self.nextClassify(self.classify);
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
                    }
                  }
                });
              };
              /*
               * Contructor
               */

              $scope.listDiseasesSelect = {};
              $scope.listSportsSelect = {};

              $scope.sessionUserID = $window.sessionUserID;
              $scope.sessionUserUsername = $window.sessionUserUsername;
              $scope.sessionUserName = $window.sessionUserName;
              $scope.sessionUserSurname = $window.sessionUserSurname;
              $scope.sessionUserEmail = $window.sessionUserEmail;
              $scope.sessionUserIdentityDocument = $window.sessionUserIdentityDocument;
              $scope.sessionUserAge = $window.sessionUserAge;
              $scope.sessionUserHeight = $window.sessionUserHeight;
              $scope.sessionUserWeight = $window.sessionUserWeight;

              $scope.getSession = function(userID, userUsername, userName,
                  userSurname, userEmail, userIdentityDocument, userAge,
                  userHeight, userWeight) {

                if (userID !== null) {
                  self.loadClassifyByUser(userID, userUsername, userName,
                      userSurname, userEmail, userIdentityDocument, userAge,
                      userHeight, userWeight);
                  self.loadDiseasesListByUser(userID);
                  self.loadSportsListByUser(userID);
                }
              };

            } ]);
