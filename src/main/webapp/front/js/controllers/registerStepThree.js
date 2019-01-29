angular.module("registerStepThree",[])
    .controller("goRegisterStepThree",function($scope,$state,$rootScope,$http,$interval) {
        $scope.isName = false;
        $scope.isPassword = false;
        $scope.isRepeatPassword = false;
        $scope.isCkick = true;
        //用户昵称验证
        $scope.userName = function () {
            var reg = /^[0-9a-zA-Z_\/u4e00-\u9fa5]{4,10}$/;
            if (reg.test($scope.nickName)) {
                $scope.isName = false;
                if(!$scope.isName && !$scope.isPassword && !$scope.isRepeatPassword &&$scope.nickName &&$scope.password &&$scope.confirmPassword){
                    $scope.isCkick = false;
                }
                return true;
            } else {
                $scope.isName = true;
                $scope.isCkick = true;
                return false;
            }
        };
        //设置密码
        $scope.userPassword = function () {
            var passwordReg = /^[0-9A-Za-z_]{8,18}$/;
            if (passwordReg.test($scope.password)) {
                if($scope.confirmPassword == $scope.password){
                    $scope.isPassword = false;
                    $scope.isRepeatPassword = false;
                    if(!$scope.isName && !$scope.isPassword && !$scope.isRepeatPassword &&$scope.nickName &&$scope.password &&$scope.confirmPassword){
                        $scope.isCkick = false;
                    }
                    return true;
                }else {
                    $scope.isRepeatPassword = true;
                    $scope.isCkick = true;
                    return false;
                }
            } else {
                $scope.isPassword = true;
                $scope.isCkick = true;
                return false;
            }
        };
        //确认密码
        $scope.userRepeatPassword = function () {
            var passwordReg = /^[0-9A-Za-z_]{8,18}$/;
            if (passwordReg.test($scope.confirmPassword)) {
                if($scope.confirmPassword == $scope.password){
                    $scope.isPassword = false;
                    $scope.isRepeatPassword = false;
                    if(!$scope.isName && !$scope.isPassword && !$scope.isRepeatPassword &&$scope.nickName &&$scope.password &&$scope.confirmPassword){
                        $scope.isCkick = false;
                    }
                    return true;
                }else {
                    $scope.isRepeatPassword = true;
                    $scope.isCkick = true;
                    return false;
                }
            } else {
                $scope.isPassword = true;
                $scope.isCkick = true;
                return false;
            }
        };
        //完成是否可以点击
        if(!$scope.isName && !$scope.isPassword && !$scope.isRepeatPassword &&$scope.nickName &&$scope.password &&$scope.confirmPassword){
            $scope.isCkick = false;
        }
        //完成发送请求
        $scope.success = function () {
            //手机号
            var phone = $rootScope.registerTel;
            //短信验证码
            var msg = $rootScope.messageTel;
            var userName = $scope.nickName;
            var pwd = $scope.password;
            $http({
                url: '../front/register.do?phone='+phone+'&secretCode='+msg+'&nickName='+userName+'&password='+pwd,
                method: 'post'
            }).success(function (data) {
                //console.log(data);
                if(data.success == -101){
                	layer.msg("您频繁登录，ip登录受限，请联系管理员！");
                }
                if (data.success == 1) {
                    //注册成功
                    $http({
                        url:'../frontLogin.do?phone='+phone+'&password='+pwd,
                        method:'get'
                    }).success(function (data) {
                        // ipCookie("user",{name:data.data.sessionAdminName,signLevel:data.data.level});
                        $rootScope.userName =data.data.sessionAdminName;
                        //alert(userName);
                        $state.go("registerSuccess");
                    });
                } else if(data.success == 0){
                    //请求失败
                    layer.msg("系统未知异常，请联系管理员");
                }else if(data.success == -1){
                    //请求失败
                    layer.msg("手机号不可以为空!");
                }else if(data.success == -2){
                    //请求失败
                    // layer.msg("该手机号已注册");
                    var loginLayer = layer.confirm('该手机号已注册，请直接登录', {
                        btn: ['登陆', '取消'] //按钮
                    }, function () {
                        layer.close(loginLayer);
                        $state.go('login');
                    }, function () {
                        layer.close(loginLayer);
                    });
                }else if(data.success == -3){
                    //请求失败
                    layer.msg("短信验证码不能为空!");
                }else if(data.success == -4){
                    //请求失败
                    layer.msg("未发送请求手机验证!");
                }else if(data.success == -5){
                    //请求失败
                    layer.msg("短信验证码错误!");
                }else {
                    layer.msg("短信验证码超时!");
                }

            });
        };


        // $scope.saveRegister = function () {
        //     var password = $("#password").val();
        //     var confirmPassword = $("#confirmPassword").val();
        //     if(password == "" ||confirmPassword == ""){
        //         layer.msg("")
        //     }
        // }
        // $rootScope.passwordStar = false;
        // $scope.registerStepThree = function(){
        //     $http({
        //         method:'GET',
        //         url:'../front/register.do',
        //         params:{
        //             secretCode:$rootScope.secretCode,
        //             phone:$rootScope.phone,
        //             password:$scope.password,
        //             verificationCode:$rootScope.verificationCode,
        //             nickName:$rootScope.nickName
        //
        //         }
        //     }).success(function(data){
        //         console.log(data);
        //         if(data.success==1){
        //             $state.go('registerSuccess');
        //         }else if(data.success==0){
        //             layer.msg("该手机号已注册，请直接登录");
        //             $state.go('login');
        //         }
        //         else if(data.data.tipMessage == '用户名已存在，请登录'){
        //             $scope.reject = true;
        //         }
        //     });
        // };
    });