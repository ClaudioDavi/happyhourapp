'use strict';
App.factory('WorkerService', ['$http', '$q', function ($http, $q) {
        var REST_URI = 'localhost:8282/worker/';

        var factory = {
            getAllWorkers: getAllWorkers,
            createWorker: createWorker,
            updateWorker: updateWorker,
            deleteWorker: deleteWorker
        };
        return factory;

        function getAllWorkers() {
            var deferred = $q.defer();
            $http.get(REST_URI)
                    .then(
                            function (response) {
                                deferred.resolve(response.data);
                            },
                            function (errResponse) {
                                console.error('Error Getting Workers');
                                deferred.reject(errResponse);
                            }
                    );
            return deferred.promise;
        }
        function createWorker(worker) {
            var deferred = $q.defer();
            $http.post(REST_URI, worker)
                    .then(
                            function (response) {
                                deferred.resolve(response.data);
                            },
                            function (errResponse) {
                                console.error('Error Creating Worker');
                                deferred.reject(errResponse);
                            }
                    );
            return deferred.promise;
        }
        function updateWorker(worker, id) {
            var deferred = $q.defer();
            $http.put(REST_URI + id, worker)
                    .then(
                            function (response) {
                                deferred.resolve(response.data);
                            },
                            function (errResponse) {
                                console.error('Error Updating Worker');
                                deferred.reject(errResponse);
                            }
                    );
            return deferred.promise;
        }
        function deleteWorker(id) {
            var deferred = $q.defer();
            $http.delete(REST_URI + id)
                    .then(
                            function (response) {
                                deferred.resolve(response.data);
                            },
                            function (errResponse) {
                                console.error('Error Deleting Worker');
                                deferred.reject(errResponse);
                            }
                    );
            return deferred.promise;
        }

    }]);
