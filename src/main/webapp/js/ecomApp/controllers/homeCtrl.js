ecomApp.controller('HomeCtrl' ,['$scope','$http','$location',
	function($scope, $http, $location){
	
	$scope.getUsers = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/jpaproject/users/users'
			}).then(function successCallback(response) {
				$scope.users = response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });		
	}
	
	$scope.editUser = function(){
		$http({
			  method: 'GET',
			  url: $location.absUrl() + "/getData"
			}).then(function successCallback(response) {
				$scope.user = response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/jpaproject/userRoles/userRoles'
			}).then(function successCallback(response) {
				$scope.userRoles = response.data;
			  }, function errorCallback(response) {
				  console.log(response);
			  });	
	}
	
}]);