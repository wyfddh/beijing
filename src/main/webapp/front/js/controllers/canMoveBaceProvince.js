/**
 * Created by Administrator on 2017/4/29.
 */
angular.module('canMoveBaceProvince',[])
    .controller('canMoveBaceProvinceCtrl',function ($scope,$rootScope,$timeout,$stateParams,$http,ipCookie) {
        $rootScope.hideFoot = false;
        $scope.showCover = false;
        $scope.index = true;   //开始的时候显示第一个tab
        $scope.cityMuseumTitle = "";
        $scope.categoryList = [];
        $scope.yearTypeList = [];
        $scope.timeTypeList = [];
        $scope.cityList = [];
        $scope.museumList = [];
        $scope.gridDataList = [];
        $scope.gradeTitleList = [];
        $scope.gradeCountList = [];
        $scope.tuliList = [];
        $scope.fullList = [];
        $scope.cityId = "All";
        $scope.orgId = "";
        $scope.num = 0;   //开始的时候显示第一个tab
        $scope.dataInfo = {
            cityId:$scope.orgId,
            orgId:$scope.orgId
        };
        $scope.back = function () {
            history.back();
        };

        // 年代统计图
        var yearChart = echarts.init(document.getElementById("timeChart"));
        var optionyear = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            // legend: {
            //     data: ['2011年', '2012年']
            // },
            grid: {
                top:'10%',
                left: '3%',
                right: '9%',
                bottom: '1%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                boundaryGap: [0, 0.01]
            },
            yAxis: {
                type: 'category',
                data: ['6','5','4','3','2','1']
            },
            series: [
                {
                    name: '数量',
                    type: 'bar',
                    data: [],
                    barWidth:20,

                    itemStyle: {
                        normal: {
                            //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
                            color: function(params) {
                                // build a color map as your need.
                                var colorList = [
                                    '#706d8f','#6894a7','#76b3a2','#4f909e','#edc283','#d66e61'
                                ];
                                return colorList[params.dataIndex]
                            },
                            //以下为是否显示，显示位置和显示格式的设置了
                            label: {
                                show: true,
                                position: 'right',
//                             formatter: '{c}'
                                formatter: '{c}'
                            }
                        }
                    }
                }
            ]
        };
        yearChart.setOption(optionyear);

        //等级统计图
        var gradeChart = echarts.init(document.getElementById("gradeChart"));
        var optionGrade = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            // legend: {
            //     show:'true',
            //     orient:'horizontal',
            //     data: ["一级"],
            //     x:"center",
            //     y:"bottom"
            // },
            grid: {
                top:'10%',
                left: '3%',
                right: '9%',
                bottom: '5%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                boundaryGap: [0, 0.01]
            },
            yAxis: {
                type: 'category',
                data: []
            },
            series: [
                {
                    name: '数量',
                    type: 'bar',
                    data: [],
                    barWidth:20,
                    itemStyle: {
                        normal: {
                            //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
                            color: function(params) {
                                // build a color map as your need.
                                var colorList = [
                                    '#d66e61','#edc283','#4f909e','#76b3a2','#6894a7'
                                ];
                                return colorList[params.dataIndex]
                            },
                            //以下为是否显示，显示位置和显示格式的设置了
                            label: {
                                show: true,
                                position: 'right',
//                             formatter: '{c}'
                                formatter: '{c}'
                            }
                        }
                    }
                }
            ]
        };
        gradeChart.setOption(optionGrade);

        //完残状态统计图
        var fullChart = echarts.init(document.getElementById("fullChart"));
        // fullChart.showLoading();   //loading动画
        // fullChart.hideLoading();   //loading动画
        optionFull = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                bottom: '1%',
                data: []
            },
            series : [
                {
                    name: '',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '38%'],
                    data:[],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 20,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ],
            color:['#4f909e','#76b3a2','#d66e61','#edc283']
        };
        fullChart.setOption(optionFull);




        //调取数据
        yearChart.showLoading();
        gradeChart.showLoading();
        fullChart.showLoading();
        $scope.getData = function (cityID,orgID) {
            $http({
                url:'../front/statisticsAttributes/index.do',
                method:"GET",
                params:{
                    cityId:cityID,
                    orgId:orgID
                }
            }).success(function (data) {
                // console.log(data);
                if(data.success == "1"){
                    $scope.cityMuseumTitle = "";
                    $scope.categoryList = [];
                    $scope.yearTypeList = [];
                    $scope.timeTypeList = [];
                    $scope.gridDataList = [];
                    $scope.gradeTitleList = [];
                    $scope.gradeCountList = [];
                    $scope.tuliList = [];
                    $scope.fullList = [];

                    yearChart.hideLoading();
                    gradeChart.hideLoading();
                    fullChart.hideLoading();
                     // console.log(data);
                    //拿到所选择的title
                    $scope.cityMuseumTitle = data.data.title;

                    //拿到所有的列表集合，各个列表里的数据都更新
                    $scope.cityList = data.data.cities;

                    $scope.museumListCity = data.data.cities[0].orgs;
                    // console.log($scope.museumListCity);

                    //拿到类别列表
                    $scope.categoryList = data.data.categories;

                    //年代统计图列表
                    $scope.yearTypeList = data.data.yearTypes1;
                    $scope.timeTypeList = data.data.yearTypes2;
                    // 拿到年代统计表的数量数组
                    for(var i = 0;i < $scope.yearTypeList.length;i++){
                        $scope.gridDataList.push($scope.yearTypeList[i].count);
                    }
                    $scope.gridDataList = $scope.gridDataList.reverse();

                    //拿到级别统计表的列表
                    $scope.gradeList = data.data.collectionLevels;
                    //拿到统计列表的纵轴数据
                    // $scope.gradeTitleList =
                    for(var j = 0;j < $scope.gradeList.length;j++){
                        $scope.gradeTitleList.push($scope.gradeList[j].name);
                        $scope.gradeCountList.push($scope.gradeList[j].count);
                    }

                    //拿到完残的列表
                    $scope.fullLists = data.data.collectionResidueLevels;
                    //拿到完残统计的数据和图例信息
                    $scope.json = {value:'',name:''};
                    for(var k = 0;k < $scope.fullLists.length;k++){
                        $scope.tuliList.push($scope.fullLists[k].name);
                        $scope.fullList[k] = {value:$scope.fullLists[k].count,name:$scope.fullLists[k].name};
                    }
                    // console.log($scope.gridDataList);
                    // console.log($scope.gradeCountList);

                    //年代统计图表放进数据
                    yearChart.setOption({
                        series: [
                            {
                                name: '数量',
                                type: 'bar',
                                data: $scope.gridDataList,
                                barWidth:20,

                                itemStyle: {
                                    normal: {
                                        //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
                                        color: function(params) {
                                            // build a color map as your need.
                                            var colorList = [
                                                '#706d8f','#6894a7','#76b3a2','#4f909e','#edc283','#d66e61'
                                            ];
                                            return colorList[params.dataIndex]
                                        },
                                        //以下为是否显示，显示位置和显示格式的设置了
                                        label: {
                                            show: true,
                                            position: 'right',
//                                          formatter: '{c}'
                                            formatter: '{c}'
                                        }
                                    }
                                }
                            }
                        ]
                    });
                    //级别统计图表放进数据
                    gradeChart.setOption({
                        yAxis: {
                            type: 'category',
                            data: $scope.gradeTitleList
                        },
                        series: [
                            {
                                name: '数量',
                                type: 'bar',
                                data: $scope.gradeCountList,
                                barWidth:20,
                                itemStyle: {
                                    normal: {
                                        //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
                                        color: function(params) {
                                            // build a color map as your need.
                                            var colorList = [
                                                '#d66e61','#edc283','#4f909e','#76b3a2','#6894a7'
                                            ];
                                            return colorList[params.dataIndex]
                                        },
                                        //以下为是否显示，显示位置和显示格式的设置了
                                        label: {
                                            show: true,
                                            position: 'right',
//                                          formatter: '{c}'
                                            formatter: '{c}'
                                        }
                                    }
                                }
                            }
                        ]
                    });
                    //完残成都统计表放进数据
                    fullChart.setOption({
                        legend: {
                            orient: 'vertical',
                            bottom: '1%',
                            data: $scope.tuliList
                        },
                        series : [
                            {
                                name: '',
                                type: 'pie',
                                radius : '55%',
                                center: ['56%', '38%'],
                                data:$scope.fullList,
                                itemStyle: {
                                    emphasis: {
                                        shadowBlur: 20,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ],
                    })
                }else {
                    layer.alert(data.error.message, {
                        title:"提示",
                        icon: 5,
                        skin: 'layer-ext-moon'
                    })
                }
            });
        };

        if(ipCookie('user').signLevel == "1"){
            $scope.showCityList = true;
            $scope.cityMuseumTitle = "选择地区-博物馆";
            // 调取省的接口
            $scope.getData('','');

        }else if(ipCookie('user').signLevel == "2"){
            $scope.cityMuseumTitle = "选择博物馆";
            $scope.showCityList = false;
            //调取市的接口
            $scope.getData('','');
        }

        // 点击选择城市博物馆
        $scope.coverShow = function () {
            $scope.showCover = true;
        };
        //点击遮罩隐藏
        $scope.coverHide = function () {
            $scope.showCover = false;
        };

        //三秒后遮罩消失
        $scope.hideInThree = function () {
          $timeout(function () {
              $scope.coverHide();
          },300);
        };

        //点击城市的对应的城市
        $scope.cityClick = function (e,index) {
            angular.element(e.target).parent().children().removeClass("cityActive");
            angular.element(e.target).addClass('cityActive');
            // $scope.cityName = angular.element(e.target).html();
            // 拿到对应的城市下的博物馆
            $scope.museumList = $scope.cityList[index].orgs;
            //请求城市的所有的数据
            $scope.checkCity = angular.element(e.target).attr("data");
            // console.log($scope.checkCity);
        };

        // 点击对应的博物馆
        $scope.museumClick = function (e) {
            angular.element(e.target).parent().children().removeClass("liActive").find("i").removeClass("iActive");
            angular.element(e.target).addClass('liActive').find("i").addClass("iActive");
            // $scope.museumName = angular.element(e.target).find("span").html();

            //请求对应的博物馆的数据
            $scope.checkMuseum = angular.element(e.target).attr("data1");
            $scope.getData($scope.checkCity,$scope.checkMuseum);

            //三秒之后收起来
            $scope.hideInThree();

        };

        //选项卡
        $scope.checkStatistics =function (e,num) {
            $scope.num = num;
            angular.element(e.target).parent().children().removeClass("btnActive");
            angular.element(e.target).addClass("btnActive");
            $scope.index = angular.element(e.target).attr("data");
            // console.log(angular.element(e.target).parent().next().next(".tab_wrap").eq($scope.index));
            angular.element(e.target).parent().next().next(".tab_wrap").children().removeClass("tabActive").addClass("tabUnActive");
            angular.element(e.target).parent().next().next(".tab_wrap").children().eq($scope.index).removeClass("tabUnActive").addClass("tabActive");
        };


    });