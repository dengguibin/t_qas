<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-10 10:41:30
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<style>
<!--
.inputText{
	width: 400px;
}
-->
</style>
<body>
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" />
	</div>
	<div class="editBlock">
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/mty/templet/save.action" method="post">
			<s:hidden name="menuId" id="menuId" />
			<s:hidden name="bean.id" id="id" />
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>

			<div class="formtitle">
				<span>表头信息控制</span>
			</div>
			<table>
				<tr>
					<td colspan="2" class="subtitle">必填信息</td>
				</tr>
				<tr>
					<th width="120">模板名称：<span class="warning">*</span></th>
					<td><input type="text" class="inputText" maxlength="15"
						id="name_templet" name="bean.name_templet"
						value="${bean.name_templet}" datatype="*" nullmsg="请填写模板名称" />
					</td>
				</tr>
				<tr>
					<th width="120">相对路劲：<span class="warning">*</span></th>
					<td><input type="text" class="inputText" maxlength="50"
						id="path_relative" name="bean.path_relative"
						value="${bean.path_relative}" datatype="*" nullmsg="请填写相对路劲" />
					</td>
				</tr>
				<tbody>
					<tr>
						<th width="120">备注：</th>
						<td><textarea id="remark" maxlength="500" name="bean.remark"
								class="textinput2">${bean.remark}</textarea></td>
					</tr>
					<tr>
						<th width="120">创建人：</th>
						<td><input type="text" class="inputText" maxlength="18"
							id="cjr" name="bean.cjr" value="${bean.cjr}" />
						</td>
					</tr>
					<tr>
						<th width="120">修改人：</th>
						<td><input type="text" class="inputText" maxlength="18"
							id="xgr" name="bean.xgr" value="${bean.xgr}" />
						</td>
					</tr>

					<tr>
						<td colspan="2" class="toolbar"><input type="button"
							class="inputButton" onclick="$('#opForm').submit();"
							value=" 确 定 " /> <input type="button" class="cancel"
							value=" 返 回 " id="returnButton" /> &nbsp;&nbsp;</td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>
	<!--editblock end-->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
