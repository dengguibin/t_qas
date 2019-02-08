<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
	/**
	 *@date 2017-11-10 10:41:30
	 *@author upaths@gmail.com
	 */
%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<body>
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" />
	</div>
	<div class="editBlock">
		<form action="" id="opForm">
			<s:hidden name="menuId" id="menuId" />
			<div class="formtitle">
				<span>放在这里提示</span>
			</div>
			<table>
				<tr>
					<td colspan="2" class="subtitle">必填选填放在TBODY前面信息</td>
				</tr>
				<tr>
					<th width="120">模板名称：</th>
					<td>${bean.name_templet}</td>
				</tr>
				<tr>
					<th width="120">相对路劲：</th>
					<td>${bean.path_relative}</td>
				</tr>
				<tbody>
					<tr>
						<th width="120">主键：</th>
						<td>${bean.id}</td>
					</tr>
					<tr>
						<th width="120">备注：</th>
						<td>${bean.remark}</td>
					</tr>
					<tr>
						<th width="120">创建人：</th>
						<td>${bean.cjr}</td>
					</tr>
					<tr>
						<th width="120">创建时间：</th>
						<td><fmt:formatDate value="${bean.cjsj}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th width="120">修改人：</th>
						<td>${bean.xgr}</td>
					</tr>
					<tr>
						<th width="120">修改时间：</th>
						<td><fmt:formatDate value="${bean.xgsj}" pattern="yyyy-MM-dd" />
						</td>
					</tr>

					<tr>
						<td colspan="2" class="toolbar"><input type="button"
							id="returnButton" class="cancel" value=" 返 回 " /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!--editBlock END-->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp"%>
