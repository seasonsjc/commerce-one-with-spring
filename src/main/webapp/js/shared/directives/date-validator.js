"use strict";
var TMS = TMS || {};

TMS.DateValidator = (function(){
	
	function DateValidator(options){
		for(var attr in options) { this[attr] = options[attr]; }
	}
	
	DateValidator.prototype.isValid = function() {
		var isDateValid = true, isDateFormatValid = true;
		
		if (!this.value) { return false; };
			
		isDateValid = this.value.length == 10;
		isDateFormatValid = moment(this.value, ["DD/MM/YYYY"]).isValid();
		return ( isDateValid || isDateFormatValid );
	};
	
	DateValidator.prototype.isValidRange = function() {
		if (!this.startDate || !this.endDate) { return true; }
		if (Date.parse(this.startDate) <= Date.parse(this.endDate)) { return true; }
		return false;
	};
	
	return DateValidator;
	
})();


/**
 * [description]
 * @return {[type]} [description]
 */
TMS.DateTimeConverter  = ( function(){

	function DateTimeConverter (){
	}
	/**
	 * Utility method used to convert Received Date from SalesForce Pattern
	 * Convert YYYY-MM-DD to App Date Pattern (dd/MM/yyyy)
	 * @param  Json  date - using  [description]
	 * @return String date - with DD/MM/YYYY Pattern
	 */
	DateTimeConverter.toAppDate = function (date) {
		return moment( date, 'YYYY-MM-DD' ).format ('DD/MM/YYYY');	
	}


	DateTimeConverter.toSfDate = function (date) {
		return moment( date, 'DD/MM/YYYY' ).format ('YYYY-MM-DD');	
	}

	DateTimeConverter.fromApptoJsDate = function (date) {
		return moment( date, 'DD/MM/YYYY' ).toDate();
	}

	DateTimeConverter.toAppJsDate = function (date) {
		return moment( date, 'YYYY-MM-DD' ).toDate();
	}

	DateTimeConverter.toSfDateTime = function (dateTime) {
		return moment( date, 'DD/MM/YYYYHH:mm' ).format ("YYYY-MM-DD'T'HH:mm:ss.SSSZ");	
	}

	DateTimeConverter.toAppTime = function (dateTime) {
		return moment( dateTime, '"YYYY-MM-DD"T"HH:mm:ss.SSSZ"' ).format ('HH:mm');	
	}

	return DateTimeConverter;

} )(); 

/**
 * [description]
 * @return {[type]} [description]
 */
TMS.HourConverter = (function(){

	function HourConverter () {}

	HourConverter.toTime = function (value) {
		if (!value) return '00:00';
		var hours = parseInt(value);
		var minutes = Math.round( ( value - hours ) * 60 );
		return  moment (hours + ':' + minutes, 'HH:mm').format('HH:mm'); 	
	}

	HourConverter.toDouble = function (time) {
		if (!time) return 0.00; 
		var minutes = moment(time,'HH:mm').minutes(); 
		if (minutes > 0) {
			minutes /= 60;
		}	

		var _hours =  moment(time,'HH:mm').hours() + minutes;
		if (!_hours) return 0.00;
		
		return parseFloat(_hours); 		
	}

	return HourConverter;

})();
