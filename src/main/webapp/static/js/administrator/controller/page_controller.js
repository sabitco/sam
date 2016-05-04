'use strict';
App.constant("baseUrl", "http://localhost:8080/admin/pages/");
App.constant("baseUrlPages", "http://localhost:8080/admin/pages/");
App.constant("baseUrlStateEnum", "http://localhost:8080/enum/states");
App.constant("baseUrlTypePageEnum", "http://localhost:8080/enum/typepage");

App.controller('PageController', [
    '$scope',
    'crudService',
    'baseUrl',
    'stateEnumService',
    'baseUrlStateEnum',
    'typePageEnumService',
    'baseUrlTypePageEnum',
    'searchPageService',
    'baseUrlPages',
    function($scope, crudService, baseUrl, stateEnumService, baseUrlStateEnum, typePageEnumService, baseUrlTypePageEnum, searchPageService, baseUrlPages) {
      var self = this;
      self.page = {
      		id:null,
    		name:"",
    		title:"",
    		descriptionPage:"",
    		base:"",
    		url:"",
            icone:"",
            namePage:"",
            namePageAll:"",
            descriptionListRecent:"",
            descriptionList:"",
            typePage : "ADMINISTRATOR",
            state : "ACTIVE",
            orderPage : 10,
            dateUpdate : new Date(),
            dateRegister : new Date() 
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
        self.page.name = page.name;
        self.page.title = page.title;
        self.page.descriptionPage = page.descriptionPage;
        self.page.base = page.base;
        self.page.url = page.url;
        self.page.icone = page.icone;
        self.page.namePage = page.namePage;
        self.page.namePageAll = page.namePageAll;
        self.page.descriptionListRecent = page.descriptionListRecent;
        self.page.descriptionList = page.descriptionList;
        self.page.typePage = page.typePage;
        self.page.state = page.state;
        self.page.orderPage = page.orderPage;
        self.page.dateUpdate = new Date(),
        self.page.dateRegister = new Date(page.dateRegister);
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
        		id:null,
        		name:"",
        		title:"",
        		descriptionPage:"",
        		base:"",
        		url:"",
                icone:"",
                namePage:"",
                namePageAll:"",
                descriptionListRecent:"",
                descriptionList:"",
                typePage : "ADMINISTRATOR",
                state : "ACTIVE",
                orderPage : 10,
                dateUpdate : new Date(),
                dateRegister : new Date() 
        };
        $scope.pageForm.$setPristine();
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
			    isFirstOpen: true
			  };
	  
	 
		
    } ]);