angular.module("collectionSpecimen-controller",['ionic'])
    .controller("goCollectionSpecimen",function($scope,$rootScope,$http,$timeout,$stateParams,$ionicScrollDelegate){
        $rootScope.hideFoot = true;
        $scope.params = {currentPage:$scope.page,
            size:$scope.size,
            collectionUnit:$rootScope.collectionUnitID,
            yearType:$rootScope.yearType,
            collectionsCategory:$rootScope.collectionsCategory,
            key:$rootScope.cdkey,
            order:'',
            fenlei:$rootScope.fenlei,
            niandai:$rootScope.niandai};
        var page =1;
        var size = 5;
        $rootScope.isCollect = true;
        $scope.search=function(e,index) {
            if (e.target.nodeName == 'SPAN') {
                $scope.params.key = angular.element(e.target).prev().prev().val();
                $rootScope.cdkey = $scope.params.key;
                console.log($scope.params);
            }
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
            $('.home-search-area').hide();
            $('.collection-bigBox').show();
            $('.homeSearch').val($scope.params.key);
            $('.collection-search').val($scope.params.key);
        };
        $('.qingchu').on('touchend',function(){
            $('.homeSearch').val('');
            $('.collection-search').val('');
            $(this).hide();
            $scope.params.key = '';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });
        //$scope.collectionKey = function(){
        //    return $scope.params.key;
        //};
        $('.collection-search').on('focus',function(){
            $('.home-search-area').show();
            $('.collection-bigBox').hide();
        });
        $('.homeBack').on('touchend',function(){
            $('.home-search-area').hide();
            $('.collection-bigBox').show();
        });
        $scope.isHsVal = function(){
            if($scope.hsVal ==''){
                $('.qingchu').hide();
            }else{
                $('.qingchu').show();
            }
        };
        function showMask(){
            $("#mask").css("height",$(document).height());
            $("#mask").css("width",$(document).width());
            $("#mask-bottom").css("height",$(document).height());
            $("#mask-bottom").css("width",$(document).width());
        }
        showMask();
        $scope.cour=function(index){
            $scope.indes = index;
            for(var i=0;i<$scope.detailData.data.orgList.length;i++){
                $scope.detailData.data.orgList[i].isclick=false;
            }
            $scope.detailData.data.orgList[index].isclick=true;
            $(".city-museum").show();
        };
        $scope.boWu=function(e,index){
            //for(var i=0;i<$scope.detailData.data.orgList[i].museums[i].length;i++){
            //    $scope.detailData.data.orgList[i].museums[i].isclick=false;
            //}
            //$scope.detailData.data.orgList[index].museums[index].isclick=true;
            //$(".city-museum i img").hide();
            //$(".city-museum i img").eq(index).show();
            $('.city-museum li').removeClass('selected');
            $('.city-museum li').eq(index+1).addClass('selected');
            //console.log($scope.detailData.data.orgList[indes].museums[indes].name);
            $rootScope.collectionUnitID = angular.element(e.target).attr('data-cityid');
            $scope.params.collectionUnit=angular.element(e.target).attr('data-cityid');
            console.log($scope.params);
            $(".collection-list-city").slideUp();
            $(".city-museum").slideUp();
            $('#mask').hide();
            $('.collection-search-box').show();
            $('.collection-top').css('top','2.5rem');
            $(".body-shaixuan-box").hide();
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        };
        $scope.ciqiContent=function(e,index){
            for (var i = 0;i<$scope.detailData.data.ccList.length;i++) {
                $scope.detailData.data.ccList[i].isclick = false;
            }
            $scope.detailData.data.ccList[index].isclick = true;

            $rootScope.collectionsCategory = angular.element(e.target).attr('data-ciqiid');
            $scope.params.collectionsCategory=angular.element(e.target).attr('data-ciqiid');
            $rootScope.fenlei = angular.element(e.target).html();
            $scope.fenlei = angular.element(e.target).html();
            console.log($scope.params);
            //$scope.doRefresh();
        };
        $scope.chaodaiContent=function(e,index){
            for (var i = 0;i<$scope.detailData.data.ytList.length;i++) {
                $scope.detailData.data.ytList[i].isclick = false;
            }
            $scope.detailData.data.ytList[index].isclick = true;

            $rootScope.yearType = angular.element(e.target).attr('data-chaodaiid');
            $scope.params.yearType=angular.element(e.target).attr('data-chaodaiid');
            $rootScope.niandai = angular.element(e.target).html();
            $scope.niandai = angular.element(e.target).html();
            console.log($scope.params);
            //$scope.doRefresh();
        };
        $scope.collectionData = [];

        $scope.getIndex = function(index){
            $scope.collectionDataID = $scope.collectionData.data.mociList[index].mipOpenCulturalrelicInfo.id;
        };

        $scope.doRefresh = function() {
            //$scope.params.currentPage = page++;
            $scope.params.size = size;
            $http({
                method:"get",
                url:'../front/OCFossil/info.do',
                params:$scope.params
            })
                .success(function(data) {
                    $scope.collectionData = data;
                    console.log(data);
                    if(data.data.mociList.length==0){
                        $scope.searchNone = true;
                    }else{
                        $scope.searchNone = false;
                    }
                    if(data.data.mociList.length<5){
                        $scope.hasMore = false;
                    }else{
                        $scope.hasMore = true;
                    }
                })
                .finally(function() {
                    $timeout(function () {
                        $scope.$broadcast('scroll.refreshComplete');
                    },1000)
                });
        };

        $scope.detailData = [];
//        $scope.detailData = function(){
//        	$http.get('../front/OCCollection/info.do?id='+$stateParams.id).success(function(data){
//        		$scope.detailData = data;
//        	});
//        }
        $scope.reset = function(){
            $scope.params.yearType='';
            $scope.params.collectionsCategory='';
            $scope.params.key='';
            console.log($scope.params);
            $(".ciqi-content li").removeClass("move");
            $rootScope.fenlei = '';
            $scope.fenlei = " ";
            $(".chaodai-content p").removeClass("move");
            $rootScope.niandai ='';
            $scope.niandai = " ";
            if($rootScope.fenlei == ''){
                $scope.doRefresh();
            }else if($rootScope.niandai ==''){
                $scope.doRefresh();
            }
            // $(".collection-top .list a").parent().show();
            // $(".shaixuan-shadow").hide();
            // $(".shaixuan-box").slideUp();
            // $(".body-shaixuan-box").hide();
            //$scope.doRefresh();
            $(".body-shaixuan-box").hide();
            $(".shaixuan-box").slideUp();
            $('.collection-search-box').show();
            $('.collection-top').css('top','2.5rem');
            $(".collection-list-city").slideUp();
            $(".city-museum").slideUp();
            $('#mask').hide();
        };
        $(".city-museum li:first-child").click(function(){
            $(".city-museum i img").hide();
            $('.collection-list-city li').removeClass('selected');
            $('.city-museum li').removeClass('selected');
            $scope.params.collectionUnit='';
            console.log($scope.params);
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
            $(".collection-list-city").slideUp();
            $(".city-museum").slideUp();
            $('#mask').hide();
            $('.collection-search-box').show();
            $('.collection-top').css('top','2.5rem');
            $(".body-shaixuan-box").hide();
        });
        $(function(){
            $scope.page = 1;
            // 每页展示5个
            $scope.size = 5;
            // dropload
            var dropload = $('.collection-top .down-list').dropload({
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
                    $scope.load = function(){
                        $scope.params.currentPage = page++;
                        $scope.params.size = size;
                        $scope.loadMore = function () {
                            $http({
                                method: "get",
                                url: '../front/OCFossil/info.do',
                                params: $scope.params
                            })
                                .success(function (data) {
                                    var result = '';
                                    console.log(data);
                                    $scope.detailData = data;
                                    for (var i = 0; i < data.data.mociList.length; i++) {
                                        if(data.data.mociList[i].mipOpenFossilInfo.threeDimensionalCollection==''){
                                            var isThreeD = ''
                                        }else{
                                            var isThreeD = '<span>3D</span>';
                                        }
                                        if(data.data.mociList[i].mipOpenFossilInfo.fVideo==''){
                                            var isVideo = ''
                                        }else{
                                            var isVideo = '<span>视频</span>';
                                        }
                                        if(data.data.mociList[i].mipOpenFossilInfo.fAudio==''){
                                            var isAudio = ''
                                        }else{
                                            var isAudio = '<span>语音</span>';
                                        }
                                        result += '<div class="list" ng-click="detailDate()">'
                                            + '<a class="item item-thumbnail-left" niandai="' + data.data.mociList[i].mipOpenFossilInfo.yearType + '" fenlei="' + data.data.mociList[i].mipOpenFossilInfo.collectionsCategory + '" brand="' + data.data.mociList[i].mipOpenFossilInfo.collectionUnit + '" href="#/collectionSpecimenDetail/' + data.data.mociList[i].mipOpenFossilInfo.id + '">'
                                            + '<img src="'+data.data.mociList[i].picture.thumb3 + '" alt="">'
                                            + '<h2>' + data.data.mociList[i].mipOpenFossilInfo.name + '</h2>'
                                            + '<p class="year">' + data.data.mociList[i].mipOpenFossilInfo.yearType + '</p>'
                                            + '<p class="zhonglei">' + data.data.mociList[i].mipOpenFossilInfo.collectionsCategory + '</p>'
                                            + '<div class="collection-media-box">'
                                            +  isThreeD
                                            +  isVideo
                                            +  isAudio
                                            + '</div>'
                                            + '</a>'
                                            + '</div>';
                                    }
                                    if(data.data.mociList.length<5){
                                        $scope.hasMore = false;
                                    }else{
                                        $scope.hasMore = true;
                                    }
                                    // 为了测试，延迟1秒加载
                                    setTimeout(function () {
                                        $('.collection-top .down-list').append(result);
                                        // 每次数据加载完，必须重置
                                        dropload.resetload();
                                    }, 1000);
                                }).error(function (xhr, type) {
                                //alert('Ajax error!');
                                // 即使加载出错，也得重置
                                dropload.resetload();
                            })
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
        $(".danwei").on("touchend",function(){
            $(this).toggleClass("acts");
            $(this).siblings().removeClass("acts");
            if($(this).hasClass('acts')){
                $(".collection-list-city").slideDown();
                $('#mask').show();
                $('.collection-search-box').hide();
                $('.collection-top').css('top','1rem');
                $('#mask').css('top','1rem');
                $(".body-shaixuan-box").hide();
            }else{
                $(".collection-list-city").slideUp();
                $(".city-museum").slideUp();
                $('#mask').hide();
                $('.collection-search-box').show();
                $('.collection-top').css('top','2.5rem');
                $(".body-shaixuan-box").hide();
            }
        });
        $scope.params.order = 2;
        $scope.newest = function(){
            $(".newest span").toggleClass("show");
            console.log($scope.params);
            if($scope.params.order == 1){
                $scope.params.order = 2;
                $('.down-list .list').hide();
                $ionicScrollDelegate.scrollTop();
                $scope.doRefresh();
            }else{
                $scope.params.order = 1;
                $('.down-list .list').hide();
                $ionicScrollDelegate.scrollTop();
                $scope.doRefresh();
            }
        };
        $(".shaixuan").on("touchend",function(){
            $(".body-shaixuan-box").show();
            $('#mask').show();
            $('.collection-search-box').hide();
            $('.collection-top').css('top','1rem');
            $(".body-shaixuan-box").css({'top':'1rem','right':'0'});
            $('#mask').css('top','1rem');
            //$(".shaixuan-shadow").show();
            $(".shaixuan-box").slideDown();
            $(".collection-list-city").slideUp();
            $(".city-museum").slideUp();
        });
        $('#mask').on('touchend',function(){
            $(".body-shaixuan-box").hide();
            $(".shaixuan-box").slideUp();
            $('.collection-search-box').show();
            $('.collection-top').css('top','2.5rem');
            $(".collection-list-city").slideUp();
            $(".city-museum").slideUp();
            $('#mask').hide();
        });
        $(".enter").on("touchend",function(){
            //$(".shaixuan-shadow").hide();
            $(".shaixuan-box").slideUp();
            $('#mask').hide();
            $('.collection-search-box').show();
            $('.collection-top').css('top','2.5rem');
            $(".body-shaixuan-box").hide();
            $('.down-list .list').hide();
            $('#mask').hide();
            $('.collection-search-box').show();
            $('.collection-top').css('top','2.5rem');
            $(".body-shaixuan-box").hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
        });


        //$(function() {
        //    var page = 0;
        //    // 每页展示5个
        //    var size = 5;
        //
        //    // dropload
        //    $('.collection-top').dropload({
        //        scrollArea: window,
        //        loadDownFn: function (me) {
        //            page++;
        //            // 拼接HTML
        //            var result = '';
        //            $scope.loadMore = function () {
        //                $http.get('json/collection.json')
        //                    .success(function (data) {
        //                        var arrLen = data.data.mociList.length;
        //                            for (var i = 0; i < arrLen; i++) {
        //                                result += '<div class="list">'
        //                                    + '<a class="item item-thumbnail-left">'
        //                                    + '<img src="' + data.data.mociList[i].fpic + '" alt="">'
        //                                    + '<h2>' + data.data.mociList[i].name + '</h2>'
        //                                    + '<p class="year">唐（公元618~907年）</p>'
        //                                    + '<p class="zhonglei">青铜器</p>'
        //                                    + '<p class="high">高12cm</p>'
        //                                    + '<div class="media-box">'
        //                                    + '<span>3D</span>'
        //                                    + '<span>视频</span>'
        //                                    + '<span>语音</span>'
        //                                    + '</div>'
        //                                    + '</a>'
        //                                    + '</div>';
        //                            }
        //                        // 为了测试，延迟1秒加载
        //                        setTimeout(function () {
        //                            // 插入数据到页面，放到最后面
        //                            $('.collection-top').append(result);
        //                            // 每次数据插入，必须重置
        //                            me.resetload();
        //                        }, 1000);
        //                    })
        //                    .error(function (xhr, type) {
        //                        alert('Ajax error!');
        //                        // 即使加载出错，也得重置
        //                        me.resetload();
        //                    });
        //            }
        //        }
        //
        //    });
        //});
        //var pagination = $scope.pagination = {
        //    size:10,
        //    currentPage:1
        //};//获取分页信息
        //var pageSize = $scope.pagination.size;
        //var currentPage = $scope.pagination.currentPage++;
        //$scope.selectedcondition = {year: 'all', unit: 'all', area: 'all', classify: 'all', sort: '最新'};
        //
        //$scope.isHaveMoreData = false;
        ////{pageSize: $scope.pagination.size, currentPage: $scope.pagination.currentPage++}  +JSON.stringify($scope.selectedcondition)
        //$scope.loadMore = function() {
        //    $http.get("json/collection.json")
        //        .success(function (data) {
        //            //console.log(data);
        //            if (data.length == 0) {
        //                $scope.isHaveMoreData = true;
        //                return;
        //            }
        //            $scope.collectionData = data;
        //            //Array.prototype.push.apply($scope.collectionData, data);
        //        })
        //        .finally(function () {
        //            $timeout(function () {
        //                $scope.$broadcast("scroll.infiniteScrollComplete");
        //            }, 2000);
        //        });
        //};
        //$scope.loadMore();
        //$scope.$on('goCollection', function() {
        //
        //});
    });
