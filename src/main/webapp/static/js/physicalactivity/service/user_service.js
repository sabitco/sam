'use strict';
 
App.factory('UserService', ['$http', '$q', function($http, $q) {
  var baseUrl;
  return {
    setBaseUrl: function(url) {
      baseUrl=url;
    },
    fetchAllUsers: function() {
      return $http.get(baseUrl).then(
          function(response){
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    },
    createUser: function(user) {
      return $http.post(baseUrl, user).then(
          function(response){
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    },
    updateUser: function(user, id){
      return $http.put(baseUrl+id, user).then(
          function(response){
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    },
    deleteUser: function(id) {
      return $http.delete(baseUrl+id).then(
          function(response) {
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    }
         
  };
 
}]);