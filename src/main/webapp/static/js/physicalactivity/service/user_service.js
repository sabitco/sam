function UserService($http, baseUrl) {
  return {
    create : function(user) {
      return $http.post(baseUrl, user).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    },
    update : function(user, id) {
      return $http.put(baseUrl + id, user).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    }
  }
}