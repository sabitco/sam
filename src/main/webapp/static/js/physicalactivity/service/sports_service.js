function SportsService($http, baseUrlSport) {
  return {
    loadSportsListByUser : function(userID) {
      return $http.get(baseUrlSport + "/" + userID, {
        params : {
          'state' : 'ACTIVE'
        }
      }).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return response.data;
      });
    },
    loadSportsCheckedListByUser : function(userID) {
      return $http.get(baseUrlSport + "/" + userID, {
        params : {
          'onlySelected' : 'true'
        }
      }).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return response.data;
      });
    },
  }
}
