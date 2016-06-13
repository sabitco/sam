function SportsService($http, baseUrlSports) {
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
    }
  }
}
