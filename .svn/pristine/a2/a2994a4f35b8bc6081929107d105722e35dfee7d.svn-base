/**
 * Created by Administrator on 2017/4/28.
 */
angular.module('statisticProvince',[])
    .controller('statisticProvinceCtrl',function ($scope,$rootScope,$http) {
        $rootScope.hideFoot = false;
        //点击后退按钮
        $scope.back = function () {
            history.back();
        };

        // 调取数据
        $http({
            url:"../front/statistics/info.do",
            method:'GET',
            params:''
        }).success(function (data) {
            // console.log(data);
            if(data.success == 1){
                $scope.dataNum = data.data;
                if(data.data.level == "1"){
                    $scope.proCity = "省";
                    $scope.leapContent = "数量分布";
                }else if(data.data.level == "2"){
                    $scope.proCity = "市";
                    $scope.leapContent = "名单";
                }
                $scope.differenceValue = data.data.oaSum - data.data.ypSum;
            }else {
                // layer.msg(data.error.message);
                layer.alert(data.error.message, {
                    title:"提示",
                    icon: 5,
                    skin: 'layer-ext-moon'
                })
            }
        })


    });