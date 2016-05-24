function FacultiesService($http, baseUrlFaculties) {
	return {
		loadFacultiesList : function() {
			return $http.get(baseUrlFaculties, {
				params : {
					'state' : 'ACTIVE'
				}
			}).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		},
		loadFacultiesListByCampus : function(campusID) {
			return $http.get(baseUrlFaculties + "/" + campusID, {
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
