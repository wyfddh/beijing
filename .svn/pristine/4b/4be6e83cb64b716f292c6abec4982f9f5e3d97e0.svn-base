'use strict';

angular.module("mapp",['ionic','ui.router','mapp-controller','ngSanitize','ipCookie'])
.controller("goHome",function($scope,$rootScope,$http,ipCookie,$ionicScrollDelegate,$state){
    $rootScope.isCollect = false;
    $rootScope.isMuseum = false;
    $rootScope.isBrowse = false;
    $rootScope.hideFoot = true;
    $scope.collectionsCategory = $rootScope.collectionsCategory;
    $('.tab-item').on('touchend',function(){
        $rootScope.cdkey = '';
        $rootScope.collectionUnitID = '';
        $rootScope.yearType = '';
        $rootScope.collectionsCategory = '';
        $rootScope.museumkey = '';
        $rootScope.museumId = '';
        $rootScope.museumCityId = '',
        $rootScope.categoryId = '';
        $rootScope.flag = '';
        $rootScope.level = '';
        $('.down-list .list').hide();
        $ionicScrollDelegate.scrollTop();
    });
    $http({
        method:"get",
        url:'../turnimghome/getmuseumList.do'
    }).success(function(data) {
            $scope.homeUrlData = data;
            // console.log(data);
    });
    $scope.swiperFn = function() {
        var swiper = new Swiper('.homePic.swiper-container', {
            pagination: '.swiper-pagination',
            paginationClickable: true,
            spaceBetween: 100,
            effect: 'fade',
            autoplay: 2000,
            resistanceRatio : 0,
            // prevButton:'.swiper-button-prev',
            // nextButton:'.swiper-button-next',
            //loop: true,
            observer:true,
            observeParents:true,
            autoplayDisableOnInteraction: false
        });
    }
    $scope.swiperFn();

    //点击我的收藏先判断是不是登录
    $scope.goCollection = function () {
        $http({
            url:'../front/OCCollection/doCollect.do',
            method:'GET',
            params:{}
        }).success(function (data) {
            // console.log(data);
            if(data.success == "0"){
                layer.msg(data.data);
                $state.go('login');
            }else {
                $state.go('myCollection');
            }
        });
    };

    //点击我的评论先判断是不是登录
    $scope.goPinglun = function () {
        $http({
            url:'../front/OCCollection/doCollect.do',
            method:'GET',
            params:{}
        }).success(function (data) {
            // console.log(data);
            if(data.success == "0"){
                layer.msg(data.data);
                $state.go('login');
            }else {
                $state.go('myComment');
            }
        });
    };

    //点击我的策展先判断是不是登录
    $scope.goCezhan = function () {
//        $http({
//            url:'../front/OCCollection/doCollect.do',
//            method:'GET',
//            params:{}
//        }).success(function (data) {
//            console.log(data);
//            if(data.success == "0"){
//                layer.msg(data.data);
//                $state.go('login');
//            }else {
                $state.go('cezhan');
//            }
//        });
    }
}).directive('repeatDone', function() {
    return {
        link: function(scope, element, attrs) {
            //console.log(scope.$last);
            if (scope.$last) {
                // 这个判断意味着最后一个 OK

                scope.$eval(attrs.repeatDone);    // 执行绑定的表达式
            }
        }
    }
});

