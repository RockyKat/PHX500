app.controller('HibernateController', ['$scope', 'HibernateFactory', 
	function ($scope, HibernateFactory) 
	{
	    $scope.bla = 'bla from controller';
	    HibernateFactory.get({}, 
	    function (hibernateFactory) 
	    {
	        $scope.firstName		= hibernateFactory.firstName;
	        $scope.lastName			= hibernateFactory.lastName;
	        $scope.outLog 		= hibernateFactory.strOutLog;

	        
	    })
}]);