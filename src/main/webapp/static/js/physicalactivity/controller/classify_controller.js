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

            function($scope, $window, $http, $uibModal, $log, viewService,
                baseUrlView, userService, baseUrlUsers, diseasesService,
                baseUrlDiseases, sportsService, baseUrlSports) {

              /*
               * Init Var
               */

              /** init self * */
              var self = this;

              /** init classify * */
              self.classify = {};

              /** init detail View * */
              self.practiceDays = [];

              /** init listDiseases * */
              self.listDiseases = [];

              /** init listDiseasesCheck * */
              self.listDiseasesCheck = [];

              /** init listSports * */
              self.listSports = [];

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
                  console.log(self.classify);
                }
              };

              /** funtion for load detai diseases by userID * */
              self.loadDiseasesListByUser = function(userID) {
                diseasesService.loadDiseasesListByUser(userID).then(
                    function(d) {
                      self.listDiseases = d;
                      console.log(self.listDiseases);
                    }, function(errResponse) {
                      console.error('Error while fetching Currencies');
                    });
              };

              /** funtion for load detai diseases by userID * */
              self.loadSportsListByUser = function(userID) {
                sportsService.loadSportsListByUser(userID).then(function(d) {
                  self.listSports = d;
                  console.log(self.listSports);
                }, function(errResponse) {
                  console.error('Error while fetching Currencies');
                });
              };

              /** funtion for Create(save) from Signon * */
              self.nextClassify = function(classify) {

                angular.forEach(self.listDiseases, function(value, index) {
                  console.log(index); // 0, 1, 2, 3
                  console.log(value); // A, B, C, D
                  if (value.selected === true) {
                    self.listDiseasesCheck.push(value);
                  }
                });

                console.log(self.listDiseasesCheck);

                self.classifyOne = {
                  id : classify.id,
                  name : classify.name,
                  height : classify.height,
                  weight : classify.weight,
                  activities : classify.activities,
                  diseases : classify.diseases
                };
                console.log("entro");
                console.log(self.classifyOne);
              };

              /*
               * Function Submit
               */
              self.submit = function() {
                console.log(self.classify);
                self.nextClassify(self.classify);
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
