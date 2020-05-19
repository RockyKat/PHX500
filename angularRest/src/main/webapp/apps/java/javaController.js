//app.controller('JavaController', ['$scope', '$http',
//  function ($scope, $http) {
//    $http.get('apps/data.json').then(function(response) {
//      $scope.artists = response.data;
//      $scope.artistOrder = 'name';
//  });
//}]);

app.controller('JavaController', ['$scope', 'JavaFactory', 
	function ($scope, JavaFactory) 
	{
	    $scope.bla = 'bla from controller';
	    JavaFactory.get({}, 
	    function (javaFactory) 
	    {
	        $scope.outLog			= javaFactory.strOutLog;
	        $scope.firstname		= javaFactory.firstname;
	        $scope.lastname 		= javaFactory.lastname;
	        
	    })
}]);