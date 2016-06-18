function ClassifyDetailService($http, baseUrlClassifyDetail) {
  return {
    classify : function(classifyOne) {
      return $http.put(baseUrlClassifyDetail, classifyOne).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    }
  }
}