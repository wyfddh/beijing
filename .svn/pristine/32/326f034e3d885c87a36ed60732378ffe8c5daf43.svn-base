angular.module("person-controller",[])
    .controller("goPerson",function($scope,$rootScope,$http,$state,ipCookie,$ionicScrollDelegate){
        $rootScope.exitShow = false;
        $rootScope.hideFoot = true;

        //进入个人中心先判断是不是登录
        $scope.isLigin = function () {
            $http({
                url:'../front/OCCollection/doCollect.do',
                method:'GET',
                params:{}
            }).success(function (data) {
                console.log(data);
                //没登陆
                if(data.success == "0"){
                    $("#shawn").show();
                    $("#welcome").hide();
                    $rootScope.exitShow = false;
                }else {
                    //登录了
                    $("#shawn").hide();
                    $("#welcome").show();
                }
            });
        };
        $scope.isLigin();

        // if(ipCookie('user')&&ipCookie('user').name){
        //     $("#shawn").hide();
        //     $("#welcome").show();
        //     $rootScope.userName = ipCookie('user').name;
        // }else if(!ipCookie('user')||ipCookie('user').name == ''){
        //     $("#shawn").show();
        //     $("#welcome").hide();
        //     $rootScope.exitShow = false;
        // }

        //省市级的可以查看统计报表
        if(ipCookie('user') && (ipCookie('user').signLevel == 1 || ipCookie('user').signLevel == 2)) {
            $rootScope.exitShow = true;
        }else {
            $rootScope.exitShow = false;
        }



        $('.tab-item').on('touchend',function(){
            $rootScope.cdkey = '';
            $rootScope.collectionUnitID = '';
            $rootScope.yearType = '';
            $rootScope.collectionsCategory = '';
            $rootScope.museumkey = '';
            $rootScope.museumId = '';
            $rootScope.museumCityId = '',
            $rootScope.categoryId = '';
            $rootScope.flag = '';
            $rootScope.level = '';
            $('.down-list .list').hide();
            $ionicScrollDelegate.scrollTop();
        });
        $scope.esc = function(){
            $http.get('../front/loginOut.do').success(function(data){
                console.log(data);
            });
            ipCookie('user','');
            $("#welcome").hide();
            $("#shawn").show();
            $rootScope.exitShow = false;
        };
        $rootScope.isCollect = false;
        $rootScope.isMuseum = false;
        $rootScope.isBrowse = false;

        //点击我的收藏先判断是不是登录
        $scope.isLogin = function () {
            $http({
                url:'../front/OCCollection/doCollect.do',
                method:'GET',
                params:{}
            }).success(function (data) {
                console.log(data);
                if(data.success == "0"){
                    layer.msg(data.data);
                    $state.go('login');
                }else {
                    $state.go('myCollection');
                }
            });
        };

        //点击我的评论先判断是不是登录
        $scope.myPinglun = function () {
            $http({
                url:'../front/OCCollection/doCollect.do',
                method:'GET',
                params:{}
            }).success(function (data) {
                console.log(data);
                if(data.success == "0"){
                    layer.msg(data.data);
                    $state.go('login');
                }else {
                    $state.go('myComment');
                }
            });
        };

        //点击我的策展先判断登录
        $scope.myCezhan = function () {
            $http({
                url:'../front/OCCollection/doCollect.do',
                method:'GET',
                params:{}
            }).success(function (data) {
                console.log(data);
                if(data.success == "0"){
                    layer.msg(data.data);
                    $state.go('login');
                }else {
                    $state.go('wodecezhan');
                }
            });
        };

        //点击统计报表先判断登录
        $scope.tongjibaobiao = function () {
            $http({
                url:'../front/OCCollection/doCollect.do',
                method:'GET',
                params:{}
            }).success(function (data) {
                console.log(data);
                if(data.success == "0"){
                    layer.msg(data.data);
                    $state.go('login');
                }else {
                    $state.go('statisticProvince');
                }
            });
        };
        //点击修改密码
        $scope.goChangePassWord = function () {
            $http({
                url:'../front/OCCollection/doCollect.do',
                method:'GET',
                params:{}
            }).success(function (data) {
                console.log(data);
                if(data.success == "0"){
                    layer.msg(data.data);
                    $state.go('login');
                }else {
                    $state.go('changePassWord');
                }
            });
        }
    });
