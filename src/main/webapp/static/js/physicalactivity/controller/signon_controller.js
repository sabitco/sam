'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");

App.constant("baseUrlView", "http://localhost:8080/admin/pages/");

App.controller('SignonController', [ '$scope', 'viewService', 'baseUrlView',
		function($scope, viewService, baseUrlView) {
			var self = this;

			self.detailView = [];

			self.loadViewByID = function(id) {
				viewService.loadViewByID(id).then(function(d) {
					self.detailView = d;
					console.log(self.detailView);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};
			// self.loadViewByID(2);
		} ]);