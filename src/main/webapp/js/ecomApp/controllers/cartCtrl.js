ecomApp.controller('CartCtrl' ,['$scope','$http','$location',
	function($scope, $http, $location){
	
	$scope.getCarts = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/jpaproject/carts/carts'
			}).then(function successCallback(response) {
				$scope.carts = response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });
	}
	
	$scope.editCart = function(){
		$http({
			  method: 'GET',
			  url: $location.absUrl() + "/getData"
			}).then(function successCallback(response) {
				$scope.cart = response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/jpaproject/shipTos/shipTos'
			}).then(function successCallback(response) {
				$scope.shipTos = response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/jpaproject/status/status'
			}).then(function successCallback(response) {
				$scope.statuses = response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });
	}
	
	$scope.show=function(status){
		  return status.type == 'CART';
		}
	
}]);