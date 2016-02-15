function CrudService($http, baseUrl) {
  return {
    fetchAll : function() {
      return $http.get(baseUrl).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return $q.reject(errResponse);
      });
    },
    create: function(user) {
      return $http.post(baseUrl, user).then(
          function(response){
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    },
    update: function(user, id){
      return $http.put(baseUrl+id, user).then(
          function(response){
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    },
    delete: function(id) {
      return $http.delete(baseUrl+id).then(
          function(response) {
            return response.data;
          },
          function(errResponse){
            return $q.reject(errResponse);
          }
      );
    }
  }
}