$(document).ready(function(){
	//新增模型
	$(".add-temp").click(function(){
		var id = $(this).siblings("#id").val();
		var name = $(this).siblings("#name").val();
		//点击出来一个弹窗
		layer.open({
			id: 'addDiagnoseSchemeform',
		  	type: 2,
		  	skin: 'layui-layer-demo', //加上边框
		  	area: ['80%', '85%'], //宽高
			shadeClose: true,
		  	shade: 0.4,
		  	title:"指标详情",
		  	content: 'details.action?id='+id+'&name='+name,
		  	title:'<i class="s_logo"></i>指标详情',
		  /*	btn:["下一步"],
		  	yes:function(){
		  		var frameId=document.getElementById('addDiagnoseSchemeform').getElementsByTagName("iframe")[0].id;
		  	    $('#'+frameId)[0].contentWindow.mySubmit();
		  	}*/
		});
	})
})
Array.prototype.max = function() {
	return Math.max.apply({}, this)
};

//加载图的样式
var loadOpt = {
	text: 'loading',
	color: '#0387CE',
	textColor: '#333',
	maskColor: 'rgba(255, 255, 255, 0.9)',
	zlevel: 0
}

//预警、合格、不合格
function pieAChart(chart,num,name){
	chart.showLoading(loadOpt);
	var color = ["#ff494a","#ffaf23","#11d793"];
	var color1 = ["#ff0000","#ff494a"];
	//这里的40，70，100以及底下的0.4，0.7，1只是用来区分合格、不合格、预警，具体分值具体改变
	if(num >= 0 && num <40){
		color1 = ["#ff0000",color[0]];
	}else if(num >= 40 && num <70){
		color1 = ["#ff0000",color[1]];
	}else if(num >= 70 && num <= 100){
		color1 = ["#5ee5b7",color[2]];
	}else {
		color1 = ["#ff0000",color[0]];
	}
	var option = {
	    title: {
	        text:[
				'{a|' + num + '分}',
				'{b|' + name + '}'
			].join("\n"),
	        x: 'center',
	        y: 'center',
	        textStyle: {
	            color: "#666",
	            fontSize:14,
	           	rich:{
					a:{
						fontWeight: '600',
						fontSize:16,
					},
					b:{
						fontWeight: 'normal',
						fontSize:14,
						lineHeight:24,
						
					}
				}
	        }
	    },
	    tooltip: {
	    	show:false,
	    	confine:true,
	        trigger: 'item',
	        formatter: "{a} : {d}分"
	    },
	    series: [{
	        name: "专业总体诊断结果",
	        center: ["50%", "50%"],
	        radius: ["66%", "76%"],
	        hoverAnimation: false,
	        type: "pie",
	        clockWise: false,
	        cursor:"default",
	        data: [{
	            value: num,
	            name: "",
	            label: {
	                normal: {
	                    show: false,
	                    formatter: '{d} %',
	                    textStyle: {
	                        fontSize: 28,
	                        fontWeight: "bold"
	                    },
	                    position: "center"
	                }
	            },
	            labelLine: {
	                show: false
	            },
	            itemStyle: {
	                normal: {
	                   
	                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                        offset: 0,
	                        color: color1[0]
	                    }, {
	                        offset: 1,
	                        color: color1[1]
	                    }]),
	                    borderWidth: 0
	                }
	            },
	        }, {
	            name: " ",
	            value: 100 - num,
	            itemStyle: {
	                normal: {
	                    label: {
	                        show: false
	                    },
	                    labelLine: {
	                        show: false
	                    },
	                    color: '#fafafa',
	                    
	                }
	            }
	        }]
	    }, {
	        name: "专业总体诊断结果 外圈",
	        center: ["50%", "50%"],
	        radius: ["88%", "90%"],
	        clockWise: false,
	        hoverAnimation: false,
	        type: "pie",
	        data: [{
	            value: num,
	            name: "",
	            label: {
	                normal: {
	                    show: false,
	                    formatter: '{d} %',
	                    textStyle: {
	                        fontSize: 28,
	                        fontWeight: "bold"
	                    },
	                    position: "center"
	                }
	            },
	            labelLine: {
	                show: false
	            },
	            itemStyle: {
	                normal: {
	                    color: color1[1],
	                    borderWidth: 2
	                },
	                
	            },
	        }, {
	            name: " ",
	            value: 100 - num,
	            itemStyle: {
	                normal: {
	                    label: {
	                        show: false
	                    },
	                    labelLine: {
	                        show: false
	                    },
	                    color: 'rgba(0,0,0,0)',
	                    borderColor: 'rgba(0,0,0,0)',
	                    borderWidth: 0
	                },
	                emphasis: {
	                    color: 'rgba(0,0,0,0)',
	                    borderColor: 'rgba(0,0,0,0)',
	                    borderWidth: 0
	                }
	            }
	        }]
	    }]
	};
	chart.hideLoading();
	chart.setOption(option);
}

