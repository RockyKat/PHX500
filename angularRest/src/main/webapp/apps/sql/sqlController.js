// SQL Controler.
app.controller('SQLController', ['$scope', 'SQLFactory', 
	function ($scope, SQLFactory) 
	{
	    $scope.bla = 'bla from controller';
	    SQLFactory.get({}, 
	    function (sqlFactory) 
	    {
	        $scope.sqlfirstname 	= sqlFactory.firstName;
	        $scope.sqllastname 		= sqlFactory.lastName;
	        $scope.sqlbmp 			= sqlFactory.bmp;
	        $scope.outLog			= sqlFactory.strOutLog;

	    })
}]);