App
    .controller(
        'GoalsController',
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

              /** Url Success * */
              var urlsuccess = "/physicalactivity/Classificationdetail";

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

              /** funtion for load detai diseases by userID * */
              self.loadClassifyByUser = function(userID, userUsername,
                  userName, userSurname, userEmail, userIdentityDocument,
                  userAge, userHeight, userWeight, userProgress) {

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
                    otherActivities : "",
                    progress : userProgress
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

              /** funtion for Create(save) from Classify detail * */
              self.nextClassify = function(classifyOne) {
                preclassifyService.preclassify(classifyOne).then(
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

                if ((self.classify.otherActivities != "")
                    || (self.classify.otherActivities != null)) {
                  $scope.listSportsSelect.push({
                    "name" : self.classify.otherActivities,
                    "selected" : true
                  })
                }
                if ((self.classify.otherDiseases != "")
                    || (self.classify.otherDiseases != null)) {
                  $scope.listDiseasesSelect.push({
                    "name" : self.classify.otherDiseases,
                    "selected" : true
                  })
                }

                self.classifyOne = {
                  id : self.classify.id,
                  name : self.classify.name,
                  height : self.classify.height,
                  weight : self.classify.weight,
                  activities : $scope.listSportsSelect,
                  diseases : $scope.listDiseasesSelect
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
              $scope.sessionUserProgress = $window.sessionUserProgress;

              $scope.getSession = function(userID, userUsername, userName,
                  userSurname, userEmail, userIdentityDocument, userAge,
                  userHeight, userWeight, userProgress) {

                if (userID !== null) {
                  self.loadClassifyByUser(userID, userUsername, userName,
                      userSurname, userEmail, userIdentityDocument, userAge,
                      userHeight, userWeight, userProgress);
                  self.loadDiseasesListByUser(userID);
                  self.loadSportsListByUser(userID);
                  self.loadMorris(userProgress)
                }
              };

            } ]);
