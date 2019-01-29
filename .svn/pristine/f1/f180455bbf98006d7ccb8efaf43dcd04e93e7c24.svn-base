angular.module("museumDetail",[])
    .controller("goMuseumDetail",function($scope,$rootScope,$http,$stateParams,$window,$state,$sce){
        $rootScope.hideFoot = false;
        $http.get('../front/OCCollection/info.do').success(function(data){
            $scope.detailData = data;
            console.log(data);
        });
        // alert($scope.museumDetailData.data.culList[0].mipOpenCulturalrelicInfo.collectionUnit);

        $('.detail-left-arrow').on('touchend',function(){
            // $state.go('museum',{
            //     museumName:$rootScope.museumName,
            //     orgId:$rootScope.orgId,
            //     categoryId:$rootScope.categoryId,
            //     flag:$rootScope.flag
            // });
            history.back(-1);
        });
        $rootScope.isMuseum = true;
        $("#mask").click(function(){
            $("#mask-bottom").hide();
            $(".museum-jieshao").hide();
            $(".museum-buyTicket").hide();
            $(".museum-nearby").hide();
            $(".museum-visitNotes").hide();
            $(".museum-serviceInformation").hide();
            $("#mask").hide();
        });
        $scope.changguanjieshao = function(){
            $("#mask-bottom").show();
            $(".museum-jieshao").show();
            $("#mask").show();
        };
        $scope.howBuyTicket = function(){
            $("#mask-bottom").show();
            $(".museum-buyTicket").show();
            $("#mask").show();
            $(".museum-buyTicket-head").find('img').attr('src','img/ticket.png');
            $scope.buyTicket = $scope.museumDetailData.data.museumInfo.buyTicket;
        };
        $scope.aroundService = function(){
            $("#mask-bottom").show();
            $(".museum-nearby").show();
            $("#mask").show();
            $(".museum-nearby-head").find('img').attr('src','img/around.png');
            $scope.nearby = $scope.museumDetailData.data.museumInfo.nearby;
        };
        $scope.howLooking = function(){
            $("#mask-bottom").show();
            $(".museum-visitNotes").show();
            $("#mask").show();
            $(".museum-visitNotes-head").find('img').attr('src','img/looking.png');
            $scope.visitNotes = $scope.museumDetailData.data.museumInfo.visitNotes;
        };
        $scope.howService = function(){
            $("#mask-bottom").show();
            $(".museum-serviceInformation").show();
            $("#mask").show();
            $(".museum-serviceInformation-head").find('img').attr('src','img/service.png');
            $scope.serviceInformation = $scope.museumDetailData.data.museumInfo.serviceInformation;
        };
        function showMask(){
            $("#mask").css("height",$(document).height());
            $("#mask").css("width",$(document).width());
            $("#mask-bottom").css("height",$(document).height());
            $("#mask-bottom").css("width",$(document).width());
        }
        showMask();
        $http.get('../museuminfo/getMuseum.do?orgId='+$stateParams.id).success(function(data){ 
            $scope.museumDetailData = data;
            //$scope.toFake = data.data.virList.viMoveUrl;
            console.log(data);
            $scope.free = false;
            if(data.data.museumInfo.ticket==1){
                $scope.free = true;
            }else{
                $scope.free = false;
            }
            $scope.sce = $sce.trustAsResourceUrl;
            $scope.levelMuseum = data.data.museumInfo.levelName;
            $scope.museumDetailHead = data.data.museumInfo.museumName;
            $scope.introduce = data.data.museumInfo.introduce;
            $scope.address = data.data.museumInfo.address;
            $scope.openingHours = data.data.museumInfo.openingHours;
            $scope.fAudio = data.data.museumInfo.audioPath;
            $scope.fakeImg = data.data.virList.pictureThumb;
            $scope.viName = data.data.virList.viName;
            $scope.viIntro = data.data.virList.viIntro;
            $scope.zhanxunContentPic = data.data.spreList.pictureThumb;
            $scope.headline = data.data.spreList.headline;
            $scope.musExhibition = data.data.spreList.musExhibition;
            $scope.staTime = data.data.spreList.staTime;
            $scope.overTime = data.data.spreList.overTime;
            $scope.browseId = data.data.spreList.id;
            $scope.editor = data.data.spreList.editor;
            $scope.sprSize = parseInt(data.data.sprSize);      //有多少个展览
            $scope.virSize = parseInt(data.data.virSize);       //有多少个虚拟展厅
            $scope.showSprSize = ($scope.sprSize > 1);
            $scope.showVirSize = ($scope.sprSize > 1);
            $scope.getIndex = function(index){
                $scope.collectionId = data.data.culList[index].mipOpenCulturalrelicInfo.id;
            };
            if(data.data.spreList.staTime==''){
                $scope.isStaTime = false;
            }else{
                $scope.isStaTime = true;
            }
//            if($scope.fAudio!=''){
//                var musicC = document.querySelector(".music-c");
//                var musicNote = document.querySelector(".music-note");
//                var audio = document.querySelector("audio");
//                audio.play();
//                musicNote.style.zIndex = 2;
//                musicC.style.animationPlayState = "running";
//            }
            var map = data.data.museumInfo.geography;
            console.log(map);
            var width=$window.screen.width;
            var height=$window.screen.height;
            $('#map').width(width);
            $('#map').height(height);
            var reg1=/(width=\"?\d*\"?)/g;
            var reg2=/(height=\"?\d*\"?)/g;
            var map1=map.replace(reg1,'width='+width);
            var map2=map1.replace(reg1,'height='+height);
           angular.element('#map').attr('src',map2);
        });



        $scope.goBrowse = function(){
            $rootScope.museumDetailId = $scope.museumDetailData.data.spreList.orgId;
        };
        $scope.goVirtual = function(){
            $rootScope.virtualId =  $scope.museumDetailData.data.virList.orgId;
        };
        $scope.goCollect = function(){
            // alert($scope.museumDetailData.data.museumInfo.orgId);
            $rootScope.collectionUnitID = $scope.museumDetailData.data.museumInfo.orgId;
        };


        $scope.toMap = function(){
            $(".museumDetail-Box").hide();
            $(".baidumap").show();
            $(".tabs-icon-top").hide();
        };
        $(".mapReturn").click(function(){
            $(".museumDetail-Box").show();
            $(".baidumap").hide();
            $(".tabs-icon-top").show();
        });
        $scope.swiperFn = function () {
            var swiper = new Swiper('.museumdetailPic.swiper-container', {
                pagination: '.swiper-pagination',
                paginationClickable: true,
                spaceBetween: 30,
                effect: 'fade',
                // observer:true,
                // observeParents:true,
                autoplay:2000,
                autoplayDisableOnInteraction : false
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
});
