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
		
	}
	$(function(){
		  $('.select9').select2({
			  tags: "true"
		  });
	})
//-->
</script>
<body>
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" />
	</div>
	<s:form action="saveDept" namespace="/org/auth" method="post"
		id="opForm" name="opForm">
		<s:hidden name="bean.bmid" id="bmid"></s:hidden>
		<s:token></s:token>
		<s:hidden name="bean.unit_type" id="unit_type"/>
		<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
		<div class="tabBlock" id="tabBlock">
			<div class="editBlock">
				<table>
					<tr>
						<td colspan="2" class="subtitle">单位/部门信息</td>
					</tr>
					<tbody>
						<tr>
							<th width="120">单位/部门名称：<span class="warning">*</span></th>
							<td><s:textfield name="bean.bmmc" cssClass="inputText"
									id="bmmc" maxlength="50" datatype="s2-50" nullmsg="单位名称必须填写"
									errormsg="单位名称必须为2到50个字符" /></td>
						</tr>
					
						<c:choose>
							<c:when test="${bean.bmid ne user.departId }">
								<tr>
								<th width="120">所属单位：</th>
								<td>
									<select name="bean.fbmid" id="fbmid" class="select2">
										<c:forEach var="item" items="${datas }">
											<option value="${item.BMID}" ${item.BMID eq bean.fbmid ? 'selected' : '' }>${item.BMMC }</option>
										</c:forEach>
									</select>
								</td>
								</tr>
							</c:when>
							<c:otherwise>
								<s:hidden name="bean.fbmid" id="fbmid"/>
							</c:otherwise>
						</c:choose>	
						
						
						<tr>
							<th width="120">单位/部门编号：</th>
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
							<th width="120">负责人：</th>
							<td>
							   <select  class="select9" name="bean.bmhjr" id="bmhjr" style="width:160px;">
			                 	<option value="">--请选择--</option>
							   		<c:forEach var="item" items="${users }">
											<option value="${item.userId}" ${item.userId eq bean.bmhjr ? 'selected' : '' }>${item.userName }</option>
									</c:forEach>
							   </select>
							</td>
						</tr>

						<tr>
							<th width="120">职能描述：</th>
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
