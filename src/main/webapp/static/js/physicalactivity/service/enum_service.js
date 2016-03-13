function EnumService($http, baseUrl) {
	return {
		fetchAll : function() {
			return $http.get(baseUrl).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		}
	}
}