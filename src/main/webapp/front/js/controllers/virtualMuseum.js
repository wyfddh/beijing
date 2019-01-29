angular.module("virtual-museum",[])
    .controller("virtualMuseum",function($scope,$rootScope,$state,$http,$timeout,$stateParams) {
        $rootScope.hideFoot = true;
        $scope.isActive = true;
        //$state.go("cezhan.hot");
        $scope.params = {
            currentPage: $scope.page,
            size: $scope.size,
            flag: '',
            orgId: $rootScope.virtualId
        };
        var page = 1;
        var size = 6;
        //var hotFlag =2;
        $(".virtual-cezhan-table div:first-child").click(function () {
            $(".new-top").hide();
            $(".hot-top").show();
        });
        $(".virtual-cezhan-table div:last-child").click(function () {
            $(".hot-top").hide();
            $(".new-top").show();
            $('.new-top .down-list').html('');
            $scope.newVirtual();
        });
        $scope.newVirtual = function () {
                var page = 1;
                var size = 6;
                var newFlag = 1;
            $scope.page = 1;
            // 每页展示5个
            $scope.size = 6;
            // dropload
            var dropload = $('.new-top .down-list').dropload({
                domUp: {
                    domClass: 'dropload-up',
                    domRefresh: '<div class="dropload-refresh">↓下拉刷新</div>',
                    domUpdate: '<div class="dropload-update">↑释放更新</div>',
                    domLoad: '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
                },
                domDown: {
                    domClass: 'dropload-down',
                    domRefresh: '<div class="dropload-refresh"></div>',
                    domLoad: '<div class="dropload-load"><span class="loading"></span>加载中...</div>',
                    domNoData: '<div class="dropload-noData">暂无数据</div>'
                },
                loadDownFn: function (me) {
                    $scope.load = function () {
                        $scope.params.currentPage = page++;
                        $scope.params.size = size;
                        $scope.params.flag = 1;
                        $scope.params.orgId = '';
                        $scope.loadMore = function () {
                            $http({
                                method: "get",
                                url: '../virtual/getPCVirtual.do',
                                params: $scope.params
                            })
                                .success(function (data) {
                                    var result = '';
                                    console.log(data);
                                    $scope.virtualData = data;
                                    for (var i = 0; i < data.data.length; i++) {
                                        result += '<div class="list">'
                                            + '<a class="item item-thumbnail-left" href="' + data.data[i].viMoveUrl + '">'
                                            + '<img src="' + data.data[i].viAddress + '">'
                                            + '<h2>' + data.data[i].viName + '</h2>'
                                            + '<p>' + data.data[i].viIntro + '</p>'
                                            + '</a>'
                                            + '</div>'
                                    }
                                    if (data.data.length < 6) {
                                        $scope.hasVirtual = false;
                                    } else {
                                        $scope.hasVirtual = true;
                                    }
                                    // 为了测试，延迟1秒加载
                                    setTimeout(function () {
                                        $('.new-top .down-list').append(result);
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
                        }, 1000);
                        $scope.loadMore();
                    };
                    $scope.load();
                }
            });
        };
        // });
        $(function(){
            $scope.page = 1;
            // 每页展示5个
            $scope.size = 6;
            // dropload
            var dropload = $('.hot-top .down-list').dropload({
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
                        $scope.params.flag = 2;
                        $scope.params.orgId = '';
                        $scope.loadMore = function () {
                            $http({
                                method: "get",
                                url: '../virtual/getPCVirtual.do',
                                params: $scope.params
                            })
                                .success(function (data) {
                                    var result = '';
                                    console.log(data);
                                    $scope.virtualData = data;
                                    for (var i = 0; i < data.data.length; i++) {
                                        result += '<div class="list">'
                                            + '<a class="item item-thumbnail-left" href="' + data.data[i].viMoveUrl + '">'
                                            + '<img src="' + data.data[i].viAddress + '">'
                                            + '<h2>' + data.data[i].viName + '</h2>'
                                            + '<p>' + data.data[i].viIntro + '</p>'
                                            + '</a>'
                                            + '</div>'
                                    }
                                    // if (data.data.length == 0) {
                                    //     $(".dropload-down").hide();
                                    // } else {
                                    //     $(".dropload-down").show();
                                    // }
                                    if(data.data.length<6){
                                        $scope.hasVirtual = false;
                                    }else{
                                        $scope.hasVirtual = true;
                                    }
                                    // 为了测试，延迟1秒加载
                                    setTimeout(function () {
                                        $('.hot-top .down-list').append(result);
                                        // 每次数据加载完，必须重置
                                        dropload.resetload();
                                        //$('.hot-top .list').on('touchend',function(){
                                        //    num = $(this).index();
                                        //    $http.get('../virtual/addOnclick.do?id=' + $scope.virtualData.data[num].orgId)
                                        //        .success(function (data) {
                                        //            console.log(data);
                                        //        })
                                        //});
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
    });
