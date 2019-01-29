/**
 * Created by Administrator on 2017/5/17.
 */
angular.module("wodecezhan-controller-yixiajia",[])
    .controller("yixiajiaCtrl",function($scope,$state,$http,$timeout){
        $scope.miaoshu = true;
        $scope.searchNone = false;   //一开始的时候没有搜到数据的话就隐藏
        $scope.currentPage = 0;
        $scope.size = 5;
        $scope.isPublished = 0;
        $scope.daifabuList = [];

        //关闭描述
        $scope.guanbi = function () {
            $scope.miaoshu = false;
        };

        //传给后台的参数
        $scope.dataInfo  = {
            currentPage:$scope.currentPage,
            size:$scope.size,
            isPublished:$scope.isPublished
        };

        //上拉加载更多
        $scope.moreData = true;
        $scope.loadMore = function () {
            $scope.dataInfo.currentPage++;
            $scope.loadPage();
            $scope.$broadcast("scroll.infiniteScrollComplete");  //加载完成之后广播出去
        };
        $scope.$on("$stateChangeSuccess",function () {
            $scope.loadMore();
        });

        //下拉刷新
        $scope.doRefresh = function () {
            $scope.dataInfo.currentPage = 1;
            $http({
                url:'../front/myCurations.do',
                method:'GET',
                params:$scope.dataInfo
            }).success(function (data) {
                $scope.daifabuList = [];
                console.log(data);
                if(data.success == 1){
                    $scope.currentPage = data.data.page.currentPage;  //当前的page页数
                    $scope.totalPage = data.data.page.totalPage;  //当前的page页数
                    $scope.rootUrl = data.data.rootUrl;          //根路径
                    $scope.daifabuList = $scope.daifabuList.concat(data.data.curList);
                    if($scope.currentPage < $scope.totalPage){
                        $scope.moreData = true;
                    }else {
                        $scope.moreData = false;
                    }
                    if($scope.daifabuList.length == 0){
                        $scope.searchNone = true;
                    }else {
                        $scope.searchNone = false;
                    }
                }else {
                    layer.alert(data.data,{
                        title:"提示",
                        icon:'0',
                        skin:'layer-ext-moon'
                    })
                }
            }).finally(function () {
                $timeout(function(){
                    $scope.$broadcast("scroll.refreshComplete");
                },1000)
            });
        };

        //加载数据
        $scope.loadPage = function () {
            $scope.moreData = false;   //未开始的时候禁止加载
            $http({
                url:'../front/myCurations.do',
                method:"GET",
                params:$scope.dataInfo
            }).success(function (data) {
                console.log(data);
                if(data.success == 1){
                    $scope.currentPage = data.data.page.currentPage;  //当前的page页数
                    $scope.totalPage = data.data.page.totalPage;  //当前的page页数
                    $scope.rootUrl = data.data.rootUrl;          //根路径
                    $scope.daifabuList = $scope.daifabuList.concat(data.data.curList);
                    if($scope.currentPage < $scope.totalPage){
                        $scope.moreData = true;
                    }else {
                        $scope.moreData = false;
                    }
                    if($scope.daifabuList.length == 0){
                        $scope.searchNone = true;
                    }else {
                        $scope.searchNone = false;
                    }
                }else {
                    layer.alert(data.error.message, {
                        title:'提示',
                        icon: 1,
                        skin: 'layer-ext-moon'
                    })
                }
            }).error(function (data) {
                layer.alert(data.error.message, {
                    title:'提示',
                    icon: 1,
                    skin: 'layer-ext-moon'
                })
            })
        }

    });