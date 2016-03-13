'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");
App.constant("baseUrlEnumState", "http://localhost:8080/enum/states");

App.controller('PageController', [
    '$scope',
    'crudService',
    'baseUrl',
    'enumService',
    'baseUrlEnumState',
    function($scope, crudService, baseUrl, enumService, baseUrlEnumState) {
      var self = this;
      self.page = {
        id : null,
        dateRegister : new Date(),
        name : '',
        state : "ACTIVE",
        orderPage : 1,
        typePage : "ADMINISTRATOR",
        url : '',
        base : '',
        descriptionList : '',
        descriptionPage : '',
        icone : '',
        namePage : '',
        title : ''
      };     
   
      self.pages = [];
      
      self.fetchAllPages = function() {
          crudService.fetchAll().then(function(d) {
            self.pages = d;
            console.log(self.pages);
          }, function(errResponse) {
            console.error('Error while fetching Currencies');
          });
        };

      self.createPage = function(page) {
        crudService.create(page).then(self.fetchAllPages,
            function(errResponse) {
              console.error('Error while creating PAGE.');
            });
      };

      self.updatePage = function(page, id) {
        crudService.update(page, id).then(self.fetchAllPages,
            function(errResponse) {
              console.error('Error while updating PAGE.');
            });
      };

      self.deletePage = function(id) {
        crudService.delete(id).then(self.fetchAllPages,
            function(errResponse) {
              console.error('Error while deleting PAGE.');
            });
      };
    	  
      self.editPage = function(page) {
        self.page.id = page.id;
        self.page.dateRegister = new Date(page.dateRegister);
        self.page.name = page.name;
        self.page.state = page.state;
        self.page.orderPage = page.orderPage;
        self.page.typePage = page.typePage;
        self.page.url = page.url;
        self.page.base = page.base;
        self.page.descriptionList = page.descriptionList;
        self.page.descriptionPage = page.descriptionPage;
        self.page.icone = page.icone;
        self.page.namePage = page.namePage;
        self.page.title = page.title;
      };

      self.fetchAllPages();

      self.submit = function() {
        if (self.page.id === null) {
          self.createPage(self.page);
        } else {
          self.updatePage(self.page, self.page.id);
        }
        self.reset();
      };

      self.edit = function(id) {
        for (var i = 0; i < self.pages.length; i++) {
          if (self.pages[i].id === id) {
            self.page = angular.copy(self.pages[i]);
            break;
          }
        }
      };

      self.remove = function(id) {
        if (self.page.id === id) {
          self.reset();
        }
        self.deletePage(id);
      };

      self.reset = function() {
        self.page = {
                id : null,
                dateRegister : new Date(),
                name : '',
                state : "ACTIVE",
                orderPage : 1,
                typePage : "ADMINISTRATOR",
                url : '',
                base : '',
                descriptionList : '',
                descriptioPage : '',
                icone : '',
                namePage : '',
                title : ''
        };
        $scope.pageForm.$setPristine();
      };
      
      self.enumStates = [];
      
      self.fetchAllEnumStates = function() {
    	  enumService.fetchAll().then(function(d) {
          self.enumStates = d;
          console.log(self.enumStates);
        }, function(errResponse) {
          console.error('Error while fetching Currencies');
        });
      };
      
      self.fetchAllEnumStates();

    } ]);