'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");

App.constant("baseUrlView", "http://localhost:8080/admin/pages/");

App.constant("baseUrlCampus", "http://localhost:8080/campus/");

App.controller('SignonController',
		[
				'$scope',
				'viewService',
				'baseUrlView',
				'campusService',
				'baseUrlCampus',
				function($scope, viewService, baseUrlView, campusService,
						baseUrlCampus) {
					var self = this;

					self.signonBasic = {
						id : null,
						name : "",
						dateRegister : new Date()
					};

					self.resetBasic = function() {
						self.signonBasic = {
							id : null,
							name : "",
							dateRegister : new Date()
						};
						$scope.signonFormBasic.$setPristine();
					};

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

					self.listCampus = [];

					self.loadCampusList = function() {
						campusService.loadCampusList().then(function(d) {
							self.listCampus = d;
							console.log(self.listCampus);
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
					};

					self.loadCampusList();

				} ]);