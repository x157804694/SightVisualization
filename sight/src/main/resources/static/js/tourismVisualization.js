$(function(){
    drawChart1();
    drawChart2();
    drawChart3();
    function drawChart1() {
        // 基于准备好的dom，初始化echarts实例
        var chart1 = echarts.init(document.getElementById('numOfTourists'));
        var xData = function() {
            var data = [];
            for (var i = 2000; i <= 2020; i++) {
                data.push(i + "年");
            }
            return data;
        }();
        option1 = {
            "title": {
                "text": "国内旅游人数预测",
                left: 'center',
            },
            "tooltip": {
                "trigger": "axis",
                "axisPointer": {
                    "type": "shadow",
                    textStyle: {
                        color: "#2eaba7"
                    }

                },
            },
            "grid": {
                "borderWidth": 0,
                "top": 110,
                "bottom": 95,
                textStyle: {
                    color: "#fff"
                }
            },
            "legend": {
                x: '10%',
                top: '5%',
                textStyle: {
                    color: '#64696c',
                },
                "data": ['城镇游客', '农村游客']
            },
            "xAxis": [{
                "name": "年份",
                "type": "category",
                "axisLine": {
                    lineStyle: {
                        color: '#90979c'
                    }
                },
                "splitLine": {
                    "show": false
                },
                "axisTick": {
                    "show": false
                },
                "splitArea": {
                    "show": false
                },
                "axisLabel": {
                    "interval": 0,
                },
                "data": xData,
            }],
            "yAxis": [{
                "name": "人数(百万)",
                "type": "value",
                "splitLine": {
                    "show": false
                },
                "axisLine": {
                    lineStyle: {
                        color: '#90979c'
                    }
                },
                "axisTick": {
                    "show": false
                },
                "axisLabel": {
                    "interval": 0,

                },
                "splitArea": {
                    "show": false
                },

            }],
            "dataZoom": [{
                "show": true,
                "height": 30,
                "xAxisIndex": [0],
                bottom: 30,
                "start": 50,
                "end": 100,
                handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
                handleSize: '110%',
                handleStyle: {
                    color: "#acb5ba",

                },
                textStyle: {
                    color: "#734e31"
                },
                borderColor: "#90979c"
            },
                {
                    "type": "inside",
                    "show": true,
                    "height": 15,
                }
            ],
            "series": [{
                "name": "农村游客",
                "type": "bar",
                "stack": "总量",
                "barMaxWidth": 35,
                "barGap": "10%",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,144,128,1)",
                        "label": {
                            "show": true,
                            "textStyle": {
                                "color": "#fff"
                            },
                            "position": "inside",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": [
                    415,
                    409,
                    493,
                    519,
                    643,
                    716,
                    818,
                    998,
                    1009,
                    999,
                    1038,
                    954,
                    1024,
                    1076,
                    1128,
                    1188,
                    1240,
                    1324,
                    1420,
                    1557,
                    1240,
                ],
            },

                {
                    "name": "城镇游客",
                    "type": "bar",
                    "stack": "总量",
                    "itemStyle": {
                        "normal": {
                            "color": "rgba(55, 206, 229, 1)",
                            "barBorderRadius": 0,
                            "label": {
                                "show": true,
                                "position": "inside",
                                formatter: function(p) {
                                    return p.value > 0 ? (p.value) : '';
                                }
                            }
                        }
                    },
                    "data": [
                        329,
                        375,
                        385,
                        351,
                        459,
                        496,
                        576,
                        612,
                        703,
                        903,
                        1065,
                        1687,
                        1933,
                        2186,
                        2483,
                        2802,
                        3195,
                        3677,
                        4119,
                        4453,
                        4012,
                    ]
                }, {
                    "name": "总数",
                    "type": "line",
                    symbolSize: 10,
                    symbol: 'diamond',
                    "itemStyle": {
                        "normal": {
                            "color": "rgb(243, 110, 221)",
                            "barBorderRadius": 0,
                            "label": {
                                "show": true,
                                "position": "top",
                                formatter: function(p) {
                                    return p.value > 0 ? (p.value) : '';
                                }
                            }
                        }
                    },
                    "data": [
                        744,
                        784,
                        878,
                        870,
                        1102,
                        1212,
                        1394,
                        1610,
                        1712,
                        1902,
                        2103,
                        2641,
                        2957,
                        3262,
                        3611,
                        4000,
                        4440,
                        5001,
                        5539,
                        6010,
                        5252,
                    ]
                },
            ]
        }
        // 使用制定的配置项和数据显示图表
        chart1.setOption(option1);
        window.onresize = function() {
            chart1.resize();
        }
    }
    function drawChart2() {
        // 基于准备好的dom，初始化echarts实例
        var chart2 = echarts.init(document.getElementById('avgCost4Travel'));
        var xData = function() {
            var data = [];
            for (var i = 2000; i <= 2020; i++) {
                data.push(i + "年");
            }
            return data;
        }();
        option2 = {
            title: {
                text: '旅游人均消费预测',
                left: 'center',
            },
            grid: {
                top: '20%',
                containLabel: true
            },
            legend: {
                x: '17%',
                top: '9%',
                textStyle: {
                    color: '#64696c',
                },
                "data": ['国内旅游人均消费', '城镇居民旅游人均消费', '农村居民旅游人均消费']
            },
            tooltip: {
                trigger: 'item',
            },
            xAxis: {
                type: 'category',
                data: xData,
                axisTick: {
                    alignWithLabel: true
                }
            },
            yAxis: {
                type: 'value',
                name: '人均消费(元)',
            },
            series: [{
                name: '国内旅游人均消费',
                data: [
                    426.6,
                    449.5,
                    441.8,
                    395.7,
                    427.5,
                    436.1,
                    446.9,
                    482.6,
                    511,
                    535.4,
                    598.2,
                    731,
                    767.9,
                    805.5,
                    839.7,
                    857,
                    888.2,
                    913,
                    925.8,
                    935.6,
                    910.2
                ],
                type: 'line',
                color: '#e273c8',
                symbol: 'circle',
                symbolSize: 8
            },
                {
                    name: '城镇居民旅游人均消费',
                    data: [
                        678.6,
                        708.3,
                        739.7,
                        684.9,
                        731.8,
                        737.1,
                        766.4,
                        906.9,
                        849.4,
                        801.1,
                        883,
                        878.8,
                        914.5,
                        946.6,
                        975.4,
                        985.5,
                        1009.1,
                        1024.6,
                        1034,
                        1044,
                        1003,
                    ],
                    type: 'line',
                    color: '#e2585a',
                    symbol: 'circle',
                    symbolSize: 8
                },
                {
                    name: '农村居民旅游人均消费',
                    data: [
                        226.6,
                        212.7,
                        209.1,
                        200,
                        210.2,
                        227.6,
                        221.9,
                        222.5,
                        275.3,
                        295.3,
                        306,
                        471.4,
                        491,
                        518.9,
                        540.2,
                        554.2,
                        576.4,
                        603.3,
                        611.9,
                        620,
                        606.1,
                    ],
                    type: 'line',
                    color: '#5d9dea',
                    symbol: 'circle',
                    symbolSize: 8,
                }
            ]
        };
        // 使用制定的配置项和数据显示图表
        chart2.setOption(option2);
        window.onresize = function() {
            chart2.resize();
        }
    }
    function drawChart3(){
        // 基于准备好的dom，初始化echarts实例
        var chart3 = echarts.init(document.getElementById('appHeat'));

        option3 = {
            backgroundColor: '#fff',
            title: {
                text: '旅游app活跃度分析',
                left: 'center',

            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                top: '10%',
                containLabel: true
            },
            legend: {
                data: ['1月', '2月', '3月','4月'],
                right: '2%',
                top: '5%',
                textStyle: {
                    color: '#333'
                },
                selected: {
                    '1月': false,
                    '2月': true,
                    '3月': true,
                    '4月': true,
                }
            },
            xAxis: {
                type: 'category',
                data: ['同程', '途牛', '马蜂窝','飞猪','去哪儿','携程'],
                "axisLine": {
                    lineStyle: {
                        color: '#7c7c7c'
                    }
                },
            },
            yAxis: {
                name: '人数(万)',
                type: 'value',
                axisLine: {
                    lineStyle: {
                        color: '#7c7c7c'
                    }
                },
                axisTick: {
                    show: false
                },
                splitLine: {
                    show: false,
                }
            },
            series: [{
                name: '1月',
                type: 'bar',
                barMaxWidth:'30%',
                itemStyle: {
                    normal: {
                        color: '#4150d8',
                        label: {
                            show: true,
                            position: 'top',
                            textStyle: {
                                color: '#4150d8',
                            }
                        }
                    }
                },
                data: [1926.96, 653.76, 986.73,1191,4544.69,7504.61]
            },
                {
                    name: '2月',
                    type: 'bar',
                    barMaxWidth:'30%',
                    itemStyle: {
                        normal: {
                            color: '#28bf7e',
                            // barBorderRadius: 12,
                            label: {
                                show: true,
                                position: 'top',
                                textStyle: {
                                    color: '#28bf7e',
                                }
                            }
                        }
                    },
                    data: [929.39,272.57,424.81,590.7,1932.1,3284.62]
                },

                {
                    name: '3月',
                    type: 'bar',
                    barMaxWidth:'30%',
                    itemStyle: {
                        normal: {
                            color: '#ed7c2f',
                            // barBorderRadius: 12,
                            label: {
                                show: true,
                                position: 'top',
                                textStyle: {
                                    color: '#ed7c2f',
                                }
                            }
                        }
                    },
                    data: [195.55,294.28,462.67,630.61,2086.19,3563.18]
                },
                {
                    name: '4月',
                    type: 'bar',
                    barMaxWidth:'30%',
                    itemStyle: {
                        normal: {
                            color: '#e2585a',
                            // barBorderRadius: 12,
                            label: {
                                show: true,
                                position: 'top',
                                textStyle: {
                                    color: '#e2585a',
                                }
                            }
                        }
                    },
                    data: [222.38,332.89,522.24,706.22,2355.72,4077.26]
                }
            ]
        };
        // 使用制定的配置项和数据显示图表
        chart3.setOption(option3);
        window.onresize = function() {
            chart3.resize();
        }
    }
}
)