function GoalsMorrisService($http, baseUrlGoalsMorris) {
  return {
    loadGoalsListForMorrisByUser : function(userID) {
      return $http.get(baseUrlGoalsMorris + "/" + userID, {}).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    }
  }
}
