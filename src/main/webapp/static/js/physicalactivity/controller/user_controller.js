'use strict';

App.constant('baseUrl', 'http://localhost:8080/admin/users/');

App.controller('UserController', ['$scope', 'UserService', 'baseUrl', function($scope, UserService, baseUrl) {
  UserService.setBaseUrl(baseUrl);
      var self = this;
      self.user = {
        id : null,
        birthdate : new Date(),
        name : '',
        username : '',
        dateIngress : new Date(),
        dateInteraction : new Date,
        typeuser: "PLAYER"
      };
      self.users = [];

      self.fetchAllUsers = function() {
        UserService.fetchAllUsers().then(function(d) {
          self.users = d;
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      self.createUser = function(user) {
        UserService.createUser(user).then(self.fetchAllUsers,
            function(errResponse) {
              console.error('Error while creating User.');
            });
      };

      self.updateUser = function(user, id) {
        UserService.updateUser(user, id).then(self.fetchAllUsers,
            function(errResponse) {
              console.error('Error while updating User.');
            });
      };

      self.deleteUser = function(id) {
        UserService.deleteUser(id).then(self.fetchAllUsers,
            function(errResponse) {
              console.error('Error while deleting User.');
            });
      };
      
      self.editUser = function(user) {
        self.user.id = user.id;
        self.user.dateRegister = user.dateRegister;
        self.user.name = user.name;
        self.user.state = user.state;
        self.user.bmi = user.bmi;
        self.user.dateBirth = new Date(user.dateBirth);
        self.user.dateIngress = user.dateIngress;
        self.user.dateInteraction = user.dateInteraction;
        self.user.descriptionHistory = user.descriptionHistory;
        self.user.email = user.email;
        self.user.height = user.height;
        self.user.history = user.history;
        self.user.role = user.role;
        self.user.subGoals = user.subGoals;
        self.user.typeuser = user.typeuser;
        self.user.useCondition = user.useCondition;
        self.user.username = user.username;
        self.user.weight = user.weight;
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

      self.remove = function(id) {
        if (self.user.id === id) {
          self.reset();
        }
        self.deleteUser(id);
      };

      self.reset = function() {
        self.user = {
          id : null,
          username : '',
          address : '',
          email : ''
        };
        $scope.userForm.$setPristine(); 
      };

    } ]);