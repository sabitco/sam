function HomeService($http, baseUrlHomeTips, baseUrlHomeAdvantages,
    baseUrlHomeAlerts, baseUrlHomeMyths) {
  return {
    loadTips : function() {
      return $http.get(baseUrlHomeTips + '/', {}).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    },
    loadAdvantages : function() {
      return $http.get(baseUrlHomeAdvantages + '/', {}).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    },
    loadAlerts : function() {
      return $http.get(baseUrlHomeAlerts + '/', {}).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    },
    loadMyths : function() {
      return $http.get(baseUrlHomeMyths + '/', {}).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    },
  }
}
