'use strict';
app.controller ('SearchProductCtrl' 
		, [ '$scope', '$rootScope', '$route','$routeParams' , '$location',  '$filter' , 'catalogServices'
             , function ( $scope, $rootScope, $route, $routeParams , $location,  $filter , catalogServices) {
			
			
	$scope.items = [];
	
	$scope.criteria = {
			 filter : '',
			 pageSize : 20,
			 page : 0
	};
	
	$scope.allJobs = function () {
		
		catalogServices.findAll($scope.criteria).then(function (response) {
			$scope.items = response;
		});
		
	};
			
}]);