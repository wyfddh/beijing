angular.module("forgotPasswordSuccess",["ipCookie"])
    .controller("forgotPasswordSuccess",function($scope,$state,$rootScope,$http,ipCookie,$interval) {
        $rootScope.hideFoot = false;
        $scope.vm={
            time:5
        };
        $scope.info = function(){
            $scope.vm.data = $scope.vm.time;
            $interval(function(){
                $scope.vm.data = ($scope.vm.time-1);
                $scope.vm.time--;
                if($scope.vm.time ==0){
                    $state.go('login');
                }
            },1000,$scope.vm.time)
        };
        $scope.info();
    });