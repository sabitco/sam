'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");

App.constant("baseUrlView", "http://localhost:8080/admin/pages/");

App.constant("baseUrlCampus", "http://localhost:8080/campus/");

App.constant("baseUrlFaculties", "http://localhost:8080/campus/faculties/");

App.constant("baseUrlUsers", "http://localhost:8080/admin/users/");

App.controller('SignonController', [
		'$scope',
		'$window',
		'viewService',
		'baseUrlView',
		'campusService',
		'baseUrlCampus',
		'facultiesService',
		'baseUrlFaculties',
		'userService',
		'baseUrlUsers',
		function($scope, $window, viewService, baseUrlView, campusService,
				baseUrlCampus, facultiesService, baseUrlFaculties, userService,
				baseUrlUsers) {

			/*
			 * Public Function
			 */

			/** init self * */
			var self = this;
			self.signonBasic = {
				id : null,
				username : "",
				name : "",
				surname : "",
				password : "",
				confirmpassword : "",
				identityDocument : "",
				email : "",
				age : "",
				height : "",
				weight : "",
				universitysede : "",
				faculty : "",
				state : "ACTIVE",
				typeuser : "PLAYER",
				dateUpdate : new Date(),
				dateRegister : new Date(),
				dateExpireClasification : new Date(),
				dateBirth : new Date(),
				dateIngress : new Date(),
				dateInteraction : new Date(),
				descriptionHistory : "",
				history : true,
				useCondition : true,
				role : ""

			};

			/** init detail View * */
			self.detailView = [];

			/** init list campus * */
			self.listCampus = [];

			/** init list faculties * */
			self.listFaculties = [];

			/** Url Success * */
			var landingUrl = "http://" + $window.location.host
					+ "/physicalactivity/classify";

			/*
			 * Function Submit
			 */
			self.submit = function() {
				self.createSignon(self.signonBasic);
			};

			/*
			 * Private Function
			 */

			/** funtion for Create(save) from Signon * */
			self.createSignon = function(signonBasic) {
				if (signonBasic.confirmpassword === signonBasic.password) {
					userService.create(signonBasic).then(
					// $window.location.href = landingUrl,
					self.fetchAllPages, function(errResponse) {
						console.error('Error while creating User.');
					});
				} else {
					console.error('Error en la validacion de los password');
				}

			};

			/** funtion for reset from Signon * */
			self.resetBasic = function() {
				self.signonBasic = {
					id : null,
					username : "",
					name : "",
					surname : "",
					password : "",
					confirmpassword : "",
					identityDocument : "",
					email : "",
					age : "",
					height : "",
					weight : "",
					universitysede : "",
					faculty : "",
					state : "ACTIVE",
					typeuser : "PLAYER",
					dateUpdate : new Date(),
					dateRegister : new Date(),
					dateExpireClasification : new Date(),
					dateBirth : new Date(),
					dateIngress : new Date(),
					dateInteraction : new Date(),
					descriptionHistory : "",
					history : true,
					useCondition : true,
					role : ""
				};
				$scope.signonFormBasic.$setPristine();
			};

			/** funtion for load detail View by ID * */
			self.loadViewByID = function(id) {
				viewService.loadViewByID(id).then(function(d) {
					self.detailView = d;
					console.log(self.detailView);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			/** function for load list campus * */
			self.loadCampusList = function() {
				campusService.loadCampusList().then(function(d) {
					self.listCampus = d;
					console.log(self.listCampus);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			/** function for load list faculties By ID * */
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

			/*
			 * Init constructor function
			 */

			/** self.loadViewByID(2); * */
			self.loadCampusList();

			/*
			 * Public Function
			 */

			/** Public function for load Faculties * */
			$scope.loadFacultiesListByCampus = function() {
				self.loadFacultiesListByCampus();
			};

		} ]);