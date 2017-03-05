
var app = angular.module('happyApp', ['ngResource']);

app.factory("Worker", ['$resource', function($resource){
    return $resource('http://localhost:8282/worker/:workerId', {workerId: '@id'},
        {
            update: {method: 'PUT'}
        }
    );
}]);
app.controller("WorkerCtrl", ['$scope', 'Worker', function($scope, Worker){
    this.workers = [];
    this.worker = new Worker();

    this.getAllWorkers = function(){
        this.workers = Worker.query();
    };
    this.getAllWorkers();
    this.addWorker(){
        if($scope.)
    }
}]);
