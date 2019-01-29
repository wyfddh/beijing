/**
 * Created by Administrator on 2017/4/29.
 */
angular.module('collectionUnitName',[])
    .controller('collectionUnitNameCtrl',function ($scope,$rootScope,$http) {
        $rootScope.hideFoot = false;
        $scope.back = function () {
            history.back();
        };
        $http({
            url:'../front/statistics/relicCount.do',
            method:"GET",
            params:""
        }).success(function (data) {
            // console.log(data);
            $scope.relicMuseumList = data.data.relicCountList;
        })
    });