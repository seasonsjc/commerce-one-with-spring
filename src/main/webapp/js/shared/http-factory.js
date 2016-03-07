'user strict';

var App = App || {};

App.CallBackProvider = function ($rootScope,$q){

	var deferred = $q.defer();

	return {

		success : function(data, status, headers, config) {
			deferred.resolve (data);
		},

		error : function(data, status, headers, config) {
				try{ console.trace (response); }catch(e){};
		
					var errorOptions = { data: data, status: status, headers: headers, config: config };
									
					if (!config.ignoreException) 
						$rootScope.$broadcast('httpErrorEvent', errorOptions);
					
					deferred.reject(data);
		},
			
		promise : function() {
			return deferred.promise;
		},

	};

};

angular.module('httpResource', [])
.factory("httpResource", ["$rootScope", "$http", "$q", function($rootScope, $http, $q) {
	
	return {
	
		post : function(options) {
			var deferred = $q.defer();
			
			$http.post(options.url, options.param, options.config)
				.success(function(data, status, headers, config) {
					deferred.resolve(data);
				})
				.error(function(data, status, headers, config) {
					var errorOptions = { data: data, status: status, headers: headers, config: config };
					
					if (!config.ignoreException) 
						$rootScope.$broadcast('httpErrorEvent', errorOptions);
					
					deferred.reject(data);
				});
			return deferred.promise;
		},

		get :  function(options) {
			var deferred = $q.defer();
			
			$http.get(options.url)
				.success(function(data, status, headers, config) {
					deferred.resolve(data);
				})
				.error(function(data, status, headers, config) {
					var errorOptions = { data: data, status: status, headers: headers, config: config };
					$rootScope.$broadcast('httpErrorEvent', errorOptions);
					deferred.reject(data);
				});
			return deferred.promise;
		},		
		
	};
	
}]);



