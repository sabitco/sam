function PreclassifyService($http, baseUrlPreclassifies) {
  return {
    preclassify : function(classifyOne) {
      return $http.put(baseUrlPreclassifies, classifyOne).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    }
  }
}