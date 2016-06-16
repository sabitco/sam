function SportsCheckedService($http, baseUrlSportsChecked) {
  return {
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
