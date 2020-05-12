app.controller('SwapController', ['$scope', 'SwapFactory', 
	function ($scope, SwapFactory) 
	{
	    $scope.bla = 'bla from controller';
	    SwapFactory.get({}, 
	    function (swapFactory) 
	    {
//	        $scope.swapfirstname 	= swapFactory.firstName;
//	        $scope.swaplastname 	= swapFactory.lastName;
//	        $scope.swapbmp 			= swapFactory.bmp;
	        $scope.outLog			= swapFactory;


	    })
}]);