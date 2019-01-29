angular.module("login",["ipCookie"])
    .controller("goLogin",function($scope,$state,$rootScope,$http,ipCookie){
        $rootScope.hideFoot = false;
        $scope.credentials = {
            phone:$scope.tel,
            password:$scope.password
        };
        $scope.codeShow =false;
        //$scope.model = {
        //    tel : '',
        //    password : ''
        //};
        //$scope.login = function(model) {
        //    console.log('login', model);
        //    AuthService.login(model).then(function(user) {
        //        $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
        //        $scope.$parent.setCurrentUser(user);
        //    }, function() {
        //        $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
        //    });
        //};
        // $('.wx').on('touchend',function(){
        //     window.open('http://demo.net.tj720.com/mip/wxLogin.do');
        // });
        $scope.submit = function(){
                $http({
                    url: '../frontLogin.do',
                    method: 'POST',
                    data: {
                        phone: $scope.tel,
                        password: $scope.password,
                        verificationCode:$scope.verificationcode,
                        isback:'1'
                    },
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function (obj) {
                        var str = [];
                        for (var s in obj) {
                            str.push(encodeURIComponent(s) + "=" + encodeURIComponent(obj[s]));
                        }
                        return str.join("&");
                    }
                }).success(function (data) {
                    console.log($scope.tel);
                    console.log($scope.password);
                    console.log(data.data.errorTimes);
                    console.log(data);
                    if(data.success == -101){
                    	layer.msg("您频繁登录，ip登录受限，请联系管理员！");
                    }
                    if(data.data.errorTimes == 5){
                        $scope.error = true;
                        $scope.codeShow = true;
                    }else if(data.data.sessionAdminName != null){
                        $scope.error = false;
                        ipCookie("user",{name:data.data.sessionAdminName,signLevel:data.data.level});
                        $rootScope.userName = ipCookie("user").name;
                        // console.log(ipCookie('user'));
                        // console.log($rootScope.userName);
                        //$scope.signUpForm.tel.$error.minlength = true;
                        $state.go('person');
                        $rootScope.exitShow = true;          //显示统计报表
                        $rootScope.sign = data.data.level;    //标记是省管理员还是市管理员
                    }else if(data.data.errorTimes > 0){
                        $scope.codeShow = true;
                    }else if(data.data.errorTimes ==0){
                        $scope.codeShow = false;
                    }else{
                        $scope.signUpForm.tel.$error.minlength = true;
                    }
                });
        };
        $scope.changeImg = function(e){
            angular.element(e.target).prev().find('img').attr('src','../getImgCode.do?'+Math.random());
        }

    });