angular.module("mapp").config(function($stateProvider,$urlRouterProvider){

    $urlRouterProvider.otherwise('home');
    $stateProvider
    .state('home',{
        url:'/home',
        templateUrl:'templates/home.html',
        controller:'goHome'
    }).state('waiting',{
            url:'/waiting',
            templateUrl:'templates/waiting.html',
            controller:'goWaiting'
    }).state('browse',{
        url:'/homebrowse',
        templateUrl:'templates/home-browse.html',
        controller:'goHomeBrowse'
    }).state('browseBefore',{
            url:'/homebrowseBefore',
            templateUrl:'templates/home-browse-before.html',
            controller:'goHomeBrowseBefore'
    }).state('browseDetail',{
        url:'/browseDetail/:id',
        templateUrl:'templates/browse-detail.html',
        controller:'goBrowseDetail'
    }).state('provinceDetail',{
            url:'/provinceDetail',
            templateUrl:'templates/province-detail.html',
            controller:'goProvinceDetail'
    }).state('provinceDetailContent',{
            url:'/provinceDetailContent/:id',
            templateUrl:'templates/province-detail-content.html',
            controller:'goProvinceDetailContent'
    }).state('foreignDetail',{
            url:'/foreignDetail',
            templateUrl:'templates/foreign-detail.html',
            controller:'goForeignDetail'
    }).state('foreignDetailContent',{
            url:'/foreignDetailContent/:id',
            templateUrl:'templates/foreign-detail-content.html',
            controller:'goForeignDetailContent'
    }).state('collection',{
        url:'/collection/:collectionsCategory',
        templateUrl:'templates/collection.html',
        controller:'goCollection'
    }).state('collectionSpecimen',{
            url:'/collectionSpecimen',
            templateUrl:'templates/collectionSpecimen.html',
            controller:'goCollectionSpecimen'
    }).state('collectionSpecimenDetail',{
    	url:'/collectionSpecimenDetail/:id',
        templateUrl:'templates/collectionSpecimen-detail.html',
        controller:'CollectionSpecimenDetail'
    }).state('collectionDetail',{
            url:'/collectionDetail/:id',
            templateUrl:'templates/collection-detail.html',
            controller:'CollectionDetail'
    }).state('virtual-museum',{
            url:'/virtual-museum',
            templateUrl:'templates/virtual-museum.html',
            controller:'virtualMuseum'
    }).state('daolan',{
            url:'/daolan/:gsNo',
            templateUrl:'templates/daolan.html',
            controller:'goDaolan'
    }).state('daolanSpecimen',{
            url:'/daolanSpecimen/:gsNo',
            templateUrl:'templates/daolan-specimen.html',
            controller:'goDaolanSpecimen'
    }).state('museum',{
        url:'/museum',
        templateUrl:'templates/museum.html',
        controller:'goMuseum'
    }).state('moreCollection-controller',{
            url:'/moreCollection-controller',
            templateUrl:'templates/moreCollection.html',
            controller:'goMoreCollection'
    }).state('museumDetail',{
            url:'/museumDetail/:id',
            templateUrl:'templates/museum-detail.html',
            controller:'goMuseumDetail'
    }).state('cezhan',{
        url:'/cezhan',
        templateUrl:'templates/cezhan.html',
        controller:'goCezhan'
    }).state('cezhanDetail',{
            url:'/cezhanDetail/:id',
            templateUrl:'templates/cezhanDetail.html',
            controller:'goCezhanDetail'
    }).state('cezhan.hot',{
        url:'/hot',
        templateUrl:'templates/hot.html',
        controller:'cezhan.hot'
    }).state('cezhan.new',{
            url:'/new',
            templateUrl:'templates/new.html',
            controller:'cezhan.new'
    }).state('person',{
        url:'/person',
        templateUrl:'templates/person.html',
        controller:'goPerson'
    }).state('login',{
        url:'/login',
        templateUrl:'templates/login.html',
        controller:'goLogin'
    }).state('registerStepOne',{
        url:'/registerStepOne',
        templateUrl:'templates/register-stepOne.html',
        controller:'goRegisterStepOne'
    }).state('registerStepTwo',{
        url:'/registerStepTwo',
        templateUrl:'templates/register-stepTwo.html',
        controller:'goRegisterStepTwo'
    }).state('registerStepThree',{
        url:'/registerStepThree',
        templateUrl:'templates/register-stepThree.html',
        controller:'goRegisterStepThree'
    }).state('registerSuccess',{
        url:'/registerSuccess',
        templateUrl:'templates/register-success.html',
        controller:'goRegisterSuccess'
    })
    //以图搜图
    .state('searchPic',{
        url:'/searchPic',
        templateUrl:'templates/searchPic.html',
        controller:'searchPicCtrl'
    })
    //我的收藏
    .state('myCollection',{
        url:'/myCollection',
        templateUrl:'templates/myCollection.html',
        controller:'myCollectionCtrl'
    }).state('statisticProvince',{
        url:'/statisticProvince',
        templateUrl:'templates/statisticProvince.html',
        controller:'statisticProvinceCtrl'
    }).state('collectionUnit',{
        url:'/collectionUnit',
        templateUrl:'templates/collectionUnit.html',
        controller:'collectionUnitCtrl'
    }).state('statisticCity',{
        url:'/statisticCity',
        templateUrl:'templates/statisticCity.html',
        controller:'statisticCityCtrl'
    }).state('collectionUnitName',{
        url:'/collectionUnitName',
        templateUrl:'templates/collectionUnitName.html',
        controller:'collectionUnitNameCtrl'
    })
    //可移动文物地区分布省级
      .state('canMoveCollectionArea',{
        url:'/canMoveCollectionArea',
        templateUrl:'templates/canMoveCollectionArea.html',
        controller:'canMoveCollectionAreaCtrl'
    })
    //可移动文物地区分布市级
      .state('canMoveCollectionCity',{
        url:'/canMoveCollectionCity',
        templateUrl:'templates/canMoveCollectionCity.html',
        controller:'canMoveCollectionCityCtrl'
    })
    //可移动文物基本情况省级
      .state('canMoveBaceProvince',{
        url:'/canMoveBaceProvince',
        templateUrl:'templates/canMoveBaceProvince.html',
        controller:'canMoveBaceProvinceCtrl'
    })
    //我的评论
      .state('myComment',{
        url:'/myComment',
        templateUrl:'templates/myComment.html',
        controller:'myCommentCtrl'
     })
     //我的评论-评论我的
     .state('myComment.pinglunwode',{
         url:'/pinglunwode',
         templateUrl:'templates/pinglunwode.html',
         controller:'pinglunwodeCtrl'
     })
     //我的评论-评论我的
     .state('myComment.wodepinglun',{
        url:'/wodepinglun',
        templateUrl:'templates/wodepinglun.html',
        controller:'wodepinglunCtrl'
     })
        //我的策展
     .state('wodecezhan',{
         url:'/wodecezhan',
         templateUrl:'templates/wodecezhan.html',
         controller:'wodecezhanCtrl'
     })
        //待发布
     .state("wodecezhan.daifabu",{
         url:'/daifabu',
         templateUrl:'templates/daifabu.html',
         controller:'daifabuCtrl'
     })
        //已发布
     .state("wodecezhan.yifabu",{
         url:'/yifabu',
         templateUrl:'templates/yifabu.html',
         controller:'yifabuCtrl'
     })
        //已下架
     .state("wodecezhan.yixiajia",{
         url:'/yixiajia',
         templateUrl:'templates/yixiajia.html',
         controller:'yixiajiaCtrl'
     })
    //忘记密码第一步
        .state("forgotPassword",{
            url:'/forgotPassword',
            templateUrl:'templates/forgotPassword.html',
            controller:'forgotPassword'
        })
    //忘记密码第二步
        .state("forgotPasswordTwo",{
            url:'/forgotPasswordTwo',
            templateUrl:'templates/forgotPasswordTwo.html',
            controller:'forgotPasswordTwo'
        })
        //忘记密码第三步
        .state("forgotPasswordSuccess",{
            url:'/forgotPasswordSuccess',
            templateUrl:'templates/forgotPasswordSuccess.html',
            controller:'forgotPasswordSuccess'
        })
        //修改密码
        .state("changePassWord",{
            url:'/changePassWord',
            templateUrl:'templates/changePassWord.html',
            controller:'changePassWordCtrl'
        })
    ;
});