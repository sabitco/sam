'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/users/");
App.constant("baseUrlPages", "http://localhost:8080/admin/pages/");
App.constant("baseUrlStateEnum", "http://localhost:8080/enum/states");
App.constant("baseUrlTypePageEnum", "http://localhost:8080/enum/typepage");

App.controller('UserAdministratorController', [
		'$scope',
		'crudService',
		'baseUrl',
		'stateEnumService',
		'baseUrlStateEnum',
		'typePageEnumService',
		'baseUrlTypePageEnum',
		'searchPageService',
		'baseUrlPages',
		function($scope, crudService, baseUrl, stateEnumService,
				baseUrlStateEnum, typePageEnumService, baseUrlTypePageEnum,
				searchPageService, baseUrlPages) {
			var self = this;
			self.user = {
				id : null,
				name : "",
				state : "ACTIVE",
				dateUpdate : new Date(),
				dateRegister : new Date()
			};

			self.users = [];

			self.fetchAllUsers = function() {
				crudService.fetchAll().then(function(d) {
					self.users = d;
					console.log(self.users);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.createUser = function(user) {
				crudService.create(user).then(self.fetchAllUsers,
						function(errResponse) {
							console.error('Error while creating USERS.');
						});
			};

			self.updateUser = function(user, id) {
				crudService.update(user, id).then(self.fetchAllUsers,
						function(errResponse) {
							console.error('Error while updating USER.');
						});
			};

			self.editUser = function(user) {
				self.user.id = user.id;
				self.user.name = user.name;
				self.user.state = user.state;
				self.user.dateUpdate = new Date(),
						self.user.dateRegister = new Date(user.dateRegister);
			};

			self.fetchAllUsers();

			self.submit = function() {
				if (self.user.id === null) {
					self.createUser(self.user);
				} else {
					self.updateUser(self.user, self.user.id);
				}
				self.reset();
			};

			self.edit = function(id) {
				for (var i = 0; i < self.users.length; i++) {
					if (self.users[i].id === id) {
						self.user = angular.copy(self.users[i]);
						break;
					}
				}
			};

			self.reset = function() {
				self.user = {
					id : null,
					name : "",
					state : "ACTIVE",
					dateUpdate : new Date(),
					dateRegister : new Date()
				};
				$scope.userForm.$setPristine();
			};

			self.enumStates = [];

			self.fetchAllEnumStates = function() {
				stateEnumService.fetchAll().then(function(d) {
					self.enumStates = d;
					console.log(self.enumStates);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllEnumStates();

			self.enumTypePages = [];

			self.fetchAllEnumTypePages = function() {
				typePageEnumService.fetchAll().then(function(d) {
					self.enumTypePages = d;
					console.log(self.enumTypePages);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllEnumTypePages();

			self.descriptionPage = null;

			self.searchPageById = function(id) {
				searchPageService.searchById(id).then(function(d) {
					self.descriptionPage = d;
					console.log(self.descriptionPage);
				}, function(errResponse) {
					console.error('Error while description PAGE.');
				});
			};

			self.searchPageById(1);

			$scope.oneAtATime = true;

			$scope.status = {
				isFirstOpen : true
			};

		} ]);