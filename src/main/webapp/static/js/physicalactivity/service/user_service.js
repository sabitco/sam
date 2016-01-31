'use strict';
 
App.factory('UserService', ['$http', '$q', function($http, $q) {
  return {
    fetchAllUsers: function() {
      return $http.get('http://localhost:8080/users/').then(
          function(response){
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    },
    createUser: function(user) {
      return $http.post('http://localhost:8080/users/', user).then(
          function(response){
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    },
    updateUser: function(user, id){
      return $http.put('http://localhost:8080/users/'+id, user).then(
          function(response){
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    },
    deleteUser: function(id) {
      return $http.delete('http://localhost:8080/users/'+id).then(
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