angular.module("waiting",[])
    .controller("goWaiting",function($scope,$rootScope,$http,$stateParams,$state) {
        $rootScope.hideFoot = true;
        $scope.goBackRoom = function(){
            $state.go('home');
        }
    });