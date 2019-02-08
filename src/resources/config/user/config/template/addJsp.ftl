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
<%@include file="/pages/plat/frame/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${"$"}{param.menuId}"/></div>
<s:form action="${className?uncap_first}!save" namespace="${wizard.pack?replace(".", "/")}" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${"$"}{param.menuId}" id="menuId">
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
       <tbody>
       <#list columns as column>
       <#assign validate=''>
       <#if column.nullAble == true><#assign validate><span class="warning">*</span></#assign></#if>	
       <tr>
       	  <#if column.javaType == 'Integer'>
       	   <th width="120">${validate}${column.comments!''}：</th>
           <td>
           <s:textfield  name="bean.${column.name?lower_case}" cssClass="inputText" id="${column.name?lower_case}"/>
           <em  class="valid" title="${column.comments!''}输入必须是数字类型。" lang="n"></em>
           </td>
       	  <#elseif column.javaType == 'Date'>
       	   <th width="120">${validate}${column.comments!''}：</th>
           <td><s:textfield  name="bean.${column.name?lower_case}" cssClass="Wdate" cssStyle="width:100px;"  id="${column.name?lower_case}" onfocus="WdatePicker();" /></td>
       	  <#elseif column.javaType == 'String'>
       	  		<#if column.size < 200 >
       	   <th width="120">${validate}${column.comments!''}：</th>
           <td><s:textfield  name="bean.${column.name?lower_case}" cssClass="inputText" id="${column.name?lower_case}"/></td>
       	  		<#else>
          <th width="120">${validate}${column.comments!''}：</th>
          <td><div class="smsEdit" style="width:380px;"><span>共字数：${column.size/2}</span></div>
          <s:textarea name="bean.${column.name?lower_case}" cssClass="" cssStyle="width:380px; height:60px;" id="${column.name?lower_case}"></s:textarea>
           </td>
       	  		</#if>
       	  <#else>
       	  <th width="120">${validate}${column.comments!''}：</th>
          <td><s:textfield  name="bean.${column.name?lower_case}" cssClass="inputText" id="${column.name?lower_case}"/></td>
       	  </#if>
        </tr>
	   </#list>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
         <input type="button"  class="inputButton" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
</div>
</s:form>
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>
	</#if>
</#list>