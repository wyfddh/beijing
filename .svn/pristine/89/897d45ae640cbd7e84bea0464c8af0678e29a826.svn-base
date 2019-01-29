/**
 * Created by Administrator on 2017/5/17.
 */
angular.module("wodecezhan-controller-daifabu",[])
    .controller("daifabuCtrl",function($scope,$state,$http,$timeout,$window){
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
                url:'../front/curation/myCurations.do',
                method:'GET',
                params:$scope.dataInfo
            }).success(function (data) {
                $scope.daifabuList = [];
                // console.log(data);
                if(data.success == 1){
                    $scope.rootUrl = data.data.rootUrl;
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
                        $scope.miaoshu = false;
                    }else {
                        $scope.searchNone = false;
                        $scope.miaoshu = true;
                    }
                }else {
                    layer.alert(data.error.message,{
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
                url:'../front/curation/myCurations.do',
                method:"GET",
                params:$scope.dataInfo
            }).success(function (data) {
                // console.log(data);
                if(data.success == 1){
                    $scope.rootUrl = data.data.rootUrl;
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
                        $scope.miaoshu = false;
                    }else {
                        $scope.searchNone = false;
                        $scope.miaoshu = true;
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
        };

        //点击发布
        $scope.fabuInfo = {
            id:$scope.cezhanId
        };
        $scope.fabu = function () {
            $http({
                url:'../front/curation/publishAll.do',
                method:'POST',
                data:$scope.fabuInfo,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                transformRequest: function (obj) {
                    var str = [];
                    for (var s in obj) {
                        str.push(encodeURIComponent(s) + "=" + encodeURIComponent(obj[s]));
                    }
                    return str.join("&");
                }
            }).success(function (data) {
                // console.log(data);
                if(data.success == "1"){
                    // $state.go("cezhanSuccess");     //跳转到发布成功的那个页面\
                    layer.msg("发布成功",{
                        time: 2000});
                    $scope.doRefresh();
                }else {
                    layer.alert(data.error.message,{
                        title:"提示",
                        icon:6,
                        skin: 'layer-ext-moon'
                    });
                }
            }).error(function (data) {
                layer.alert(data.error.message,{
                    title:"提示",
                    icon:5,
                    skin: 'layer-ext-moon'
                });
            });
        };

        $scope.clickFabu = function (e) {
            $scope.fabuId = angular.element(e.target).attr("data");
            // console.log($scope.fabuId);
            $scope.fabuInfo.id = $scope.fabuId;
            // console.log($scope.fabuInfo);
            layer.confirm('您确定要发布吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                $scope.fabu();
            }, function(){
               layer.closeAll();
            });
        }

    });