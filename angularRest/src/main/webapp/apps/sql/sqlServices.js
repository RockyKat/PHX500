services.factory('SQLFactory', function ($resource) {
    return $resource('/ngdemo/rest/mysql/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});