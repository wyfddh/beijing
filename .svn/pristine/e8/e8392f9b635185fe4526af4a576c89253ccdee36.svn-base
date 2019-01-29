angular.module("daolanSpecimen",[])
    .controller("goDaolanSpecimen",function($scope,$http,$stateParams){
        $http.get('../front/OCCollection/toDaoLan.do?gsNo='+$stateParams.gsNo).success(function(data) {
            $rootScope.hideFoot = true;
            $scope.collectionData = data;
            console.log(data);
            $scope.daolanName = data.mipOpenFossilInfo.name;
            $scope.collectionID = data.mipOpenFossilInfo.id;
            $scope.daolanPic = data.picture.thumb1;
            //http://assets.jq22.com/plugin/2016-04-25-11-04-36.jpg
            jwplayer('mediaplayer').setup({
                'flashplayer': 'lib/jwplayer.flash.swf',
                'image':data.picture.thumb1,
                'id': 'playerID',
                'width': '100%',
                'aspectratio':'10:6',
                'file': data.mipOpenFossilInfo.fVideo,
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
        });

        (function() {
            var musicC = document.querySelector(".music-c");
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
        })()
    });
