services.factory('SwapFactory', function ($resource) {
    return $resource('/ngdemo/rest/swap/readTable', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});