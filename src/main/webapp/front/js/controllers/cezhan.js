angular.module("cezhan-controller",[])
    .controller("goCezhan",function($scope,$rootScope,$state){
        $rootScope.hideFoot = true;
        $scope.isActive = true;
        $scope.back = function () {
            $state.go("home");
        };
        $state.go("cezhan.hot");
    });
