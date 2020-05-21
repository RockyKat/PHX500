services.factory('POIFactory', function ($resource) {
    return $resource('/ngdemo/rest/poi/demo', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: true
        }
    })
});