//柱状图(颜色不同的柱状图)
function barBChart(chart,data){
	chart.showLoading();
	var color = ["#1982ed","#7373f1","#ffa200","#11d793"];
	var dataX = [];
	var dataY1 = [];//总指标数
	var dataY2 = [];//诊断指标数
	for(var i = 0; i < data.length; i++){
		var idx = i % 4;
		dataX.push(data[i].name)
		dataY1.push({
			value:data[i].total,
			itemStyle:{
	        	normal:{
	        		color:color[idx],
	        		opacity:0.4
	        	}
	        }
		});
		dataY2.push({
			value:data[i].value,
			itemStyle:{
	        	normal:{
	        		color:color[idx],
	        		opacity:1
	        	}
	        }
		})
	};
	var option = {
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: { // 坐标轴指示器，坐标轴触发有效
	            type: 'line',// 默认为直线，可选为：'line' | 'shadow'
	            lineStyle:{
	            	color:"#fff",
	            	opacity:0
	            }
	        },
	        confine:true,
	        formatter:"{b}<br/>{a0} : {c0}个<br />{a1} : {c1}个"
	    },
	    grid:{
	    	left:0,
	    	bottom:20,
	    	top:0,
	    	right:0
	    },
	    xAxis: [{
	        type: 'category',
	        axisLine:{
	        	show:false
	        },
	        axisTick:{
	        	show:false
	        },
	        data: dataX
	    }],
	    yAxis: [{
	    	show:false,
	        type: 'value',
	        name: '',
	        axisLabel: {
	            formatter: '{value}'
	        }
	    }],
	    series: [{
	        name: '总指标数',
	        type: 'bar',
	        barGap:"-100%",
	        barWidth:20,
	        data: dataY1
	    }, {
	        name: '诊断指标',
	        type: 'bar',
	        barWidth:20,
	        data:dataY2
	    }]
	};
	chart.hideLoading();
	chart.setOption(option);
}

//饼图进度条
function speedPie(chart,num,txt,stute){
	//stute:0 合格
	//stute:1 预警
	//stute:2 不合格
	chart.showLoading(loadOpt);
	//已完成样式
	var sum = 20;//指标的总数,具体情况具体分析
	var color = ["#ff494a","#ffaf23","#11d793"];
	var color1 = "#ff494a";
	//这里的5,10,20以及只是用来区分合格、不合格、预警，具体分值具体改变
	
	if(stute == 0){
		color1 = color[2];
	}else if(stute == 1){
		color1 = color[1];
	}else if(stute == 2){
		color1 = color[0];
	}else {
		color1 = color[0];
	}
	
	var dataStyle = {
	    normal: {
	        label: {
	            show: false
	        },
	        labelLine: {
	            show: false
	        },
	        
	    }
	};
	var placeHolderStyle = {
	    normal: {
	        color: '#e1e7f0',//未完成的圆环的颜色
	        label: {
	            show: false
	        },
	        labelLine: {
	            show: false
	        },
	        shadowColor: 'rgba(0, 0, 0, 0.5)',
    		shadowBlur: 0
	    },
	    emphasis: {
	        color: '#e1e7f0'//未完成的圆环的颜色
	    }
	};
	
	var option = {
		animationDuration:2000,
	    title: {
	        text:[
				'{a|' + num + '个}',
				'{b|' + txt + '}'
			].join("\n"),
	        x: 'center',
	        y: 'center',
	        textStyle: {
	            color: "#333",
	            fontSize:14,
	           	rich:{
					a:{
						fontWeight: '600',
					},
					b:{
						fontWeight: 'normal',
					}
				}
	        }
	    },
		color:[color1],
	    tooltip: {
	        show: false,
	        confine:true,
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        show: false,
	        itemGap: 12,
	        data: ['01', '02']
	    },
	    
	    series: [{
	            name: 'pie 1',
	            type: 'pie',
	            clockWise: false,
	            radius: ["70%", "82%"],
	            itemStyle: dataStyle,
	            hoverAnimation: false,
	            data: [{
	                    value: num,
	                    name: '01'
	                }, {
	                    value: sum - num,
	                    name: 'invisible',
	                    itemStyle: placeHolderStyle
	                }
	
	            ]
	        }, {
	            name: 'pie 2',
	            type: 'pie',
	            animation: false,
	            clockWise: false,
	            radius: [320, 318],
	            itemStyle: dataStyle,
	            hoverAnimation: false,
	            tooltip: {
	                show: false,
	                confine:true,
	            },
	            data: [{
	                    value: sum,
	                    name: '02',
	                    itemStyle: {
	                        
	                    }
	                }, {
	                    value: 0,
	                    name: 'invisible',
	                    itemStyle: placeHolderStyle
	                }
	
	            ]
	        },
	    ]
	};
	chart.hideLoading();
	chart.setOption(option);
}

