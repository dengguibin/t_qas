<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-5 11:00:49
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
			action="${ctx}/mty/atom/save.action" method="post">
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
					<th width="120">名称：<span class="warning">*</span></th>
					<td><input type="text" class="inputText" maxlength="50"
						id="name_atom" name="bean.name_atom" value="${bean.name_atom}"
						datatype="*" nullmsg="请填写名称" />
					</td>
				</tr>
				<tr>
					<th width="120">前面的标签片段：<span class="warning">*</span></th>
					<td><textarea id="front_html" name="bean.front_html"
							class="textinput2">${bean.front_html}</textarea></td>
				</tr>
				<tr>
					<th width="120">后面的标签片段：<span class="warning">*</span></th>
					<td><textarea id="back_html" name="bean.back_html"
							class="textinput2">${bean.back_html}</textarea></td>
				</tr>
				<tbody>
					<tr>
						<th width="120">前面的Js片段：</th>
						<td><textarea id="front_js" name="bean.front_js"
								class="textinput2">${bean.front_js}</textarea></td>
					</tr>
					<tr>
						<th width="120">后面的Js片段：</th>
						<td><textarea id="back_js" name="bean.back_js"
								class="textinput2">${bean.back_js}</textarea></td>
					</tr>
					<tr>
						<th width="120">备注：</th>
						<td><textarea id="remark" name="bean.remark"
								class="textinput2">${bean.remark}</textarea></td>
					</tr>
					<tr>
						<th width="120">创建人：</th>
						<td><input type="text" class="inputText" maxlength="16"
							id="cjr" name="bean.cjr" value="${bean.cjr}" />
						</td>
					</tr>
					<tr>
						<th width="120">修改人：</th>
						<td><input type="text" class="inputText" maxlength="16"
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
