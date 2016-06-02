'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");

App.constant("baseUrlView", "http://localhost:8080/admin/pages/");

App.constant("baseUrlCampus", "http://localhost:8080/campus/");

App.constant("baseUrlFaculties", "http://localhost:8080/campus/faculties/");

App.constant("baseUrlUsers", "http://localhost:8080/admin/users/");

App.controller('SignonController', [
    '$scope',
    '$window',
    'viewService',
    'baseUrlView',
    'campusService',
    'baseUrlCampus',
    'facultiesService',
    'baseUrlFaculties',
    'userService',
    'baseUrlUsers',
    '$uibModal',
    '$log',
    function($scope, $window, viewService, baseUrlView, campusService,
        baseUrlCampus, facultiesService, baseUrlFaculties, userService,
        baseUrlUsers, $uibModal, $log) {

      /*
       * Public Function
       */

      /** init self * */
      var self = this;
      self.signonBasic = {
        username : "",
        name : "",
        surname : "",
        password : "",
        confirmpassword : "",
        identityDocument : "",
        email : "",
        height : "",
        weight : "",
        dateBirth : new Date(),
        universitysede : "",
        faculty : "",
        descriptionHistory : "",
        useCondition : true

      };

      /** init detail View * */
      self.detailView = [];

      /** init list campus * */
      self.listCampus = [];

      /** init list faculties * */
      self.listFaculties = [];

      /** Url Success * */
      var landingUrl = "http://" + $window.location.host
          + "/physicalactivity/classify";

      /*
       * Function Submit
       */
      self.submit = function() {
        self.createSignon(self.signonBasic);
      };

      /*
       * Private Function
       */

      /** funtion for Create(save) from Signon * */
      self.createSignon = function(signonBasic) {
        if (signonBasic.confirmpassword === signonBasic.password) {
          self.signon = {
            username : self.signonBasic.username,
            name : self.signonBasic.name,
            surname : self.signonBasic.surname,
            password : self.signonBasic.password,
            identityDocument : self.signonBasic.identityDocument,
            email : self.signonBasic.email,
            height : self.signonBasic.height,
            weight : self.signonBasic.weight,
            faculty : JSON.parse(self.signonBasic.faculty),
            state : "ACTIVE",
            typeuser : "PLAYER",
            dateExpireClasification : new Date(),
            dateBirth : self.signonBasic.dateBirth,
            dateIngress : new Date(),
            dateInteraction : new Date(),
            descriptionHistory : self.signonBasic.descriptionHistory,
            history : true,
            useCondition : self.signonBasic.useCondition,
            role : ""
          };

          delete self.signon.role;

          userService.create(self.signon).then(function(d) {
            console.log(d);
            self.open('lg', d.message, 'SUCCESS');
          }, function(errResponse) {
            self.open('lg', d.detail, 'ERROR');
            console.error('Error while creating user');
          });
        } else {
          console.error('Error en la validacion de los password');
        }

      };

      self.open = function(size, msn, typeMsn) {
        var template = '';
        if (typeMsn === 'ERROR') {
          template = "modalContentError.html";
        } else if (typeMsn === 'SUCCESS') {
          template = "modalContent.html";
        }

        var modalInstance = $uibModal.open({
          keyboard : true,
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

      /** funtion for reset from Signon * */
      self.resetBasic = function() {
        self.signonBasic = {
          id : null,
          username : "",
          name : "",
          surname : "",
          password : "",
          confirmpassword : "",
          identityDocument : "",
          email : "",
          age : "",
          height : "",
          weight : "",
          universitysede : "",
          faculty : "",
          state : "ACTIVE",
          typeuser : "PLAYER",
          dateUpdate : new Date(),
          dateRegister : new Date(),
          dateExpireClasification : new Date(),
          dateBirth : new Date(),
          dateIngress : new Date(),
          dateInteraction : new Date(),
          descriptionHistory : "",
          history : true,
          useCondition : true,
          role : ""
        };
        $scope.signonFormBasic.$setPristine();
      };

      /** funtion for load detail View by ID * */
      self.loadViewByID = function(id) {
        viewService.loadViewByID(id).then(function(d) {
          self.detailView = d;
          console.log(self.detailView);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      /** function for load list campus * */
      self.loadCampusList = function() {
        campusService.loadCampusList().then(function(d) {
          self.listCampus = d;
          console.log(self.listCampus);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      /** function for load list faculties By ID * */
      self.loadFacultiesListByCampus = function() {
        facultiesService.loadFacultiesListByCampus(
            $scope.ctrl.signonBasic.universitysede).then(function(d) {
          self.listFaculties = d;
          console.log(self.listFaculties);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      /*
       * Init constructor function.
       */

      /** self.loadViewByID(2); * */
      self.loadCampusList();

      /*
       * Public Function.
       */

      /** Public function for load Faculties * */
      $scope.loadFacultiesListByCampus = function() {
        self.loadFacultiesListByCampus();
      };

      /*
       * Segmento Datepicker.
       */

      $scope.today = function() {
        $scope.dateBirth = new Date();
      };
      $scope.today();

      $scope.clear = function() {
        $scope.dateBirth = null;
      };

      $scope.inlineOptions = {
        customClass : getDayClass,
        minDate : new Date(),
        showWeeks : true
      };

      $scope.dateOptions = {
        dateDisabled : disabled,
        formatYear : 'yy',
        maxDate : new Date(2020, 5, 22),
        minDate : new Date(),
        startingDay : 1
      };

      // Disable weekend selection
      function disabled(data) {
        var date = data.date, mode = data.mode;
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
      }

      $scope.toggleMin = function() {
        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null
            : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
      };

      $scope.toggleMin();

      $scope.open1 = function() {
        $scope.popup1.opened = true;
      };

      $scope.open2 = function() {
        $scope.popup2.opened = true;
      };

      $scope.setDate = function(year, month, day) {
        $scope.dateBirth = new Date(year, month, day);
      };

      $scope.formats = [ 'dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy',
          'shortDate' ];
      $scope.format = $scope.formats[0];
      $scope.altInputFormats = [ 'M!/d!/yyyy' ];

      $scope.popup1 = {
        opened : false
      };

      $scope.popup2 = {
        opened : false
      };

      var tomorrow = new Date();
      tomorrow.setDate(tomorrow.getDate() + 1);
      var afterTomorrow = new Date();
      afterTomorrow.setDate(tomorrow.getDate() + 1);
      $scope.events = [ {
        date : tomorrow,
        status : 'full'
      }, {
        date : afterTomorrow,
        status : 'partially'
      } ];

      function getDayClass(data) {
        var date = data.date, mode = data.mode;
        if (mode === 'day') {
          var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

          for (var i = 0; i < $scope.events.length; i++) {
            var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0,
                0);

            if (dayToCheck === currentDay) {
              return $scope.events[i].status;
            }
          }
        }

        return '';
      }
      /*
       * End Segmento Datepicker
       */

    } ]);

App.controller('ModalInstanceCtrl', function($scope, $uibModalInstance, msn) {
  $scope.message = msn;
  $scope.ok = function() {
    console.log('se cerro fredy');
  };
});