//乘法
function mul(a, b) {
    var c = 0,
        d = a.toString(),
        e = b.toString();
    try {
        c += d.split(".")[1].length;
    } catch (f) {}
    try {
        c += e.split(".")[1].length;
    } catch (f) {}
    return Number(d.replace(".", "")) * Number(e.replace(".", "")) / Math.pow(10, c);
}

//除法
function div(a, b) {
    var c, d, e = 0,
        f = 0;
    try {
        e = a.toString().split(".")[1].length;
    } catch (g) {}
    try {
        f = b.toString().split(".")[1].length;
    } catch (g) {}
    return c = Number(a.toString().replace(".", "")), d = Number(b.toString().replace(".", "")), mul(c / d, Math.pow(10, f - e));
}

//单色柱状图
function singleBarChart(chart,data,firstDesc,secondDesc,sinpleDesc,indicatorName,time,echartIndex){
//function singleBarChart(chart,data){
	chart.showLoading(loadOpt);
	var length = data.length;
	var rotate = length>8?20:0;
	var bottom = length>8?70:40;
	var dataX = [];//柱状图的x轴的数据[1,1,1,1]
	var dataY = [];//柱状图的y轴的数据[1,1,1,1]
	for(var i = 0;i < length; i ++){
		dataX.push(data[i].name);
		dataY.push(data[i].value)
	};
	var option = {
		grid:{
			top:50,
			bottom:bottom,
		},
		tooltip: {
			trigger: 'item',
			//formatter:"{a}</br>{b} : {c}分",
			formatter:"{a}</br>{b} : {c}",
			confine:true,
		},
		toolbox:{
			show: true,
			feature:{
				saveAsImage:{
					show:true,
					type:"png"
				},
				name:"专业得分",
				magicType: {
			        type: ['line', 'bar']
			    }
			},
			left:60,
			top:0
		},
		xAxis: {
			show: true,
			axisLabel: {
				interval: 0,
				rotate: rotate,
				showMaxLabel:true,
				color:"#666",
			},
			axisLine:{
				lineStyle: {
					color: '#ccc'
				}
			},
			axisTick: {
				alignWithLabel: true,
			},
			splitLine: {
				lineStyle: {
					color: '#ccc'
				}
			},
			data:dataX,
		},
		yAxis: {
			show: true,
			type: "value",
			min:'0',
			axisLabel: {
				interval: 0,
				color:"#666",
			},
			axisLine:{
				lineStyle: {
					color: '#ccc'
				}
			},
			axisTick: {
				alignWithLabel: true,
			},
			splitLine: {
				lineStyle: {
					color: '#eee'
				}
			},
		},
		series: [{
			type: "bar",
			name: sinpleDesc,
			//name: "专业对比",
			data: dataY,
			barWidth: "20",
			itemStyle: {
				normal: {
					color: new echarts.graphic.LinearGradient(
						0, 0, 0, 1, [{
							offset: 0,
							color: '#83bff6'
						}, {
							offset: 0.5,
							color: '#188df0'
						}, {
							offset: 1,
							color: '#188df0'
						}]
					)
				},
				emphasis: {
					color: new echarts.graphic.LinearGradient(
						0, 0, 0, 1, [{
							offset: 0,
							color: '#2378f7'
						}, {
							offset: 0.7,
							color: '#2378f7'
						}, {
							offset: 1,
							color: '#83bff6'
						}]
					)
				}
			},
			label: {
				normal: {
					show: true,
					position: "top",
					formatter: "{c}",
					color: "#2378f7",
				}
			}
		}]
	}

	chart.hideLoading();
	chart.setOption(option);

	if(time){
		var time = time;
		var _date = new Date();
		var yearCurrent = _date.getFullYear();//当前年份 
	   	var monCurrent = _date.getMonth(); //当前月 
	   	var dayCurrent = _date.getDate();//当前日
		if(dataX[0].indexOf("月") >= 0){
			//x轴的数据格式是X月X
			var monthArr = ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"];
	
			var timer = setInterval(function (){
				
				var lenX = dataX.length;
	    		var dataV = dataX[lenX - 1].split("月");
	    		var index = monthArr.indexOf(dataV[0] + "月"); //获取当前月份的索引
	    		var setDate = new Date(yearCurrent,index + 1,1 - 1); //把时间设为下个月的1号 然后天数减去1 就可以得到 当前月的最后一天; 
	    		var setDay = setDate.getDate(); //获取 当前月最后一天 
	    		var month = parseInt(dataV[0]);
	    		var day = parseInt(dataV[1]);
	    		day ++;
	    		
				var data0 = option.xAxis.data;
			    var data1 = option.series[0].data;
			    data0.shift();//删除数组的第一个元素;
			    if(month < monCurrent + 1){
			    	if(day > setDay){
		    			data0.push(monthArr[index + 1] + "1");
		    		}else{
		    			data0.push(monthArr[index] + "" + day);
					}; 
			    }else if(month = monCurrent + 1){
			    	if(day > dayCurrent){
		    			data0.push("1月1");
		    		}else{
		    			data0.push(month + "月" + day);
					}; 
			    }else{
			    	data0.push("1月1");
			    };
			    data1.shift();
			    data1.push(parseInt(Math.round(Math.random() * 60)));
			    chart.setOption({
			    	xAxis:{
			    		data:data0
			    	},
			    	series:[{
			    		data:data1
			    	}]
			    });
			}, time);
			if(timeArr[echartIndex]){
				timeArr[echartIndex] = timer;
			}else if(timeArr){
				timeArr.push(timer)
			}else{
				
			}
			console.log(echartIndex,timeArr)
		}else if(dataX[0].length == 6 && dataX[0].indexOf("201") >= 0){
			//x轴的格式是201712 年+月 6位数
			var timer = setInterval(function (){
				
				var lenX = dataX.length;
	    		var dataY = dataX[lenX - 1].slice(0,4);//截取年份
	    		var dataM = dataX[lenX - 1].slice(4,6);//截取月份
	    		dataM --;
				var data0 = option.xAxis.data;
			    var data1 = option.series[0].data;
			    data0.shift();//删除数组的第一个元素;
			    
			    if(dataY == yearCurrent - 1){
	    			if(dataM < 1){
	    				if(monCurrent < 9){
	    					data0.push(yearCurrent + "" + "0" + (monCurrent + 1));
	    				}else{
	    					data0.push(yearCurrent + "" + (monCurrent + 1));
	    				}
		    		}else{
		    			if(dataM < 10 && dataM >= 1){
		    				data0.push(yearCurrent - 1 + "" + "0" + dataM);
				    	}else{
				    		data0.push(yearCurrent - 1 + "" + dataM);
				    	}
		    		}
	    		}else if(dataY == yearCurrent){
	    			
	    			if(dataM < 1){
	    				data0.push("201712");
		    		}else if(dataM < 10 && dataM >= 1){
		    			data0.push(yearCurrent + "" + "0" + dataM);
		    		}else{
		    			data0.push(yearCurrent + "" + dataM);
		    		}
	    		};
			    data1.shift();
			    data1.push(parseInt(Math.round(Math.random() * 100)));//取一个小于100的随机整数
			    chart.setOption({
			    	xAxis:{
			    		data:data0
			    	},
			    	series:[{
			    		data:data1
			    	}]
			    });
			}, time);
			if(timeArr[echartIndex]){
				timeArr[echartIndex] = timer;
			}else if(timeArr){
				timeArr.push(timer)
			}else{
				
			}
			console.log(echartIndex,timeArr)
		}else{
			
		};
		
	}
	
}

