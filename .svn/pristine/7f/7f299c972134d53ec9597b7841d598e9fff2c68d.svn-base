angular.module("museum-controller",[])
    .controller("goMuseum",function($scope,$rootScope,$http,$timeout,$stateParams,$ionicScrollDelegate,$state){
        $rootScope.hideFoot = true;
            //$scope.isActive=true;
        $scope.params = {
            currentPage:$scope.page,
            museumId:$rootScope.museumId,
            museumCityId:$rootScope.museumCityId,
            categoryId:$rootScope.categoryId,
            flag:$rootScope.flag,
            museumName:$rootScope.museumkey,
            level:$rootScope.level
        };
        $scope.toScale = function(){
           $('.museum-bigBox').hide();
           $('.tabs-icon-top').hide();
           $('.svg-bigBox').show();
        };
        $scope.toSmall = function(){
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
        };
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
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
        });
        $rootScope.isCollect = false;
        $rootScope.isMuseum = true;
        $rootScope.isBrowse = false;
        $scope.search=function(e,index) {
            if (e.target.nodeName == 'SPAN') {
                $scope.params.museumName = angular.element(e.target).prev().prev().val();
                $rootScope.museumkey = $scope.params.museumName;
                // console.log($scope.params);
            }
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
            $('.home-search-area').hide();
            $('.museum-bigBox').show();
            $('.homeSearch').val($rootScope.museumkey);
            $('.museum-search').val($scope.params.museumName);
        };
        $('.qingchu').on('touchend',function(){
            $('.homeSearch').val('');
            $('.museum-search').val('');
            $(this).hide();
            $scope.params.museumName = '';
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        //$scope.collectionKey = function(){
        //    return $scope.params.key;
        //};
        $('.museum-search').on('focus',function(){
            $('.home-search-area').show();
            $('.museum-bigBox').hide();
        });
        $('.homeBack').on('touchend',function(){
            $('.home-search-area').hide();
            $('.museum-bigBox').show();
        });
        $scope.isHsVal = function(){
            if($scope.hsVal ==''){
                $('.qingchu').hide();
            }else{
                $('.qingchu').show();
            }
        };
        var page =1;
        var size = 6;
        function showMask(){
            $("#mask").css("height",($(document).height()-$('.content-search').height()));
            $("#mask").css("width",$(document).width());
            $("#mask-bottom").css("height",($(document).height()-$('.content-search').height()));
            $("#mask-bottom").css("width",$(document).width());
        }
        showMask();
        $scope.museumCour=function(index){
            $scope.indes = index;
            for(var i=0;i<$scope.museumListData.data.cityList.length;i++){
                $scope.museumListData.data.cityList[i].isclick=false;
            }
            $scope.museumListData.data.cityList[index].isclick=true;
            $(".city-museum").show();
        };

        // 点击博物馆筛选按钮
        $scope.museumeEare=function(indes,e){
            $('.city-museum li').removeClass('selected');
            $('.city-museum li').eq(indes+1).addClass('selected');
            $('.area').removeClass('act');
            $scope.params.museumId=angular.element(e.target).attr('data-cityid');
            $rootScope.museumId = angular.element(e.target).attr('data-cityid');
            $scope.params.museumCityId = angular.element(e.target).attr('data-id');
            $rootScope.museumCityId = angular.element(e.target).attr('data-id');
            // console.log($scope.params.museumId);
            // console.log($scope.params);
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
            $(".collection-list-city").slideUp();
            $(".city-museum").slideUp();
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
        };

        // 点击全部按钮
        $(".city-museum li:first-child").click(function(){
            $(".city-museum i img").hide();
            $('.collection-list-city li').removeClass('selected');
            $('.city-museum li').removeClass('selected');
            $('.area').removeClass('act');
            $scope.params.museumId='';
            $rootScope.museumId = '';
            $scope.params.museumCityId= $(".city-museum").find("li").eq(1).attr("data-id");
            $rootScope.museumCityId = $(".city-museum").find("li").eq(1).attr("data-id");
            $scope.params.categoryId = '';
            $scope.params.flag = '';
            $scope.params.level = '';
            $scope.params.museumName = '';

            // console.log($scope.params);
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
            $(".collection-list-city").slideUp();
            $(".city-museum").slideUp();
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
        });
        // $scope.objectList=function(indes,e) {
        //     $(".object-list-item img").hide();
        //     $(".object-list-item img").eq(indes).show();
        //     $scope.params.categoryId=angular.element(e.target).attr('data-categoryId');
        //     console.log($scope.params.categoryId);
        //     console.log($scope.params);
        //     $(".object-list").fadeOut();
        //     $('.object').removeClass('act');
        //     $('#mask').hide();
        //     $('.svg-box').show();
        //     $('.search').show();
        //     $('.museum-top').css('top','8.90625rem');
        // };
        $('.object-list-item').eq(0).on('touchend',function(){
            var index = $(this).index();
            $(".object-list-item img").hide();
            $(".object-list-item img").eq(index-1).show();
            $scope.params.level= 1;
            $rootScope.level = 1;
            // console.log($scope.params.level);
            // console.log($scope.params);
            $(".object-list").fadeOut();
            $('.object').removeClass('act');
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $('.object-list-item').eq(1).on('touchend',function(){
            var index = $(this).index();
            $(".object-list-item img").hide();
            $(".object-list-item img").eq(index-1).show();
            $scope.params.level= 2;
            $rootScope.level = 2;
            // console.log($scope.params.level);
            // console.log($scope.params);
            $(".object-list").fadeOut();
            $('.object').removeClass('act');
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $('.object-list-item').eq(2).on('touchend',function(){
            var index = $(this).index();
            $(".object-list-item img").hide();
            $(".object-list-item img").eq(index-1).show();
            $scope.params.level= 3;
            $rootScope.level = 3;
            // console.log($scope.params.level);
            // console.log($scope.params);
            $(".object-list").fadeOut();
            $('.object').removeClass('act');
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $('.object-list-item').eq(3).on('touchend',function(){
            var index = $(this).index();
            $(".object-list-item img").hide();
            $(".object-list-item img").eq(index-1).show();
            $scope.params.level= 4;
            $rootScope.level = 4;
            // console.log($scope.params.level);
            // console.log($scope.params);
            $(".object-list").fadeOut();
            $('.object').removeClass('act');
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $(".object-list li:first-child").click(function(){
            $(".object-list-item img").hide();
            $scope.params.level='';
            $rootScope.level = '';
            // console.log($scope.params);
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
            $(".object-list").fadeOut();
            $('.object').removeClass('act');
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
        });
        $scope.newUpdate = function(){
            $scope.params.flag = 1;
            $rootScope.flag = 1;
            // console.log($scope.params);
            $('.order').removeClass('act');
            $('.area-paixu').slideUp();
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $scope.hotUpdate = function(){
            $scope.params.flag = 2;
            $rootScope.flag = 2;
            // console.log($scope.params);
            $('.order').removeClass('act');
            $('.area-paixu').slideUp();
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $scope.areaUpdate = function(){
            $scope.params.flag = 3;
            $rootScope.flag = 3;
            // console.log($scope.params);
            $('.order').removeClass('act');
            $('.area-paixu').slideUp();
            $('#mask').hide();
            $('.svg-box').show();
            $('.search').show();
            $('.search').css('margin-top',0);
            $('.museum-top').css('top','8.90625rem');
            $('.museum-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $scope.getIndex = function(index){
            $scope.museumDataID = $scope.museumData.data.museumArr[index].museumId;
        };
        //下拉刷新
        $scope.doRefresh = function() {
            $scope.params = {
                currentPage:$scope.page,
                museumId:$rootScope.museumId,
                museumCityId:$rootScope.museumCityId,
                categoryId:$rootScope.categoryId,
                flag:$rootScope.flag,
                museumName:$rootScope.museumkey,
                level:$rootScope.level
            };
            $scope.params.size = size;
            //$scope.params.currentPage = 1;
            $http({
                method:"get",
                url:'../area/getmuseumListMB.do',
                params:$scope.params
            })
                .success(function(data) {
                    $scope.museumData = data;
                    // console.log(data);
                    if(data.data.museumArr.length==0){
                        $scope.museumSearchNone = true;
                    }else{
                        $scope.museumSearchNone = false;
                    }
                    if(data.page.currentPage < data.page.totalPage){
                        $scope.hasMore = true;
                    }else{
                        $scope.hasMore = false;
                    }
                })
                .finally(function() {
                    $timeout(function () {
                        $scope.$broadcast('scroll.refreshComplete');
                    },1500)
                });
        };

        // 下拉刷新
        $(function(){
            $scope.params = {
                currentPage:$scope.page,
                museumId:$rootScope.museumId,
                museumCityId:$rootScope.museumCityId,
                categoryId:$rootScope.categoryId,
                flag:$rootScope.flag,
                museumName:$rootScope.museumkey,
                level:$rootScope.level
            };
            $scope.page = 1;
            // 每页展示5个
            $scope.size = 5;
            // dropload
            var dropload = $('.museum-top .down-list').dropload({
                domUp : {
                    domClass   : 'dropload-up',
                    domRefresh : '<div class="dropload-refresh">↓下拉刷新</div>',
                    domUpdate  : '<div class="dropload-update">↑释放更新</div>',
                    domLoad    : '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
                },
                domDown : {
                    domClass   : 'dropload-down',
                    domRefresh : '<div class="dropload-refresh"></div>',
                    domLoad    : '<div class="dropload-load"><span class="loading"></span>加载中...</div>',
                    domNoData  : '<div class="dropload-noData">暂无数据</div>'
                },
                loadDownFn : function(me) {
                    $scope.hasMore = false;
                    $scope.load = function(){
                        $scope.params.currentPage = page++;
                        //$scope.params.size = size;
                        $rootScope.level = $scope.params.level;
                        $scope.loadMore = function () {
                            $http({
                                method: "get",
                                url: '../area/getmuseumListMB.do',
                                params: $scope.params
                            })
                                .success(function (data) {
                                    var result = '';
                                    console.log(data);
                                    // console.log($scope.params);
                                    $scope.museumListData = data;
                                    for (var i = 0; i < data.data.museumArr.length; i++) {
                                        if (data.data.museumArr[i].museumTicket == 0) {
                                            var str = '';
                                        }else {
                                            var str = '<img class="free" src="img/free.png">';
                                        }
                                        result += '<div class="museumList">'
                                                +'<a class="museumListHref" href="#/museumDetail/'+data.data.museumArr[i].museumId+'">'
                                                +'<img src="'+data.data.museumArr[i].museumPicture+'" class="museumImg">'
                                                +'<div class="museumIntroduce">'
                                                +'<h2>'+data.data.museumArr[i].museumName+''+str+'</h2>'
                                                +'<div class="contIntro">'
                                                +'<img class="addressTime" src="img/position.png">'
                                                +'<article>'+data.data.museumArr[i].museumAddress+'</article>'
                                                +'</div>'
                                                +'<div class="contIntro">'
                                                +'<img class="timeTime" src="img/museumdetail-date.png">'
                                                +'<article>'+data.data.museumArr[i].museumOpenTime+'</article>'
                                                +'</div>'
                                                +'</div>'
                                                +'</a>'
                                                +'</div>'
                                    }
                                    if(data.page.currentPage < data.page.totalPage){
                                        $scope.hasMore = true;
                                    }else{
                                        $scope.hasMore = false;
                                    }
                                    // 为了测试，延迟1秒加载
                                    setTimeout(function () {
                                        $('.museum-top .down-list').append(result);
                                        // 每次数据加载完，必须重置
                                        dropload.resetload();
                                    }, 1000);
                                }).error(function (xhr, type) {
                                //alert('Ajax error!');
                                // 即使加载出错，也得重置
                                // dropload.resetload();
                            })
                        };
                        $timeout(function () {
                            $scope.$broadcast('scroll.infiniteScrollComplete');
                        },1500);
                        $scope.loadMore();
                    };
                    $scope.load();
                }
            });
        });





        //获取到地区市和对应的下边的博物馆的列表
        $http({
            method:"get",
            url:'../area/getAreaList.do'
        })
            .success(function(data) {
                $scope.areaListData = data;
                // console.log(data);
                // for(var i=0;i<data.length;i++){
                //     data[i].i = i;
                //     $('.svg-box .city-numb').eq(i).html(data[i].museumCount);
                // }
                // for(var i=0;i<data.length;i++){
                //     data[i].i = i;
                //     $('.svg-bigBox .city-numb').eq(i).html(data[i].museumCount);
                // }
            });
        $scope.toWeiHai = function(){
            $rootScope.museumCityId = '1466';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path3').on('touchend',function(){
            $rootScope.museumCityId = '1466';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toYanTai = function(){
            $rootScope.museumCityId = '1421';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path16').on('touchend',function(){
            $rootScope.museumCityId = '1421';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toQingDao = function(){
            $rootScope.museumCityId = '1387';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path4').on('touchend',function(){
            $rootScope.museumCityId = '1387';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toWeiFang = function(){
            $rootScope.museumCityId = '1434';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path13').on('touchend',function(){
            $rootScope.museumCityId = '1434';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toRiZhao = function(){
            $rootScope.museumCityId = '1471';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path5').on('touchend',function(){
            $rootScope.museumCityId = '1471';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toLinXi = function(){
            $rootScope.museumCityId = '1479';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path6').on('touchend',function(){
            $rootScope.museumCityId = '1479';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toZiBo = function(){
            $rootScope.museumCityId = '1399';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path12').on('touchend',function(){
            $rootScope.museumCityId = '1399';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toDongYing = function(){
            $rootScope.museumCityId = '1415';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path14').on('touchend',function(){
            $rootScope.museumCityId = '1415';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toBinZhou = function(){
            $rootScope.museumCityId = '1513';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path15').on('touchend',function(){
            $rootScope.museumCityId = '1513';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toLaiWu = function(){
            $rootScope.museumCityId = '1476';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path10').on('touchend',function(){
            $rootScope.museumCityId = '1476';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toZaoZhuang = function(){
            $rootScope.museumCityId = '1408';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path2').on('touchend',function(){
            $rootScope.museumCityId = '1408';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toJiNing = function(){
            $rootScope.museumCityId = '1447';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path7').on('touchend',function(){
            $rootScope.museumCityId = '1447';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toTaiAn = function(){
            $rootScope.museumCityId = '1459';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path11').on('touchend',function(){
            $rootScope.museumCityId = '1459';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toJiNan = function(){
            $rootScope.museumCityId = '1376';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path9').on('touchend',function(){
            $rootScope.museumCityId = '1376';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toDeZhou = function(){
            $rootScope.museumCityId = '1492';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path0').on('touchend',function(){
            $rootScope.museumCityId = '1492';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toLiaoCheng = function(){
            $rootScope.museumCityId = '1504';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path1').on('touchend',function(){
            $rootScope.museumCityId = '1504';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $scope.toHeZe = function(){
            $rootScope.museumCityId = '1522';
            $('.museum-bigBox').show();
            $('.tabs-icon-top').show();
            $('.svg-bigBox').hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $('#path8').on('touchend',function(){
            $rootScope.museumCityId = '1522';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        $(".shouqi").on("touchend",function(){
            $(".svg-box").hide();
            $(".museum-top").css('top','4.2rem');
            $('.search').css('margin-top','1.8rem');
            $(".zhankai").show();
        });
        $(".zhankai").on("touchend",function(){
            $(".svg-box").show();
            $('.search').css('margin-top','0');
            $(".museum-top").css('top','8.90625rem');
            $(".zhankai").hide();
        });
        $('#mask').on('touchend',function(){
            $(".collection-list-city").slideUp();
            $(".city-museum").slideUp();
            $(".object-list").hide();
            $(".area-paixu").slideUp();
            $(".svg-box").show();
            $('.search').show();
            $(".museum-top").css('top','8.90625rem');
            $(".zhankai").hide();
            $('#mask').hide();
            $(".area").removeClass('act');
            $(".object").removeClass('act');
            $(".order").removeClass('act');
            $('.search').css('margin-top','0');
        });
        $("nav>div").on("touchend",function(){
            $(this).toggleClass("act");
            $(this).siblings().removeClass("act");
            if($(".object").hasClass('act')){
                $(".collection-list-city").slideUp();
                $(".city-museum").slideUp();
                $(".area-paixu").slideUp();
                $(".object-list").fadeIn();
                $('#mask').show();
                //$(".object-shadow").fadeIn();
                $('.zhankai').hide();
                $('.svg-box').hide();
                $('.search').hide();
                $('#mask').css('top','0.9375rem');
                $('.museum-top').css('top','0.8rem');
                $('.search').css('margin-top','0');
            }
            else if($(".area").hasClass("act")){
                $(".collection-list-city").slideDown();
                $(".area-paixu").slideUp();
                $(".object-list").hide();
                $('#mask').show();
                //$(".object-shadow").hide();
                $('.zhankai').hide();
                $('.svg-box').hide();
                $('.search').hide();
                $('#mask').css('top','0.9375rem');
                $('.museum-top').css('top','0.8rem');
                $('.search').css('margin-top','0');
            }else if($(".order").hasClass("act")){
                $(".area-paixu").slideDown();
                $(".collection-list-city").slideUp();
                $(".city-museum").slideUp();
                $(".object-list").hide();
                $('#mask').show();
                //$(".object-shadow").hide();
                $('.zhankai').hide();
                $('.svg-box').hide();
                $('.search').hide();
                $('#mask').css('top','0.9375rem');
                $('.museum-top').css('top','0.8rem');
                $('.search').css('margin-top','0');
            }
            else{
                $(".area-paixu").slideUp();
                $(".collection-list-city").slideUp();
                $(".city-museum").slideUp();
                $(".object-list").hide();
                $('#mask').hide();
                $('.svg-box').show();
                $('.search').show();
                $('.search').css('margin-top',0);
                $('.museum-top').css('top','8.90625rem');
            }
        });
    });

