app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/management/users', {
        templateUrl: 'partials/users/list.html',
        controller: 'UserCtrl'
      }).
      when('/catalog/search/', {
          templateUrl: 'partials/catalog/search.html',
          controller: 'SearchProductCtrl'
      }).  
      when('/orders/shoppingcart/', {
    	  templateUrl: 'partials/orders/shooping-cart.html',
    	  controller: 'ShoppingCartCtrl'
      }).  
      when('/orders/', {
    	  templateUrl: 'partials/orders/list.html',
    	  controller: 'SearchOrdersCtrl'
      }).  
      otherwise({
        redirectTo: '/'
      });
  }]);
