angular.module("forgotPasswordTwo",[])
    .controller("forgotPasswordTwo",function($scope,$state,$rootScope,$http,$interval) {
        // $scope.isName = false;
        $scope.isPassword = false;
        $scope.isRepeatPassword = false;
        $scope.isCkick = true;
        //用户昵称验证
        // $scope.userName = function () {
        //     var reg = /^[0-9a-zA-Z_\/u4e00-\u9fa5]{4,10}$/;
        //     if (reg.test($scope.nickName)) {
        //         $scope.isName = false;
        //         if(!$scope.isName && !$scope.isPassword && !$scope.isRepeatPassword &&$scope.nickName &&$scope.password &&$scope.confirmPassword){
        //             $scope.isCkick = false;
        //         }
        //         return true;
        //     } else {
        //         $scope.isName = true;
        //         $scope.isCkick = true;
        //         return false;
        //     }
        // };
        //设置密码
        $scope.userPassword = function () {
            var passwordReg = /^[0-9A-Za-z_]{8,18}$/;
            if (passwordReg.test($scope.password)) {
                if($scope.confirmPassword == $scope.password){
                    $scope.isPassword = false;
                    $scope.isRepeatPassword = false;
                    if(!$scope.isPassword && !$scope.isRepeatPassword &&$scope.password &&$scope.confirmPassword){
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
                    if(!$scope.isPassword && !$scope.isRepeatPassword &&$scope.password &&$scope.confirmPassword){
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
        if(!$scope.isPassword && !$scope.isRepeatPassword &&$scope.password &&$scope.confirmPassword){
            $scope.isCkick = false;
        }
        //完成发送请求
        $scope.success = function () {
            //手机号
            //短信验证码
            var msg = $scope.confirmPassword;
            var pwd = $scope.password;
            $http({
                url: '../front/resetPass.do?password='+msg+'&rpassword='+pwd,
                method: 'post'
            }).success(function (data) {
                //console.log(data);
                if(data.success == -101){
                	layer.msg("您频繁登录，ip登录受限，请联系管理员！");
                }
                if (data.success == 1) {
                    //验证通过
                    $state.go('forgotPasswordSuccess');
                } else if(data.success == 0){
                    //请求失败
                    layer.msg("系统未知异常，请联系管理员!");
                }else if(data.success == -1){
                    //请求失败
                    layer.msg("您长时间未操作或未正确操作，请返回登录页面重新操作!");
                }else if(data.success == -2){
                    //请求失败
                    layer.msg("密码、重复密码不可为空");
                }else if(data.success == -3){
                    //请求失败
                    layer.msg("两次输入密码不一致!");
                }else if(data.success == -4){
                    //请求失败
                    layer.msg("此手机号尚未注册!");
                }else if(data.success == -5){
                    //请求失败
                    layer.msg("账号重复，请联系管理员!");
                }else {
                    layer.msg("此账号已被管理员禁用，请联系管理员!");
                }

            });
        };

    });