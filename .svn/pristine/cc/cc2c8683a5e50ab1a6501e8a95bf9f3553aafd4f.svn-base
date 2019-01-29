angular.module("registerStepOne", ["ipCookie"])
    .controller("goRegisterStepOne", function ($scope,$rootScope, $state, $rootScope, $http, ipCookie, $interval) {
        $scope.jump = function () {
            $interval.cancel($scope.timer);
            $state.go("person");

        };

        //协议显示隐藏
        $scope.xieyiShow = function () {
            $("#mask-bottom").show();
            $(".xieyi-box").show();
            $("#mask").show();
        };
        $scope.readXieyi = function () {
            $("#mask-bottom").hide();
            $(".xieyi-box").hide();
            $("#mask").hide();
        };
        //下一步按钮是否能点
        $scope.isChecked = true;
        //手机是否为空默认为空
        $scope.isPhoneAir = false;
        //手机是否有效默认有效
        $scope.isPhoneTrue = false;
        //短信验证码提示是否错误默认为否
        $scope.isMessageTrue = false;
        //手机验证
        $scope.phoneTest = function () {
            var reg = /^1[3-9][0-9]\d{8}$/;
            if (reg.test($scope.registerTel)) {
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
            if ($scope.registerTel && $scope.phoneTest()) {
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
                    url: '../sendSecretCode.do?phone=' + $scope.registerTel,
                    method: 'post'
                }).success(function (data) {
                    //console.log(data);
                    if(data.success == -101){
                    	layer.msg("您频繁登录，ip登录受限，请联系管理员！");
                    }
                    if (data.success == 1) {
                        //请求成功
                        layer.msg("获取短信验证码成功");
                    } else {
                        //请求失败
                        if (data.data == "0") {
                            //表示手机号存在
                            var loginLayer = layer.confirm('该手机号已注册，请直接登录', {
                                btn: ['登陆', '取消'] //按钮
                            }, function () {
                                layer.close(loginLayer);
                                $state.go('login');
                            }, function () {
                                layer.close(loginLayer);
                            });
                            $interval.cancel($scope.timer);
                            $scope.getMessage = false;
                            $("#messageYz").html("获取");
                            $("#messageYz").css("background", "#3DACA8");
                            $("#messageYz").css("color", "#fff");
                        } else if (data.data == "-1") {
                            //表示手机号为空号
                        } else if (data.data == "2") {
                            //表示系统异常
                        }
                    }

                });

            } else if ($("#tel").val() == "") {
                $scope.isPhoneAir = true;
            } else {
                return;
            }
        };
        $scope.checkbox = false;
        //同意勾选
        $scope.choose = function () {
            if ($scope.checkbox) {
                $scope.checkbox = true;
                $scope.isChecked = false;
            } else {
                $scope.checkbox = false;
                $scope.isChecked = true;
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
                $rootScope.messageTel = $("#passMessage").val();
                $rootScope.registerTel = $("#tel").val();
                $state.go('registerStepThree');
                $interval.cancel($scope.timer);
                $scope.getMessage = false;
                $("#messageYz").html("获取");
                $("#messageYz").css("background", "#3DACA8");
                $("#messageYz").css("color", "#fff");
            }
        }
        // $rootScope.hideFoot = false;
        // // $scope.registerTel ="";
        // $scope.changeImg = function(e){
        //     angular.element(e.target).prev().find('img').attr('src','../getImgCode.do?'+Math.random());
        // };
        // function showMask(){
        //     $("#mask").css("height",$(document).height());
        //     $("#mask").css("width",$(document).width());
        //     $("#mask-bottom").css("height",$(document).height());
        //     $("#mask-bottom").css("width",$(document).width());
        // }
        // showMask();
        // $scope.disCheckbox = true;
        // $scope.choose = function(){
        //     if($.trim($scope.registerTel) == ""){
        //         layer.msg("请检查注册信息是否为空或者有误");
        //         $scope.checkbox = false;
        //     }else {
        //         if($scope.checkbox == true){
        //             $scope.disCheckbox = false;
        //         }else{
        //             $scope.disCheckbox = true;
        //         }
        //     }
        //
        //     console.log($scope.checkbox);
        // };
        // $scope.registerStepOne = function(){
        //     $state.go('registerStepThree');
        //     $rootScope.phone = $scope.registerTel;
        //     $rootScope.verificationCode = $scope.verificationcode;
        //     $rootScope.nickName = $scope.nickName;
        // };
    });