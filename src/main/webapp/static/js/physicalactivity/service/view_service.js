function ViewService($http, baseUrlView) {
	return {
		loadViewByID : function(id) {
			return $http.get(baseUrlView).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		},
		loadViewByBase : function(base) {
			return $http.get(baseUrlView).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		}
	}
}