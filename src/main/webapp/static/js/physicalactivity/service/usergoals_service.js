function UserGoalsService($http, baseUrlUserGoals) {
  return {
    saveGoals : function(classifyOne) {
      return $http.post(baseUrlUserGoals, classifyOne).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    }
  }
}