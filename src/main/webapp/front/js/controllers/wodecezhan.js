/**
 * Created by Administrator on 2017/5/17.
 */
angular.module("wodecezhan",[])
    .controller("wodecezhanCtrl",function($scope,$rootScope,$state){
        $rootScope.hideFoot = true;
        $scope.isActive = true;
        $scope.table = 0;
        $scope.back = function () {
            history.back();
        };
        $state.go("wodecezhan.daifabu");
        $scope.changeTab0 = function () {
            $scope.table = 0;
            $state.go("wodecezhan.daifabu");
        };
        $scope.changeTab1 = function () {
            $scope.table = 1;
            $state.go("wodecezhan.yifabu");
        };
        $scope.changeTab2 = function () {
            $scope.table = 2;
            $state.go("wodecezhan.yixiajia");
        }
    });
