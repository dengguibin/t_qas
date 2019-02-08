<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2013-5-15 10:22:26
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/plat/frame/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<s:form action="tCommonTemplate!save" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<s:hidden name="bean.tid" id="tid"></s:hidden>
<s:hidden name="showType" id="showType"></s:hidden>
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
       <tbody>
        <!-- 
         <tr>
       	   <th width="120">父节点：</th>
           <td><s:textfield  name="bean.pid" cssClass="inputText" id="pid"/></td>
        </tr>
         -->
      
       <tr>
       	   <th style="width: 90px;" nowrap="nowrap"><span class="warning">*</span>模板类型：</th>
           <td>
            <select name="bean.mblx" id="mblx" style="width: 135px;">
          	<option value="">--请选择模板类型--</option>
          	<x:cache subject="TEMPLATE"  option="true" selected="${bean.mblx}"/>
          	</select>
           <em  class="valid" title="必须要选择模板类型。" for="mblx" lang="n"></em>
           </td>
        </tr>
         <tr>
          <th width="120"><span class="warning">*</span>模板：</th>
          <td><div class="smsEdit" style="width:350px;"><span>共字数：500</span></div>
          <s:textarea name="bean.template" cssClass="" cssStyle="width:350px; height:60px;" id="template"></s:textarea>
          <em  class="valid" title="模板是必须录入项。" for="template" lang="*"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">是否有效：</th>
           <td>
           	<select name="bean.sfyx" id="sfyx" style="width: 135px;">
          	<option value="">--请选择是否有效--</option>
          	<x:cache subject="OPTION01"  option="true" selected="${bean.sfyx}"/>
          	</select>
            <em  class="valid" title="是否有效输入必须是数字类型。" for="sfyx" lang="n"></em>
           </td>
        </tr>
         <tr>
       	   <th width="120">排序号：</th>
           <td>
           <s:textfield  name="bean.pxh" cssClass="inputText" id="pxh" cssStyle="width:90px;"/>
           <em  class="valid" title="排序号输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <c:if test="${empty showType}">
       <tr>
       	   <th width="120">参数配置：</th>
           <td><s:textfield  name="bean.params" cssClass="inputText" id="params"/></td>
        </tr>
       <tr>
       	   <th width="120">所属人：</th>
           <td><s:textfield  name="bean.owner" cssClass="inputText" id="owner"/></td>
        </tr>
       </c:if> 
       <tr>
          <th width="120">备注：</th>
          <td><div class="smsEdit" style="width:350px;"><span>共字数：250</span></div>
          <s:textarea name="bean.marks" cssClass="" cssStyle="width:350px; height:60px;" id="marks"></s:textarea>
           </td>
        </tr>
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
