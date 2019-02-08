<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-28 22:24:28
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/plat/frame/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<s:form action="tCommonOnline!save" namespace="com/upath/plat/common/modules" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>主键：</th>
           <td><s:textfield  name="bean.tid" cssClass="inputText" id="tid"/></td>
        </tr>
       <tr>
       	   <th width="120">会话ID：</th>
           <td><s:textfield  name="bean.sessionid" cssClass="inputText" id="sessionid"/></td>
        </tr>
       <tr>
       	   <th width="120">登陆时间：</th>
           <td><s:textfield  name="bean.logintime" cssClass="Wdate" cssStyle="width:100px;"  id="logintime" onfocus="WdatePicker();" /></td>
        </tr>
       <tr>
       	   <th width="120">登出时间：</th>
           <td><s:textfield  name="bean.logouttime" cssClass="Wdate" cssStyle="width:100px;"  id="logouttime" onfocus="WdatePicker();" /></td>
        </tr>
       <tr>
       	   <th width="120">当前状况：</th>
           <td>
           <s:textfield  name="bean.status" cssClass="inputText" id="status"/>
           <em  class="valid" title="当前状况输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">是否在线：</th>
           <td>
           <s:textfield  name="bean.online" cssClass="inputText" id="online"/>
           <em  class="valid" title="是否在线输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">登陆人：</th>
           <td><s:textfield  name="bean.userid" cssClass="inputText" id="userid"/></td>
        </tr>
       <tr>
       	   <th width="120">客户端IP：</th>
           <td><s:textfield  name="bean.cip" cssClass="inputText" id="cip"/></td>
        </tr>
       <tr>
       	   <th width="120">创建时间：</th>
           <td><s:textfield  name="bean.cjsj" cssClass="Wdate" cssStyle="width:100px;"  id="cjsj" onfocus="WdatePicker();" /></td>
        </tr>
       <tr>
       	   <th width="120">创建人：</th>
           <td><s:textfield  name="bean.cjr" cssClass="inputText" id="cjr"/></td>
        </tr>
       <tr>
       	   <th width="120">修改时间：</th>
           <td><s:textfield  name="bean.xgsj" cssClass="Wdate" cssStyle="width:100px;"  id="xgsj" onfocus="WdatePicker();" /></td>
        </tr>
       <tr>
       	   <th width="120">修改人：</th>
           <td><s:textfield  name="bean.xgr" cssClass="inputText" id="xgr"/></td>
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
<%@include file="/pages/plat/frame/footer.jsp" %>
