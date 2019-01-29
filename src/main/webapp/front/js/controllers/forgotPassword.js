angular.module("forgotPassword",[])
    .controller("forgotPassword",function($scope,$http,$rootScope,$interval,$state){

        $scope.jump = function () {
            $interval.cancel($scope.timer);
            $state.go("login");

        };
        //下一步按钮是否能点
        // $scope.isChecked = true;
        //手机是否为空默认为空
        $scope.isPhoneAir = false;
        // //手机是否有效默认有效
        $scope.isPhoneTrue = false;
        //短信验证码提示是否错误默认为否
        $scope.isMessageTrue = false;
        //手机验证
        $scope.phoneTest = function () {
            var reg = /^1[3-9][0-9]\d{8}$/;
            if (reg.test($scope.pwdTel)) {
                $scope.isPhoneAir = false;
                $scope.isPhoneTrue = false;
                return true;
            } else {
                $scope.isPhoneTrue = true;
                $scope.isPhoneAir = false;
                return false;
            }
        };
        //短信验证码功能
        var wait = 60;
        $scope.messageYz = function () {
            if ($scope.pwdTel && $scope.phoneTest()) {
                $scope.getMessage = true;
                $("#messageYz").html(wait);
                $("#messageYz").css("background", "#DFDFDF");
                $("#messageYz").css("color", "#7A7A7A");
                $scope.timer = $interval(function () {
                        wait--;
                        $("#messageYz").html(wait);
                        if (wait == 0) {
                            $interval.cancel($scope.timer);
                            $("#messageYz").html("获取");
                            $scope.getMessage = false;
                            $("#messageYz").css("background", "#3DACA8");
                            $("#messageYz").css("color", "#fff");
                            wait = 60;
                        }
                    },
                    1000);
                //验证通过发请求短信
                $http({
                    url: '../forget/sendCode.do?phone=' + $scope.pwdTel,
                    method: 'post'
                }).success(function (data) {
                    //console.log(data);
                    if(data.success == -101){
                    	layer.msg("您频繁登录，ip登录受限，请联系管理员！");
                    }
                    if (data.success == 1) {
                        //请求成功
                        layer.msg("短信已发送");
                    } else if(data.success == 0){
                        //用户不存在
                        layer.msg("您输入的账号不存在，请重新输入或注册账号");
                        $interval.cancel($scope.timer);
                        $scope.getMessage = false;
                        $("#messageYz").html("获取");
                        $("#messageYz").css("background", "#3DACA8");
                        $("#messageYz").css("color", "#fff");
                    } else{
                        layer.msg("系统异常");
                        $interval.cancel($scope.timer);
                        $scope.getMessage = false;
                        $("#messageYz").html("获取");
                        $("#messageYz").css("background", "#3DACA8");
                        $("#messageYz").css("color", "#fff");
                    }
                });

            } else if ($("#tel").val() == "") {
            	$scope.isPhoneAir = true;
            	$scope.isPhoneTrue = false;
            } else {
                return;
            }
        };
        //下一步
        $scope.next = function () {
            if(!$scope.phoneTest()){
                return;
            }else if($("#passMessage").val()==""){
                $scope.isMessageTrue = true;
                return;
            }else{
                $scope.isMessageTrue = false;
                $rootScope.pwdMsg = $("#passMessage").val();
                $rootScope.pwdTel = $("#tel").val();
                $http({
                    url:'../front/toNewPass.do?phone='+$rootScope.pwdTel+'&secretCode='+$rootScope.pwdMsg,
                    type:'get',
                }).success(function(data){
                    //console.log(data);
                    if(data.success == -101){
                    	layer.msg("您频繁登录，ip登录受限，请联系管理员！");
                    }
                    if(data.success == 1){
                        $state.go('forgotPasswordTwo');
                        $scope.getMessage = false;
                        $("#messageYz").html("获取");
                        $("#messageYz").css("background", "#3DACA8");
                        $("#messageYz").css("color", "#fff");
                        $interval.cancel($scope.timer);
                    }else if(data.success == -5){
                        //短信验证码错误
                        layer.msg("短信验证码错误");
                    }else if(data.success == -6){
                        //短信验证码超时
                        layer.msg("短信验证码超时");
                    }else if(data.success == -8){
                        //此账号已被管理员禁用，请联系管理员
                        layer.msg("此账号已被管理员禁用，请联系管理员");
                    }
                });

            }
        }
    });
