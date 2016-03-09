'use strict';
app.controller ('SearchProductCtrl' 
		, [ '$scope', '$rootScope', '$route','$routeParams' , '$location',  '$filter' , 'catalogService'
             , function ( $scope, $rootScope, $route, $routeParams , $location,  $filter , catalogService) {
			
			
	$scope.items = [];
	
	$scope.criteria = {
			 filter : '',
			 pageSize : 20,
			 page : 0
	};
	
	$scope.findAll = function () {
		
		catalogService.findAll($scope.criteria).then(function (response) {
			$scope.items = response;
		});
		
	};
			
}]);