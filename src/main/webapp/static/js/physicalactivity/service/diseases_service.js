function DiseasesService($http, baseUrlDiseases) {
  return {
    loadDiseasesListByUser : function(userID) {
      return $http.get(baseUrlDiseases + "/" + userID, {
        params : {
          'state' : 'ACTIVE'
        }
      }).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    }
  }
}
