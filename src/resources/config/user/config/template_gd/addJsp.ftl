<#list tables as table>
	<#if table.name == path.id>
		<#assign  columns=table.columns>
		<#assign  tname=table.name>
		<#assign className=''>
		<#assign subfix=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
			<#assign subfix>${fiex?lower_case}</#assign>
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
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${"$"}{ctx}/请配置路径/${subfix}/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
       <#list columns as column>
       <#assign validate=''>
       <#assign validateJS=''>
       <#if column.nullAble == true><#assign validate><span class="warning">*</span></#assign></#if>	
       <#if column.nullAble == true><#assign validateJS>datatype="*" nullmsg="请填写${column.comments!''}"</#assign></#if>	
       <tr>
       	  <#if column.javaType == 'Integer'>
       	   <th width="120">${column.comments!''}：${validate}</th>
          <td>
           <input type="text" class="inputText" id="${column.name?lower_case}"  maxlength="9"  name="bean.${column.name?lower_case}"  value="${"$"}{bean.${column.name?lower_case}}" ${validateJS} />
           </td>
       	  <#elseif column.javaType == 'Date'>
       	   <th width="120">${column.comments!''}：${validate}</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="${column.name?lower_case}" name="bean.${column.name?lower_case}"  value="${"$"}{${column.name?lower_case}}" />
          </td>
       	  <#elseif column.javaType == 'String' || column.sqlType?upper_case == 'TEXT' || column.sqlType?upper_case == 'MEDIUMTEXT' >
       	  		<#if column.size < 210 >
       	   <th width="120">${column.comments!''}：${validate}</th>
           <td><input type="text" class="inputText"  maxlength="${column.size/2}"  id="${column.name?lower_case}" name="bean.${column.name?lower_case}"  value="${"$"}{bean.${column.name?lower_case}}"  ${validateJS}/></td>
       	  		<#else>
          <th width="120">${column.comments!''}：${validate}</th>
          <td>
                <textarea id="${column.name?lower_case}"  maxlength="${column.size/2}" name="bean.${column.name?lower_case}" class="textinput2" >${"$"}{bean.${column.name?lower_case}}</textarea>
           </td>
       	  		</#if>
       	  <#else>
       	 <th width="120">${column.comments!''}：${validate}</th>
         <td><input type="text" class="inputText" id="${column.name?lower_case}" name="bean.${column.name?lower_case}"  value="${"$"}{bean.${column.name?lower_case}}" /></td>
       	  </#if>
        </tr>
	   </#list>
	   
	    <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
         <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      	</tr>
	   
       </tbody>
    </table>
         </form>
  </div><!--editblock end-->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
 	</#if>
</#list>