$(function () {

    getTime();
    setInterval(function () {
        getTime();
    }, 1000);

    // 基于准备好的dom，初始化echarts实例
    var mapEchart = echarts.init(document.getElementById('center1'));
    var pie1chart = echarts.init(document.getElementById("pie1"));
    var pie2chart = echarts.init(document.getElementById("pie2"));
    var right1chart = echarts.init(document.getElementById('right1chartArea'));
    var right2chart = echarts.init(document.getElementById('right2chartArea'));
    var right3chart = echarts.init(document.getElementById('right3chartArea'));
    var left2chart = echarts.init(document.getElementById('left2chartArea'));
    chinaMap(5);
    pie1();
    pie2();
    right1();
    right2(5);
    right3(5);
    left2(5);

    $('#selectMonth').change(function () {
        var month = $("#selectMonth").find("option:selected").val();
        updateSumSaleCount(month);
        chinaMap(month)
        left1(month);
        left2(month);
        right2(month);
        right3(month);
    });
    function left1(month) {
        var url = "/SightVisualization/updateSightSaleCountTop10/"+month;
        // console.log(url);
        $("#top10").load(url);
    }
    function updateSumSaleCount(month) {
        var url = "/SightVisualization/updateSumSaleCount/"+month;
        // console.log(url);
        $("#sumOfSaleCountDiv").load(url);
    }
    function pie1() {

        $.get("/visualization/getDiffStarNum", function (jsonData) {
            var data = [
                {
                    // value: 359,
                    // name: '5A',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(235,232,6, 0.2)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#EBE806' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                },
                {
                    // value: 1369,
                    // name: '4A',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(255,86,36, 0.2)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#FF5624' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                },
                {
                    // value: 414,
                    // name: '3A',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(94,166,254, 0.2)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#5EA6FE' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                },
                {
                    // value: 5167,
                    // name: '其它',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(0,222,215, 0.2)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#2bcbc6' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                }
            ];
            var DiffStarNum = JSON.parse(jsonData);
            for (var i = 0; i < DiffStarNum.length; i++) {
                var star = DiffStarNum[i].star;
                var value = DiffStarNum[i].value;
                if (star) {
                    data[i].name = star;
                } else {
                    data[i].name = "其它";
                }
                data[i].value = value;
            }

            var option = {
                title: {
                    text: '全国各等级景区占比情况',
                    top: '2%',
                    left: 'center',
                    textStyle: {
                        fontSize: '13',
                        fontWeight: 'lighter',
                        color: '#fff',
                    }
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{b}景区数量: {c} <br> ' +
                                '占比：{d}%',
                    position: function (pos, params, dom, rect, size) {
                        // 鼠标在左侧时 tooltip 显示到右侧，鼠标在右侧时 tooltip 显示到左侧。
                        var obj = {
                            top: 60
                        };
                        obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 5;
                        return obj;
                    }
                },
                legend: {
                    orient: 'horizontal',
                    bottom: 0,
                    type: 'scroll',
                    data: ['5A', '4A', '3A', '其它'],
                    textStyle: {
                        color: '#fff'
                    },
                    icon: 'circle'
                },
                series: [{
                    name: '景区占比情况',
                    type: 'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    selectedMode: 'single',
                    label: {
                        show: false,
                        position: 'center',
                    },
                    data: data,
                    emphasis: {
                        label: {
                            show: true,
                            fontSize: 16,
                            fontWeight: 'bold',
                            color: "#fff"
                        }
                    }
                }]
            };
            pie1chart.setOption(option);
            window.addEventListener("resize", function () {
                pie1chart.resize();
            });
        });
    }

    function pie2() {

        $.get("/visualization/getDiffPriceRangeNum", function (jsonData) {
            var data = [{
                value: 335,
                name: '免费',
                itemStyle: {
                    color: {
                        type: 'radial',
                        x: 550,
                        y: 440,
                        r: 120,
                        colorStops: [{
                            offset: 0,
                            color: 'rgba(235, 91, 173, 51)' // 0% 处的颜色
                        }, {
                            offset: 1,
                            color: 'rgba(235, 91, 173, 100)' // 100% 处的颜色
                        }],
                        global: true // 缺省为 false
                    }
                }
            },
                {
                    value: 335,
                    name: '1~50',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(235,232,6, 0.2)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#EBE806' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                },
                {
                    value: 310,
                    name: '51~100',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(255,86,36, 0.2)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#FF5624' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                },
                {
                    value: 234,
                    name: '101~150',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(83, 189, 122, 51)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#45b96c' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                },
                {
                    value: 135,
                    name: '151~200',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(94,166,254, 0.2)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#5EA6FE' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                },
                {
                    value: 154,
                    name: '200+',
                    itemStyle: {
                        color: {
                            type: 'radial',
                            x: 550,
                            y: 440,
                            r: 120,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(0,222,215, 0.2)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#2bcbc6' // 100% 处的颜色
                            }],
                            global: true // 缺省为 false
                        }
                    }
                }
            ];
            var DiffPriceRangeNum = JSON.parse(jsonData);
            for (var i = 0; i < DiffPriceRangeNum.length; i++) {
                var value = DiffPriceRangeNum[i].value;
                data[i].value = value;
            }
            var option = {
                title: {
                    text: '全国景区价格区间',
                    top: '2%',
                    left: 'center',
                    textStyle: {
                        fontSize: '13',
                        fontWeight: 'lighter',
                        color: '#fff'
                    }
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{b}: {c} <br>' +
                                '占比：{d}%',
                    position: function (pos, params, dom, rect, size) {
                        // 鼠标在左侧时 tooltip 显示到右侧，鼠标在右侧时 tooltip 显示到左侧。
                        var obj = {
                            top: 60
                        };
                        obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 5;
                        return obj;
                    }
                },
                legend: {
                    orient: 'horizontal',
                    type: 'scroll',
                    itemGap: 10,
                    icon: 'circle',
                    bottom: 0,
                    data: ['免费', '1~50', '51~100', '101~150', '151~200', '200+'],
                    textStyle: {
                        color: '#fff'
                    },

                },
                series: {
                    name: '价格区间占比',
                    type: 'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    selectedMode: 'single',
                    label: {
                        show: false,
                        position: 'center',
                    },
                    data: data,
                    emphasis: {
                        label: {
                            show: true,
                            fontSize: 16,
                            fontWeight: 'bold',
                            color: "#fff"
                        }
                    }
                }
            };

            pie2chart.setOption(option);
            window.addEventListener("resize", function () {
                pie2chart.resize();
            });
        });
    }

    function right1() {

        $.get("/visualization/getCitySightNumTop5", function (jsonData) {
            var newSeries = [{
                name: '5A级景区',
                type: 'bar',
                stack: '总量',
                barWidth: '70%',
                itemStyle: {
                    normal: {
                        color: '#04b1a9',
                    }
                },
                label: {
                    normal: {
                        show: false,
                        position: 'inside',
                    }
                },
                data: []
            },
                {
                    name: '4A级景区',
                    type: 'bar',
                    stack: '总量',
                    barWidth: '70%',
                    itemStyle: {
                        normal: {
                            color: '#ccc904',
                        }
                    },
                    label: {
                        normal: {
                            show: false,
                            position: 'inside'
                        }
                    },
                    data: [],
                },
                {
                    name: '3A级景区',
                    type: 'bar',
                    stack: '总量',
                    barWidth: '70%',
                    itemStyle: {
                        normal: {
                            color: '#2c61a2',
                        }
                    },
                    label: {
                        normal: {
                            show: false,
                            position: 'inside'
                        }
                    },
                    data: [],
                },
                {
                    name: '其它景区',
                    type: 'bar',
                    stack: '总量',
                    barWidth: '70%',
                    itemStyle: {
                        normal: {
                            color: '#ff5624',
                        }
                    },
                    label: {
                        normal: {
                            show: true,
                            position: 'insideTop'
                        }
                    },
                    data: [],
                },
            ];
            var option = {
                title: {
                    text: '景区数量最多的城市top5',
                    top: '1%',
                    left: 'center',
                    textStyle: {
                        fontSize: '14',
                        fontWeight: 'lighter',
                        color: '#fff'
                    }
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    type: 'scroll',
                    top: '10%',
                    left: 'center',
                    data: ['5A级景区', '4A级景区', '3A级景区', '其它景区'],
                    textStyle: {
                        color: 'rgba(46, 213, 208, 1)'
                    }
                },
                grid: {
                    left: '2%',
                    right: '5%',
                    top: '23%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'value',
                    // max: 250,
                    axisLine: {
                        lineStyle: {
                            color: '#fff',
                        }
                    }
                },
                yAxis: {
                    type: 'category',
                    data: [],
                    splitLine: {
                        show: false
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#8bbdf9',
                        }
                    },
                    axisLabel: {
                        color: '#8bbdf9'
                    }
                },
                series: newSeries
            };

            var CitySightNumTop5 = JSON.parse(jsonData);
            for (var i = CitySightNumTop5.length-1; i >= 0; i--) {
                var city = CitySightNumTop5[i].city;
                var a5 = CitySightNumTop5[i]["5A"];
                var a4 = CitySightNumTop5[i]["4A"];
                var a3 = CitySightNumTop5[i]["3A"];
                var a0 = CitySightNumTop5[i]["其它"];
                newSeries[0].data.push(a5);
                newSeries[1].data.push(a4);
                newSeries[2].data.push(a3);
                newSeries[3].data.push(a0);
                option["yAxis"].data.push(city);
            }
            // 使用刚指定的配置项和数据显示图表。
            right1chart.setOption(option);
            window.addEventListener("resize", function () {
                right1chart.resize();
            });
        });
    }

    function right2(month) {
        $.get("/visualization/getCitySaleCountTop5/"+month, function (jsonData){
            var option = {
                title: {
                    text: month+'月热门旅游城市',
                    top: '2%',
                    left: 'center',
                    textStyle: {
                        fontSize: '14',
                        fontWeight: 'lighter',
                        color: '#fff'
                    }
                },
                tooltip: {
                    trigger: 'item',
                    // axisPointer: { // 坐标轴指示器，坐标轴触发有效
                    // 	type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    // }
                },
                grid: {
                    left: '2%',
                    right: '7%',
                    top: '15%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'value',
                    // max: 15000,
                    splitLine: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    },
                    axisLabel: {
                        show: false
                    }
                },
                yAxis: {
                    type: 'category',
                    data: [],
                    splitLine: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    },
                    axisLabel: {
                        textStyle: {
                            color: "#8bbdf9"
                        }
                    },

                },
                series: {
                    name: '月销量',
                    type: 'bar',
                    stack: '总量',
                    barWidth: '70%',
                    itemStyle: {
                        normal: {
                            color: 'rgba(41, 203, 198, 204)',
                            barBorderRadius: [20, 20, 20, 20],
                        }
                    },
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: []
                }
            };
            var CitySaleCountTop5 = JSON.parse(jsonData);
            for (var i = CitySaleCountTop5.length-1; i >= 0; i--){
                option["yAxis"].data.push(CitySaleCountTop5[i].city);
                option["series"].data.push(CitySaleCountTop5[i].value);
            }
            right2chart.clear();
            right2chart.setOption(option);
            window.addEventListener("resize", function () {
                right2chart.resize();
            });
        });
    }

    function right3(month) {
        $.get("/visualization/getZoneSaleCount/"+month,function (jsonData) {
            var option = {
                title: {
                    text: '各地区月销量情况',
                    top: '1%',
                    left: 'center',
                    textStyle: {
                        fontSize: '14',
                        fontWeight: 'lighter',
                        color: '#fff'
                    }
                },
                color: "#3cefff",
                tooltip: {},
                grid: {
                    left: '2%',
                    right: '7%',
                    top: '15%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: "category",
                    data: ["东北", "华东", "华中", "华北", "华南", "西北", "西南"],
                    axisTick: {
                        alignWithLabel: true
                    },
                    nameTextStyle: {
                        color: "#82b0ec"
                    },
                    axisLine: {
                        lineStyle: {
                            color: "#82b0ec"
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            color: "#82b0ec"
                        }
                    }
                }],
                yAxis: [{
                    type: "value",
                    axisLabel: {
                        textStyle: {
                            color: "#82b0ec"
                        },
                        formatter: "{value}"
                    },
                    splitLine: {
                        lineStyle: {
                            color: "#0c2c5a"
                        }
                    },
                    axisLine: {
                        show: false
                    }
                }],
                series: [{
                    type: "pictorialBar",
                    // 尺寸 x方向 y方向
                    symbolSize: [20, 10],
                    // 左右上下偏移
                    symbolOffset: [0, -5],
                    symbolPosition: "end",
                    label: {
                        normal: {
                            show: true,
                            position: "top",
                            formatter: "{c}"
                        }
                    },

                    data: []
                },
                    {
                        type: "pictorialBar",
                        symbolSize: [20, 10],
                        symbolOffset: [0, 5],

                        data: []
                    },
                    {
                        type: "bar",
                        itemStyle: {
                            normal: {
                                opacity: 0.6
                            }
                        },
                        barWidth: 20,
                        data: []
                    },
                ]
            }
            var ZoneSaleCount = JSON.parse(jsonData);
            for (var i = 0; i < ZoneSaleCount.length; i++){
                option["series"][0].data.push(ZoneSaleCount[i].value);
                option["series"][1].data.push(ZoneSaleCount[i].value);
                option["series"][2].data.push(ZoneSaleCount[i].value);
            }
            right3chart.clear();
            right3chart.setOption(option);
            window.addEventListener("resize", function () {
                right3chart.resize();
            });
        });
    }

    function left2(month) {
        $.get("/visualization/getDiffStarSaleCount/"+month, function (jsonData) {

            var data = [
                {
                    itemStyle: {
                        normal: {
                            color: '#f59047'
                        }
                    }
                },
                {
                    itemStyle: {
                        normal: {
                            color: '#487be7'
                        }
                    }
                },
                {
                    itemStyle: {
                        normal: {
                            color: '#30e27b'
                        }
                    }
                },
                {
                    itemStyle: {
                        normal: {
                            color: '#e3e379'
                        }
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                }
            ];
            var DiffStarSaleCount = JSON.parse(jsonData);
            for (var i = 0; i < DiffStarSaleCount.length; i++) {
                var star = DiffStarSaleCount[i].star;
                var value = DiffStarSaleCount[i].value;
                if (star) {
                    data[i].name = star;
                } else {
                    data[i].name = "其它";
                }
                data[i].value = value;
            }
            var option = {
                title: {
                    text: '各等级景区月销量情况',
                    top: '2%',
                    left: 'center',
                    textStyle: {
                        fontSize: '16',
                        fontWeight: 'lighter',
                        color: '#fff'
                    }
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{b} : {c}人次"

                },
                legend: {
                    x: 'center',
                    y: '15%',
                    type: 'scroll',
                    data: ['5A', '4A', '3A', '其它'],
                    // icon: 'circle',
                    textStyle: {
                        color: '#fff',
                    }
                },
                calculable: true,
                series: {
                    type: 'pie',
                    //起始角度，支持范围[0, 360]
                    startAngle: 0,
                    //饼图的半径，数组的第一项是内半径，第二项是外半径
                    radius: ['20%', '80%'],
                    //支持设置成百分比，饼图的中心（圆心）坐标，数组的第一项是横坐标，第二项是纵坐标。
                    center: ['50%', '40%'],
                    //是否展示成南丁格尔图，通过半径区分数据大小。可选择两种模式：
                    // 'radius' 面积展现数据的百分比，半径展现数据的大小。
                    //  'area' 所有扇区所占圆径角度相同，仅通过半径展现数据大小
                    roseType: 'area',
                    //是否启用防止标签重叠策略，默认开启，圆环图这个例子中需要强制所有标签放在中心位置，可以将该值设为 false。
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: true,
                            formatter: '{c}人次',
                            fontWeight: 'bold'
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    labelLine: {
                        normal: {
                            show: true,
                            length2: 1,
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data: data
                }
            };
            left2chart.clear();
            left2chart.setOption(option);
            window.addEventListener("resize", function () {
                left2chart.resize();
            });
        });
    }

    function chinaMap(month) {
        //处理数据函数
        var convertData = function (data) {
            var res = [];
            console.log(data.length);
            for (var i = 0; i < data.length; i++) {
                var cityName = data[i].city;
                var geoCoord = geoCoordMap[cityName];
                if (geoCoord) {
                    names = [];
                    names.push(cityName);
                    var goodRate = (data[i].goodCommentAmount*100/data[i].sumAmount).toFixed(2);
                    res.push({
                        name: names.concat(data[i].saleCount,goodRate),
                        value: geoCoord.concat(data[i].value)
                    });
                }
            }
            console.log(res);
            return res;
        };
        var data;
        var geoCoordMap;
        // 旅游城市分布图
        $.get("/js/echarts/json/cityCoords.json", function (jsonData) {
            geoCoordMap = jsonData;
            $.get("/visualization/getCitySightNum/"+month, function (jsonData) {
                data = JSON.parse(jsonData);
                option = {
                    title: {
                        text: '全国热门旅游城市分布图',
                        subtext: 'data from qunar',
                        left: 'center',
                        top: 15,
                        textStyle: {
                            fontWeight: 'lighter',
                            color: '#fff'
                        }
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        icon: 'circle',
                        orient: 'vertical',
                        y: 'bottom',
                        x: 'right',
                        data: ['散点图', 'Top 10', '热力图'],
                        textStyle: {
                            color: '#fff'
                        },
                        selected: {
                            '散点图': true,
                            'Top 10': true,
                            '热力图': false
                        }
                    },
                    geo: {
                        map: 'china',
                        label: {
                            normal: {
                                show: false,
                                color: "#fff"
                            },
                            emphasis: {
                                show: true,
                                color: "#fff"
                            }
                        },
                        roam: true,
                        scaleLimit: {
                            min: 0.5,
                            max: 25,
                        },
                        itemStyle: {
                            normal: {
                                borderColor: 'rgba(147, 235, 248, 1)',
                                borderWidth: 1,
                                areaColor: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(147, 235, 248, 0)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(147, 235, 248, .2)' // 100% 处的颜色
                                    }],

                                },
                            },
                            emphasis: {
                                areaColor: '#278aa8'
                            }
                        }
                    },
                    visualMap: {
                        min: 0,
                        max: 300,
                        pieces: [{
                            min: 80
                        },
                            {
                                min: 50,
                                max: 80
                            },
                            {
                                min: 25,
                                max: 50
                            },
                            {
                                min: 15,
                                max: 25
                            },
                            {
                                min: 5,
                                max: 15
                            },
                            {
                                max: 5
                            }
                        ],
                        inRange: {
                            color: ['#22e5e8', '#eac736', '#f15769']
                        },
                        textStyle: {
                            color: '#fff'
                        }
                    },
                    series: [{
                        name: '散点图',
                        type: 'scatter',
                        coordinateSystem: 'geo',
                        data: convertData(data),
                        symbolSize: function (val) {
                            return (5 + Math.log2(val[2]));
                        },
                        label: {
                            normal: {
                                formatter: function (params) {
                                    return params.name[0];
                                },
                                position: 'right',
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(255,255,0,0.8)'
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: function (params) {
                                return params.name[0]+'<br>'+
                                    '景区数量：'+params.value[2]+'<br>'+
                                    '城市月销量：'+params.name[1]+'<br>'+
                                    '好评率：'+params.name[2]+'%';
                            }
                        },
                    },
                        {
                            name: 'Top 10',
                            type: 'effectScatter',
                            coordinateSystem: 'geo',
                            data: convertData(data.sort(function (a, b) {
                                return b.saleCount - a.saleCount;
                            }).slice(0, 11)),
                            symbolSize: function (val) {
                                return (6 + Math.log2(val[2]));
                            },
                            showEffectOn: 'render',
                            rippleEffect: {
                                brushType: 'stroke'
                            },
                            hoverAnimation: true,
                            label: {
                                normal: {
                                    formatter: function (params) {
                                        return params.name[0];
                                    },
                                    position: 'right',
                                    show: true
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#f4e925',
                                    shadowBlur: 10,
                                    shadowColor: '#333'
                                }
                            },
                            tooltip: {
                                trigger: 'item',
                                formatter: function (params) {
                                    return params.name[0]+'<br>'+
                                        '景区数量：'+params.value[2]+'<br>'+
                                        '城市月销量：'+params.name[1]+'<br>'+
                                        '好评率：'+params.name[2]+'%';
                                }
                            },
                            zlevel: 1
                        },
                        {
                            name: '热力图',
                            type: 'heatmap',
                            coordinateSystem: 'geo',
                            data: convertData(data)
                        }
                    ]
                };
                // 使用制定的配置项和数据显示图表
                mapEchart.setOption(option);
                window.addEventListener("resize", function () {
                    mapEchart.resize();
                });
            });
        });

    }

    function getTime() {
        //1、获得当前时间，格式化时间
        var now = new Date();
        var year = now.getFullYear();
        var month = now.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        var date = now.getDate();
        if (date < 10) {
            date = "0" + date;
        }
        var hour = now.getHours();
        if (hour < 10) {
            hour = "0" + hour;
        }
        var minute = now.getMinutes();
        if (minute < 10) {
            minute = "0" + minute;
        }
        var second = now.getSeconds();
        if (second < 10) {
            second = "0" + second;
        }
        var nowstr = year + "/" + month + "/" + date + " " + hour + ":" + minute + ":" + second;
        //2、显示时间
        //获得标签对象
        $("#nowTime").text(nowstr);
    }

})
