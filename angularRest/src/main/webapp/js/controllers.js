'use strict';

/* Controllers */


var app = angular.module('ngdemo.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});


app.controller('MyCtrl1', ['$scope', 'UserFactory', 
	function ($scope, UserFactory) {
    $scope.bla = 'bla from controller';
    UserFactory.get({}, function (userFactory) {
        $scope.firstname = userFactory.firstName;
        $scope.lastname = userFactory.lastName;

    })
}]);


app.controller('SearchController', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('js/data.json').then(function(response) {
      $scope.artists = response.data;
      $scope.artistOrder = 'name';
  });
}]);