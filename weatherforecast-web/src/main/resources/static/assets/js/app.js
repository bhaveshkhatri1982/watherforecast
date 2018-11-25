var restApp = angular.module('restApp',['ngTouch', 'ngAnimate', 'toastr', 'cgBusy']);
var urlBase= window.location.href;
urlBase = urlBase.split("/#")[0];
urlBase = "http://localhost:8081/api/v1/weather";

restApp.controller('indexController', ['$scope', '$http', '$q', '$window','toastr','$timeout', function ($scope, $http, $q, $window, toastr,$timeout){
	
	$scope.message = 'Please Wait...';
	$scope.promise = null;
	$scope.forecasts = [];
	$scope.getWeatherForecast = function(){
		
		$scope.promise = $http.get(urlBase + '/get')
	      .success(function(jsonData){
	    	  
	    	  $scope.forecasts = jsonData;
	      })
	      .error(function(data, status) {
	    	  alert("There is no weather forecast available currently. Please try after approximately 30 minutes");
	      }); 
	};
	$scope.getWeatherForecast();
	
	$scope.listCity=[];
	$scope.getAllCities = function(){
		
		$scope.promise = $http.get(urlBase + '/get/cities')
	      .success(function(jsonData){
	    	  
	    	  $scope.listCity = jsonData;
	      })
	      .error(function(data, status) {
	    	  alert("Currently no cities' information available")
	      }); 
	};
	$scope.getAllCities();
}]);


