<#list tables as table>
	<#if table.name == path.id>
		<#assign  columns=table.columns>
		<#assign  tname=table.name>
		<#assign className=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
		</#list>
<#assign sindex = path.target?last_index_of('/')>		
<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date ${.now?datetime}
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${"$"}{param.menuId}"/></div>
<div class="editBlock">
<form action="" id="opForm">
<s:hidden name="menuId" id="menuId"/>
	<div class="formtitle"><span>放在这里提示</span></div>
		<table>
			<tr>
				<td colspan="2" class="subtitle">必填选填放在TBODY前面信息 </td>
			</tr>
       <tbody>
       <#list columns as column>
       <#assign validate=''>
       <#if column.nullAble == true><#assign validate><span class="warning">*</span></#assign></#if>	
       <tr>
       	  <#if column.javaType == 'Date'>
       	   <th width="120">${column.comments!''}：</th>
           <td ><fmt:formatDate value="${"$"}{bean.${column.name?lower_case}}" pattern="yyyy-MM-dd"/></td>
       	  <#else>
    	   <th width="120">${column.comments!''}：</th>
           <td>${"$"}{bean.${column.name?lower_case}}</td>
       	  </#if>
        </tr>
	   </#list>
	   
	  			 <tr>
					<td colspan="2" class="toolbar">
						<input type="button" id="returnButton" class="cancel" value=" 返 回 " /></td>
				</tr>
       </tbody>
    </table>
 </div>   <!--editBlock END-->
  </form>
</body> 
<%@include file="/pages/t_qas/layout/footer.jsp" %>
 	</#if>
</#list>