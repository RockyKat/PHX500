// SQL Controler.
app.controller('HomeController', ['$scope', 'HomeFactory', 
	function ($scope, HomeFactory) 
	{
	    $scope.bla = 'bla from controller';
	    HomeFactory.get({}, 
	    function (homeFactory) 
	    {
	        $scope.homefirstname 	= homeFactory.firstName;
	        $scope.homelastname 	= homeFactory.lastName;
	        $scope.homebmp 			= homeFactory.bmp;
	        $scope.homestrOutLog	= homeFactory.strOutLog;


	    })
}]);