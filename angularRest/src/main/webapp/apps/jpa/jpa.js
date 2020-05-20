
	
	
	app.controller('ngclickCtrl', ['$scope', '$http', 
	function ($scope, $http) 
	{
		if($scope.clkcount)
			$scope.clickcount = false;
		else
			$scope.clickcount = true;
	}]);
	
	app.controller('ngShowConsole', ['$scope', '$http', 
	function ($scope, $http) 
	{
		if($scope.showConsole)
		{
			$scope.showConsole = false;
		}
		else
			$scope.showConsole = true;
    
	}]);