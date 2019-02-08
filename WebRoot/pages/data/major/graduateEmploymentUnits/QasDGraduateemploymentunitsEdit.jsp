<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:11:24
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/graduateEmploymentUnits/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.id" id="id"/>
			<s:hidden name="bean.status" id="status"/>
			<s:hidden name="bean.createdby" id="createdby"/>
			<s:hidden name="bean.createdtime" id="createdtime"/>
			<s:hidden name="bean.updatedby" id="updatedby"/>
			<s:hidden name="bean.updatedtime" id="updatedtime"/>
			<s:hidden name="bean.tenantid" id="tenantid"/>
			<s:hidden name="bean.storagetime" id="storagetime"/>
			
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
      <%--  <tr>
       	   <th width="120">记录标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写记录标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">应届毕业生主要就业单位名称(全称)：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="mainemploymentunit" name="bean.mainemploymentunit"  value="${bean.mainemploymentunit}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否做过雇主调查：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isemployersurvey" name="bean.isemployersurvey"  value="${bean.isemployersurvey}"  /></td>
        </tr>
       <tr>
       	   <th width="120">就业单位联系人信息<-->姓名：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="contactname" name="bean.contactname"  value="${bean.contactname}"  /></td>
        </tr>
       <tr>
       	   <th width="120">就业单位联系人信息<-->职务：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="contactduty" name="bean.contactduty"  value="${bean.contactduty}"  /></td>
        </tr>
       <tr>
       	   <th width="120">就业单位联系人信息<-->区号－电话号码：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="contactphone" name="bean.contactphone"  value="${bean.contactphone}"  /></td>
        </tr>
       <tr>
       	   <th width="120">就业单位联系人信息<-->电子邮箱：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="contactemail" name="bean.contactemail"  value="${bean.contactemail}"  /></td>
        </tr>
       <%-- <tr>
       	   <th width="120">状态：</th>
          <td>
           <input type="text" class="inputText" id="status"  maxlength="9"  name="bean.status"  value="${bean.status}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">创建人：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="createdby" name="bean.createdby"  value="${bean.createdby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">创建时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="createdtime" name="bean.createdtime"  value="${createdtime}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">修改人：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="updatedby" name="bean.updatedby"  value="${bean.updatedby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">修改时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="updatedtime" name="bean.updatedtime"  value="${updatedtime}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">租户：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="tenantid" name="bean.tenantid"  value="${bean.tenantid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">入库时间（接口传输，导入）：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="storagetime" name="bean.storagetime"  value="${storagetime}" />
          </td>
        </tr> --%>
	   
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
