function ClassifyDetailService($http, baseUrlClassifies) {
  return {
    classify : function(classifyOne) {
      return $http.put(baseUrlClassifies, classifyOne).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    }
  }
}