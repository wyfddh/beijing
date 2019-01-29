angular.module("browse",[])
    .controller("goHomeBrowse",function($scope,$rootScope,$http,$timeout,$stateParams,$ionicScrollDelegate){
        $rootScope.hideFoot = true;
        $scope.params = {currentPage:$scope.page,
            size:$scope.size,
            cityId:$rootScope.museumDetailId,
            spreType:1
        };
        $('.tab-item').on('touchend',function(){
            $rootScope.cdkey = '';
            $rootScope.collectionUnitID = '';
            $rootScope.yearType = '';
            $rootScope.collectionsCategory = '';
            $rootScope.museumkey = '';
            $rootScope.museumId = '';
            $rootScope.categoryId = '';
            $rootScope.flag = '';
            $rootScope.level = '';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
        });
        var page =1;
        var size = 5;
        //$scope.browseData = [];
        //$http.get('../front/OCCollection/info.do')
        //    .success(function(data){
        //        console.log(data);
        //        $scope.browseData = data;
        //    });
        $rootScope.isCollect = false;
        $rootScope.isMuseum = false;
        $rootScope.isBrowse = true;
        $scope.browseList=function(index){
            $scope.index = index;
            for(var i=0;i<$scope.homeBrowseData.data.cityList.length;i++){
                $scope.homeBrowseData.data.cityList[i].isclick=false;
            }
            $scope.homeBrowseData.data.cityList[index].isclick=true;
            $(".browse-city-musueum").show();
        };

        $scope.cityMuseum=function(indes,e) {
            //for (var i = 0; i < $scope.homeBrowseData.data.cityList[i].length; i++) {
            //    $scope.homeBrowseData.data.cityList[i].museum[i].isclick = false;
            //}
            //$scope.homeBrowseData.data.cityList[index].museum[index].isclick = true;
            $('.browse-city-musueum li').removeClass('selected');
            $('.browse-city-musueum li').eq(indes+1).addClass('selected');
                $scope.params.cityId=angular.element(e.target).attr('data-cityid');
                console.log($scope.params);
                $('.browse-top .down-list').hide();
                $ionicScrollDelegate.scrollTop();
                $scope.doRefresh();
            $(".browse-list-city").slideUp();
            $(".browse-city-musueum").slideUp();
            $('#mask').hide();
        };
        $(".browse-city-musueum li:first-child").click(function(){
            $('.browse-list-city li').removeClass('selected');
            $('.browse-city-musueum li').removeClass('selected');
            $scope.params.cityId='';
            $rootScope.museumDetailId = '';
            console.log($scope.params);
            $('.browse-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
            $(".browse-list-city").slideUp();
            $(".browse-city-musueum").slideUp();
            $('#mask').hide();
        });
        $scope.getBrowseIndex = function(index){
            $scope.browseDataID = $scope.homeBrowseData.data.newSpreList[index].id;
        };

        $scope.doRefresh = function() {
            //$scope.params.currentPage = page++;
            $scope.params.size = size;
            $http({
                method:"get",
                url:'../spreadtrum/getPCSpreadtrum.do',
                params:$scope.params
            })
                .success(function(data) {
                    $scope.homeBrowseListData = data;
                    console.log(data);
                    if(data.data.newSpreList.length==0){
                        $scope.searchNone = true;
                    }else{
                        $scope.searchNone = false;
                    }
                    if(data.data.newSpreList.length<6){
                        $scope.hasMoreBrowse = false;
                    }else{
                        $scope.hasMoreBrowse = true;
                    }
                })
                .finally(function() {
                    $timeout(function () {
                        $scope.$broadcast('scroll.refreshComplete');
                    },1000)
                });
        };

        $(function(){
            $scope.page = 1;
            $scope.size = 5;
            // dropload
            var dropload = $('.browse-top .down-list').dropload({
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
                //autoLoad:false,
                loadDownFn : function(me) {
                    $scope.load = function () {
                        $scope.params.currentPage = page++;
                        $scope.params.size = size;
                        $scope.loadMore = function () {
                            $http({
                                method: "get",
                                url: '../spreadtrum/getPCSpreadtrum.do',
                                params: $scope.params
                            })
                                .success(function (data) {
                                    var result = '';
                                    console.log(data);
                                    console.log($scope.params);
                                    $scope.homeBrowseData = data;
                                    for (var i = 0; i < data.data.newSpreList.length; i++) {
                                        //$(".browse-date p[time="+data.data.newSpreList[i].beginTime+"]").hide();
                                        if (data.data.newSpreList[i].staTime == '') {
                                            var str = '';
                                        } else {
                                            var str = '<div class="browse-date"><img src="img/1t.png">' + data.data.newSpreList[i].staTime + '-' + data.data.newSpreList[i].overTime + '</div>';
                                        }
                                        result += '<div class="list">'
                                            + '<a class="item item-thumbnail-left" href="#/browseDetail/' + data.data.newSpreList[i].id + '">'
                                            + '<img src="'+data.data.newSpreList[i].pictureThumb+'">'
                                            + '<h2>' + data.data.newSpreList[i].headline + '</h2>'
                                            + str
                                            + '<div class="browse-museum"><img src="img/4t.png">' + data.data.newSpreList[i].musExhibition + '</div>'
                                            + '<div class="browse-museum"><img src="img/shuxie.png"><span>编辑人:' + data.data.newSpreList[i].editor + '</span></div>'
                                            + '</a>'
                                            + '</div>';
                                    }
                                    if(data.data.newSpreList.length<6){
                                        $scope.hasMoreBrowse = false;
                                    }else{
                                        $scope.hasMoreBrowse = true;
                                    }
                                    if(data.data.newSpreList.length==0){
                                        $scope.searchNone = true;
                                        $(".dropload-down").hide();
                                    }else{
                                        $scope.searchNone = false;
                                        $(".dropload-down").show();
                                    }
                                    // 为了测试，延迟1秒加载
                                    setTimeout(function () {
                                        $('.browse-top .down-list').append(result);
                                        // 每次数据加载完，必须重置
                                        dropload.resetload();
                                    }, 1000);
                                }).error(function (xhr, type) {
                                //alert('Ajax error!');
                                // 即使加载出错，也得重置
                                dropload.resetload();
                            });
                        };
                        $timeout(function () {
                            $scope.$broadcast('scroll.infiniteScrollComplete');
                        },1000);
                        $scope.loadMore();
                    };
                    $scope.load();
                }
            });
        });
        function showMask(){
            $("#mask").css("height",($(document).height()-$('.content-search').height()));
            $("#mask").css("width",$(document).width());
            $("#mask-bottom").css("height",($(document).height()-$('.content-search').height()));
            $("#mask-bottom").css("width",$(document).width());
        }
        showMask();
        $("header>div").on("touchend",function(){
            $(this).toggleClass("acts");
            $(this).siblings().removeClass("acts");
            if($(".home-browse-area").hasClass('acts')){
                $(".browse-list-city").slideDown();
                $(".zhanxun-list").slideUp();
                $('#mask').show();
                $('#mask').css('top','1.375rem');
            }else if($("header>div:nth-of-type(2)").hasClass('acts')){
                $(".browse-list-city").slideUp();
                $(".browse-city-musueum").slideUp();
                $(".zhanxun-list").slideDown();
                $('#mask').show();
                $('#mask').css('top','1.375rem');
            }else{
                $(".browse-list-city").slideUp();
                $(".browse-city-musueum").slideUp();
                $(".zhanxun-list").slideUp();
                $('#mask').hide();
            }
        });
        $('#mask').on('touchend',function(){
            $(".browse-list-city").slideUp();
            $(".browse-city-musueum").slideUp();
            $(".zhanxun-list").slideUp();
            $('#mask').hide();
        });
    });
