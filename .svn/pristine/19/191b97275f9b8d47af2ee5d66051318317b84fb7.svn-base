
angular.module("moreCollection-controller",['ionic'])
    .controller("goMoreCollection",function($scope,$http,$timeout,$stateParams){
        $rootScope.hideFoot = true;
        $scope.params = {currentPage:$scope.page,
            size:$scope.size,
            collectionUnit:''};
        var page =1;
        var size = 20;
        $scope.cour=function(index){
            $scope.indes = index;
            for(var i=0;i<$scope.detailData.data.orgList.length;i++){
                $scope.detailData.data.orgList[i].isclick=false;
            }
            $scope.detailData.data.orgList[index].isclick=true;
            $(".city-museum").show();
        };
        $scope.boWu=function(e,index){
            for(var i=0;i<$scope.detailData.data.orgList[i].museums[i].length;i++){
                $scope.detailData.data.orgList[i].museums[i].isclick=false;
            }
            $scope.detailData.data.orgList[index].museums[index].isclick=true;
            $(".city-museum i img").eq(index).show();
            //console.log($scope.detailData.data.orgList[indes].museums[indes].name);
            if(e.target.nodeName=='SPAN'){
                $scope.params.collectionUnit=angular.element(e.target).html();
                console.log($scope.params);
            }

            //$(".collection-list-city").slideUp();
            //$(".city-museum").slideUp();
            //console.log($scope.detailData.data.menuList[index].muName);
            //$http.get("../front/OCCollection/info.do?collectionUnit="+$scope.detailData.data.menuList[index].muName+"&currentPage="+page++).
            //    success(function(data){
            //    console.log(data);
            //    $scope.collectionUnitData = data;
            //});
            //var museumName = $scope.detailData.data.orgList[index].museums[index].shortname;
            //$(".collection-top .list a").parent().show();
            //$(".collection-top .list a[brand!="+$scope.detailData.data.orgList[indes].museums[indes].shortname+"]").parent().hide();
            //console.log($(".collection-top .list a[brand!="+$scope.detailData.data.orgList[indes].museums[indes].shortname+"]"));
            $scope.doRefresh();
        };
        $scope.ciqiContent=function(index){
            for (var i = 0;i<$scope.detailData.data.ccList.length;i++) {
                $scope.detailData.data.ccList[i].isclick = false;
            }
            $scope.detailData.data.ccList[index].isclick = true;
            $scope.fenlei = $scope.detailData.data.ccList[index].name;
            $(".collection-top .list a").parent().show();
            $(".collection-top .list a[fenlei!="+$scope.detailData.data.ccList[index].name+"]").parent().hide();
        };
        $scope.chaodaiContent=function(index){
            for (var i = 0;i<$scope.detailData.data.ytList.length;i++) {
                $scope.detailData.data.ytList[i].isclick = false;
            }
            $scope.detailData.data.ytList[index].isclick = true;
            $scope.niandai =  $scope.detailData.data.ytList[index].name;
            $(".collection-top .list a").parent().show();
            $(".collection-top .list a[niandai!="+$scope.detailData.data.ytList[index].name+"]").parent().hide();
        };
        $scope.collectionData = [];

        $scope.getIndex = function(index){
            $scope.collectionDataID = $scope.collectionData.data.mociList[index].mipOpenCulturalrelicInfo.id;
        };

        $scope.doRefresh = function() {
            $scope.params.currentPage = page++;
            $scope.params.size = size;
            $http({
                method:"get",
                url:'../front/OCCollection/info.do',
                params:$scope.params
            })
                .success(function(data) {
                    $scope.collectionData = data;
                    console.log(data);
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
        $(".reset").click(function(){
            $(".ciqi-content p").removeClass("move");
            $scope.fenlei = " ";
            $(".chaodai-content p").removeClass("move");
            $scope.niandai = " ";
            $(".collection-top .list a").parent().show();
        });
        $(function(){
            $scope.page = 2;
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
                loadDownFn : function(me){
                    $scope.params.currentPage = page++;
                    $scope.params.size = size;
                    $scope.loadMore = function () {
                        $http({
                            method:"get",
                            url:'../front/OCCollection/info.do',
                            params:$scope.params
                        })
                            .success(function(data){
                                var result = '';
                                console.log(data);
                                $scope.detailData = data;
                                for(var i = 0; i < data.data.mociList.length; i++){
                                    result +=  '<div class="list" ng-click="detailDate()">'
                                        + '<a class="item item-thumbnail-left"  href="#/collectionDetail/'+data.data.mociList[i].mipOpenCulturalrelicInfo.id+'">'
                                        + '<img src="' + data.data.mociList[i].mipOpenCulturalrelicInfo.fpic + '" alt="">'
                                        + '<h2>' + data.data.mociList[i].mipOpenCulturalrelicInfo.name + '</h2>'
                                        + '<p class="year">' + data.data.mociList[i].mipOpenCulturalrelicInfo.yearType + '</p>'
                                        + '<p class="zhonglei">' + data.data.mociList[i].mipOpenCulturalrelicInfo.collectionsCategory + '</p>'
                                        + '<p class="high">' + data.data.mociList[i].mipOpenCulturalrelicInfo.size + '</p>'
                                        + '<div class="media-box">'
                                        + '<span>3D</span>'
                                        + '<span>视频</span>'
                                        + '<span>语音</span>'
                                        + '</div>'
                                        + '</a>'
                                        + '</div>';
                                }
                                // 为了测试，延迟1秒加载
                                setTimeout(function(){
                                    $('.collection-top .down-list').append(result);
                                    // 每次数据加载完，必须重置
                                    dropload.resetload();
                                },1000);
                            }).
                        error(function(xhr, type){
                            alert('Ajax error!');
                            // 即使加载出错，也得重置
                            dropload.resetload();
                        })
                    };
                    $scope.loadMore();
                }
            });
        });
    });
