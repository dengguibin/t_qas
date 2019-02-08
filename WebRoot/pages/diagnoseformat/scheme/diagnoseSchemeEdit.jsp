<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<link rel="stylesheet" href="${ctx}/scripts/css/style.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/layer-v3.1.0/layer/theme/default/layer.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/select2-master/dist/css/select2.min.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/public.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/diagnoseScheme.css" />
<script type="text/javascript" src="${ctx}/scripts/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/layer-v3.1.0/layer/layer.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/select2-master/dist/js/select2.full.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/js/diagnose/addIndicator.js" ></script>
<body style="background:#f0f9fd;"  class="layer_btn">
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${menuId}" /> &gt; 模型
	</div>
	<div class="wrapper d-add">
		<!-- 上面功能按钮 -->
		<div class="top-txt">
			<!--<div class="configure clear">
				<div class="left">
					<i class="return-icon icon"></i>
					<a class="return" href="${ctx }/diagnose/diagnosescheme/queryList.action?menuId=${menuId}">返回</a>
				</div>
			</div>-->
			<div class="clear d-search">
				<div class="left">
					<span class="label">模型名称：</span>
					<span class="msg" style="display: none;">
					 	<input id="diagnosname" type="text" value="${diagnose.schemename}">
					</span>
					<span id="displays" style="display: none;">${diagnose.schemename}</span>
					<span class="label">模型类型：</span>
					<span class="msg"><x:cache subject="INDICATORTYPE" key="${diagnose.rangetype}"></x:cache></span>
					<input type="hidden" id="rangetype" value="${diagnose.rangetype}">
					<input type="hidden" id="diagnoseid" value="${diagnose.id}">
					<input type="hidden" id="sourceschemeid" value="${diagnose.sourceschemeid}">
					<input type="hidden" id="status" value="${diagnose.status}">
					<input type="hidden" id="path" value="${ctx}">
				</div>
				<div class="right">
					<!--
						禁用状态：d-release-disable
						选中状态：d-release-select
						可点击状态：d-release
					-->
					<span class="d-release-b d-release valid" onclick="publish()">发布模型</span>
					<span class="return-box">
						<i class="return-icon icon"></i>
						<a class="return" href="${ctx }/diagnose/diagnosescheme/queryList.action?menuId=${menuId}">返回</a>
					</span>
				</div>
			</div>
		</div>
		<!-- 下面主要内容 -->
		<div class="clear add-content" id="add-content">
			<!-- 左边树型展现 -->
			<div class="left box-l">
				<div class="box-d">
					<!-- 增删按钮 -->
					<div class="clear box-s">
						<div class="left" id="search_btn">
							<!--
								同理：图标的类名以icon结尾表示是常规状态（可点击状态），select结尾是选中状态，unable结尾为不可点击
								如：
								search-icon：这里放一个搜索的小图标，这是常规状态
								search-select：选中状态
								search-unable：不可点击状态
							-->
							<div class="icon search-icon"></div>
						</div>
						<div class="right valid" style="text-align: right;">
							<!--添加指标-->
							<!--a_d 添加和删除-->
							<ul id="a_d">
								<li class="remove-index show-tip">
									<i class="icon remove-index-icon"></i>
									<div class="tip">
										<span>选择指标模板</span>
									</div>
								</li>
								<li class="add-indicat show-tip">
									<i class="icon add-metrics-icon"></i>
									<div class="tip">
										<span>添加指标</span>
									</div>
								</li>
								<!--删除-->
								<li class="delete  show-tip">
									<i class="icon delete-unable"></i>
									<div class="tip">
										<span>删除</span>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<!-- 指标搜索 -->
					<div class="search-box" style="display: none;" id="s_b">
						<div class="search-box-1">
							<input type="text" placeholder="指标名称/关键字搜索" class="search-input" id="indicatorKey"/>
							<span class="icon search-icon" onclick="searchByKey()"></span>
						</div>
					</div>
					<!-- 树型结构 -->
					<div class="ztree">
						<div id="dia_tree_m"></div>
					</div>
				</div>
			</div>
			<!-- 右边内容编辑 -->
			<div class="right box-r">
				<!-- 面包屑 -->
				<div class="title-tab">
					<span id="tab_name"></span>
				</div>
				<s:hidden id="_ids"></s:hidden>
				<s:hidden id="_type"></s:hidden>
				<s:hidden id="_diagnoseId" value="%{#request.diagnose.id }"></s:hidden>
				<s:hidden id="_status" value="%{#request.diagnose.status }"></s:hidden>
				<!-- 目录编辑 -->
				<div class="content-program">
					<form id="saveShcemeCatalog" name="saveShcemeCatalog" action="${ctx }/diagnose/diagnosescheme/editShcemeCatalog.action" method="post" onsubmit="return false">
						<s:hidden id="diagnosnames" name="diagnose.schemename"></s:hidden>
						<input type="hidden" class="parentId" name="parentId">
						<s:hidden id="diagnoseids" name="diagnose.id"></s:hidden>
						<s:hidden id="schemeid_p" name="scheme.id"></s:hidden>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i>
								<label id="nameTitle"></label>
							</div>
							<div class="row-r">
								<input type="text" class="inputxt" disabled="disabled" placeholder="请填写诊断项目" id="c_p_project" />
							</div>
						</div>
						<div class="row clear" style="display:none;">
							<div class="row-l">
								<label>总分：</label>
							</div>
							<div class="row-r" >
								<input type="text" class="inputxt" id="schemeScore" disabled="disabled" placeholder="请填写总分" value="根据下方的计算权重和公式自动汇总得到"/>
							</div>
						</div>
						<div class="row clear" id="weight">
							<div class="row-l">
								<label>计算权重：</label>
							</div>
							<div class="row-r">
								<input type="text"  class="inputxt" id="schemeWeight" name="scheme.weight" placeholder="请填写计算权重" datatype="weight" msgnull="权重不可为空！" errormsg="权重必须为不大于1的数字"/>
							</div>
							<span id="hint_2" style="margin-left:10%;font-size:8px;color:red;display:none;padding-left:20px">*计算规则：当前同级目录所有项目类型权重总和≤1</span>
							<span id="hint_3" style="margin-left:10%;font-size:8px;color:red;display:none;padding-left:20px">*计算规则：当前同级目录项目要素类型权重总和≤1</span>
						</div>
						<div class="row clear">
							<div class="row-l">
								<label>备注：</label>
							</div>
							<div class="row-r">
								<textarea class="textarea" placeholder="请填写备注" id="c_p_remark" /></textarea>
							</div>
						</div>
						<div class="btn-s-c">
							<input type="submit" class="sumbit valid" value="保存">
							<input type="button" class="cancel valid" value="取消" onclick="javascript:window.location.href='${ctx }/diagnose/diagnosescheme/queryList.action?menuId=${menuId}'">
						</div>
					</form>
				</div>
				<!-- 指标编辑 -->
				<div class="content-index" style="display: none;">
					<form id="saveIndicatorRate" name="saveIndicatorRate" action="${ctx }/diagnose/diagnosescheme/editIndicatorRate.action" method="post">
						<input type="hidden" id="schemeid_c" name="scheme.id">
						<input type="hidden" class="parentId" name="parentId">
						<s:hidden id="diagnosnamess" name="diagnose.schemename"></s:hidden>
						<s:hidden id="diagnoseidss" name="diagnose.id"></s:hidden>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i>
								<label>指标名称：</label>
							</div>
							<div class="row-r">
								<input type="text" class="inputxt" placeholder="请填写指标名称"  disabled="disabled" id="c_i_name" />
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<label>数据类型：</label>
							</div>
							<div class="row-r">
								<select id='dis_type_1'  disabled="disabled" class="select" style="width: 230px;" >
								<x:cache subject="INDICATORDATATYPE" option="true" selected="1"></x:cache>
							</select>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i>
								<label>核心指标：</label>
							</div>
							<div class="row-r">
								<span class="add-radio">
									<span>
										<input type="radio" disabled="disabled" name="add_index" checked="checked" />是
									</span>
									<span class="no-first">
										<input type="radio" disabled="disabled" name="add_index" />否
									</span>
								</span>
								
							</div>
						</div>
							<div class="row clear">
							<div class="row-l">
								<i class="must"></i>
								<label>院校标准： </label>
							</div>
							<div class="row-r">
								<input type="text" value="是" disabled="disabled" class="inputxt" style="width: 216px;"/>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i>
								<label>指标分值：</label>
							</div>
							<div class="row-r">
								<input type="text" value="100" disabled="disabled" class="inputxt" style="width: 216px;"/>
								<input type="hidden" value="100" id="score" name="scheme.score" datatype="n"/>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i>
								<label>分值设置：</label>
							</div>
							<!-- 数值型指标 -->
							<div class="row-r " id="datatype-1">
								<table style="table-layout: fixed;width: 90%;"class="table">
									<thead>
										<tr>
											<th width="33%">数值范围</th>
											<th width="33%">得分</th>
											<th width="33%">指标状态</th>
										</tr>
									</thead>
									<tbody>
										<tr class="item">
											<td width="33%">
												<input type="text" class="table-input" name="indicatorratedes[0].leftvalue" datatype="n" msgnull="数值范围不可为空！" errormsg="数值范围必须为数字"/>
												<span>=<</span>
												<input type="hidden" name="indicatorratedes[0].operator" value="{0}>={1}">
												<input type="text" disabled="disabled" class="table-input" value="X" readonly="readonly">
											</td>
											<td width="33%">
												<input type="text" disabled="disabled" value="100" readonly="readonly"  id="lock1" class="inputxt" name="indicatorratedes[0].score" datatype="score" msgnull="得分不可为空！" errormsg="得分必须为数字且需符合得分逻辑"/>
											</td>
											<td width="33%">
												<span class="qualified">合格</span>
												<input type="hidden" class="inputxt" name="indicatorratedes[0].warninggrade" value="3"/>
											</td>
										</tr>
										<tr class="item">
											<td width="33%">
												<input type="text"  class="table-input" name="indicatorratedes[1].leftvalue" datatype="leftvalue" msgnull="数值范围不可为空！" errormsg="数值范围必须为数字且符合判断"/>
												<span><=</span>
												<span>X</span>
												<span><</span>	
												<input type="hidden" name="indicatorratedes[1].operator" value="{0}<=X<{1}">
												<input type="text"  class="table-input" name="indicatorratedes[1].rightvalue" readonly="readonly"/>
											</td>
											<td width="33%">
												<input type="text"  class="inputxt score" name="indicatorratedes[1].score" datatype="score" msgnull="得分不可为空！" errormsg="得分必须为数字且需符合得分逻辑"/>
											</td>
											<td width="33%">
												<span class="unqualified">预警</span>
												<input type="hidden"  class="inputxt" name="indicatorratedes[1].warninggrade" value="2"/>
											</td>
										</tr>
										<tr class="item">
											<td width="33%">
												<input type="text" disabled="disabled" class="table-input" value="X" readonly="readonly">
												<span><</span>
												<input type="hidden" name="indicatorratedes[2].operator" value="{0}<{1}">
												<input type="text" class="table-input" name="indicatorratedes[2].rightvalue" datatype="n" msgnull="数值范围不可为空！" errormsg="数值范围必须为数字" readonly="readonly"/>
											</td>
											<td width="33%">
												<input type="text" class="inputxt score" name="indicatorratedes[2].score" datatype="score" msgnull="得分不可为空！" errormsg="得分必须为数字且需符合得分逻辑"/>
											</td>
											<td width="33%">
												<span class="warn-txt">不合格</span>
												<input type="hidden"  class="inputxt" name="indicatorratedes[2].warninggrade" value="1" disabled="disabled"/>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- 判断型指标 -->
							<div class="row-r " id="datatype-2" >
								<table style="table-layout: fixed;width: 90%;"class="table">
									<thead>
										<tr>
											<th width="33%">是/否</th>
											<th width="33%">得分</th>
											<th width="33%">指标状态</th>
										</tr>
									</thead>
									<tbody>
										<tr class="item">
											<td width="33%">
												<select id='select-y-n-1' name="indicatorratedes[0].operator" class="select" style="width: 50px;" >
													<option value="是" selected="selected">是</option>
													<option value="否">否</option>
												</select>
											</td>
											<td width="33%">
												<input type="text"disabled="disabled" value="100" readonly="readonly" id="lock2" class="inputxt" name="indicatorratedes[0].score" datatype="score" msgnull="得分不可为空！" errormsg="得分必须为数字且需符合得分逻辑"/>
											</td>
											<td width="33%">
												<span class="qualified">合格</span>
												<input type="hidden" class="inputxt" name="indicatorratedes[0].warninggrade" value="3"/>
											</td>
										</tr>
										<tr class="item">
											<td width="33%">
												<select id='select-y-n-2'  name="indicatorratedes[1].operator" class="select" style="width: 50px;" >
													<option value="是">是</option>
													<option value="否" selected="selected">否</option>
												</select>
											</td>
											<td width="33%">
												<input type="text"  class="inputxt score" name="indicatorratedes[1].score" datatype="score" msgnull="得分不可为空！" errormsg="得分必须为数字且需符合得分逻辑"/>
											</td>
											<td width="33%">
												<span class="warn-txt">不合格</span>
												<input type="hidden"  class="inputxt" name="indicatorratedes[1].warninggrade" value="1" disabled="disabled"/>
											</td>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<label>备注：</label>
							</div>
							<div class="row-r">
								<textarea disabled="disabled" class="textarea" placeholder="请填写备注" id="c_i_remark" /></textarea>
							</div>
						</div>
						<div class="btn-s-c">
							<input type="submit" class="sumbit valid" value="保存">
							<input type="button" class="cancel valid" value="取消" onclick="javascript:window.location.href='${ctx }/diagnose/diagnosescheme/queryList.action?menuId=${menuId}'">
						</div>
					</form>
				</div>
			</div>
			
		</div>
	</div>
</body>
<script>
	$("#diagnosname").change(function(){
	    var name=$("#diagnosname").val();
	    $("#diagnosnames").val(name);
	    $("#diagnosnamess").val(name);
	});
	var diagnoseid=$("#diagnoseid").val();
	$("#diagnoseids").val(diagnoseid);
	$("#diagnoseidss").val(diagnoseid);
	var status=$("#status").val();
	if(status == '0'){
		$(".msg").removeAttr("style");
	}else{
		$(".content-index").find("input,select,radio,textarea").attr("disabled","disabled");
		$(".content-program").find("input,select,radio,textarea").attr("disabled","disabled");
		$("#displays").removeAttr("style");
	}
</script>
<%@include file="/pages/t_qas/layout/footer.jsp" %>