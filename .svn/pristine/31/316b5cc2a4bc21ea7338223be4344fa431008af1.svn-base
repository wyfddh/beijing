angular.module("collectionSpecimenDetail",[])
    .controller("CollectionSpecimenDetail",function($scope,$rootScope,$http,$stateParams,$sce,$state){
        $rootScope.hideFoot = false;
        $scope.detailData = [];
        $scope.goBack = function () {
            history.back();
        };
        $http.get('../front/OCFossil/detail.do?id='+$stateParams.id).success(function(data){
            $scope.detailData = data;
            $scope.collectionGsNo = data.data.mofid.mipOpenFossilInfo.gsNo;
            console.log(data);
            $scope.success = data.data.mofid.isCollected;
            if($scope.success == 1){
                $scope.successed = false;
                $scope.successedd = true;
            }else{
                $scope.successedd = false;
                $scope.successed = true;
            }
            $scope.name = data.data.mofid.mipOpenFossilInfo.name;
            $scope.lei = data.data.mofid.mipOpenFossilInfo.collectionsCategory;
            $scope.chaodai = data.data.mofid.mipOpenFossilInfo.yearType;
            $scope.level = data.data.mofid.mipOpenFossilInfo.collectionLevel;
            $scope.danwei = data.data.mofid.mipOpenFossilInfo.collectionUnit;
            $scope.inform = data.data.mofid.mipOpenFossilInfo.description;
            $scope.pic = data.data.mofid.picture.thumb1;

            $('.detail-left-arrow').on('touchend',function(){
                $state.go('collectionSpecimen',{
                    key:$rootScope.cdkey,
                    collectionUnit:$rootScope.collectionUnitID,
                    collectionsCategory:$rootScope.collectionsCategory,
                    yearType:$rootScope.yearType,
                    fenlei:$rootScope.fenlei,
                    niandai:$rootScope.niandai});
            });

            var timeoutflag = 0;
            //$scope.success = true;
            $scope.collectionSuccess = function(){
                if(timeoutflag) {
                    layer.msg('操作太频繁啦！');
                    return;
                }
                timeoutflag = 1;
                timeoutflagfn = setTimeout(function(){
                    timeoutflag = 0;
                },3000);
                $http({
                    method: 'GET',
                    url: '../front/OCCollection/doCollect.do',
                    params: {
                        id: $stateParams.id,
                        collectionType: data.data.mofid.mipOpenFossilInfo.collectionType
                    }
                }).success(function (data) {
                    console.log(data);
                    if (data.success == '0') {
                        layer.msg('请先登录');
                        $state.go('login');
                    } else {
                        layer.msg('收藏成功');
                        //$('.wujiaoxing').attr('src','img/shixinwjx.png');
                        $scope.successed = false;
                        $scope.successedd = true;
                    }
                })
            };
            $scope.collectionSuccessFalse = function(){
                if(timeoutflag) {
                    layer.msg('操作太频繁啦！');
                    return;
                }
                timeoutflag = 1;
                timeoutflagfn = setTimeout(function(){
                    timeoutflag = 0;
                },3000);
                $http({
                    method: 'GET',
                    url: '../front/OCCollection/notCollect.do',
                    params: {
                        id: $stateParams.id,
                        collectionType: data.data.mofid.mipOpenFossilInfo.collectionType
                    }
                }).success(function (data) {
                    console.log(data);
                    if (data.success == '1') {
                        layer.msg('取消收藏成功');
                        $scope.successedd = false;
                        $scope.successed = true;
                    }
                })
            };
            if(data.data.mofid.mipOpenFossilInfo.threeDimensionalCollection==''){
                //$('.isThreeD').hide();
                $scope.isThreeD = false;
            }else{
                //$('.isThreeD').show();
                $scope.isThreeD = true;
            }
            if(data.data.mofid.mipOpenFossilInfo.fVideo==''){
                //$('.isVideo').hide();
                $scope.isVideo = false;
            }else{
                //$('.isVideo').show();
                $scope.isVideo = true;
            }
            if(data.data.mofid.mipOpenFossilInfo.fAudio==''){
                //$('.isAudio').hide();
                $scope.isAudio = false;
            }else{
                //$('.isAudio').show();
                $scope.isAudio = true;
            }
            $scope.toThreeD = function(){
                window.open(data.data.mofid.mipOpenFossilInfo.threeDimensionalCollection);
            };
            $('.audio').on('touchend',function(){
                $(this).toggleClass('start');
                if($(this).hasClass('start')){
                    $(this).attr('src','img/audio.png')
                }else{
                    $(this).attr('src','img/audioClose.png')
                }
            });
            $scope.goDaolan = function(){
                $rootScope.daolanID = data.data.mofid.mipOpenFossilInfo.gsNo;
            };
            $scope.otherMofiList = function(index){
                $state.go('collectionSpecimenDetail',{id:data.data.otherMofiList[index].mipOpenFossilInfo.id});
            };
            $scope.relations = function(index){
                $state.go('collectionSpecimenDetail',{id:data.data.relations[index].mipOpenFossilInfo.id});
            };
            $scope.sce = $sce.trustAsResourceUrl;
            $scope.collectionAudio = data.data.mofid.mipOpenFossilInfo.fAudio;
            (function() {
                var musicC = document.querySelector(".audio");
                var audio = document.querySelector("audio");

                musicC.addEventListener("touchend", function (event) {
                    event.stopPropagation();
                    if (audio.paused) {
                        audio.play();
                        musicC.style.animationPlayState = "running";
                    } else {
                        audio.pause();
                        musicC.style.animationPlayState = "paused";
                    }
                });
            })();

            jwplayer('mediaplayer').setup({
                'flashplayer': 'lib/jwplayer.flash.swf',
                'image':data.data.mofid.picture.thumb3,
                'id': 'playerID',
                'width': '100%',
                'aspectratio':'1:1.76',
                autostart: true,
                'file': data.data.mofid.mipOpenFossilInfo.fVideo
            });
        });
        $(".video").click(function(){
            $(".collectionDetail-box").hide();
            $(".video-box").show();
            $(".tabs-icon-top").hide();
        });
        $(".return").click(function(){
            $(".collectionDetail-box").show();
            $(".video-box").hide();
            $(".tabs-icon-top").show();
        });
        $scope.swiperFn = function(){
            var swiper = new Swiper('.swiper-one.swiper-container', {
                slidesPerView: 3,
                spaceBetween: 30,
                //observer:true,
                //observeParents:true,
                paginationClickable: true,
                loop:false
            });
        };
        $scope.swiperTwoFn = function(){
            var swiper = new Swiper('.swiper-two.swiper-container', {
                slidesPerView: 3,
                spaceBetween: 30,
                //observer:true,
                //observeParents:true,
                paginationClickable: true,
                loop:false
            });
        };
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
}).directive('repeatDo', function() {
    return {
        link: function(scope, element, attrs) {
            //console.log(scope.$last);
            if (scope.$last) {
                // 这个判断意味着最后一个 OK
                scope.$eval(attrs.repeatDo);    // 执行绑定的表达式
            }
        }
    }
});
