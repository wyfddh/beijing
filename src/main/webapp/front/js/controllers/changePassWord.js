/**
 * Created by Administrator on 2017/6/5.
 */
angular.module("changePassWord",[])
    .controller("changePassWordCtrl",['$scope','$http','$rootScope','$state','$timeout',function($scope,$http,$rootScope,$state,$timeout){
        $rootScope.hideFoot = true;
        $scope.isActive = true;
        $scope.back = function () {
            history.back();
        };
        //修改密码
        $scope.submitInfo = function () {
            $scope.dataInfo = {
                orgPass:$scope.orignPassWord,
                newPass:$scope.newPassWord
            };
            $http({
                url:'../front/updatePass.do',
                method:'POST',
                data:$scope.dataInfo,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                transformRequest: function (obj) {
                    var str = [];
                    for (var s in obj) {
                        str.push(encodeURIComponent(s) + "=" + encodeURIComponent(obj[s]));
                    }
                    return str.join("&");
                }
            }).success(function (data) {
                console.log(data);
                if(data.success == 1){
                    layer.msg(data.data,{
                        time:2000
                    });
                    $timeout(function () {
                        $state.go("home");
                    },1500);
                }else {
                    layer.alert(data.data,{
                        icon:0,
                        skin:'layer-ext-moon'
                    });
                }
            });
        };
    }]);
