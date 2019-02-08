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
<script type="text/javascript" src="${ctx}/scripts/js/indicator/diagnosis.js"></script>
<!--<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js" ></script>-->
<!--[if lt IE 9]
		<script type="text/javascript" src="${ctx}/scripts/js/common/html5shiv.min.js" ></script>
		<script type="text/javascript" src="${ctx}/scripts/js/common/respond.min.js" ></script>
		<![endif]-->
<style>
.row-l {
	width: 100px;
}
</style>

<body style="background:#f0f9fd;">
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" />
	</div>
	<div class="wrapper in-manager">
		<div class="top-txt">
			<div class="total">
				共计：<span id="count"></span>
			</div>
		</div>
		<div class="clear" id="content">
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
										<span>移动层级</span>
									</div>
								</li>
								<li class="add-indicat show-tip"><i class="icon add-metrics-unable"></i>
									<div class="tip">
										<span id="indicat-title">添加</span>
									</div>
								</li>
								<!--添加层级-->
								<li class="add-index  show-tip"><i class="icon add-index-unable"></i>
									<div class="tip">
										<span id="index-title">添加层级</span>
									</div>
								</li>
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
			<div class="right box-r">
				<div class="title-tab">
					<span id="tab_name">首页</span>
					<button id="modify" class="modify" onclick="update()">修改</button>
				</div>
				<input id="_type" type="hidden"> 
				<input id="_id" type="hidden"> 
				<input id="_pid" type="hidden">
				<div class="content-list">
					<form id="frmAddOrEditCatalog" name="frmAddOrEditCatalog" action="${ctx}/indicator/indicatorcatalog/frmAddOrEditCatalog.action" method="post">
						<s:hidden name="bean.id" id="catalog_id"></s:hidden>
						<s:hidden name="bean.parentid" id="catalog_pid"></s:hidden>
						<s:hidden name="bean.indicatortype" id="indicatortype"></s:hidden>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label id="nameTitle">诊断项目：</label>
							</div>
							<div class="row-r"  id = "inputText">
								<input type="text" class="inputxt disabled" name="bean.name_" placeholder="请填写内容"  datatype="notnull" msgnull="指标名称不可为空！"  disabled="disabled" id="project" />
							</div>
							<div class="row-r"  id = "selectText"  style="display: none;" disabled="disabled" >
								<select class="select" id="name-s" name="bean.sort" style="width: 30%;">
									<x:cache subject="INDICATORTYPE" option="true"></x:cache>
								</select>
								<input id="name-d" name="bean.name_" type="hidden">
							</div>
						</div>
						<div class="row clear" id="leadDeptDeptDiv">
							<div class="row-l">
								<label>牵头部门：</label>
							</div>
							<div class="row-r"  id = "inputText">
								<input id="leadDept" type="text" class="inputxt disabled" name="bean.leadDept" placeholder="请填写内容" disabled="disabled" />
							</div>
						</div>
						<div class="row clear" id="synergeticDeptDiv">
							<div class="row-l">
								<label>协同部门：</label>
							</div>
							<div class="row-r"  id = "inputText">
								<input id="synergeticDept" type="text" class="inputxt disabled" name="bean.synergeticDept" placeholder="请填写内容" disabled="disabled"/>
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<label>备注说明：</label>
							</div>
							<div class="row-r">
								<textarea class="textarea disabled" name="bean.remark" placeholder="请填写备注" disabled="disabled" id="remark_t" /></textarea>
								<div class="input-view"></div>
							</div>
						</div>
						<div class="btn-s-c">
							<input type="submit" class="sumbit"  value="保存">
							<input type="button"  class="cancel" onclick="cancelModify()" value="取消">
						</div>
					</form>
				</div>
				<div class="content-item" style="display: none;">
					<form id="frmAddOrEditContent"  name="frmAddOrEditContent" action="${ctx}/indicator/indicatorcontent/frmAddOrEditContent.action" >
						<s:hidden name="bean.id" id="content_id"></s:hidden>
						<s:hidden name="bean.parentindicatorcontentid" id="content_pid"></s:hidden>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>指标名称：</label>
							</div>
							<div class="row-r">
								<input type="text" class="inputxt disabled" name="bean.name_" placeholder="请填写指标名称"  datatype="notnull"  msgnull="指标内容不可为空！"  disabled="disabled" id="name" />
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>数据类型：</label>
							</div>
							<div class="row-r">
								<select id='type' name='bean.indicatordatatype'  class="select" disabled="disabled" style="display: none;width: 30%;">
									<x:cache subject="INDICATORDATATYPE" option="true" selected="1"></x:cache>
								</select>
							</div>
						</div>
						<!-- <div class="row clear">
							<div class="row-l">
								<i class="must"></i> <label>数据规则：</label>
							</div>
							<div class="row-r">
								<span class="label">系统默认公式</span> <span class="label"
									id="set_role">系统默认公式</span>
							</div>
						</div> -->
						<div class="row clear">
							<div class="row-l">
								<label>院校标准：</label>
							</div>
							<div class="row-r">
								<input type="text" class="inputxt disabled" name="bean.standard" placeholder="填是或者>X或者<X"   datatype="notnull" 
								disabled="disabled" id="standard" />
							</div>
						</div>
						<div class="row clear">
							<div class="row-l">
								<label>指标备注：</label>
							</div>
							<div class="row-r">
								<textarea class="textarea disabled" placeholder="请填写备注" name="bean.remark" disabled="disabled" id="remark_f" /></textarea>
								<div class="input-view"></div>
							</div>
						</div>
						<div class="btn-s-c">
							<input type="submit" class="sumbit"  value="保存">
							<input type="button"  class="cancel" onclick="cancelModify()" value="取消">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp"%>