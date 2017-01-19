ecomApp.controller('CartCtrl' ,['$scope','$http','$location',
	function($scope, $http, $location){
	
	$scope.getCart = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/jpaproject/carts/carts'
			}).then(function successCallback(response) {
				$scope.carts = response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });
	}
	
}]);