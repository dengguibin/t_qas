<%@ page pageEncoding="UTF-8" language="java"
	contentType="text/html;charset=UTF-8"%>
<%
	/**
	 *@date 2015-3-16 9:48:06
	 *@author upaths@gmail.com
	 */
%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<script type="text/javascript">
<!--
	function submitTempForm() {
		var path = $("#doc").val();
		if (path == '') {
			alert('请选择需要上传的模板文件!');
			$("#doc").focus();
			return;
		}
		var strRegex = "(.xls)$";
		var re = new RegExp(strRegex);
		if (!re.test(path)) {
			alert('模板文件格式必须是以【xls】结尾的文件!');
			$("#doc").focus();
			return;
		}
		$('#opForm').submit()
	}
	
function nextCode(){
	var url = "${ctx }/auth/code.action?type=code&v="+Math.random();
	$("#imgCode").attr("src",url);
}
//-->
</script>
<body>
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" />
	</div>

	<form id="opForm" name="opForm" onsubmit="return true;"
		action="${ctx}/plat/auth/tRmsDeptment!saveExcel.action"
		enctype="multipart/form-data" method="post">
		<s:hidden name="menuId" id="menuId" />
		<s:hidden name="assetTypeId" id="assetTypeId" />
		<s:hidden name="tabs" id="tabs" />
		<!-- 令牌环，防止重复提交 -->
		<s:token></s:token>
		<div class="tabBlock" id="tabBlock">
			<div class="editBlock">
			<div class="formtitle"><span>单位用户信息导入</span></div>	
				<table>
					<tbody>
						<tr>
							<th width="120">选择文件：<span class="warning">*</span></th>
							<td><s:file id="doc" class="inputText" maxlength="9" name="doc" /></td>
						</tr>
						 <tr>
				       	   <th width="120"><span class="warning">*</span>验证码：</th>
				           <td>
				           <input class="inputText" name="code" style="display: block;" datatype="s4-4" errormsg="验证码不能为空，并且长度为必须为4位">
				           <img alt="" id="imgCode" style="width: 108px;height: 36px;display: inline-block;" src="${ctx }/auth/code.action?v=t"><span class="note">不区分大小写</span>
				           <a href="javascript:void(0);" onclick="nextCode()" class="tablelink">换一张</a>
				           <br>
				           </td>
				        </tr>
					</tbody>
				</table>
				 <br>
    <ul class="forminfo">
    <li><label style="width: 120px;">&nbsp;</label><input type="button" class="btn" onclick="submitTempForm();" value="开始导入 " /> 
    	<input type="button" class="cancel" value=" 返 回 " id="returnButton" />
    </li>
    </ul>
				
				
					<c:if test="${not empty actionErrors }">
						<div>
							<span class="warning"> <s:actionerror /></span>
						</div>
					</c:if>
			</div>
		</div>

	</form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp"%>
