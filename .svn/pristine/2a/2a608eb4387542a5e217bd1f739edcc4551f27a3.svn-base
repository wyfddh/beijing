/**
 * Created by Administrator on 2017/5/15.
 */
angular.module('myComment',[])
    .controller('myCommentCtrl',function ($scope,$http,$rootScope,$state) {
        $rootScope.hideFoot = true;
        $state.go("myComment.pinglunwode");
        // $scope.searchNone = false;
        $scope.tabIndex = 0;
        $scope.back = function () {
            history.back();
        };

        $scope.changeTab = function (index) {
          $scope.tabIndex = index;
        };




        //
        //
        //
        //
        // // 刷新评论我的
        // $scope.doRefreshCommentMe = function () {
        //     $scope.dataInfoCommentMe.currentPage = 1;
        //     $http({
        //         url:url,
        //         method:'GET',
        //         params:$scope.dataInfoCommentMe
        //     }).success(function (data) {
        //         console.log(data);
        //         $scope.commentMe = [];
        //         $scope.commentMe = $scope.commentMe.concat(data.data.list);
        //         if(data.data.page.currentPage < data.data.page.totalPage){
        //             $scope.moreDataCommentMe = true;
        //         }else {
        //             $scope.moreDataCommentMe = false;
        //         }
        //     }).error(function (data) {
        //         console.log(data);
        //     }).finally(function () {
        //         $timeout(function(){
        //             $scope.$broadcast("scroll.refreshComplete");
        //         },1000)
        //     });
        // };
        //
        // // 刷新我评论的
        // $scope.doRefreshMyComment = function () {
        //     $scope.dataInfoMyComment.currentPage = 1;
        //     $http({
        //         url:url,
        //         method:'GET',
        //         params:$scope.dataInfoMyComment
        //     }).success(function (data) {
        //         console.log(data);
        //         $scope.myComment = [];
        //         $scope.myComment = $scope.myComment.concat(data.data.list);
        //         if(data.data.page.currentPage < data.data.page.totalPage){
        //             $scope.moreDataMyComment = true;
        //         }else {
        //             $scope.moreDataMyComment = false;
        //         }
        //     }).error(function (data) {
        //         console.log(data);
        //     }).finally(function () {
        //         $timeout(function(){
        //             $scope.$broadcast("scroll.refreshComplete");
        //         },1000)
        //     });
        // };
    });