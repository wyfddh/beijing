angular.module("browseDetail",[])
    .controller("goBrowseDetail",function($scope,$rootScope,$http,$stateParams,$sce){
        $rootScope.hideFoot = false;
        $scope.backMuseumDetail = function(){
            $rootScope.isMuseum = true;
            $rootScope.isBrowse = false;
        };
        $http.get("../spreadtrum/getOneSpreadtrum.do?type=2&id="+$stateParams.id)
            .success(function(data){
               console.log(data);
               $scope.sce = $sce.trustAsResourceUrl;
                $scope.toMuseumDetail = data.data.orgId;
                $scope.head = data.data.headline;
                $scope.name = data.data.musExhibition;
                $scope.editor = data.data.editor;
                $scope.time = data.data.staTime+'--'+data.data.overTime;
                $scope.fAudio = data.data.fAudio;
                $scope.viMoveUrl = data.data.viMoveUrl;
                if(data.data.staTime == ''){
                    $scope.Time = false;
                }else{
                    $scope.Time = true;
                }
                $scope.content = data.data.content;
//                if($scope.fAudio!=''){
//                    var musicC = document.querySelector(".music-c");
//                    var musicNote = document.querySelector(".music-note");
//                    var audio = document.querySelector("audio");
//                    audio.play();
//                    musicNote.style.zIndex = 2;
//                    musicC.style.animationPlayState = "running";
//                }
            });
    });