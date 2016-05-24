var App = angular.module('physicalactivity', [ 'ngAnimate', 'ui.bootstrap' ]);

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