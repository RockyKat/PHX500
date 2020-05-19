services.factory('DroolsFactory', function ($resource) {
    return $resource('/ngdemo/rest/drools/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});