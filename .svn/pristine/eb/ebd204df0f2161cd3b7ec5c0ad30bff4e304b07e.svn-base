angular.module("provinceDetailContent",[])
    .controller("goProvinceDetailContent",function($scope,$rootScope,$http,$stateParams){
        $rootScope.hideFoot = true;
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