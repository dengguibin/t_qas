<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>诊断分析</title>
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
		<script type="text/javascript" src="/analy/js/analyCom.js" ></script>
	</head>
	<body>
		<div class="wrapper analy">
			<div class="main">
				<div class="main-content container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 content-r">
							<div class="row box">
								<div class="col-lg-12 col-md-12 col-sm-12 con-top">
									<!-- 标题   -->
									<h5 class="at-1">${itemFruitPage.itemAnaly.name}分析：</h5>
									<div class="con">
										本次从<#list itemFruitPage.itemAnaly.basicList as basicMap>
												${basicMap.basicName}，
											</#list>这些方面对${itemFruitPage.itemAnaly.name}进行了诊断，总体达标率为 
										<span class="dis-warn ${itemFruitPage.itemAnaly.reachClass}">
											${itemFruitPage.itemAnaly.reachValue}</span>。
									</div>
									<div class="con">
										诊断要素的诊断情况如下：
									</div>
									<div class="diag-result">
									<#list itemFruitPage.itemAnaly.basicList as basicMap>
										<div class="diag-r-item">
											<i class="icon-small ${basicMap.basicClass!''}"></i><span>${basicMap.basicName}</span>
										</div>
									</#list>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="con">
										<span>诊断结论：</span>
									</div>
									<div class="con">
										<span class="dis-warn ${itemFruitPage.itemAnaly.reachClass}">
											${itemFruitPage.itemAnaly.diagnoseConclusion}
										</span>
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
									<div>
										<ul class="list">																				
									<#if itemFruitPage??>
										<#if itemFruitPage.itemAnaly.questionList?exists>
											<#list itemFruitPage.itemAnaly.questionList as questionMap>					
												<li>
													<h6>${(questionMap.name)!}</h6>
													<div class="clear">
														<h6 class="left sbox-t warn">问题描述：</h6>
														<p class="sbox-c">${(questionMap.questioninfo)!}</p>
													</div>
													<div class="clear">
														<h6 class="left sbox-t suggest">改进建议：</h6>
														<p class="sbox-c">${(questionMap.suggestioninfo)!}</p>
													</div>
												</li>
											</#list>
										</#if>
									</#if>
										</ul>
									</div>
								</div>
							</div>
							
							<!--要素导航-->
							<div class="row box" id="sub_nav">
								<ul class="nav nav-tabs">
									<li class="first">
										<select class="nav-select" id="index_type">
											<option>全部指标</option>
									<#if itemFruitPage??>
										<#if itemFruitPage.itemAnaly.elementList?exists>
											<#list itemFruitPage.itemAnaly.elementList as map>
												<option>${(map.element)!}</option>
											</#list>
										</#if>
									</#if>
										</select>
									</li>									
							<#if itemFruitPage??>
								<#if itemFruitPage.itemAnaly.elementList?exists>
									<#list itemFruitPage.itemAnaly.elementList as map>
										<li role="presentation" class="list-i">
											<a href="#sub_con_${(map_index)!}">${(map.element)!}</a>
										</li>
									</#list>
								</#if>
							</#if>
								</ul>
							</div>
							<!--指标结果-->
				<#if itemFruitPage??>
					<#if itemFruitPage.itemAnaly.elementList?exists>
						<#list itemFruitPage.itemAnaly.elementList as map>
							<div class='row box2' id='sub_con_${(map_index)!}'>
								<h4 class="sub-t">${(map.element)!}</h4>
							<#list map.moleculeList as molecule>
								<#if molecule.type == 1>
								<div class="col-lg-6 col-md-6 col-sm-6 box2-1">
									<div class="sbox">
										<div class="sbox-t-b">
											<h6 class="sbox-t">
 												<span class="${(molecule.stateClass)!}">${(molecule.stateName)!}</span>
 												${(molecule.indicatorName)!}
 												<span class="detail-btn" onclick="indicatorDetail('./${molecule.detailhre}')">详情</span>
											</h6>
										</div>
										<div class="hr2">
											<div id="chart_${(map_index)!}${(molecule_index)!}" class="chart_col_lg_6"></div>
										</div>
										<div class="s-conclusion">
											<h6 class="sbox-t">总结结论：</h6>
											<div class="s-con">
												${(molecule.conclusion)!}
											</div>
										</div>
									</div>
								</div>
								<#elseif molecule.type == 2>
								<div class="col-lg-6 col-md-6 col-sm-6 box2-1">
									<div class="sbox">
										<div class="sbox-t-b">
											<h6 class="sbox-t">
 												<span class="${(molecule.stateClass)!}">${(molecule.stateName)!}</span>
 												${(molecule.indicatorName)!}   
 												<span class="detail-btn" onclick="indicatorDetail('./${molecule.detailhre}')">详情</span>
											</h6>
										</div>
										<div>
											<table  class="table table-bordered">
												<thead>
													<tr>
														<th width="80">诊断结果</th>
										<#if molecule??>
											<#if molecule.tableMap?exists>
												<#if molecule.tableMap.theadList?exists>
													<#list molecule.tableMap.theadList as th>
														<th>${(th)!}</th>
													</#list>
												</#if>
											</#if>
										</#if>
													</tr>
												</thead>
												<tbody>
													<tr>
														<th>是</th>
										<#if molecule??>
											<#if molecule.tableMap?exists>
												<#if molecule.tableMap.ytdList?exists>
													<#list molecule.tableMap.ytdList as td>
														<td>${(td)!}</td>
													</#list>
												</#if>
											</#if>
										</#if>
													</tr>
													<tr>
														<th>否</th>
										<#if molecule??>
											<#if molecule.tableMap?exists>
												<#if molecule.tableMap.ntdList?exists>
													<#list molecule.tableMap.ntdList as td>
														<td>${(td)!}</td>
													</#list>
												</#if>
											</#if>
										</#if>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="s-conclusion">
											<h6 class="sbox-t">总结结论：</h6>
											<div class="s-con">
												${(molecule.conclusion)!}
											</div>
										</div>
									</div>
								</div>
								</#if>
							</#list>
							</div>
						</#list>
					</#if>
				</#if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	
	<script>
		$(document).ready(function(){
			//下拉框
			$("#index_type,#in_case").select2({
				width:'resolve',
			});
			var _wr = parseInt($(".content-r").width());
			var _hr1 = _wr * 0.32;
			var _hr2 = _wr * 0.26;
			
			$(".chart_col_lg_6").css({
				"height":_hr2 +"px",
			});
			
			var _length = $(".box2>.box2-1>.sbox").length;
			var temp = 0
			for(var i = 0;i < _length;i++){
				var _h = $(".box2>.box2-1>.sbox").eq(i).height();
				if(_h){
					temp = _h > temp ? _h : temp;
				}
			};
			$(".box2>.box2-1>.sbox").css({
				"height":temp +"px",
			});
			
			
		
<#if itemFruitPage??>	
	<#if itemFruitPage.itemAnaly.elementList?exists>			
		<#list itemFruitPage.itemAnaly.elementList as map>
			<#if map??>
				<#if map.moleculeList?exists>
					<#list map.moleculeList as molecule>
						<#if molecule.type == 1>
							${(molecule.echartsFunction)!}(echarts.init(document.getElementById('chart_${(map_index)!}${(molecule_index)!}')),${(molecule.echartsData)!},"${(molecule.firstDesc)!}","${(molecule.secondDesc)!}","${(molecule.sinpleDesc)!}","${molecule.indicatorName}","${molecule.qualifiedValue}");							
						</#if>
					</#list>
				</#if>
			</#if>
		</#list>
	</#if>
</#if>
		});
		
		//resize：窗口发生改变的时候触发
		$(window).resize(function(){

<#if itemFruitPage??>	
	<#if itemFruitPage.itemAnaly.elementList?exists>			
		<#list itemFruitPage.itemAnaly.elementList as map>
			<#if map??>
				<#if map.moleculeList?exists>
					<#list map.moleculeList as molecule>
						<#if molecule.type == 1>
							echarts.init(document.getElementById('chart_${(map_index)!}${(molecule_index)!}')).resize();
						</#if>
					</#list>
				</#if>
			</#if>
		</#list>
	</#if>
</#if>
		});
		
		//查看详情按钮
		function indicatorDetail(path){
			var url = window.location.href.split("?")[0] ? window.location.href.split("?")[0] : window.location.href;
			url = url.replace("itemAnaly.html",path);
			
			top.layer.open({
			  	type: 2,
			  	skin: 'layui-layer-demo', //加上边框
			  	area: ['800px', '80%'], //宽高
				shadeClose: true,
			  	shade: 0.4,
			  	content: url,
			  	title:'详情',
			  	btn:["关闭"],
			});
		}
	</script>
</html>