'use strict';
angular.module('HappyHour').controller('WorkerController', ['$scope', 'WorkerService', function ($scope, WorkerService) {

        var self = this;
        self.worker = {id: null, name: '', email: ''};
        self.workers = [];

        self.submit = submit;
        self.edit = edit;
        self.remove = remove;
        self.reset = reset;

        getAllWorkers();

        function getAllWorkers() {
            WorkerService.getAllWorkers()
                    .then(
                            function (w) {
                                self.workers = w;
                            },
                            function (errResponse) {
                                console.error('Error getting workers');
                            }
                    );
        }

        function createWorker(worker) {
            WorkerService.createWorker(worker)
                    .then(
                            getAllWorkers,
                            function (errResponse) {
                                console.error('Error Creating Worker');
                            }
                    );
        }

        function updateWorker(worker, id) {
            WorkerService.updateWorker(worker, id)
                    .then(
                            getAllWorkers,
                            function (errResponse) {
                                console.error('Erroe updating worker');
                            }
                    );
        }

        function deleteWorker(id) {
            WorkerService.deleteWorker(id)
                    .then(
                            getAllWorkers,
                            function (errResponse) {
                                console.console.error('Error deleting worker');
                            }
                    );
        }

        function submit() {
            if (self.worker.id === null) {
                console.log('Saving new Worker', self.worker);
                createWorker(self.worker);
            } else {
                updateWorker(self.worker, self.worker.id);
                console.log('Updating Worker with Id:', self.worker.id);
            }
            reset();
        }

        function edit(id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.workers.length; i++) {
                if (self.users[i].id === id) {
                    self.user = angular.copy(self.workers[i]);
                    break;
                }
            }
        }

        function remove(id) {
            console.log('id to be deleted', id);
            if (self.worker.id === id) {
                reset();
            }
            deleteWorker(id);
        }
        function reset() {
            self.worker = {id: null, name = '', email = ''};
            $scope.workerForm.$setPristine();
        }

    }]);
