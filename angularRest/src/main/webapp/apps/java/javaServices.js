services.factory('JavaFactory', function ($resource) {
    return $resource('/ngdemo/rest/java8/', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});