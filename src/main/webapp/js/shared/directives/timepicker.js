'use strict'; 

app.directive ("timePicker" , function( $timeout )  {
	var linker = function (scope, element, attrs, ngModelCtrl) {
		element.timepicker({
                minuteStep: 1,
                showSeconds: false,
                showMeridian: false,
                defaultTime : false,
        }).on('changeTime.timepicker', function (e) {
     		ngModelCtrl.$setViewValue(e.time.value);
	        scope.$apply();
        });
	};
    return {
        restrict: 'A',
        require : 'ngModel',
        link : linker
    };
});