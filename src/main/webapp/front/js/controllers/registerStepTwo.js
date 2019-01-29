angular.module("registerStepTwo",["ipCookie"])
    .controller("goRegisterStepTwo",function($scope,$state,$rootScope,$http,ipCookie,$interval,$stateParams) {
        $rootScope.hideFoot = false;
        $scope.vm={
            data:'获取',
            kedian:false,
            time:59
        };
        $scope.info = function(){
            $http({
                method:'GET',
                url:'../sendSecretCode.do',
                params:{phone:$rootScope.phone,
                    verificationCode:$rootScope.verificationCode}
            }).success(function(data){
                console.log(data);
            });
            $scope.vm.kedian =true;
            $scope.vm.data = $scope.vm.time+'s';
            $interval(function(){
                $scope.vm.data = ($scope.vm.time-1)+'s';
                $scope.vm.time--;
                if($scope.vm.time ==0){
                    $scope.vm.kedian =false;
                    $scope.vm.data='重新获取';
                    $scope.vm.time=59;
                }
            },1000,$scope.vm.time)
        };
        $scope.registerStepTwo = function(){
            $state.go('registerStepThree');
            $rootScope.secretCode = $scope.infoCode;
        }
    });