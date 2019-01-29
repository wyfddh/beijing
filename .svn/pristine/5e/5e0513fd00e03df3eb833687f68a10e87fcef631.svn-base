/**
 * Created by Administrator on 2017/4/24.
 */
angular.module('myCollection',[])
.controller('myCollectionCtrl',function ($scope,$rootScope,$http,$timeout,$ionicScrollDelegate) {
    $rootScope.hideFoot = true;
    $scope.currentPage = 0;
    $scope.pageSize = 8;
    $scope.collectionList = [];
    $scope.isCollected = true;
    $scope.searchNone = false;
    $scope.dataaInfo = {
        size:$scope.pageSize,
        currentPage:$scope.currentPage
    };
    $scope.back = function () {
        history.back();
    };
    //刷新
    $scope.doRefresh = function () {
        $scope.dataaInfo.currentPage = 1;
        $http({
            url:'../front/Collected/myCollect.do',
            method:'get',
            params:   $scope.dataaInfo
        }).success(function (data) {
            // console.log(data);
            $scope.collectionList = [];
            if(data.success == "0"){
                layer.msg(data.data)
            }else{
                $scope.collectionList = $scope.collectionList.concat(data.data);
                if(data.page.totalPage > data.page.currentPage){
                    $scope.moreData = true;
                }else {
                    $scope.moreData = false;
                }
                if($scope.collectionList.length == 0){
                    $scope.searchNone = true;
                }else {
                    $scope.searchNone = false;
                }
            }
        }).finally(function () {
            $timeout(function () {
                $scope.$broadcast("scroll.refreshComplete");
            },1000)
        })
    };

    // 加载数据
    $scope.moreData = true;
    $scope.loadMore = function () {
        $scope.dataaInfo.currentPage++;
        $scope.loadPage();
        $scope.$broadcast("scroll.infiniteScrollComplete");
    };
    $scope.$on("$stateChangeSuccess",function () {
       $scope.loadMore();
    });

    $scope.loadPage = function () {
        $scope.moreData = false;
        $http({
            url:'../front/Collected/myCollect.do',
            method:'get',
            params:$scope.dataaInfo
        }).success(function (data) {
            // console.log(data);
            // console.log(data.success);
            if(data.success == "0"){
                layer.msg(data.data)
            }else{
                $scope.collectionList = $scope.collectionList.concat(data.data);
                if(data.page.totalPage > data.page.currentPage){
                    $scope.moreData = true;
                }else {
                    $scope.moreData = false;
                }
                if($scope.collectionList.length == 0){
                    $scope.searchNone = true;
                }else {
                    $scope.searchNone = false;
                }
            }
        });
    };
    // $scope.loadPage();

    // 点击收藏
    var timeoutFlag = 0;
    $scope.collect = function (event) {
        var collectId = angular.element(event.target).attr('data-chaodaiid');
        if(timeoutFlag) {
            layer.msg('操作太频繁啦！');
            return;
        }
        timeoutFlag = 1;
        $timeout(function () {
            timeoutFlag = 0;
        },3000);
        $http({
            url:"../front/OCCollection/doCollect.do",
            method:"GET",
            params:{
                id:collectId
            }
        }).success(function (data) {
            // console.log(data);
            layer.msg(data.data);
            angular.element(event.target).attr('class','starHide').prev().attr('class','starShow')
        })
    };

    // 点击取消收藏
    $scope.cancelCollect = function (cid,ctype) {
        if(timeoutFlag) {
            layer.msg('操作太频繁啦！');
            return;
        }
        timeoutFlag = 1;
        $timeout(function () {
            timeoutFlag = 0;
        },3000);
        layer.confirm("确定要取消收藏吗？",{
            btn:["是","否"]
        },function () {
            $http({
                url:"../front/OCCollection/notCollect.do",
                method:"GET",
                params:{
                    id:cid,
                    collectionType:ctype
                }
            }).success(function (data) {
                // console.log(data);
                layer.msg(data.data);
                // angular.element(event.target).attr('class','starHide').next().attr('class','starShow');
                $scope.doRefresh();
            })
        },function () {
            layer.closeAll();
        });
    };
});