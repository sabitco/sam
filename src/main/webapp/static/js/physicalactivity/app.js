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
