angular.module("daolan",[])
    .controller("goDaolan",function($scope,$rootScope,$http,$stateParams,$state,$sce){
        $rootScope.hideFoot = true;
        console.log($stateParams.gsNo);
        $http({
            method:'GET',
            url:'../front/OCCollection/toDaoLan.do',
            params:{gsNo:$stateParams.gsNo}
        }).success(function(data) {
            console.log(data);
            $scope.collectionData = data;
            $scope.collectionID = data.mipOpenCulturalrelicInfo.id;
            $scope.daolanName = data.mipOpenCulturalrelicInfo.name;
            $scope.danwei = data.mipOpenCulturalrelicInfo.collectionUnit;
            $scope.niandai = data.mipOpenCulturalrelicInfo.yearType;
            $scope.daolanPic = data.picture.thumb1;
            $scope.suoluetu = data.picture.thumb3;
            $scope.sce = $sce.trustAsResourceUrl;
            $scope.daolanMusic = data.mipOpenCulturalrelicInfo.fAudio;
            $scope.daolanVideo = data.mipOpenCulturalrelicInfo.fVideo;
            $scope.daolanContent = data.mipOpenCulturalrelicInfo.description;
            if(data.mipOpenCulturalrelicInfo.description =='-109'){
                $state.go('waiting');
            }
            console.log(data);
            var musicC = document.querySelector(".music-c");
            var musicNote = document.querySelector(".music-note");
            var audio = document.querySelector("audio");
            if($scope.daolanMusic!=''){
                audio.play();
                musicNote.style.zIndex = 2;
                musicC.style.animationPlayState = "running";
            }
            //http://assets.jq22.com/plugin/2016-04-25-11-04-36.jpg
            jwplayer('mediaplayer').setup({
                'flashplayer': 'lib/jwplayer.flash.swf',
                'image':data.picture.thumb3,
                'id': 'playerID',
                'width': '100%',
                'aspectratio':'10:6',
                'file':data.mipOpenCulturalrelicInfo.fVideo,
                autostart:'muted',
                modes : [

                    { type : "flash" , src : "lib/jwplayer.flash.swf" , config : {

                        file : "video.mp4" ,

                        streamer : "rtmp://rtmp.server.com/videos" ,

                        provider : "rtmp"

                    }

                    },

                    { type : "html5" , config : {

                        file : "http://server.com/videos/video.mp4"

                    }

                    },

                    { type : "download" }

                ]
            });
        }).error(function(data){
            console.log(data);
        });

        (function() {
            var musicC = document.querySelector(".music-c");
            if(typeof(musicC)=="undefined"){
	            var musicNote = document.querySelector(".music-note");
	            var audio = document.querySelector("audio");
	
	            musicC.addEventListener("touchend", function (event) {
	                event.stopPropagation();
	                if (audio.paused) {
	                    audio.play();
	                    musicNote.style.zIndex = 2;
	                    musicC.style.animationPlayState = "running";
	                } else {
	                    musicNote.style.zIndex = -1;
	                    audio.pause();
	                    musicC.style.animationPlayState = "paused";
	                }
	            });
	        }
        })();

        //点击显示大图
        $scope.showBigPic = function (e) {
            // alert(document.documentElement.clientWidth);
            // alert(document.documentElement.clientHeight);
            $scope.thisImg = angular.element(e.target);
            $scope.width = $scope.thisImg.width;
            $scope.height = $scope.thisImg.height;
            // console.log($scope.thisImg);
            // console.log($scope.width);
            // console.log($scope.height);
            //拿到图片的URL
            $scope.ImgSrc = $scope.thisImg[0].currentSrc;
            $scope.imgHeight = parseFloat($scope.thisImg[0].clientHeight);
            $scope.imgWight = parseFloat($scope.thisImg[0].clientWidth);
            $scope.imgId = $scope.thisImg[0].id;
            $("#imgCoverWrap").css({display:'block'});
            //如果宽大于高
            if($scope.imgWight > $scope.imgHeight){
                $("#imgCoverWrap img").addClass('rotateDeg');
            }else {

            }
            // layer.open({
            //     type: 1,
            //     style: 'position:fixed; left:0; top:0; width:100%; height:100%; border: none; -webkit-animation-duration: .5s; animation-duration: .5s;',
            //     // area: ['100%', '100%'], //宽高
            //     content: '<img src="'+$scope.ImgSrc+'">'
            // });
            // layer.photos({
            //     photos: {
            //         "title": "", //相册标题
            //         "id": "", //相册id
            //         "start": 0, //初始显示的图片序号，默认0
            //         "data": [   //相册包含的图片，数组格式
            //             {
            //                 "alt": $scope.daolanName,
            //                 "pid": $scope.imgId, //图片id
            //                 "src": $scope.ImgSrc, //原图地址
            //                 "thumb": $scope.suoluetu //缩略图地址
            //             }
            //         ]
            //     }, //格式见API文档手册页
            //     anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机
            // });
        };
        //点击图片收回去
        $scope.hideCover = function () {
            $("#imgCoverWrap").css({display:'none'});
        }
    });
