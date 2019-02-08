<%@ page pageEncoding="UTF-8" language="java"
	contentType="text/html;charset=UTF-8"%>
<%
	/**
	 *@date 2012-11-3 22:10:24
	 *@author upaths@gmail.com
	 */
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript"
	src="${ctx}/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
	var dlg;
	function opreate(args, opCode) {
		var baseUrl = "${ctx}/plat/auth/tRmsDeptment!listTree.action";
		if ('select' === opCode) {
			if (dlg && dlg.closed == false) {
				dlg.show();
			} else {
				dlg = $.dialog({
					id : 'depart',
					lock : true,
					max : false,
					min : false,
					title : '选择上级机构',
					//autoSize:true,
					width : '360px',
					height : '400px', 
					content : 'url:' + baseUrl
				});
			}
		} else if ('delete' === opCode) {

		} else if ('clear' === opCode) {
			$("#fbmid").val('');
			$("#pbmmc").val('');
		} else if ('clear2' === opCode) {
			$("#bmhjr").val('');
			$("#bmhjrmz").val('');
		} 
	}
	function choseUser() {
		var baseUrl = "${ctx}/plat/auth/tRmsDeptment!listUser.action";
		$.dialog({
			lock : true,
			max : false,
			min : false,
			title : '选择用户',
			width : '360px',
			height : '400px',
			content : 'url:' + baseUrl
		});

	}
	window.initNode = function(args) {
			$("#fbmid").val(args.BMID);
			$("#pbmmc").val(args.BMMC);
	}
	window.initUserNode = function(args) {
			$("#bmhjr").val(args.YHID);
			$("#bmhjrmz").val(args.YHMC);
	}
//-->
</script>
<body>
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${menuId}" />
	</div>
	<s:form action="tRmsDeptment!save" namespace="/plat/auth" method="post"
		id="opForm" name="opForm">
		<s:hidden name="bean.bmid" id="bmid"></s:hidden>
		<s:token></s:token>
		<input type="hidden" name="menuId" value="${menuId}" id="menuId">
		<div class="tabBlock" id="tabBlock">
			<div class="editBlock">
				<table>
					<tr>
						<td colspan="2" class="subtitle">机构信息</td>
					</tr>
					<tbody>
						<tr>
							<th width="120">机构名称：<span class="warning">*</span></th>
							<td><s:textfield name="bean.bmmc" cssClass="inputText"
									id="bmmc" maxlength="50" datatype="s2-50" nullmsg="机构名称必须填写"
									errormsg="机构名称必须为2到50个字符" /></td>
						</tr>
						<tr>
							<th width="120">机构类型：<span class="warning">*</span></th>
							<td>
								<select  name="bean.unit_type" class="select2" datatype="*" nullmsg="机构类型必须填写">
					          	<option value="">--所有--</option>
					          	<x:cache subject="UNIT_TYPE"  option="true" selected="${bean.unit_type}"/>
					          	</select> 	
							</td>
						</tr>
						<tr>
							<th width="120">所属机构：</th>
							<td><s:hidden name="bean.fbmid" id="fbmid"></s:hidden> <input 
								name="pbmmc" id="pbmmc" value="${pdept.bmmc }" 
								readonly="readonly" class="inputText"> <input
								type="button" class="ibtn" value=" 选 择 " 
								onclick="opreate('','select')" name="" id=""> <input
								type="button" class="ibtn" value=" 清 空 "
								onclick="opreate('','clear')" name="" id=""></td>
						</tr>
						<tr>
							<th width="120">机构编号：</th>
							<td><s:textfield name="bean.bmbh" cssClass="inputText"
									id="bmbh" maxlength="10" /></td>
						</tr>

						<tr>
							<th width="120">排序号：</th>
							<td><s:textfield name="bean.pxh" cssClass="inputText"
									id="pxh" datatype="n" ignore="ignore" maxlength="10"
									errormsg="排序号为数字类型" /></td>
						</tr>
						<tr>
							<th width="120">机构负责人：</th>
							<td><input type="hidden" class="inputText" maxlength="16" 
								 id="bmhjr" name="bean.bmhjr"
								value="${bean.bmhjr}" /> <input  class="inputText"  readonly="readonly" 
								maxlength="16" id="bmhjrmz" name="bmhjrmz" value="${use.yhmc }"/>
								<input type="button" class="ibtn" onclick="choseUser();"
								value=" 选 择 " /> <input
								type="button" class="ibtn" value=" 清 空 "
								onclick="opreate('','clear2')" name="" id=""></td>
						</tr>

						<tr>
							<th width="120">机构职能：</th>
							<td><div class="smsEdit" style="width: 380px;">
									<span></span>
								</div> <s:textarea name="bean.bmms" cssClass="textinput2"
									id="bmms" maxlength="100"></s:textarea>
							</td>
						</tr>
					</tbody>
					<tr>
						<td colspan="2" class="toolbar"><input type="button"
							class="inputButton" onclick="$('#opForm').submit();"
							value=" 确 定 " /> <input type="button" class="cancel"
							value=" 返 回 " id="returnButton" /> &nbsp;&nbsp;</td>
					</tr>
				</table>
			</div>
		</div>
	</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
