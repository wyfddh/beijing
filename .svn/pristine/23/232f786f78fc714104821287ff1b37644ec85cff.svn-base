angular.module("provinceDetail",[])
    .controller("goProvinceDetail",function($scope,$http,$rootScope,$stateParams){
        $rootScope.hideFoot = false;
        $(function(){
            var page = 0;
            var type= 1;
            // 每页展示5个
            var size = 6;
            // dropload
            var dropload = $('.provinceDetail-top .down-list').dropload({
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
                    page++;
                    $scope.loadMore = function () {
                        $http.get('../otherSpreadtrum/getReceptionSpreadtrum.do?currentPage='+page+'&size='+size+'&type='+type)
                            .success(function(data){
                                var result = '';
                                console.log(data);
                                for(var i = 0; i < data.data.length; i++){
                                    //$(".browse-date p[time="+data.data.newSpreList[i].beginTime+"]").hide();
                                    if(data.data[i].staTime == ''){
                                        var str= '';
                                    }else{
                                        var str='<div class="browse-date"><img src="img/1t.png">'+data.data[i].staTime+'-'+data.data[i].overTime+'</div>';
                                    }
                                    result += '<div class="list">'
                                        +'<a class="item item-thumbnail-left" href="#/provinceDetailContent/'+data.data[i].id+'">'
                                        +'<img src="'+data.data[i].pictureThumb+'">'
                                        +'<h2>'+data.data[i].headline+'</h2>'
                                        +str
                                        +'<div class="browse-museum"><img src="img/4t.png">'+data.data[i].musExhibition+'</div>'
                                        +'</a>'
                                        +'</div>';
                                }
                                if(data.data.length<5){
                                    $scope.hasMore = false;
                                }else{
                                    $scope.hasMore = true;
                                }
                                // 为了测试，延迟1秒加载
                                setTimeout(function(){
                                    $('.provinceDetail-top .down-list').append(result);
                                    // 每次数据加载完，必须重置
                                    dropload.resetload();
                                },1000);
                            }).
                        error(function(xhr, type){
                            //alert('Ajax error!');
                            // 即使加载出错，也得重置
                            dropload.resetload();
                        });
                    };
                    $scope.loadMore();
                }
            });
        });
    });
