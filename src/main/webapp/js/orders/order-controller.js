'use strict';
app.controller ('OrdersCtrl' 
		, [ '$scope', '$rootScope', '$route','$routeParams' , '$location',  '$filter' , 'orderServices'
             , function ( $scope, $rootScope, $route, $routeParams , $location,  $filter , orderServices) {
			
			
	$scope.shoppingCart = {};
	
	$scope.order = {};
	$scope.orders = [];

	
	$scope.checkout = function () {
		// convert ShoppingCart to Order 
	};

	$scope.createOrder = function() {
		orderServices.save($scope.order).then (function (response) {
			 
		});
	};

	$scope.all = function() {
		orderServices.findAll().then (function (response) {
			$scope.orders = response;
		});
	};
	
	
	
}]);