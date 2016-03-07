'use strict'; 
var NoResultsLabel = "No Results";

app.directive ("datePicker" , function( $timeout )  {
	
	var linker = function (scope, element, attrs, ngModelCtrl) {
    	element.datepicker({
    		  defaultDate : 0, 
              showOtherMonths: true,
              changeMonth: true,
              changeYear: true,
			  dateFormat: 'dd/mm/yy',
			  yearRange: '-6:+6',
			  onSelect:function (date) {
	                  ngModelCtrl.$setViewValue(date);
	                  scope.$apply();
	                  $(this).blur();	                
			  }
				  
    	}).on('blur', function (e) { 
    	    var value = $(this).val(); 
    		  if (!value) { return; };
    			
    		  var isDateValid = new TMS.DateValidator({ value: value }).isValid();
    		  if (!isDateValid) { $(this).val(''); };    			
	    			
		}).next('.input-group-addon').on('click', function (e) {
		    e && e.preventDefault();
		    $(element).focus();
		});
    	
    	// Focus state for append/prepend inputs
        $('.input-prepend, .input-append').on('focus', 'input', function () {
          $(this).closest('.control-group, form').addClass('focus');
        }).on('blur', 'input', function () {
          $(this).closest('.control-group, form').removeClass('focus');
        });
	};
	
    return {
        restrict: 'A',
        require : 'ngModel',
        link : linker
    };
    
});