angular.module("collection-controller",['ionic'])
    .controller("goCollection",function($scope,$rootScope,$http,$timeout,$stateParams,$ionicScrollDelegate){
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
        $rootScope.isMuseum = false;
        $rootScope.isBrowse = false;
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
            $('.homeSearch').val($rootScope.cdkey);
            $('.collection-search').val($rootScope.cdkey);
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
                //$scope.detailData.data.ccList[i].isclick = false;
                $('.ciqi-content li').removeClass('move');
            }
            //$scope.detailData.data.ccList[index].isclick = true;
            $('.ciqi-content li').eq(index).addClass('move');
            $rootScope.collectionsCategory = angular.element(e.target).attr('data-ciqiid');
            $scope.params.collectionsCategory=angular.element(e.target).attr('data-ciqiid');
            $rootScope.fenlei = angular.element(e.target).html();
            $scope.fenlei = angular.element(e.target).html();
            console.log($scope.params);
            //$scope.doRefresh();
        };
         $scope.fenleiAdd = function(){
           //var fenleiName = $rootScope.fenlei;
           // console.log(fenleiName);
           //$('.ciqi-content p:contains("'+fenleiName+'")').addClass('move');
           //  console.log($(".ciqi-content>li[data-ciqiid="+$stateParams.collectionsCategory+"]"));
             $(".ciqi-content>li[data-ciqiid="+$stateParams.collectionsCategory+"]").addClass('move');
           //console.log( $('.ciqi-content p:contains("'+fenleiName+'")'));
        }

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
                    url:'../front/OCCollection/info.do',
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
            for (var i = 0;i<$scope.detailData.data.ytList.length;i++) {
                $scope.detailData.data.ytList[i].isclick = false;
            }
            for (var i = 0;i<$scope.detailData.data.ccList.length;i++) {
                $scope.detailData.data.ccList[i].isclick = false;
            }
            $(".ciqi-content li").removeClass("move");
            $rootScope.fenlei = '';
            $scope.fenlei = '';
            //$(".chaodai-content p").removeClass("move");
            $rootScope.niandai ='';
            $scope.niandai = '';
            if($rootScope.fenlei == ''){
                $scope.doRefresh();
            }else if($rootScope.niandai ==''){
                $scope.doRefresh();
            }
            // $(".collection-top .list a").parent().show();
            // $(".shaixuan-shadow").hide();
            // $(".shaixuan-box").slideUp();
            // $(".body-shaixuan-box").hide();
            // $scope.doRefresh();
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
                                url: '../front/OCCollection/info.do',
                                params: $scope.params
                            })
                                .success(function (data) {
                                    $scope.result = '';
                                    console.log(data);
                                    console.log($scope.params);
                                    $scope.detailData = data;
                                    for (var i = 0; i < data.data.mociList.length; i++) {
                                        if(data.data.mociList[i].mipOpenCulturalrelicInfo.threeDimensionalCollection==''){
                                            var isThreeD = ''
                                        }else{
                                            var isThreeD = '<span class="thirdD"><img src="img/3-d.png" alt=""></span>';
                                        }
                                        if(data.data.mociList[i].mipOpenCulturalrelicInfo.fVideo==''){
                                            var isVideo = ''
                                        }else{
                                            var isVideo = '<span><img src="img/sp.png" alt="" class="sysp"></span>';
                                        }
                                        if(data.data.mociList[i].mipOpenCulturalrelicInfo.fAudio==''){
                                            var isAudio = ''
                                        }else{
                                            var isAudio = '<span><img src="img/yp.png" alt="" class="sysp"></span>';
                                        }
                                        $scope.result += '<div class="list" ng-click="detailDate()">'
                                            + '<a class="item item-thumbnail-left"  href="#/collectionDetail/' + data.data.mociList[i].mipOpenCulturalrelicInfo.id + '">'
                                            + '<img src="'+data.data.mociList[i].picture.thumb3 + '" alt="">'
                                            +'<div>'
                                            + '<h2 class="collectionTitle">' + isThreeD + data.data.mociList[i].mipOpenCulturalrelicInfo.name + '</h2>'
                                            + '<span class="yan"><img src="img/eye.png" alt="" class="yanImg"><span>'+data.data.mociList[i].mipOpenCulturalrelicInfo.clickCounts+'</span></span>'
                                            + '</div>'
                                            +'<div style="clear: both"></div>'
                                            + '<p class="year"><span>朝代:</span>' + data.data.mociList[i].mipOpenCulturalrelicInfo.yearType + '</p>'
                                            + '<p class="zhonglei"><span>类别:</span>' + data.data.mociList[i].mipOpenCulturalrelicInfo.collectionsCategory + '</p>'
                                            + '<div class="collection-media-box">'
                                            +  isVideo
                                            +  isAudio
                                            + '</div>'
                                            + '</a>'
                                            + '</div>';
                                    }
                                    if (data.data.mociList.length == 0) {
                                        $(".dropload-down").hide();
                                    } else {
                                        $(".dropload-down").show();
                                    }
                                    if(data.data.mociList.length<5){
                                        $scope.hasMore = false;
                                    }else{
                                        $scope.hasMore = true;
                                    }
                                    // 为了测试，延迟1秒加载
                                    setTimeout(function () {
                                        $('.collection-top .down-list').append($scope.result);
                                        // 每次数据加载完，必须重置
                                        dropload.resetload();
                                    }, 1000);
                                }).error(function (xhr, type) {
                                //alert('Ajax error!');
                                //// 即使加载出错，也得重置
                                //dropload.resetload();
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
        // $scope.baocunCiqi = function(){
        //     $(".ciqi-content p:contains("+$stateParams.fenlei+")").addClass('move');
        //     console.log($(".ciqi-content p:contains("+$stateParams.fenlei+")"));
        //     console.log($(".ciqi-content p:contains("+$stateParams.fenlei+")").html());
        // }
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
