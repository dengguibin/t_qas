<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:17:24
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/student/qualification/save.action" method="post">
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
     <%--   <tr>
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">专业方向：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="directionid" name="bean.directionid"  value="${bean.directionid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学生获取的符合专业面向职业资格证书名称(全称)：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="certname" name="bean.certname"  value="${bean.certname}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学生获取的符合专业面向职业资格证书等级：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="certlevel" name="bean.certlevel"  value="${bean.certlevel}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学生获取的符合专业面向职业资格证书人数：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="certcount" name="bean.certcount"  value="${bean.certcount}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学生获取的符合专业面向职业资格证书发证机构：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="issuingdepartment" name="bean.issuingdepartment"  value="${bean.issuingdepartment}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学生获取的符合专业面向职业资格证书鉴定地点：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="identificationsite" name="bean.identificationsite"  value="${bean.identificationsite}"  /></td>
        </tr>
      <%--  <tr>
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
