<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>诊断分析总体概述</title>
		<link rel="stylesheet" href="/analy/plug-in/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/analy/plug-in/select2-master/dist/css/select2.min.css" />
		<link rel="stylesheet" href="/analy/css/icon.css" />
		<link rel="stylesheet" href="/analy/css/public.css" />
		<link rel="stylesheet" href="/analy/css/analy.css" />
		<script type="text/javascript" src="/analy/js/jquery.min.js"></script>
		<script type="text/javascript" src="/analy/plug-in/layer-v3.1.0/layer/layer.js"></script>
		<script type="text/javascript" src="/analy/plug-in/select2-master/dist/js/select2.full.min.js"></script>
		<script type="text/javascript" src="/analy/js/echarts_3.7.2.js" ></script>
		<script type="text/javascript" src="/analy/js/chart.js" ></script>
	</head>
	<body>
		<div class="wrapper">
			<div class="main">
				<div class="main-content container-fluid">
					<div class="row">
						<!--右边主要内容-->
						<div class="col-lg-12 col-md-12 col-sm-12 content-r">
							
							<!--总体诊断结果-->
							<div class="row box" style="padding-bottom: 0px;">
								<div class="col-lg-12 col-md-12 col-sm-12 con-top no-bt"><h5 class="at-1 clear">${analyGeneral.generalOverview.objName}总体诊断结果：</h5></div>	
								<div class="clear general">
									<!--左边的仪表盘-->
									<div class="general-l">
										<div class="clear">
											<div id="pie_a_1" class="left"></div>
											<div class="left general-l-c">
												<div>综合评分：<span class="col-1">${analyGeneral.generalOverview.score}</span>分</div>
												<div>本次排名：<span class="col-1">${analyGeneral.generalOverview.ranking!''}</span></div>
											</div>
										</div>
									</div>
									<!--右边-->
									<div class="general-r">
										<div class="general-r-t clear">
											<div class="comment left">
												<div><span>量化指标：<span class="num">${analyGeneral.generalOverview.quantitativeMap.num}</span></span><i class="icon comment-icon"><div class="com-tip"><p>量化指标得分的计算公式为：量化指标得分 = 量化指标汇总得分/量化指标总分 * 100</p></div></i></div>
												<div class="col-4">得分：<span class="col-1">${analyGeneral.generalOverview.quantitativeMap.score}</span>分</div>
											</div><div class="general-r-t-c right"><div class="inline"><div id="pie_1"></div></div><div class="inline"><div id="pie_2"></div></div><div class="inline"><div id="pie_3"></div></div></div>
										</div>
										<div class="general-r-b clear">
											<div class="comment left">
												<div><span>标志性成果：<span class="num">${analyGeneral.generalOverview.signMap.num}</span></span><i class="icon comment-icon"><div class="com-tip"><p>达成度的计算公式为： 达成度 = 0.6 * 已达成的国家级成果/国家级成果目标值 + 0.4 * 已达成的省级成果/省级成果目标值；</p><p>同一项目同时获得国家级成果奖和省级成果奖时，按最高级别统计；</p><p>同一项目获得多个标志性成果时不累计。</p></div></i></div>
												<div class="col-4">达成度：<span class="col-1">${analyGeneral.generalOverview.signMap.achieve}</span>%</div>
											</div><div class="general-r-b-c right"><div id="bar_b_1"></div></div>
										</div>
									</div>
								</div>
							</div>
							
							<!--综合评估各项目及状态-->
							<div class="row box">
								<div class="col-lg-12 col-md-12 col-sm-12 con-top">
									<h5 class="at-1 clear">综合评估各项目及状态<span id="index_detail" class='right col-3 index-detail'>指标明细></span></h5>
									<div class="con">本次从${analyGeneral.itemsMap.itemsAndObj}进行了诊断，总体达标率为<span class="col-1">${analyGeneral.itemsMap.standardRate}</span>。</div>
									<ul class="clear a-c-project">
									<#list analyGeneral.itemList as item>
										<#if item_index == 0>
										<li class="a-project p-${item.resultClass} select">
										<#else>
										<li class="a-project p-${item.resultClass}">
										</#if>
											<div><i class="icon-large"></i></div>
											<div class="a-p-1">${item.itemName}</div>
											<div><span class="a-p-2">${item.result}</span></div>
										</li>
									</#list>
									</ul>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 con-bottom">
									<div class="row hr1">
										<div class="col-lg-7 col-md-7 col-sm-7">
											<div class="a-d-index">
											<#list analyGeneral.itemList as item>
												<div class="a-d-box a-d-box-${item_index}">
													<div class="a-d-total">合格指标 <span class="col-2">${item.qualifiedNum}</span> 个，预警指标 <span class="col-5">${item.earlyWarningNum}</span> 个，不合格指标 <span class="col-1">${item.unqualifiedNum}</span> 个。</div>
													<div class="a-d-table">
														<div class="a-d-t-1">
															<table class="a-d-t">
																<thead><tr><td width="10%">序号</td><td class="t-left">指标名称</td><td width="18%">诊断结果</td><td width="15%">合格值</td></tr></thead>
															</table>
														</div>
														<div class="a-d-t-2">
															<table class="a-d-t">
																<tbody>
																<#list item.indicatorResultList as indicatorResult>
																	<tr class="${indicatorResult.classStyle}">
																		<td width="10%">${indicatorResult_index+1}</td>
																		<td class="t-left" title='${indicatorResult.name}'>${indicatorResult.name}</td>
																		<td width="18%">${indicatorResult.result}</td>
																		<td width="15%">${indicatorResult.acceptanceValue!''}</td>
																	</tr>
																</#list>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</#list>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-5" style="padding: 0;">
											<div id="radar_1"></div>
										</div>
									</div>
								</div>
							</div>
							
							<!--问题描述及改进意见-->
							<div class="row box">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div>
										<h5 class="at-1">问题描述及改进意见</h5>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 box2-1 col-sm-12">
									<div class="sbox hr2">
										<ul class="list">
										<#list analyGeneral.questionList as questionMap>
											<li>
												<h6>${(questionMap.name)}</h6>
												<div class="clear">
													<h6 class="left sbox-t warn">问题描述：</h6>
													<p class="sbox-c">${questionMap.questioninfo}</p>
												</div>
												<div class="clear">
													<h6 class="left sbox-t suggest">改进建议：</h6>
													<p class="sbox-c">${questionMap.suggestioninfo}</p>
												</div>
											</li>
										</#list>
										</ul>
									</div>
								</div>
							</div>
									
							<!--诊断对象横向对比-->
							<div class="row box">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div>
										<h5 class="at-1">诊断对象横向对比图</h5>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 hr2" style="position: relative;">
									<div id="bar_1" class="chart_col_lg_12"></div>
									<div class="point">
										<span class="ponit-i"></span>
										<span>
											得分
										</span>
									</div>
									<div class="deparOrS">
										<ul class="clear">
											<li class="select">同系部</li>
											<li>学校</li>
										</ul>
									</div>
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/analy/js/analyGeneral.js" ></script>
	<script>
		$(document).ready(function(){
			$("#in_select").select2({
				width:'resolve',
			});
		})
		//仪表盘
		pieAChart(echarts.init(document.getElementById('pie_a_1')),"${analyGeneral.generalOverview.score}","${analyGeneral.generalOverview.fruit}");
		
		//表示指标完成度的三个饼图
		var num1 = "${analyGeneral.generalOverview.quantitativeMap.qualifiedNum}";
		var num2 = "${analyGeneral.generalOverview.quantitativeMap.earlyWarningNum}";
		var num3 = "${analyGeneral.generalOverview.quantitativeMap.unqualifiedNum}";
		var sum = parseInt(num1) + parseInt(num2) + parseInt(num3);
		speedPie(echarts.init(document.getElementById('pie_1')),"${analyGeneral.generalOverview.quantitativeMap.qualifiedNum}","合格",0,sum);
		speedPie(echarts.init(document.getElementById('pie_2')),"${analyGeneral.generalOverview.quantitativeMap.earlyWarningNum}","预警",1,sum);
		speedPie(echarts.init(document.getElementById('pie_3')),"${analyGeneral.generalOverview.quantitativeMap.unqualifiedNum}","不合格",2,sum);
		
		//指标诊断
		barBChart(echarts.init(document.getElementById('bar_b_1')),${analyGeneral.generalOverview.signMap.resultCount});
		
		//雷达图
		Array.prototype.max = function(){return Math.max.apply({},this)};//获取数组的最大值
		var data = ${analyGeneral.itemsMap.itemsData};
		var _max = data[1].value.max();
		var _wr = parseInt($(".content-r").width());
		var _hr1 = _wr * 0.32;
		var _hr2 = _wr * 0.26;
		document.getElementById('radar_1').style.height = _hr1 + "px";
		radarChart(echarts.init(document.getElementById('radar_1')),"各项目分析结果",${analyGeneral.itemsMap.itemsName},data);
		
		//诊断对象横向对比图
		$(".chart_col_lg_12").css({
			"height":_hr2 +"px",
		});
		var bar_1 = echarts.init(document.getElementById('bar_1'));
		var data0 = ${analyGeneral.objGeneralMolecule.echartsData};
		var data1 = [{name:"机电与汽车学院",value:82},{name:"护理学院",value:34},{name:"旅游家政与艺术学院",value:78},{name:"食品药品学院",value:99}];
		singleBarChartObj(bar_1,data0);
		
		$(".deparOrS").on("click","li",function(){
			var idx = $(this).index();
			$(this).siblings("li").removeClass("select");
			$(this).addClass("select");
			if(idx == 0){
				singleBarChartObj(bar_1,data0);
			}else{
				singleBarChartObj
				(bar_1,data1);
			}
		});
		
		//resize：窗口发生改变的时候触发
		$(window).resize(function(){
			//图表的自适应，每一个初始化的echarts都需要调用改方法
			echarts.init(document.getElementById('pie_a_1')).resize();
			echarts.init(document.getElementById('pie_1')).resize();
			echarts.init(document.getElementById('pie_2')).resize();
			echarts.init(document.getElementById('pie_3')).resize();
			echarts.init(document.getElementById('bar_b_1')).resize();
			echarts.init(document.getElementById('radar_1')).resize();
			echarts.init(document.getElementById('bar_1')).resize();
		});
		
		//指标明细
		$("#index_detail").click(function(){
			window.location.href = "./${analyGeneral.indexDetail}";
		});
	</script>
</html>