'use strict';

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

App.controller('CollapseDemoCtrl', function($scope) {
	$scope.isCollapsed = false;
});