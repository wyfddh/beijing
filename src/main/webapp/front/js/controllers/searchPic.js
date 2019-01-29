angular.module("searchPic",[])
    .controller("searchPicCtrl",function ($scope,$rootScope,$http,$state) {
        $scope.searchNone = false;
        $rootScope.hideFoot = true;
        $scope.islogin = false;
        $scope.getPic = function () {
            $("input").click();
        };
        //跳转到详情页
        $scope.getIndex = function (id,type) {
            $scope.ID = id;
            $scope.TYPE = type;
            if($scope.TYPE == "1"){
                $state.go("collectionDetail",{id:$scope.ID});
            }else if($scope.TYPE == "2"){
                $state.go("collectionSpecimenDetail",{id:$scope.ID});
            }
        };
        $scope.uploadDown = function () {
            var formData = new FormData($("#upload")[0]);
            console.log(formData);
            $.ajax({
                url: "../file/uploadSearchPicture.do?typeId=8&objectId=",
                type: "post",
                data: formData,
                dataType: "json",
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (data) {
                    $scope.islogin =  true;
                    console.log(data);
                    if(data.error == 0){
                    	/*
                        $scope.dataInfo = {
                            picId:data.picId,
                            url:data.url
                        };*/
                        $http({
                            url:'../front/picturesearch/search.do?picId='+data.picId+'&limit=15'+'&url='+data.url,
                            method:'get'/*,
                            data:$scope.dataInfo*/
                        }).success(function (result) {
                            console.log(result);
                            $scope.islogin =  false;
                            // $scope.dataList = result.
                            if(result.success == "-1"){
                                $scope.searchNone = true;
                            	$scope.dataList = [];
                                layer.msg(result.data);
                            }else if(result.success == "1"){
                                $scope.searchNone = false;
                            	$scope.dataList = result.data;     
                            }

                        })
                    }else{
                        layer.msg(data.message);
                    }
                }
            })
        }
        $scope.$on('$viewContentLoaded',function(){
            $("input").click();
        });
    }).directive('inputOnChange',function () {
        return{
            restrict:'A',
            link:function (scope,element,attrs) {
                var onChangeFunc = scope.$eval(attrs.inputOnChange);
                element.bind('change',onChangeFunc);
            }
        }
});