<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-11 21:51:54
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<s:form action="tRmsRole!save" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<s:hidden name="bean.jsid" id="jsid"></s:hidden>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>角色名称：</th>
           <td>
           <c:choose>
           	<c:when test="${not empty bean.jsid}"><s:textfield  name="bean.jsmc" cssClass="inputText" readonly="true" id="jsmc"/></c:when>
           	<c:otherwise><s:textfield  name="bean.jsmc" cssClass="inputText" id="jsmc"/></c:otherwise>
           </c:choose>
           <em  class="valid" title="请输入2-10个字符的角色名称。" lang="s2-10"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">角色描述：</th>
           <td><s:textfield  name="bean.jsms" cssClass="inputText" id="jsms"/></td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>排序号：</th>
           <td>
           <s:textfield  name="bean.pxh" cssClass="inputText" id="pxh" cssStyle="width:90px;"/>
           <em  class="valid" title="排序号必须录入整数项。" lang="n" ></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">赋予权限：</th>
           <td>
           	<x:cache subject="PERMISSION" var="list" scope="requestScope"/>
			<s:checkboxlist list="#request.list" name="permiss" listKey="subcode" listValue="cname" />
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>是否有效：</th>
           <td>
           <x:cache subject="OPTION01" var="list" scope="requestScope"/>
           <s:radio list="#request.list" name="bean.sfyx" id="sfyx" listKey="subcode" listValue="cname" ></s:radio>
           	 <em  class="valid" title="是否有效是必须录入项" lang="*" for="sfyx1"></em>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
         <input type="button"  class="cancel" value=" 返 回 " id="returnButton"  />
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
</div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>