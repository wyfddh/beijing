/**
 * Created by Administrator on 2017/5/16.
 */
angular.module("myComment-controller-pinglunwode",[])
    .controller("pinglunwodeCtrl",function ($scope,$http,$timeout) {
        $scope.searchNone = false;
        $scope.commentMe = [];
        $scope.commentMeSize = 6;
        $scope.commentMeCurrentPage = 0;
        // //评论我的的参数
        $scope.dataInfoCommentMe = {
            size : $scope.commentMeSize,
            currentPage:$scope.commentMeCurrentPage
        };
        // 加载数据
        //评论我的左边的那个
        $scope.moreDataCommentMe = true;
        $scope.loadMoreCommentMe = function () {
            $scope.dataInfoCommentMe.currentPage++;
            $scope.getListCommentMe();
            $scope.$broadcast("scroll.infiniteScrollComplete");
        };

        $scope.$on("$stateChangeSuccess",function () {
            $scope.loadMoreCommentMe();
        });

        //评论我的   左边的那个
        $scope.getListCommentMe = function () {
            $scope.moreDataCommentMe = false;
            $http({
                url:'../front/curation///commMine.do',
                method:'GET',
                params:$scope.dataInfoCommentMe
            }).success(function (data) {
                console.log(data);
                if(data.success == "1"){
                    $scope.commentMe = $scope.commentMe.concat(data.data);
                    if(data.page.currentPage < data.page.totalPage){
                        $scope.moreDataCommentMe = true;
                    }else {
                        $scope.moreDataCommentMe = false;
                    }
                    if($scope.commentMe.length == 0){
                        $scope.searchNone = true;
                    }else {
                        $scope.searchNone = false;
                    }
                }else {
                    layer.alert(data.error.message,{
                        title:"错误",
                        icon: 5,
                        skin: 'layer-ext-moon'
                    })
                }
            })
        };

        //刷新
        $scope.doRefreshCommentMe = function () {
            $scope.dataInfoCommentMe.currentPage = 1;
            $http({
                url:'../front/curation///commMine.do',
                method:'GET',
                params:$scope.dataInfoCommentMe
            }).success(function (data) {
                console.log(data);
                if(data.success == "1"){
                    $scope.commentMe = [];
                    $scope.commentMe = $scope.commentMe.concat(data.data);
                    if(data.page.currentPage < data.page.totalPage){
                        $scope.moreDataCommentMe = true;
                    }else {
                        $scope.moreDataCommentMe = false;
                    }
                    if($scope.commentMe.length == 0){
                        $scope.searchNone = true;
                    }else {
                        $scope.searchNone = false;
                    }
                }else {
                    layer.alert(data.error.message,{
                        title:"错误",
                        icon: 5,
                        skin: 'layer-ext-moon'
                    })
                }
            }).finally(function () {
                $timeout(function(){
                    $scope.$broadcast("scroll.refreshComplete");
                },500)
            });
        };

    });