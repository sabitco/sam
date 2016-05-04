function SearchPageService($http, baseUrl) {
	return {
		searchById : function(id) {
			return $http.get(baseUrl + id).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		}
	}
}