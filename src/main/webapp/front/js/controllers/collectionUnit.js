/**
 * Created by Administrator on 2017/4/28.
 */
angular.module('collectionUnit',[])
    .controller('collectionUnitCtrl',function ($scope,$rootScope,$http) {
        $rootScope.hideFoot = false;
        $scope.back = function () {
            history.back();
        };

        // 调取数据
        $http({
            url:'../front/statistics/collectionUnit.do',
            method:'GET',
            params:''
        }).success(function (data) {
            console.log(data);
            if(data.success == 1){
                $scope.cityList = data.data.collectionUnitList;
            }else {
                layer.alert(data.error.message, {
                    title:"提示",
                    icon: 5,
                    skin: 'layer-ext-moon'
                })
            }
        });

        // $scope.slideToggle = function (e) {
        //   angular.element(e.target).find("div").toggleClass("rotate");
        //   angular.element(e.target).next(".museumWrap").slideToggle();
        //   angular.element(e.target).parent().siblings().find(".museumWrap").slideUp();
        //   angular.element(e.target).parent().siblings().find(".cityItem").find("div").removeClass("rotate");
        // };

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