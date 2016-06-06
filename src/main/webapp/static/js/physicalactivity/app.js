var App = angular.module('physicalactivity', [ 'ngAnimate', 'ui.bootstrap',
    'angular.morris-chart' ]);

App.directive('pwCheck', [ function() {
  return {
    require : 'ngModel',
    link : function(scope, elem, attrs, ctrl) {
      var firstPassword = '#' + attrs.pwCheck;
      elem.add(firstPassword).on('keyup', function() {
        scope.$apply(function() {
          var v = elem.val() === $(firstPassword).val();
          ctrl.$setValidity('pwmatch', v);
        });
      });
    }
  }
} ]);

function ViewServiceProvider() {
  var _baseUrlView;
  this.setBaseUrl = function(baseUrlView) {
    _baseUrlView = baseUrlView;
  }
  this.$get = [ '$http', function($http) {
    return new ViewService($http, _baseUrlView);
  } ];
}

App.provider("viewService", ViewServiceProvider);

App.config([ 'baseUrlView', 'viewServiceProvider',
    function(baseUrlView, viewServiceProvider) {
      viewServiceProvider.setBaseUrl(baseUrlView);
    } ]);

function CampusServiceProvider() {
  var _baseUrlCampus;
  this.setBaseUrl = function(baseUrlCampus) {
    _baseUrlCampus = baseUrlCampus;
  }
  this.$get = [ '$http', function($http) {
    return new CampusService($http, _baseUrlCampus);
  } ];
}

App.provider("campusService", CampusServiceProvider);

App.config([ 'baseUrlCampus', 'campusServiceProvider',
    function(baseUrlCampus, campusServiceProvider) {
      campusServiceProvider.setBaseUrl(baseUrlCampus);
    } ]);

function FacultiesServiceProvider() {
  var _baseUrlFaculties;
  this.setBaseUrl = function(baseUrlFaculties) {
    _baseUrlFaculties = baseUrlFaculties;
  }
  this.$get = [ '$http', function($http) {
    return new FacultiesService($http, _baseUrlFaculties);
  } ];
}

App.provider("facultiesService", FacultiesServiceProvider);

App.config([ 'baseUrlFaculties', 'facultiesServiceProvider',
    function(baseUrlFaculties, facultiesServiceProvider) {
      facultiesServiceProvider.setBaseUrl(baseUrlFaculties);
    } ]);

function UserServiceProvider() {
  var _baseUrlUser;
  this.setBaseUrl = function(baseUrlUser) {
    _baseUrlUser = baseUrlUser;
  }
  this.$get = [ '$http', function($http) {
    return new UserService($http, _baseUrlUser);
  } ];
}

App.provider("userService", UserServiceProvider);

App.config([ 'baseUrlUsers', 'userServiceProvider',
    function(baseUrlUser, userServiceProvider) {
      userServiceProvider.setBaseUrl(baseUrlUser);
    } ]);
