function EventsService($http, baseUrlEvents) {
  return {
    loadEventsList : function() {
      return $http.get(baseUrlEvents, {}).then(function(response) {
        return response.data;
      }, function(errResponse) {
        return errResponse.data;
      });
    }
  }
}
