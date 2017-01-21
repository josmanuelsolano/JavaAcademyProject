ecomApp.controller('UserCtrl' ,['$scope','$http','$location','$window',
	function($scope, $http, $location, $window){
	
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
	
	$scope.searchInput = function(searchParam){
		console.log("ENTRAAA");
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/jpaproject/users/search/' + searchParam
			}).then(function successCallback(response) {
				//alert(response.data);
				$window.alert("That user don't exist");
			  }, function errorCallback(response) {
				  $scope.users = response.data;
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