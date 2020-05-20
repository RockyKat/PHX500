app.controller('JPAController', ['$scope', 'JPAFactory', 
	function ($scope, JPAFactory) 
	{
	    $scope.bla = 'bla from controller';
	    JPAFactory.get({}, 
	    function (jpaFactory) 
	    {
	        $scope.firstName		= jpaFactory.firstName;
	        $scope.lastName			= jpaFactory.lastName;
	        $scope.outLog 			= jpaFactory.strOutLog;

	        
	    })
}]);