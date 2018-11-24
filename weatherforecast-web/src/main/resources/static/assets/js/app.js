var restApp = angular.module('restApp',['ngTouch', 'ngAnimate', 'toastr', 'cgBusy']);
var urlBase= window.location.href;
urlBase = urlBase.split("/#")[0];
urlBase = urlBase + "/api/v1/weather";

restApp.controller('indexController', ['$scope', '$http', '$q', '$window','toastr','$timeout', function ($scope, $http, $q, $window, toastr,$timeout)
{
	
	$scope.message = 'Please Wait...';
	$scope.promise = null;
	
	$scope.forecasts = [];
	$scope.city="Harku";
	$scope.getWeatherForecast = function()
	{
		$scope.promise = $http.get(urlBase + '/get')
	      .success(function(jsonData) 
	      {	       
	    	  $scope.forecasts = jsonData;
	    	  console.log($scope.forecast);
	      }); 
	};
	$scope.getWeatherForecast();
	
}]);


