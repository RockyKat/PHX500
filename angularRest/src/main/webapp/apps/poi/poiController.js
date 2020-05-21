app.controller('POIController', ['$scope', 'POIFactory', 
	function ($scope, POIFactory) 
	{
	    $scope.bla = 'bla from controller';
	    POIFactory.get({}, 
	    function (poiFactory) 
	    {
	        $scope.firstName		= poiFactory.firstName;
	        $scope.lastName			= poiFactory.lastName;
	        $scope.outLog 			= poiFactory.strOutLog;

	        
	    })
}]);