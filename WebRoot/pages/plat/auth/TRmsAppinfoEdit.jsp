<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-11 12:58:42
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<s:form action="tRmsAppinfo!save" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<s:hidden name="bean.appid" id="appid"></s:hidden>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120">组织ID：<span class="warning">*</span></th>
           <td><s:textfield  name="bean.orgid" cssClass="inputText" id="orgid"  datatype="*" nullmsg="请填写组织ID"  maxlength="20"/></td>
        </tr>
       <tr>
       	   <th width="120">系统名称：<span class="warning">*</span></th>
           <td><s:textfield  name="bean.xtms" cssClass="inputText" id="xtms"  datatype="*" nullmsg="请填写系统名称"  maxlength="20"/></td>
        </tr>
         </tbody>
          <tr>
	        <td colspan="2" class="subtitle" >Logo信息</td>
	      </tr>
	        <tbody>
		       <tr>
		       	   <th width="120">登陆页面Logo：</th>
		           <td>
		          	  <img src="${ctx}/skins/uimaker/images/logo.png" title="系统首页">
		          	 <br>
		          	 <span class="note">
		          	 系统路径地址：/skins/uimaker/images/logo.png[274*71]</span>
		           	 <a href="javascript:void(0);" class="tablelink">替换此文件便可修改</a>
		           </td>
		        </tr>
		         <tr>
		       	   <th width="120">登陆后导航Logo：</th>
		           <td>
		           <img src="${ctx}/skins/uimaker/images/loginlogo.png" title="系统首页">
		          	 <br>
		          	  <span class="note">
		          	 系统路径地址：/skins/uimaker/images/loginlogo.png[280*71] </span>
		          	 <a href="javascript:void(0);" class="tablelink">替换此文件便可修改</a>
		           </td>
		        </tr>
      		<tbody>
         
         
         <tr>
	        <td colspan="2" class="subtitle" >选填信息</td>
	      </tr>
	        <tbody>
       <tr>
       	   <th width="120">系统当前版本：</th>
           <td><s:textfield  name="bean.xtdqbb" cssClass="inputText" id="xtdqbb" maxlength="20"/></td>
        </tr>
       <tr>
       	   <th width="120">开发维护人：</th>
           <td><s:textfield  name="bean.kfwfr" cssClass="inputText" id="kfwfr"  maxlength="20"/></td>
        </tr>
       <!-- 
       <tr>
          <th width="120">当前部署路径：</th>
          <td><div class="smsEdit" style="width:380px;"><span>共字数：100</span></div>
          <s:textarea name="bean.dqbslj" cssClass="" cssStyle="width:380px; height:60px;" id="dqbslj"></s:textarea>
           </td>
        </tr>
         --> 
       <tr>
       	   <th width="120">邮件联系方式：</th>
           <td><s:textfield  name="bean.yjlxfs" cssClass="inputText" id="yjlxfs" datatype="e" ignore="ignore" errormsg="请填正确填写邮件联系方式" maxlength="20"/></td>
        </tr>
       <tr>
       	   <th width="120">电话方式：</th>
           <td><s:textfield  name="bean.dhfs" cssClass="inputText" id="dhfs"/></td>
        </tr>
         <tr>
          <th width="120">系统默认首页：</th>
          <td>
          <s:textarea name="bean.xtmrsy" cssClass="textinput2" id="xtmrsy" maxlength="100"></s:textarea>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
         <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
</div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
