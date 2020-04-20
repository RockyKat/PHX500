'use strict';

// Declare app level module which depends on filters, and services 
//
var ngdemo = angular.module('ngdemo', [
					'ngdemo.filters', 
					'ngdemo.services', 
					'ngdemo.directives', 
					'ngdemo.controllers']).
    config(['$routeProvider', function ($routeProvider) 
    	{
        	$routeProvider.when('/rest', 
        							{templateUrl: 'apps/rest/rest.html', 
        						     controller:  'RestController'});
        	
        	$routeProvider.when('/search', 
        							{templateUrl: 'apps/search/search.html'  , 
        						     controller:  'SearchController' });
        								    
        	$routeProvider.when('/details/:itemId',
        							{templateUrl: 'apps/details/details.html'  , 
            				    	 controller:  'DetailsController'});
           	$routeProvider.when('/swap',
           							{templateUrl: 'apps/swap/swap.html'  , 
			    	 				controller:  'SwapController'});
           	$routeProvider.when('/bootstrap',
									{templateUrl: 'apps/bootstrap/bootstrap.html'  , 
	 								controller:  'BootstrapController'});           	
           	$routeProvider.when('/java',
									{templateUrl: 'apps/java/java.html'  , 
	 								controller:  'JavaController'});           	
           	$routeProvider.when('/tomcat',
									{templateUrl: 'apps/tomcat/tomcat.html'  , 
	 								controller:  'TomcatController'});
           	$routeProvider.when('/angular',
									{templateUrl: 'apps/angular/angular.html'  , 
	 								controller:  'AngularController'});
           	$routeProvider.when('/sql',
           							{templateUrl: 'apps/sql/sql.html'  , 
									controller:  'SQLController'});
           	
//        	$routeProvider.otherwise({redirectTo: '/rest'});
    	}]);



	

