'use strict';
app.service ('orderServices', [ '$rootScope', '$location', '$q', 'httpResource', function ($rootScope, $location, $q, httpResource) {
	
	return {

		save : function (order) {
			return httpResource.post ({ url:'api/orders/'
									  , param : order});			
		},
		
		findAll : function () {
			return httpResource.get ({ url:'api/orders/all'});			
		},
		
	};
	
	
}]);
	