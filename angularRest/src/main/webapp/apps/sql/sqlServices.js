///ngdemo/rest/mysql/demo
services.factory('SQLFactory', function ($resource) {
    return $resource('/ngdemo/rest/json/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});