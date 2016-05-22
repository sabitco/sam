function CampusService($http, baseUrlCampus) {
	return {
		loadCampusList : function() {
			return $http.get(baseUrlCampus, {
				params : {
					'state' : 'ACTIVE'
				}
			}).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		}
	}
}
