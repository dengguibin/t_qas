<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 12:33:15
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/teacher/teacherResearch/save.action" method="post">
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
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">教工名称：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="employeeid" name="bean.employeeid"  value="${bean.employeeid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">课题性质：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchnature" name="bean.researchnature"  value="${bean.researchnature}"  /></td>
        </tr>
       <tr>
       	   <th width="120">课题分类：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchtype" name="bean.researchtype"  value="${bean.researchtype}"  /></td>
        </tr>
       <tr>
       	   <th width="120">课题名称：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchname" name="bean.researchname"  value="${bean.researchname}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否横向课题：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchishorizontalissue" name="bean.researchishorizontalissue"  value="${bean.researchishorizontalissue}"  /></td>
        </tr>
       <tr>
       	   <th width="120">课题级别：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchlevel" name="bean.researchlevel"  value="${bean.researchlevel}"  /></td>
        </tr>
       <tr>
       	   <th width="120">立项日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchestablishdate" name="bean.researchestablishdate"  value="${bean.researchestablishdate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">经费来源：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchfund" name="bean.researchfund"  value="${bean.researchfund}"  /></td>
        </tr>
       <tr>
       	   <th width="120">到款金额（元）：</th>
          <td>
           <input type="text" class="inputText" id="researchamountreceived"  maxlength="9"  name="bean.researchamountreceived"  value="${bean.researchamountreceived}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">完成人顺序：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchcompleteorder" name="bean.researchcompleteorder"  value="${bean.researchcompleteorder}"  /></td>
        </tr>
       <tr>
       	   <th width="120">课题来源：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="researchsource" name="bean.researchsource"  value="${bean.researchsource}"  /></td>
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
