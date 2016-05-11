'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pageshomeadministrator/");

App.controller('ManagementController', [ '$scope', 'crudService', 'baseUrl',
		function($scope, crudService, baseUrl) {
			var self = this;
			self.pages = [];

			self.fetchAllPages = function() {
				crudService.fetchAll().then(function(d) {
					self.pages = d;
					console.log(self.pages);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllPages();
		} ]);