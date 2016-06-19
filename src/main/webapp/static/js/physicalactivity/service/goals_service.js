function GoalsService($http, baseUrlGoals) {
  return {
    loadGoalsListByUser : function(userID) {
      return $http.get(baseUrlGoals + "/" + userID, {}).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    }
  }
}
