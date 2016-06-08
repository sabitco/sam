'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");

App.constant("baseUrlView", "http://localhost:8080/admin/pages/");

App.constant("baseUrlCampus", "http://localhost:8080/campus/");

App.constant("baseUrlFaculties", "http://localhost:8080/campus/faculties/");

App.constant("baseUrlUsers", "http://localhost:8080/admin/users/");

App.constant("baseUrlDiseases", "http://localhost:8080/users/diseases/");

App.controller('ClassifyController', [
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

    function($scope, $window, $http, $uibModal, $log, viewService, baseUrlView,
        userService, baseUrlUsers, diseasesService, baseUrlDiseases) {

      /*
       * Public Function
       */

      /** init self * */
      var self = this;
      self.classify = {
        username : "",
        name : "",
        surname : "",
        email : "",
        identityDocument : "",
        age : "",
        height : "",
        weight : "",
        descriptionHistory : "",
      };

      /** init detail View * */
      self.practiceDays = [];

      /** funtion for reset from Signon * */
      self.resetBasic = function() {
        self.signonBasic = {
          id : null,
        };
        $scope.signonFormBasic.$setPristine();
      };

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

      /** init detail View * */
      self.listDiseases = [];

      /** funtion for load detai diseases by userID * */
      self.loadDiseaseListByUser = function(userID) {
        diseasesService.loadDiseaseListByUser(userID).then(function(d) {
          self.listDiseases = d;
          console.log(self.listDiseases);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

    } ]);