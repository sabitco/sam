function TipService($http, baseUrlTips) {
  return {
    loadTipByID : function(tipID) {
      return $http.get(baseUrlTips + "/" + tipID, {}).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return response.data;
      });
    },
  }
}
