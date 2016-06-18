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

function DiseasesServiceProvider() {
  var _baseUrlDiseases;
  this.setBaseUrl = function(baseUrlDiseases) {
    _baseUrlDiseases = baseUrlDiseases;
  }
  this.$get = [ '$http', function($http) {
    return new DiseasesService($http, _baseUrlDiseases);
  } ];
}

App.provider("diseasesService", DiseasesServiceProvider);

App.config([ 'baseUrlDiseases', 'diseasesServiceProvider',
    function(baseUrlDiseases, diseasesServiceProvider) {
      diseasesServiceProvider.setBaseUrl(baseUrlDiseases);
    } ]);

function SportsServiceProvider() {
  var _baseUrlSports;
  this.setBaseUrl = function(baseUrlSports) {
    _baseUrlSports = baseUrlSports;
  }
  this.$get = [ '$http', function($http) {
    return new SportsService($http, _baseUrlSports);
  } ];
}

App.provider("sportsService", SportsServiceProvider);

App.config([ 'baseUrlSports', 'sportsServiceProvider',
    function(baseUrlSports, sportsServiceProvider) {
      sportsServiceProvider.setBaseUrl(baseUrlSports);
    } ]);

function ClassifyDetailServiceProvider() {
  var _baseUrlClassifyDetail;
  this.setBaseUrl = function(baseUrlClassifyDetail) {
    _baseUrlClassifyDetail = baseUrlClassifyDetail;
  }
  this.$get = [ '$http', function($http) {
    return new ClassifyDetailService($http, _baseUrlClassifyDetail);
  } ];
}

App.provider("classifyDetailService", ClassifyDetailServiceProvider);

App.config([ 'baseUrlClassifyDetail', 'classifyDetailServiceProvider',
    function(baseUrlClassifyDetail, classifyDetailServiceProvider) {
      classifyDetailServiceProvider.setBaseUrl(baseUrlClassifyDetail);
    } ]);

function PreclassifyServiceProvider() {
  var _baseUrlPreclassifies;
  this.setBaseUrl = function(baseUrlPreclassifies) {
    _baseUrlPreclassifies = baseUrlPreclassifies;
  }
  this.$get = [ '$http', function($http) {
    return new PreclassifyService($http, _baseUrlPreclassifies);
  } ];
}

App.provider("preclassifyService", PreclassifyServiceProvider);

App.config([ 'baseUrlPreclassifies', 'preclassifyServiceProvider',
    function(baseUrlPreclassifies, preclassifyServiceProvider) {
      preclassifyServiceProvider.setBaseUrl(baseUrlPreclassifies);
    } ]);

function GoalsServiceProvider() {
  var _baseUrlGoals;
  this.setBaseUrl = function(baseUrlGoals) {
    _baseUrlGoals = baseUrlGoals;
  }
  this.$get = [ '$http', function($http) {
    return new GoalsService($http, _baseUrlGoals);
  } ];
}

App.provider("goalsService", GoalsServiceProvider);

App.config([ 'baseUrlGoals', 'goalsServiceProvider',
    function(baseUrlGoals, goalsServiceProvider) {
      goalsServiceProvider.setBaseUrl(baseUrlGoals);
    } ]);

function UserGoalsServiceProvider() {
  var _baseUrlUserGoals;
  this.setBaseUrl = function(baseUrlUserGoals) {
    _baseUrlGoals = baseUrlUserGoals;
  }
  this.$get = [ '$http', function($http) {
    return new UserGoalsService($http, _baseUrlGoals);
  } ];
}

App.provider("usergoalsService", UserGoalsServiceProvider);

App.config([ 'baseUrlUserGoals', 'usergoalsServiceProvider',
    function(baseUrlUserGoals, usergoalsServiceProvider) {
      usergoalsServiceProvider.setBaseUrl(baseUrlUserGoals);
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
