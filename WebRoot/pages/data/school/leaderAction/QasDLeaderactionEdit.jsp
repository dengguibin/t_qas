<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:43:40
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/school/leaderAction/save.action" method="post">
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
       	   <th width="120">教工名称：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="employeeid" name="bean.employeeid"  value="${bean.employeeid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">关注教学和学生情况<-->听课（节）：</th>
          <td>
           <input type="text" class="inputText" id="lecturecount"  maxlength="9"  name="bean.lecturecount"  value="${bean.lecturecount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">关注教学和学生情况<-->走访学生寝室（次）：</th>
          <td>
           <input type="text" class="inputText" id="interviewcount"  maxlength="9"  name="bean.interviewcount"  value="${bean.interviewcount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">关注教学和学生情况<-->走访校外实习点（次）：</th>
          <td>
           <input type="text" class="inputText" id="practicalsessioncount"  maxlength="9"  name="bean.practicalsessioncount"  value="${bean.practicalsessioncount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">关注教学和学生情况<-->参与学生社团文体活动（次）：</th>
          <td>
           <input type="text" class="inputText" id="studentassociationcount"  maxlength="9"  name="bean.studentassociationcount"  value="${bean.studentassociationcount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">兼课量（学时）：</th>
          <td>
           <input type="text" class="inputText" id="parttimecount"  maxlength="9"  name="bean.parttimecount"  value="${bean.parttimecount}"  />
           </td>
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
