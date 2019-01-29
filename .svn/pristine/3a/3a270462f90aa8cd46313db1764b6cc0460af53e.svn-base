angular.module("foreignDetailContent",[])
    .controller("goForeignDetailContent",function($scope,$http,$stateParams){
        $rootScope.hideFoot = false;
        $http.get("../otherSpreadtrum/getOneData.do?id="+$stateParams.id)
            .success(function(data){
                console.log(data);
                $scope.head = data.data.headline;
                $scope.name = data.data.musExhibition;
                $scope.time = data.data.beginTime+'--'+data.data.endTime;
                if(data.data.staTime == ""){
                    $scope.Time = false;
                }else{
                    $scope.Time = true;
                }
                $scope.content = data.data.content;
            });
    });
