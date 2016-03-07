'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");

App.controller('PlanController', [
    '$scope',
    'crudService',
    'baseUrl',
    function($scope, crudService, baseUrl) {
      var self = this;
      self.plan = {
        id : null,
        dateRegister : new Date(),
        name : '',
        state : 1,
        minute : null,
        obese : '',
      };
      self.plans = [];

      self.fetchAllPlans = function() {
    	  crudService.fetchAll().then(function(d) {
          self.plans = d;
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };

      self.createPlan = function(plan) {
    	  crudService.create(plan).then(self.fetchAllUsers,
            function(errResponse) {
              console.error('Error while creating Plan.');
            });
      };

      self.updatePlan = function(plan, id) {
    	  crudService.update(plan, id).then(self.fetchAllPlans,
            function(errResponse) {
              console.error('Error while updating Plan.');
            });
      };

      self.deletePlan = function(id) {
    	  crudService.delete(id).then(self.fetchAllPlans,
            function(errResponse) {
              console.error('Error while deleting Plan.');
            });
      };

      self.editPlan = function(plan) {
        self.plan.id = plan.id;
        self.plan.dateRegister = plan.dateRegister;
        self.plan.name = plan.name;
        self.plan.state = plan.state;
        self.plan.minute = plan.minute;
        self.plan.obese = plan.obese;
      };

      self.fetchAllPlans();

      self.submit = function() {
        if (self.plan.id === null) {
          self.createPlan(self.plan);
        } else {
          self.updatePlan(self.plan, self.plan.id);
        }
        self.reset();
      };

      self.edit = function(id) {
        for (var i = 0; i < self.plans.length; i++) {
          if (self.plans[i].id === id) {
            self.plan = angular.copy(self.plans[i]);
            break;
          }
        }
      };

      self.remove = function(id) {
        if (self.plan.id === id) {
          self.reset();
        }
        self.deletePlan(id);
      };

      self.reset = function() {
        self.plan = {
        	  id : null,
              dateRegister : new Date(),
              name : '',
              state : 1,
              minute : null,
              obese : ''
        };
        $scope.planForm.$setPristine();
      };

    } ]);