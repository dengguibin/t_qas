<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<!--<link rel="stylesheet" href="${ctx}/scripts/css/style.css" type="text/css" />-->
<link rel="stylesheet" href="${ctx}/scripts/css/public.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/layer-v3.1.0/layer/theme/default/layer.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/select2-master/dist/css/select2.min.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/diagnoseScheme.css" />
<script type="text/javascript" src="${ctx}/scripts/plugins/layer-v3.1.0/layer/layer.js" ></script>
<style>
	html,body{
		min-width: auto;
		height: 100%;
		background: #fff;
	}
</style>
<body style="width:33% important">
	<form id='opForm' name='opForm' 
		action='${ctx}/diagnose/diagnosescheme/save.action' target="_parent" method='post'>
		<s:hidden name="menuId" id="menuId" />
		<!-- 令牌环，防止重复提交 -->
		<s:token></s:token>
		<div class='s_box'>
			<div class='clear s_row'>
				<div class='left'>
					<i class='must'></i>模型名称：
				</div>
				<div class='right'>
					<input type='text' name='diagnose.schemename' placeholder='' class='inputxt' datatype="*" nullmsg="请输入模型名称！"/>
				</div>
			</div>
			<div class='clear s_row'>
				<div class='left'>
					<i class='must'></i>模型类别：
				</div>
				<div class='right'>
					<select id='schemeType' name='diagnose.schemetype'>
						<x:cache subject="SCHEMETYPE" option="true"></x:cache>
					</select>
				</div>
			</div>
			<div class='clear s_row'>
				<div class='left'>
					<i class='must'></i>模型类型：
				</div>
				<div class='right'>
					<select id='s_d_type' name='diagnose.rangetype'>
						<x:cache subject="SCHEMETYPEOBJ" option="true"></x:cache>
					</select>
				</div>
			</div>
		</div>
	</form>
</body>

<%@include file="/pages/t_qas/layout/footer.jsp" %>

<script>
function mySubmit(){
	$("#opForm").submit();
	<%--var fromData = $("#opForm").serialize();
	 $.post('${ctx}/diagnose/diagnosescheme/save.action',fromData,function(result){
    	if(result.success){
    		parent.myLocation();
    	} else {
    		alert(result.msg);
    	}
    });--%>
}
</script>