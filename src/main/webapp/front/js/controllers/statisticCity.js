/**
 * Created by Administrator on 2017/4/29.
 */
angular.module('statisticCity',[])
    .controller('statisticCityCtrl',function ($scope,  $rootScope) {
        $rootScope.hideFoot = false;
        $scope.back = function () {
            history.back();
        }
    });