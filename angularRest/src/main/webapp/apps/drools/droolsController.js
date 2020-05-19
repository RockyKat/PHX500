app.controller('DroolsController', ['$scope', 'DroolsFactory', 
	function ($scope, DroolsFactory) 
	{
	    $scope.bla = 'bla from controller';
	    DroolsFactory.get({}, 
	    function (droolsFactory) 
	    {
	        $scope.outLog			= droolsFactory.strOutLog;
	        $scope.firstName		= droolsFactory.firstName;
	        $scope.lastName 		= droolsFactory.lastName;
	        $scope.discount 		= droolsFactory.discount;

	    })
}]);