//双柱状图
function doubleBarChart(chart,data,firstDesc,secondDesc,sinpleDesc,indicatorName,time,echartIndex){
//function doubleBarChart(chart,data){
	chart.showLoading(loadOpt);
	var length = data.length;
	var rotate = length>6?20:0;
	var bottom = length>6?70:40;
	var sum = 1000;//毕业总人数
	var dataX = [];//柱状图的x轴的数据[1,1,1,1]
	var dataY1 = [];//柱状图的y轴的数据[1,1,1,1];毕业生对教学满意的人数
	var dataY2 = [];//柱状图的y轴的数据[1,1,1,1];毕业生总人数
	var dataY3 = [];//柱状图的y轴的数据[1,1,1,1];毕业生的教学满意度
	var colors = ["#1982ed","#11d793","#ffa200"];
	
	//指标名称中含有满意度、比例、%、师占、数占等等才显示百分比，含有均、均占等等其它的直接不做处理，相除展示

	var a=indicatorName.indexOf("满意度");
	var b=indicatorName.indexOf("比例");
	var c=indicatorName.indexOf("%");
	var d=indicatorName.indexOf("师占");
	var e=indicatorName.indexOf("数占");
	//var f=indicatorName.indexOf("均");
	//var g=indicatorName.indexOf("均占");
	
	var indicatorName1="";//处理之后的指标名称
	var suffix="";//单位
	var end1;
	var end=indicatorName.indexOf("（");//去除指标名称中的"(%)"
	if(end>0){
		indicatorName1=indicatorName.substr(0,end);
	    end1=indicatorName.indexOf("）");
		if(end1>=end){			
			suffix=indicatorName.substr(end,end1);//eg：截取单位：(m2/生)
		}
	}else{
		indicatorName1=indicatorName;
	}
	
	for(var i = 0;i < length; i ++){
		dataX.push(data[i].name);
		dataY1.push(data[i].value1);
		dataY2.push(data[i].value2);
		if(a>0 || b>0 || c>0 || d>0 || e>0){
			dataY3.push((data[i].value1 / data[i].value2 * 100).toFixed(2));
		}else{
			dataY3.push((data[i].value1 / data[i].value2).toFixed(2));//拼接单位			
		}
	};
	
	var max1 = dataY1.max();
	var max2 = dataY2.max();
	var max=max1>max2?max1:max2;
	
	var formatter;
	if(a>0 || b>0 || c>0 || d>0 || e>0){
		formatter="{b}</br>{a0}:{c0}<br>{a1}:{c1}</br>{a2}:{c2}%"
	}else{
		if(end1>end && end>0){
			formatter="{b}</br>{a0}:{c0}<br>{a1}:{c1}</br>{a2}:{c2}"+suffix
		}else{
			formatter="{b}</br>{a0}:{c0}<br>{a1}:{c1}</br>{a2}:{c2}"
		}
	}
	
	var option = {
	    color: colors,
	    tooltip: {
	    	confine:true,
	        axisPointer: {
	        	type: 'shadow'
	        },
			trigger: 'axis',
				formatter:formatter
	    },
	    grid: {
			bottom:bottom
	    },
//	    toolbox: {
//	        feature: {
//	            saveAsImage: {show: true}
//	        }
//	    },
	    toolbox:{
			show: true,
			feature:{
				saveAsImage:{
					show:true,
					type:"png"
				},
			},
			right:0,
			top:0
		},
	    xAxis: [
	        {
	            type: 'category',
	            rotate: rotate,
	            axisLabel: {
					interval: 0,
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	            data: dataX
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            name: '数量(人)',
	            min: 0,
	            max:max,
	            position: 'left',
	            axisLabel: {
					interval: 0,
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	        },
	        {
	            type: 'value',
	            name: '数量(人)',
	            min: 0,
	            max:max,
	            position: 'left',
	           	offset:200,
	            axisLabel: {
					interval: 0,
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	        },
	        {
	            type: 'value',
	            name: '比例(%)',
	            min: 0,
	            max: 100,
	            position: 'right',
	            axisLabel: {
					interval: 0,
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	        }
	    ],
	    series: [
	        {
	            name:firstDesc,
	            //name:"我是软件专业人数",
	            type:'bar',
	            data:dataY1
	        },
	        {
	            name:secondDesc,
	            //name:"我是学生总数",
	            type:'bar',
	            yAxisIndex: 1,
	            data:dataY2,
	        },
	        {
	            name:indicatorName1,
	            //name:"软件专业人数的占比",
	            //name:"啊啊啊啊啊啊啊",
	            type:'line',
	            yAxisIndex: 2,
	            data:dataY3
	        }
	    ]
	};

	chart.hideLoading();
	chart.setOption(option);
	
	
	//随机数
	if(time){
		var time = time;
		var _date = new Date();
		var yearCurrent = _date.getFullYear();//当前年份 
	   	var monCurrent = _date.getMonth(); //当前月 
	   	var dayCurrent = _date.getDate();//当前日
		if(dataX[0].length == 6 && dataX[0].indexOf("201") >= 0){
			//x轴的格式是201712 年+月 6位数
			var timer = setInterval(function (){
				
				var lenX = dataX.length;
	    		var dataY = dataX[lenX - 1].slice(0,4);//截取年份
	    		var dataM = dataX[lenX - 1].slice(4,6);//截取月份
	    		dataM --;
				var data0 = option.xAxis[0].data;
				var data1 = option.series[0].data;
				var data2 = option.series[1].data;
				var data3 = option.series[2].data;
			    data0.shift();//删除数组的第一个元素;
			    
			    if(dataY == yearCurrent - 1){
	    			if(dataM < 1){
	    				if(monCurrent < 9){
	    					data0.push(yearCurrent + "" + "0" + (monCurrent + 1));
	    				}else{
	    					data0.push(yearCurrent + "" + (monCurrent + 1));
	    				}
		    		}else{
		    			if(dataM < 10 && dataM >= 1){
		    				data0.push(yearCurrent - 1 + "" + "0" + dataM);
				    	}else{
				    		data0.push(yearCurrent - 1 + "" + dataM);
				    	}
		    		}
	    		}else if(dataY == yearCurrent){
	    			
	    			if(dataM < 1){
	    				data0.push("201712");
		    		}else if(dataM < 10 && dataM >= 1){
		    			data0.push(yearCurrent + "" + "0" + dataM);
		    		}else{
		    			data0.push(yearCurrent + "" + dataM);
		    		}
	    		};
	    		
	    		
			    var lenY = data1.length;
			    data1.shift();
			    data2.shift();
			    data3.shift();
			    data2.push(parseInt(Math.round(Math.random() * parseInt(max/2)) + max - (max/2)));
			    data1.push(parseInt(Math.round(Math.random() * data2[lenY - 1])));
			    
			    if(a>0 || b>0 || c>0 || d>0 || e>0){
					data3.push((data1[lenY - 1] / data2[lenY - 1] * 100).toFixed(2));
				}else{
					data3.push((data1[lenY - 1] / data2[lenY - 1]).toFixed(2));//拼接单位			
				}
			    chart.setOption({
			    	xAxis:{
			    		data:data0
			    	},
			    	series:[{
			    		data:data1
			    	},{
			    		data:data2
			    	},{
			    		data:data3
			    	}]
			    });
			}, time);
			if(timeArr[echartIndex]){
				timeArr[echartIndex] = timer;
			}else if(timeArr){
				timeArr.push(timer)
			}else{
				
			}
			console.log(echartIndex,timeArr)
		}else{
			
		};
	};
}

//堆叠柱状图
function stackBarChart(chart,data){
	chart.showLoading(loadOpt);
	var length = data.length;
	var rotate = length>6?20:0;
	var bottom = length>6?60:20;
	var sum = 1000;//毕业总人数
	var dataX = [];//柱状图的x轴的数据[1,1,1,1]
	var dataY1 = [];//柱状图的y轴的数据[1,1,1,1];毕业生对教学满意的人数
	var dataY2 = [];//柱状图的y轴的数据[1,1,1,1];毕业生总人数
	var dataY3 = [];//柱状图的y轴的数据[1,1,1,1];毕业生的教学满意度
	var colors = ["#1982ed","#11d793","#ffa200"];
	
	for(var i = 0;i < length; i ++){
		dataX.push(data[i].name);
		dataY1.push(data[i].value1);
		dataY2.push(data[i].value2);
		
	};
	var max1 = dataY1.max();
	var max2 = dataY2.max();
	var max = max1 + max2;
	var option = {
	    color: colors,
	    tooltip: {
	    	confine:true,
	        axisPointer: {
	        	type: 'shadow'
	        },
			trigger: 'axis',
			formatter:"{b}</br>{a0}:{c0}<br>{a1}:{c1}"
	    },
	    grid: {
			bottom:bottom
	    },
	    toolbox:{
			show: true,
			feature:{
				magicType: {
					type: ['line', 'bar']
				},
				saveAsImage:{
					show:true,
					type:"png"
				},
			},
			right:0,
			top:0
		},
	    xAxis: [
	        {
	            type: 'category',
	            rotate: rotate,
	            axisLabel: {
					interval: 0,
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	            data: dataX
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            name: '数量(人)',
	            min: 0,
	            max:max,
	            position: 'left',
	            axisLabel: {
					interval: 0,
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	        },
	        {
	            type: 'value',
	            name: '数量',
	            min: 0,
	            max:max,
	            position: 'left',
	           	offset:200,
	            axisLabel: {
					interval: 0,
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	        }
	    ],
	    series: [
	        {
	            name:'毕业生对教学满意的人数',
	            type:'bar',
	            data:dataY1,
	            barWidth:"40%",
	             //如果想要两个系列的柱子重叠，可以设置 barGap 为 '-100%'。这在用柱子做背景的时候有用。
	            stack:"堆叠",//数据堆叠，同个类目轴上系列配置相同的stack值可以堆叠放置。
	        },
	        {
	            name:'毕业生总人数',
	            type:'bar',
	            yAxisIndex: 1,
	            data:dataY2,
	            barWidth:"40%",
	            stack:"堆叠",//数据堆叠，同个类目轴上系列配置相同的stack值可以堆叠放置。
	        }
	    ]
	};

	chart.hideLoading();
	chart.setOption(option);
}

//横向柱状图,flag：是否堆叠
function hBarChart(chart,data,flag){
	var stack = flag?"堆叠":null;
	chart.showLoading(loadOpt);
	var length = data.length;
	var sum = 1000;//毕业总人数
	var dataX = [];//柱状图的x轴的数据[1,1,1,1]
	var dataY1 = [];//柱状图的y轴的数据[1,1,1,1];毕业生对教学满意的人数
	var dataY2 = [];//柱状图的y轴的数据[1,1,1,1];毕业生总人数
	var dataY3 = [];//柱状图的y轴的数据[1,1,1,1];毕业生的教学满意度
	var colors = ["#1982ed","#11d793","#ffa200"];
	var nameL = 0;
	for(var i = 0;i < length; i ++){
		dataX.push(data[i].name);
		dataY1.push(data[i].value1);
		dataY2.push(data[i].value2);
		nameL = data[i].name.length > nameL ? data[i].name.length : nameL;
	};
	var max1 = dataY1.max();
	var max2 = dataY2.max();
	var max = max1 + max2;
	var left = nameL > 6?140:90;
	var option = {
	    color: colors,
	    tooltip: {
	    	confine:true,
	        axisPointer: {
	        	type: 'shadow'
	        },
			trigger: 'axis',
			formatter:"{b}</br>{a0}:{c0}<br>{a1}:{c1}"
	    },
	    grid: {
			left:left,
			top:30,
			bottom:30,
	    },
	    toolbox:{
			show: true,
			feature:{
				magicType: {
					type: ['line', 'bar']
				},
				saveAsImage:{
					show:true,
					type:"png"
				},
			},
			right:0,
			top:0
		},
	    yAxis: [
	        {
	            type: 'category',
	            axisLabel: {
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	            data: dataX
	        }
	    ],
	    xAxis: [
	        {
	            type: 'value',
	            name: '数量',
	            min: 0,
	            max:max,
	            position: 'left',
	            axisLabel: {
					interval: 0,
					color:"#666",
				},
				axisLine:{
					lineStyle: {
						color: '#ccc'
					}
				},
				axisTick: {
					alignWithLabel: true,
				},
				splitLine: {
					lineStyle: {
						color: '#eee'
					}
				},
	        }
	    ],
	    series: [
	        {
	            name:'毕业生对教学满意的人数',
	            type:'bar',
	            data:dataY1,
	            barWidth:"40%",
	             //如果想要两个系列的柱子重叠，可以设置 barGap 为 '-100%'。这在用柱子做背景的时候有用。
	            stack:stack,//数据堆叠，同个类目轴上系列配置相同的stack值可以堆叠放置。
	        },
	        {
	            name:'毕业生总人数',
	            type:'bar',
	            data:dataY2,
	            barWidth:"40%",
	            stack:stack,//数据堆叠，同个类目轴上系列配置相同的stack值可以堆叠放置。
	        }
	    ]
	};

	chart.hideLoading();
	chart.setOption(option);
	
}

//单折线
function singleLineChart(chart,data,txt){
	chart.showLoading(loadOpt);
	var length = data.length;
	var rotate = length>6?20:0;
	var bottom = length>6?60:20;
	var dataX = [];//柱状图的x轴的数据[1,1,1,1]
	var dataY = [];//柱状图的y轴的数据[1,1,1,1]
	var colors = ["#1982ed","#11d793","#ffa200"];
	/*
	 不同颜色对应的rgb:#1982ed: (25, 130, 237); #11d793: (17, 215, 147); #ffa200: (255, 162, 0)
	 * */
	for(var i = 0;i < length; i ++){
		dataX.push(data[i].name);
		dataY.push((data[i].value1 / data[i].value2 * 100).toFixed(2));
	};
	option = {
		color:colors,
	    tooltip: {
	    	confine:true,
			trigger: 'axis',
			formatter:"{b}</br>{a} : {c}%"
	    },
	    grid: {
			bottom:bottom
	    },
	    toolbox: {
	        show: true,
	        feature: {
	            magicType: {type: ['line', 'bar']},
	            saveAsImage: {}
	        }
	    },
	    xAxis:  {
	        type: 'category',
	        boundaryGap: false,
	        data: dataX,
	        rotate: rotate,
	        axisLabel: {
				interval: 0,
				color:"#666",
			},
			axisLine:{
				lineStyle: {
					color: '#ccc'
				}
			},
			axisTick: {
				alignWithLabel: true,
			},
			splitLine: {
				lineStyle: {
					color: '#eee'
				}
			},
	    },
	    yAxis: {
	        type: 'value',
	        name: '比例(%)',
	        min:0,
	        max:100,
	        axisLabel: {
	            formatter: '{value}',
	            interval: 0,
				color:"#666",
	        },
			axisLine:{
				lineStyle: {
					color: '#ccc'
				}
			},
			splitLine: {
				lineStyle: {
					color: '#eee'
				}
			},
	    },
	    series: [{
	    	//stack:数据堆叠，同个类目轴上系列(series)配置相同的stack值后，后一个系列的值会在前一个系列的值上相加。
	        name:txt,
	        type:'line',
	        data:dataY,
	        barWidth:"40%",
	        areaStyle: {
	        	//区域填充样式。
	            normal: {
	                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                    offset: 0,
	                    color: 'rgba(25, 130, 237,0.5)'
	                }, {
	                    offset: 1,
	                    color: 'rgba(25, 130, 237,0.2)'
	                }], false)
	            }
	        },
	        markPoint:{
	        	//标记
	        	data:[{
	        		type:"min",
	        		name:"最小值"
	        	},{
	        		type:"max",
	        		name:"最大值"
	        	}],
	        	itemStyle:{
	        		normal:{
	        			color:"#ff3700"
	        		}
	        	}
	        }
	    }]
	};

	chart.hideLoading();
	chart.setOption(option);
}
//饼图 radius:是否为空心元圆(true/false);flag:是否展示成南丁格尔图
function pieChart(chart,text,data,radius,flag){
	console.log(radius)
	chart.showLoading();
	var lengend = [];
	var top = data.length > 10?"20":"20%";
	var radius = radius?["50%","70%"]:["0","70%"];
	var center = flag?["50%","50%"]:['30%', '50%'];
	if(flag){
		radius = ["0","70%"];
	}
	console.log(radius)
	if(data.length >0){
		for(var i = 0; i < data.length ; i++){
			console.log(data.length)
			lengend.push(data[i].name)
		}
	};
	var option = {
	    tooltip : {
	    	confine:true,
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend:{
	    	show:!flag,
	    	data:lengend,
	    	orient:"vertical",
	    	right:20,
	    	top:top,
	    	textStyle:{
	    		color:"#666",
	    	}
	    },
	    color:["#1982ed","#11d793","#ff494a","#7373f1","#F9DE41","#ffa200"],
	    series : [{
	        name: text,
	    	type: 'pie',
	    	radius:  radius,
	    	center: center,
	    	data: data,
	    	roseType:flag,//是否展示成南丁格尔图
	    	itemStyle: {
	    		emphasis: {
	    			shadowBlur: 10,
	    			shadowOffsetX: 0,
	    			shadowColor: 'rgba(0, 0, 0, 0.5)'
	    		}
	    	},
	    	label:{
	    		normal:{
	    			show:flag,
	    			color:"#999",
	    			
	    		}
	    	},
	    	labelLine:{
	    		normal:{
	    			lineStyle:{
	    				color:"#ccc"
	    			}
	    		}
	    	}
	    }]
	};
	chart.hideLoading();
	chart.setOption(option);
}