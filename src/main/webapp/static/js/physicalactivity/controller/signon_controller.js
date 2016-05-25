'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");

App.constant("baseUrlView", "http://localhost:8080/admin/pages/");

App.constant("baseUrlCampus", "http://localhost:8080/campus/");

App.constant("baseUrlFaculties", "http://localhost:8080/campus/faculties/");

App.controller('SignonController', [
		'$scope',
		'viewService',
		'baseUrlView',
		'campusService',
		'baseUrlCampus',
		'facultiesService',
		'baseUrlFaculties',
		function($scope, viewService, baseUrlView, campusService,
				baseUrlCampus, facultiesService, baseUrlFaculties) {
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

			self.loadFacultiesListByCampus = function() {
				facultiesService.loadFacultiesListByCampus(
						$scope.ctrl.signonBasic.universitysede).then(
						function(d) {
							self.listFaculties = d;
							console.log(self.listFaculties);
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			$scope.counter = 0;

			$scope.loadFacultiesListByCampus = function() {
				self.loadFacultiesListByCampus();
			};

		} ]);