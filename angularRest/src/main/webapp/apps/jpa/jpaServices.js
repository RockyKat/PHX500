services.factory('JPAFactory', function ($resource) {
    return $resource('/ngdemo/rest/jpa/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});