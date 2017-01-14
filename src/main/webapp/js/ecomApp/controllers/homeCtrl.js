var ecomApp = angular.module('ecomApp',[]);
ecomApp.controller('HomeCtrl' ,['$scope','$http', function($scope, $http){
	
	$scope.users = function(){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/jpaproject/users'
			}).then(function successCallback(response) {
			    $scope.users = response.data;
			  }, function errorCallback(response) {
				  console.log('BAD RESPONSE HOME CTRL: ' + response);
			  });
	}
	
}]);