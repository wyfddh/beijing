/**
 * Created by Administrator on 2017/5/16.
 */
angular.module("myComment-controller-wodepinglun",[])
    .controller("wodepinglunCtrl",function ($scope,$http,$timeout) {
        $scope.searchNone = false;
        $scope.myComment = [];
        $scope.myCommentSize = 6;
        $scope.myCommentCurrentPage = 0;

        //我评论的的参数
        $scope.dataInfoMyComment = {
            size : $scope.myCommentSize,
            currentPage:$scope.myCommentCurrentPage
        };

        // 我的评论
        $scope.moreDataMyComment = true;
        $scope.loadMoreMyComment = function () {
            $scope.dataInfoMyComment.currentPage++;
            $scope.getListMyComment();
            $scope.$broadcast("scroll.infiniteScrollComplete");
        };

        $scope.$on("$stateChangeSuccess",function () {
            $scope.loadMoreMyComment();
        });

        //请求数据我的评论   右边的那个
        $scope.getListMyComment = function () {
            $scope.moreDataMyComment = false;
            // alert($scope.dataInfoMyComment.currentPage);
            $http({
                url:'../front/curation///myComments.do',
                method:'GET',
                params:$scope.dataInfoMyComment
            }).success(function (result) {
                console.log(result);
                if(result.success == "1"){
                    $scope.myComment = $scope.myComment.concat(result.data);
                    if(result.page.currentPage < result.page.totalPage){
                        console.log($scope.dataInfoMyComment.currentPage)
                        $scope.moreDataMyComment = true;
                    }else {
                        $scope.moreDataMyComment = false;
                    }
                    if($scope.myComment.length == 0){
                        $scope.searchNone = true;
                    }else {
                        $scope.searchNone = false;
                    }
                }else {
                    layer.alert(result.error.message,{
                        title:"错误",
                        icon: 5,
                        skin: 'layer-ext-moon'
                    })
                }
            })
        };

        // 刷新
        $scope.doRefreshMyComment = function () {
            $scope.dataInfoMyComment.currentPage = 1;
            $http({
                url:'../front/curation///myComments.do',
                method:'GET',
                params:$scope.dataInfoMyComment
            }).success(function (result) {
                console.log(result);
                if(result.success == "1"){
                    $scope.myComment = [];
                    $scope.myComment = $scope.myComment.concat(result.data);
                    if(result.page.currentPage < result.page.totalPage){
                        $scope.moreDataMyComment = true;
                    }else {
                        $scope.moreDataMyComment = false;
                    }
                    if($scope.myComment.length == 0){
                        $scope.searchNone = true;
                    }else {
                        $scope.searchNone = false;
                    }
                }else {
                    layer.alert(result.error.message,{
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
        }
    });