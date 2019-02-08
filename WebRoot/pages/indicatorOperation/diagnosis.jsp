<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<link rel="stylesheet" href="${ctx}/scripts/css/style.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/layer-v3.1.0/layer/theme/default/layer.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/select2-master/dist/css/select2.min.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/diagnosis.css" />
<script type="text/javascript" src="${ctx}/scripts/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/layer-v3.1.0/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/select2-master/dist/js/select2.full.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/js/indicatorOperation/diagnosis.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/edit_area/edit_area_full.js"></script>
<script type="text/javascript">
</script>
<!--<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js" ></script>-->
<!--[if lt IE 9]
		<script type="text/javascript" src="${ctx}/scripts/js/common/html5shiv.min.js" ></script>
		<script type="text/javascript" src="${ctx}/scripts/js/common/respond.min.js" ></script>
		<![endif]-->
<style>
	.in-manager .row-l {
	    float: left;
	    width: 13%;
	    text-align: right;
	    min-width: 9rem;
	}
</style>

<body style="background:#f0f9fd;">
	<!-- 系统面包屑 -->
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" />
	</div>
	<!-- 内容 -->
	<div class="wrapper in-manager">
		<!-- 统计各类型指标的个数 -->
		<div class="top-txt">
			<div class="total">
				共计：<span id="count"></span>
			</div>
		</div>
		<!-- 主要内容 -->
		<div class="clear" id="content">
			<!-- 左边的指标目录，增删改查加树型结构 -->
			<div class="left box-l">
				<div class="box-d">
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
						<div class="right" style="text-align: right;">
							<!--添加指标-->
							<!--a_d 添加和删除-->
							<ul id="a_d">
								<li class="remove-index show-tip"><i class="icon remove-index-unable"></i>
									<div class="tip">
										<span>移动模板层级</span>
									</div></li>
								<li class="add-indicat show-tip"><i class="icon add-metrics-unable"></i>
									<div class="tip">
										<span id="indicat-title">添加</span>
									</div></li>
								<!--添加层级-->
								<li class="add-index  show-tip"><i class="icon add-index-unable"></i>
									<div class="tip">
										<span id="index-title">添加层级</span>
									</div></li>
								<!--删除-->
								<li class="delete  show-tip"><i class="icon delete-unable"></i>
									<div class="tip">
										<span>删除</span>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="search-box" style="display: none;" id="s_b">
						<div class="search-box-1">
							<input type="text" id="indicatorKey" placeholder="指标名称/关键字搜索" class="search-input" />
							<span class="icon search-icon"  onclick="searchByKey()"></span>
						</div>
					</div>
					<div class="ztree">
						<div id="dia_tree"></div>
					</div>
				</div>
			</div>
			<!-- 右边的指标内容，增删改查  -->
			<div class="right box-r">
				<div class="title-tab">
					<span id="tab_name">首页</span>
					<button id="modify" class="modify" onclick="update()">修改</button>
				</div>
				<input id="_type" type="hidden"> 
				<input id="_id" type="hidden"> 
				<input id="_pid" type="hidden">
				<!-- 指标目录 -->
				<div class="content-list">
					<form id="frmAddOrEditCatalog" action="${ctx}/indicatorOperation/indicatorcatalog/frmAddOrEditCatalog.action" method="post">
						<s:hidden name="bean.id" id="catalog_id"></s:hidden>
						<s:hidden name="bean.parentid" id="catalog_pid"></s:hidden>
						<s:hidden name="bean.indicatortype" id="indicatortype"></s:hidden>
						<s:hidden name="extend.indicatorcatalogid" id="indicatorcatalogids"></s:hidden>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label id="nameTitle">诊断项目：</label>
							</div>
							<div class="row-r"  id = "inputText">
								<input type="text" class="inputxt disabled" name="bean.name_"   datatype="notnull" msgnull="指标名称不可为空！"  placeholder="请填写内容" disabled="disabled" id="project" />
							</div>
							<div class="row-r"  id = "selectText"  style="display: none;" disabled="disabled" >
								<select class="select" id="name-s" name="bean.sort" style="width: 30%;">
									<x:cache subject="INDICATORTYPE" option="true"></x:cache>
								</select>
								<input id="name-d" name="bean.name_" type="hidden">
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>存在问题：</label>
							</div>
							<div class="row-r">
								<textarea type="text" class="textarea disabled" name="extend.problemoverview" placeholder="请填写存在问题概况" 
								disabled="disabled" id="problemoverviews" /></textarea>
								<div class="input-view"></div>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>改进建议：</label>
							</div>
							<div class="row-r">
								<textarea type="text" class="textarea disabled" name="extend.suggestionoverview" placeholder="请填写改进建议概况" 
								disabled="disabled" id="suggestionoverviews" /></textarea>
								<div class="input-view"></div>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<label>备注描述：</label>
							</div>
							<div class="row-r">
								<textarea class="textarea disabled" name="bean.remark" placeholder="请填写备注" disabled="disabled" id="remark_t" /></textarea>
								<div class="input-view"></div>
							</div>
						</div>
						<div class="btn-s-c">
							<%--<input type="button" class="sumbit" onclick="saveCatalog(this)" value="保存">--%>
							<input type="submit" class="sumbit"  value="保存">
							<input type="button"  class="cancel" onclick="cancelModify()" value="取消">
						</div>
					</form>
				</div>
				<!-- 指标内容 -->
				<div class="content-item" style="display: none;">
					<form id="frmAddOrEditContent" action="${ctx}/indicatorOperation/indicatorcontent/frmAddOrEditContent.action">
						<s:hidden name="bean.id" id="content_id"></s:hidden>
						<s:hidden name="bean.parentindicatorcontentid" id="content_pid"></s:hidden>
						<s:hidden name="extend.indicatorcatalogid" id="indicatorcatalogid"></s:hidden>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>指标名称：</label>
							</div>
							<div class="row-r">
								<input type="text" class="inputxt disabled" name="bean.name_" placeholder="请填写指标名称"   datatype="notnull"  msgnull="指标内容不可为空！" 
								disabled="disabled" id="name" />
							</div>
						</div>
						
						<div class="row clear" style="display:none">
							<div class="row-l">
								<i class="must"></i> <label>展示样式：</label>
							</div>
							<div class="row-r">
								<%-- <s:select name="bean.atomid" list="#{'0':'男','1':'女'}" label="性别" headerKey="" 
								headerValue="请选择性别"></s:select> --%>
								<select disabled="disabled" class="select" id="type" name="bean.atomid"
									style="display: none;width: 30%;">
									<x:cache subject="INDICATORSTYLE" option="true"></x:cache>
								</select> 
								<span id="type-d" class="label" style="color: #333;"></span>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>数据类型：</label>
							</div>
							<div class="row-r">
								<select id="indicatordatatype" name='bean.indicatordatatype'  class="select" disabled="disabled" style="display: none;width:30%;">
									<x:cache subject="INDICATORDATATYPE" option="true"></x:cache>
								</select>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>院校标准：</label>
							</div>
							<div class="row-r">
								<input type="text" class="inputxt disabled" name="bean.standard"  placeholder="填是或者>X或者<X"   datatype="notnull"  msgnull="指标内容不可为空！" 
								disabled="disabled" id="standard" />
							</div>
						</div>
						<div class="row clear" id="datatrend">
							<div class="row-l">
								<i class="must"></i> <label>数据走势：</label>
							</div>
							<div class="row-r">
							
								<select id='indicatorDataTrend' name='bean.indicatordatatrend'  class="select" disabled="disabled" style="display: none;width: 30%;">
									<x:cache subject="INDICATORDATATREND" option="true" ></x:cache>
								</select>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l" id="ismonitortitle">
								<i class="must"></i> <label>是否监视：</label>
							</div>
							<div class="row-r">
									<select id="ismonitor" name='catalog.ismonitor'  class="select" disabled="disabled" style="display: none;width: 30%;">
										<x:cache subject="CATAlLOGISMONITOR" option="true"></x:cache>
								</select>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>计算公式：</label>
							</div>
							<div class="row-r">
								<s:textarea name="bean.sqlstring" cssClass="" cssStyle="width:100%; height:300px;font-family:Verdana, Arial, Helvetica, sans-serif,'微软雅黑';font-size: 12px;" 
									id="sqlstring"></s:textarea>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>存在问题：</label>
							</div>
							<div class="row-r">
								<textarea type="text" class="textarea disabled" name="extend.problemoverview" placeholder="请填写存在问题概况" 
								disabled="disabled" id="problemoverview" /></textarea>
								<div class="input-view" style="display:none"></div>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>改进建议：</label>
							</div>
							<div class="row-r">
								<textarea type="text" class="textarea disabled" name="extend.suggestionoverview" placeholder="请填写改进建议概况" 
								disabled="disabled" id="suggestionoverview" /></textarea>
								<div class="input-view" style="display:none"></div>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<label>指标备注：</label>
							</div>
							<div class="row-r">
								<textarea class="textarea disabled" placeholder="请填写备注" name="bean.remark" disabled="disabled" 
								id="remark_f" /></textarea>
								<div class="input-view" style="display:none"></div>
							</div>
						</div>
						<div class="btn-s-c">
							<input type="submit" class="sumbit" id="submit"  value="保存">
							<input type="button"  class="cancel" onclick="cancelModify()" value="取消">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>