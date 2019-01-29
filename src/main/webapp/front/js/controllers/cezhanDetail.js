angular.module("cezhanDetail-controller",[])
    .controller("goCezhanDetail",function($scope,$http,$rootScope,$stateParams,$state,ipCookie,$ionicScrollDelegate){
        $rootScope.hideFoot = false;
        $scope.showCover = false;
        $scope.id = $stateParams.id;
        $scope.size = 5;
        $scope.currentPage = 0;
        $scope.showDianzan = true;
        $scope.disnwo = true;
        $scope.zhankai = true;
        $scope.cezhanImgArr = [];
        $scope.dinzhangClass = 0;
        $scope.pinglunArr = [];

        //点击评论的那个输入框
        $scope.discuss = function () {
            if(ipCookie('user')){
                $scope.showCover = true;
            }else {
                layer.confirm('您还没有登录，是否登录？', {
                    btn: ['是','否'] //按钮
                }, function(){
                    $state.go('login');   //跳到登录页面
                    layer.closeAll();
                }, function(){
                    layer.msg('如果没有登录不能发表评论', {
                        time: 2000, //20s后自动关闭
                    });
                });
            }
        };
        //点击后退按钮
        $scope.back = function () {
            $state.go("cezhan");
        };

        // 把小写数字改成大写的
        $scope.changeNum = function (num) {
          switch (num){
              case 1:return  "第一章";break;
              case 2:return  "第二章";break;
              case 3:return  "第三章";break;
              case 4:return  "第四章";break;
              case 5:return  "第五章";break;
              case 6:return  "第六章";break;
              case 7:return  "第七章";break;
              case 8:return  "第八章";break;
              case 9:return  "第九章";break;
              case 10:return  "第十章";break;
              case 11:return  "第十一章";break;
              case 12:return  "第十二章";break;
              case 13:return  "第十三章";break;
              case 14:return  "第十四章";break;
              case 15:return  "第十五章";break;
              case 16:return  "第十六章";break;
              case 17:return  "第十七章";break;
              case 18:return  "第十八章";break;
              case 19:return  "第十九章";break;
              case 20:return  "第二十章";break;
              case 21:return  "第二十一章";break;
              case 22:return  "第二十二章";break;
              case 23:return  "第二十三章";break;
              case 24:return  "第二十四章";break;
              case 25:return  "第二十五章";break;
              case 26:return  "第二十六章";break;
              case 27:return  "第二十七章";break;
              case 28:return  "第二十八章";break;
              case 29:return  "第二十九章";break;
              case 30:return  "第三十章";break;
              case 31:return  "第三十一章";break;
              case 32:return  "第三十二章";break;
              case 33:return  "第三十三章";break;
              case 34:return  "第三十四章";break;
              case 35:return  "第三十五章";break;
              case 36:return  "第三十六章";break;
              case 37:return  "第三十七章";break;
              case 38:return  "第三十八章";break;
              case 39:return  "第三十九章";break;
              case 40:return  "第四十章";break;
              case 41:return  "第四十一章";break;
              case 42:return  "第四十二章";break;
              case 43:return  "第四十三章";break;
              case 44:return  "第四十四章";break;
              case 45:return  "第四十五章";break;
              case 46:return  "第四十六章";break;
              case 47:return  "第四十七章";break;
              case 48:return  "第四十八章";break;
              case 49:return  "第四十九章";break;
              case 50:return  "第五十章";break;
          }
        };

        //点击遮罩关闭
        $scope.hidecover = function () {
            $scope.showCover = false;
        };
        //调取图片的数据
        $http({
            url:'../front/curation/curDetail.do',
            method:'GET',
            params:{
                id:$scope.id
            }
        }).success(function (data) {
            // console.log(data);
            if(data.success == 1){
                $scope.imgArr = data.data;
                // console.log($scope.imgArr);
                $scope.introduceAll = $scope.imgArr[0];      //拿到标题策展人等一干数据
                $scope.pinglunId = $scope.introduceAll.id;   //拿到评论的那个id
                // console.log($scope.pinglunId);
                $scope.cezhanImgArr = $scope.imgArr[0];      //拿到策展里边要放的图片
                $scope.cezhanImg1 = $scope.cezhanImgArr.image1;
                $("#iframe").attr('src','3d-141113221250/index.html');
            }else {
                layer.alert(data.error.message,{
                    title:'提示',
                    icon:5,
                    skin:'layer-ext-moon'
                });
            }
        }).error(function (data) {
            layer.alert(data.error.message,{
                title:'提示',
                icon:5,
                skin:'layer-ext-moon'
            })
        });

        $scope.dataInfo = {
            id:$scope.id,
            size:$scope.size,
            currentPage:$scope.currentPage
        };

        $scope.moreData = true;
        $scope.loadMore = function () {
            $scope.dataInfo.currentPage++;
            $scope.pinglunjiekou();
            $scope.$broadcast("scroll.infiniteScrollComplete");
        };

        $scope.$on("$stateChangeSuccess",function () {
            $scope.loadMore();
        });

        //调取评论的接口
        $scope.pinglunjiekou = function () {
            $scope.moreData = false;
            $http({
                url:'../front/curation/comDetail.do',
                method:'GET',
                params:$scope.dataInfo
            }).success(function (data) {
                // console.log(data);
                $scope.pinglunArr = $scope.pinglunArr.concat(data.data.comList);
                if(data.data.page.currentPage < data.data.page.totalPage){
                    $scope.moreData = true;
                }else {
                    $scope.moreData = false;
                }
            });
        };
        // $scope.pinglunjiekou();

        // 点击展开展览简介上边那个
        $scope.dianwozhankai = function (e) {
            angular.element(e.target).parents('.coverPp').css({background:"none"}).siblings("p").removeClass("youCover");
            $scope.disnwo = false;
        };
        $scope.dianwoshouqi = function (e) {
            angular.element(e.target).parents('.coverPp').css({background:'linear-gradient(to top,  rgba(255,255,255,0.8) 0%,rgba(255,255,255,0) 100%)'}).siblings("p").addClass("youCover");
            $scope.disnwo = true;
        };

        // 点击展开第一章第二章的介绍
        $scope.zhankai = function (e) {
            angular.element(e.target).siblings("p").removeClass("shouqiP").addClass("zhankaiP");
            angular.element(e.target).css({display:"none"}).siblings("img").css({display:"block"});
            angular.element(e.target).siblings(".wordCover").css({display:"none"});
        };
        //点击收起来
        $scope.shouqilai = function (e) {
            angular.element(e.target).siblings("p").removeClass("zhankaiP").addClass("shouqiP");
            angular.element(e.target).css({display:"none"}).siblings("img").css({display:"block"});
            angular.element(e.target).siblings(".wordCover").css({display:"block"});
        };

        //评论里边的点击查看所有
        $scope.lookall = function (e) {
            angular.element(e.target).css({display:"none"}).siblings("p").removeClass("pHeight").siblings(".closeAll").css({display:"block"});
        };
        //评论里的和上
        $scope.closeall = function (e) {
            angular.element(e.target).css({display:"none"}).siblings("p").addClass("pHeight").siblings(".lookAll").css({display:"block"});
        };

        //点击播放第几个
        $scope.changCezhan = function (e,index) {
            // console.log(index);      //拿到我点击的是第几个咯
            $scope.dinzhangClass = index;
            // $(".diNzhang").removeClass("diNzhangActive");
            // $(".titName").removeClass("titNameActive").find(".zhanshiNone").removeClass("zhanshiIng");
            // $(".titName").removeClass("titNameActive").find(".zhanshiNone").removeClass("zhanshiIng");
            // angular.element(e.target).parents(".seriesContent").siblings(".titleWrap").find(".diNzhang").addClass("diNzhangActive").siblings(".titName").addClass("titNameActive").find(".zhanshiNone").addClass("zhanshiIng");
            $scope.cezhanImgArr = $scope.imgArr[index];             //拿到我点的是第几个策展的那个数组
            $("#iframe").attr('src','3d-141113221250/index.html');  //重新定向策展列表
            $ionicScrollDelegate.scrollTop();
        };

        //发表评论
        $scope.submitPinglun = function () {
            $scope.submitContent = $("#saytext").val();
            $scope.dataInfoPinglun = {
                cid:$scope.pinglunId,
                content:$scope.submitContent
            };
            if(!$scope.submitContent){
                layer.alert('您还没有填写任何内容', {
                    icon: 0,
                    skin: 'layer-ext-moon'
                })
            }else {
                // console.log($scope.dataInfo);
                $http({
                    url:"../front/curation/saveComment.do",
                    method:"POST",
                    data:$scope.dataInfoPinglun,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function (obj) {
                        var str = [];
                        for (var s in obj) {
                            str.push(encodeURIComponent(s) + "=" + encodeURIComponent(obj[s]));
                        }
                        return str.join("&");
                    }
                }).success(function (data) {
                    // console.log(data);
                    if(data.success == "1"){
                        $scope.pinglunArr = [];     //先把评论清空
                        $scope.dataInfo.currentPage = 1;
                        $scope.pinglunjiekou();     //再请求一边数据
                        $scope.showCover = false;   //遮罩关闭
                    }else {
                        layer.alert(data.error.message, {
                            icon: 5,
                            skin: 'layer-ext-moon'
                        })
                    }
                }).error(function (data) {
                    layer.alert(data.error.message, {
                        icon: 5,
                        skin: 'layer-ext-moon'
                    })
                })
            }
        };
        
        $scope.dianzan = function () {
            //判断是不是已经登录
            if(ipCookie('user')){
                $http({
                    url:"../front/curation/like.do",
                    method:"GET",
                    params:{
                        id:$scope.id
                    }
                }).success(function (data) {
                    // console.log(data);
                    if(data.success == "1"){
                        layer.msg(data.data, {time: 1500, icon:6});
                        $scope.showDianzan = false;
                    }else{
                        layer.msg(data.data, {time: 1500, icon:6});
                    }
                })
            }else {
                layer.confirm('您还没有登录，是否登录？', {
                    btn: ['是','否'] //按钮
                }, function(){
                    $state.go('login');   //跳到登录页面
                    layer.closeAll();
                }, function(){
                    layer.msg('如果没有登录不能发表评论', {
                        time: 2000, //20s后自动关闭
                    });
                });
            }
        }
    });