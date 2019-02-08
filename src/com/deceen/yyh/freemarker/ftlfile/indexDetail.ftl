<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>指标明细</title>
		<link rel="stylesheet" href="/analy/plug-in/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/analy/plug-in/select2-master/dist/css/select2.min.css" />
		<link rel="stylesheet" href="/analy/css/icon.css" />
		<link rel="stylesheet" href="/analy/css/public.css" />
		<link rel="stylesheet" href="/analy/css/analy.css" />
		<script type="text/javascript" src="/analy/js/jquery.min.js"></script>
		<script type="text/javascript" src="/analy/plug-in/select2-master/dist/js/select2.full.min.js"></script>
		<script type="text/javascript" src="/analy/js/echarts_3.7.2.js" ></script>
		<script type="text/javascript" src="/analy/js/chart.js" ></script>
	</head>
	<body>
		<div class="wrapper index-d">
			<div class="main">
				<div class="main-content container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 content-r">
							<div class="search-box box row clear">
								
								<div class="col-lg-12 col-md-12 col-sm-12">
									<ul class="in-list clear">
										<li class="select">量化指标</li>
										<li>标志性结果</li>
									</ul>
								</div>
								
								<div class="col-lg-12 col-md-12 col-sm-12 index-con index-con-1">
									<div class="index-box clear">
										<div class="left">
											<span>诊断状态：</span>
											<select class="in-select" id="index_type">
												<option>
													全部
												</option>
												<option>
													不合格
												</option>
												<option>
													预警
												</option>
												<option>
													合格
												</option>
											</select>
										</div>
										<div class="right">
											<ul class="clear index-t">
												<li>
													<div class="index-li-f">
														诊断指标
													</div>
													<div>
														<span class="col-6">33</span>
														个
													</div>
												</li>
												<li>
													<div class="index-li-f">
														不合格指标
													</div>
													<div>
														<span class="col-1">10</span>
														个
													</div>
												</li>
												<li>
													<div class="index-li-f">
														预警指标
													</div>
													<div>
														<span class="col-5">20</span>
														个
													</div>
												</li>
												<li>
													<div class="index-li-f">
														合格指标
													</div>
													<div>
														<span class="col-2">3</span>
														个
													</div>
												</li>
											</ul>
										</div>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12">
										<!-- 
											选中和鼠标滑过
											td.item-td : 添加class  hignlight
										-->
										<table class="d-table">
											<thead>
												<tr>
													<th width="12%">诊断项目</th>
													<th width="16%">诊断要素</th>
													<th width="48%">诊断指标</th>
													<th width="12%">合格值</th>
													<th width="12%">预警值</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<!--这个id为aa没有实际意义，只是象征性的切换-->
													<td rowspan="5" id="aa">专业建设规划</td>
													<td>课程体系</td>
													<td class="item-td">课程体系的实施是否能实现专业能力的培养（课程体系与能力对照表），全部课程标准是否齐备</td>
													<td class="item-td">X>=15</td>
													<td class="item-td">是</td>
												</tr>
												<tr>
													<td rowspan="2">专业定位</td>
													<td class="item-td unq-td">	人才培养方案是否邀请三位以上行业专家和学生代表进行评审</td>
													<td class="item-td unq-td">X>=100</td>
													<td class="item-td unq-td">59</td>
												</tr>
												<tr>
													<td class="item-td">	人才培养方案是否建立三级的论证审核制度(专业、二级学院、学校)</td>
													<td class="item-td">X>=100</td>
													<td class="item-td"></td>
												</tr>
												<tr>
													<td rowspan="2">人才培养方案</td>
													<td class="item-td warn-td">专业建设规划是否及时跟踪市场需求变化和产业结构调整的需要，进行SWOT分析 </td>
													<td class="item-td warn-td">X>=80</td>
													<td class="item-td warn-td">70</td>
												</tr>
												<tr>
													<td class="item-td">是否明确专业核心岗位和能力要求（职业能力分析）</td>
													<td class="item-td">X>=60</td>
													<td class="item-td">是</td>
												</tr>
												
												<tr class="nodata">
													<td colspan="5" align="center" valign="center">
														<div class="nodata-msg">
															<img src="/analy/img/diagnostic/nodata.png" width="100"/>
														</div>
														<div class="nodata-msg">没有符合条件的数据</div>
													</td>
												</tr>
												
											</tbody>
											
										</table>
									</div>
								</div>
								
								<div class="col-lg-12 col-md-12 col-sm-12 index-con index-con-2" style="display: none;">
									<div class="index-box clear">
										<div class="left">
											<span>诊断状态：</span>
											<select class="in-select" id="index_case">
												<option>
													全部
												</option>
												<option>
													国家级
												</option>
												<option>
													省级
												</option>
												<option>
													市级
												</option>
												<option>
													院校级
												</option>
											</select>
										</div>
										<div class="right">
											<ul class="clear index-t">
												<li>
													<div class="index-li-f">
														国家级
													</div>
													<div>
														5/8
													</div>
												</li>
												<li>
													<div class="index-li-f">
														省级
													</div>
													<div>
														10/10
													</div>
												</li>
												<li>
													<div class="index-li-f">
														市级
													</div>
													<div>
														10/12
													</div>
												</li>
												<li>
													<div class="index-li-f">
														院校级
													</div>
													<div>
														19/20
													</div>
												</li>
											</ul>
										</div>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12">
										<!-- 
											选中和鼠标滑过
											td.item-td : 添加class  hignlight
										-->
										<table class="d-table">
											<thead>
												<tr>
													<th width="12%">诊断项目</th>
													<th width="16%">诊断要素</th>
													<th width="60%">标志性成果</th>
													<th width="12%">预警值</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<!--这个id为aa没有实际意义，只是象征性的切换-->
													<td rowspan="5" id="aa">专业建设规划</td>
													<td>课程体系</td>
													<td class="item-td">课程体系的实施是否能实现专业能力的培养（课程体系与能力对照表），全部课程标准是否齐备</td>
													<td class="item-td">省级</td>
												</tr>
												<tr>
													<td rowspan="2">专业定位</td>
													<td class="item-td">	人才培养方案是否邀请三位以上行业专家和学生代表进行评审</td>
													<td class="item-td">市级</td>
												</tr>
												<tr>
													<td class="item-td">	人才培养方案是否建立三级的论证审核制度(专业、二级学院、学校)</td>
													<td class="item-td"></td>
												</tr>
												<tr>
													<td rowspan="2">人才培养方案</td>
													<td class="item-td">专业建设规划是否及时跟踪市场需求变化和产业结构调整的需要，进行SWOT分析 </td>
													<td class="item-td">70</td>
												</tr>
												<tr>
													<td class="item-td">是否明确专业核心岗位和能力要求（职业能力分析）</td>
													<td class="item-td">国家级</td>
												</tr>
												
												<tr class="nodata">
													<td colspan="4" align="center" valign="center">
														<div class="nodata-msg">
															<img src="/analy/img/diagnostic/nodata.png" width="100"/>
														</div>
														<div class="nodata-msg">没有符合条件的数据</div>
													</td>
												</tr>
												
											</tbody>
											
										</table>
									</div>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script>
		$(document).ready(function(){
			//下拉框
			$("#index_type,#index_case").select2({
				width:'resolve',
			});
			
			//td高亮
			$(".item-td").hover(function(){
				$(this).parent().find(".item-td").addClass("hignlight");
			},function(){
				$(this).parent().find(".item-td").removeClass("hignlight");
			});
			
			//tab切换，这里只是做了显示隐藏，实际项目中应该是刷新右边内容
			$(".in-list").on("click","li",function(){
				var idx = $(this).index() + 1;
				$(this).siblings("li").removeClass("select");
				$(this).addClass("select");
				$(".index-con").hide();
				$(".index-con-" + idx).show();
			})
		})	
	</script>
</html>