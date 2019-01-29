angular.module("cezhan-controller-hot",[])
    .controller("cezhan.hot",function($scope,$state,$http,$timeout){
        $scope.currentPage = 0;
        $scope.size = 5;
        $scope.order = 1;
        $scope.cezhanList = [];
        $scope.searchNone = false;   //一开始的时候没有搜到数据的话就隐藏
        $scope.dataInfo  = {
            currentPage:$scope.currentPage,
            size:$scope.size,
            order:$scope.order
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
                url:'../front/curation/curList.do',
                method:'GET',
                params:$scope.dataInfo
            }).success(function (data) {
                $scope.cezhanList = [];
                // console.log(data);
                if(data.success == 1){
                    $scope.currentPage = data.data.page.currentPage;  //当前的page页数
                    $scope.totalPage = data.data.page.totalPage;  //当前的page页数
                    $scope.rootUrl = data.data.rootUrl;          //根路径
                    $scope.cezhanList = $scope.cezhanList.concat(data.data.curList);
                    if($scope.currentPage < $scope.totalPage){
                        $scope.moreData = true;
                    }else {
                        $scope.moreData = false;
                    }
                    if(data.data.length == 0){
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
                url:'../front/curation/curList.do',
                method:"GET",
                params:$scope.dataInfo
            }).success(function (data) {
                console.log(data);
                if(data.success == 1){
                    $scope.currentPage = data.data.page.currentPage;  //当前的page页数
                    $scope.totalPage = data.data.page.totalPage;  //当前的page页数
                    $scope.rootUrl = data.data.rootUrl;          //根路径
                    $scope.cezhanList = $scope.cezhanList.concat(data.data.curList);
                    if($scope.currentPage < $scope.totalPage){
                        $scope.moreData = true;
                    }else {
                        $scope.moreData = false;
                    }
                    if(data.data.length == 0){
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

