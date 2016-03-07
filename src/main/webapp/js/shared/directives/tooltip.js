app.directive('tooltip', ['$timeout'
	, function ($timeout) {
	return function(scope, element, attrs) {
		if (attrs.titleModel) {
			var _model = '';
			try {
				_model = eval ( attrs.titleModel );
			} catch (e) {};
				
			$(element).tooltip( { title : _model } );
		} else {
			$(element).tooltip();
		} 

	};
}]);
