services.factory('HibernateFactory', function ($resource) {
    return $resource('/ngdemo/rest/hibernate/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});