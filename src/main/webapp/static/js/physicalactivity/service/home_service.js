function HomeService($http, baseUrlhome) {
  return {
    loadTips : function() {
      return $http.get(baseUrlhome + '/tips', {}).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    },
    loadAdvantages : function() {
      return $http.get(baseUrlhome + '/advantages', {}).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    },
    loadAlerts : function() {
      return $http.get(baseUrlhome + '/alerts', {}).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    },
    loadMyths : function() {
      return $http.get(baseUrlhome + '/myths', {}).then(
          function(response) {
            return response.data;
          }, function(errResponse) {
            return errResponse.data;
          });
    },
  }
}
