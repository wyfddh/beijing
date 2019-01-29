/**
 * Created by Administrator on 2017/4/29.
 */
angular.module('canMoveCollectionCity',[])
    .controller('canMoveCollectionCityCtrl',function ($scope,$rootScope,$http) {
       $rootScope.hideFoot = false;
       $scope.back = function () {
           history.back();
       };
       $http({
           url:'../front/statistics/relicCount.do',
           method:'GET',
           params:''
       }).success(function (data) {
           // console.log(data);
           if(data.success == '1'){
               $scope.relicMuseumList = data.data.relicCountList;
           }else {
               layer.alert(data.error.message, {
                   title:"提示",
                   icon: 5,
                   skin: 'layer-ext-moon'
               })
           }

       });
    });