function SportsService($http, baseUrlSports, baseUrlSportsChecked) {
  return {
    loadSportsListByUser : function(userID) {
      return $http.get(baseUrlSports + "/" + userID, {
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
      return $http.get(baseUrlSportsChecked + "/" + userID, {
        params : {
          'state' : 'ACTIVE'
        }
      }).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return response.data;
      });
    },
  }
}
