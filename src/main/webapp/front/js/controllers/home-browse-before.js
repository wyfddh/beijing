angular.module("browseBefore",[])
	.controller("goHomeBrowseBefore",function($scope,$rootScope,$http,$timeout,$stateParams,$ionicScrollDelegate){
	    $rootScope.hideFoot = true;
	    $scope.params = {currentPage:$scope.page,
	        size:$scope.size,
	        cityId:$rootScope.museumDetailId,
	        spreType:0
	    };
        var page =1;
        var size = 5;
        //$scope.browseData = [];
        //$http.get('../front/OCCollection/info.do')
        //    .success(function(data){
        //        console.log(data);
        //        $scope.browseData = data;
        //    });

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
            $(".browse-city-musueum i img").hide();
            $(".browse-city-musueum i img").eq(indes).show();
            $scope.params.cityId=angular.element(e.target).attr('data-cityid');
            console.log($scope.params);
            $('.browse-top .down-list').hide();
            $ionicScrollDelegate.scrollTop();
            $scope.doRefresh();
            $(".browse-list-city").slideUp();
            $(".browse-city-musueum").slideUp();
        };

        $scope.getBrowseIndex = function(index){
            $scope.browseDataID = $scope.homeBrowseData.data.pastSpreList[index].id;
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
                    if(data.data.pastSpreList.length==0){
                        $scope.searchNone = true;
                    }else{
                        $scope.searchNone = false;
                    }
                    if(data.data.pastSpreList.length<5){
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
                                    for (var i = 0; i < data.data.pastSpreList.length; i++) {
                                        //$(".browse-date p[time="+data.data.newSpreList[i].beginTime+"]").hide();
                                        if (data.data.pastSpreList[i].staTime == '') {
                                            var str = '';
                                        } else {
                                            var str = '<div class="browse-date"><img src="img/1t.png">' + data.data.pastSpreList[i].staTime + '-' + data.data.pastSpreList[i].overTime + '</div>';
                                        }
                                        result += '<div class="list">'
                                            + '<a class="item item-thumbnail-left" href="#/browseDetail/' + data.data.pastSpreList[i].id + '">'
                                            + '<img src="'+data.data.pastSpreList[i].pictureThumb+'">'
                                            + '<h2>' + data.data.pastSpreList[i].headline + '</h2>'
                                            + str
                                            + '<div class="browse-museum"><img src="img/4t.png">' + data.data.pastSpreList[i].musExhibition + '</div>'
                                            +'<div class="browse-museum"><img src="img/shuxie.png"><span>编辑人:'+ data.data.pastSpreList[i].editor +'</span></div>'
                                            + '</a>'
                                            + '</div>';
                                    }
                                    if(data.data.pastSpreList.length<5){
                                        $scope.hasMore = false;
                                    }else{
                                        $scope.hasMore = true;
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
    });
