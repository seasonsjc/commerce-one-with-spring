'use strict';
app.service ('catalogService', [ '$rootScope', '$location', '$q', 'httpResource', function ($rootScope, $location, $q, httpResource) {
	
	return {

		findAll : function (criteria) {
			return httpResource.get ({ url:'api/catalog/search'
									  , param : criteria});			
		},
		
	};
	
	
}]);
	