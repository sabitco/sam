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

			/*
			 * Public Function
			 */

			/** init self * */
			var self = this;
			self.signonBasic = {
				id : null,
				username : "",
				name : "",
				lastname : "",
				password : "",
				confirmpassword : "",
				document : "",
				email : "",
				age : "",
				height : "",
				weight : "",
				universitysede : "",
				faculty : "",
				dateUpdate : new Date(),
				dateRegister : new Date(),
				dateExpireClasification : new Date()
			};

			/** init detail View * */
			self.detailView = [];

			/** init list campus * */
			self.listCampus = [];

			/** init list faculties * */
			self.listFaculties = [];

			/*
			 * Function Submit
			 */
			self.submit = function() {
				self.createSignon(self.signon);
				self.reset();
			};

			/*
			 * Private Function
			 */

			/** funtion for Create(save) from Signon * */
			self.createSignon = function(signon) {
				crudService.create(signon).then(
				// self.fetchAllPages,
				// Crear session y redirect y enviar la contraseña al correo
				function(errResponse) {
					console.error('Error while creating Signon.');
				});
			};

			/** funtion for reset from Signon * */
			self.resetBasic = function() {
				self.signonBasic = {
					id : null,
					username : "",
					name : "",
					lastname : "",
					password : "",
					confirmpassword : "",
					document : "",
					email : "",
					age : "",
					height : "",
					weight : "",
					universitysede : "",
					faculty : "",
					dateUpdate : new Date(),
					dateRegister : new Date(),
					dateExpireClasification : new Date()
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