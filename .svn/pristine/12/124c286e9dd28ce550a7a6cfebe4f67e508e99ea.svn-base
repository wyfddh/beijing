/**
 * Created by Administrator on 2017/4/29.
 */
angular.module('canMoveCollectionArea',[])
    .controller('canMoveCollectionAreaCtrl',function ($scope,$rootScope,$state,$http) {
        $rootScope.hideFoot = false;
        $scope.back = function () {
            history.back();
        };
        $scope.goMuseum = function () {
            $state.go('canMoveCollectionCity');
        };

        //调数据
        $http({
            url:'../front/statistics/relicCount.do',
            method:'GET',
            params:''
        }).success(function (data) {
            console.log(data);
            if(data.success == "1"){
                $scope.relicCountList = data.data.relicCountList;
            }else {
                layer.alert(data.error.message, {
                    title:"提示",
                    icon: 5,
                    skin: 'layer-ext-moon'
                })
            }
        });

        //点击的时候
        // $(".unitWrap").delegate('.cityItem','touchend',function () {
        //     // var down=!$(this).siblings(".museumWrap").hasClass('show');
        //     // $(".museumWrap").removeClass('show').slideUp();
        //     // if(down){
        //     //     $(this).siblings(".museumWrap").slideDown();
        //     //     $(this).siblings(".museumWrap").addClass('show');
        //     // }
        //     $(this).find("div").toggleClass("rotate").end().siblings(".museumWrap").slideToggle().parents(".cityList").siblings().find(".museumWrap").slideUp().siblings(".cityItem").find("div").removeClass("rotate");
        // });

        $scope.showMuseum = function (e) {
            var down = !angular.element(e.target).siblings('.museumWrap').hasClass('show');
            $(".museumWrap").removeClass('show').slideUp().siblings(".cityItem").find("div").removeClass("rotate");
            if(down){
                angular.element(e.target).find("div").toggleClass("rotate");
                angular.element(e.target).siblings(".museumWrap").slideToggle().addClass('show');
            }
        };
    });