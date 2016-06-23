function GoalsService($http, baseUrlGoals) {
  return {
    loadGoalsListByUser : function(userID) {
      return $http.get(baseUrlGoals + "/" + userID, {}).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    },
    loadGoalsSelectListByUser : function(userID) {
      return $http.get(baseUrlGoals + "/" + userID, {
        params : {
          'onlySelected' : 'true'
        }
      }).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    }
  }
}
