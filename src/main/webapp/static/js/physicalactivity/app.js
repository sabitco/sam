var App = angular.module('physicalactivity', [ 'ngAnimate', 'ui.bootstrap' ]);

function CrudServiceProvider() {
	var _baseUrl;
	this.setBaseUrl = function(baseUrl) {
		_baseUrl = baseUrl;
	}
	this.$get = [ '$http', function($http) {
		return new CrudService($http, _baseUrl);
	} ];
}

App.provider("crudService", CrudServiceProvider);

App.config([ 'baseUrl', 'crudServiceProvider',
		function(baseUrl, crudServiceProvider) {
			crudServiceProvider.setBaseUrl(baseUrl);
		} ]);

function StateEnumServiceProvider() {
	var _baseUrl;
	this.setBaseUrl = function(baseUrlStateEnum) {
		_baseUrl = baseUrlStateEnum;
	}
	this.$get = [ '$http', function($http) {
		return new StateServiceEnum($http, _baseUrl);
	} ];
}

App.provider("stateEnumService", StateEnumServiceProvider);

App.config([ 'baseUrlStateEnum', 'stateEnumServiceProvider',
		function(baseUrlStateEnum, stateEnumServiceProvider) {
			stateEnumServiceProvider.setBaseUrl(baseUrlStateEnum);
		} ]);

function TypePageEnumServiceProvider() {
	var _baseUrl;
	this.setBaseUrl = function(baseUrlTypePageEnum) {
		_baseUrl = baseUrlTypePageEnum;
	}
	this.$get = [ '$http', function($http) {
		return new TypePageServiceEnum($http, _baseUrl);
	} ];
}

App.provider("typePageEnumService", TypePageEnumServiceProvider);

App.config([ 'baseUrlTypePageEnum', 'typePageEnumServiceProvider',
		function(baseUrlTypePageEnum, typePageEnumServiceProvider) {
			typePageEnumServiceProvider.setBaseUrl(baseUrlTypePageEnum);
		} ]);

function SearchPageServiceProvider() {
	var _baseUrl;
	this.setBaseUrl = function(baseUrlPages) {
		_baseUrl = baseUrlPages;
	}
	this.$get = [ '$http', function($http) {
		return new SearchPageService($http, _baseUrl);
	} ];
}

App.provider("searchPageService", SearchPageServiceProvider);

App.config([ 'baseUrlPages', 'searchPageServiceProvider',
		function(baseUrlPages, searchPageServiceProvider) {
			searchPageServiceProvider.setBaseUrl(baseUrlPages);
		} ]);

// p.controller('CollapseDemoCtrl', function($scope) {
// $scope.isCollapsed = false;
// });
