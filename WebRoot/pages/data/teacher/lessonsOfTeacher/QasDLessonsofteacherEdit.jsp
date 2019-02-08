<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 12:34:30
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/teacher/lessonsOfTeacher/save.action" method="post">
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
       <%-- <tr>
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">教工名称：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="employeeid" name="bean.employeeid"  value="${bean.employeeid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">专业方向：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="directionid" name="bean.directionid"  value="${bean.directionid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">课程名称：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="courseid" name="bean.courseid"  value="${bean.courseid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">授课任务：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="teachingtask" name="bean.teachingtask"  value="${bean.teachingtask}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否合班授课：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="ismergeclass" name="bean.ismergeclass"  value="${bean.ismergeclass}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否平行班：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isparallelclass" name="bean.isparallelclass"  value="${bean.isparallelclass}"  /></td>
        </tr>
       <tr>
       	   <th width="120">教学工作量（学时）：</th>
          <td>
           <input type="text" class="inputText" id="teachingload"  maxlength="9"  name="bean.teachingload"  value="${bean.teachingload}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">实际授课课时：</th>
          <td>
           <input type="text" class="inputText" id="hour"  maxlength="9"  name="bean.hour"  value="${bean.hour}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">主要开设实践项目名称(全称)<-->实验：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="experiment" name="bean.experiment"  value="${bean.experiment}"  /></td>
        </tr>
       <tr>
       	   <th width="120">主要开设实践项目名称(全称)<-->实训：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="training" name="bean.training"  value="${bean.training}"  /></td>
        </tr>
       <tr>
       	   <th width="120">主要开设实践项目名称(全称)<-->实习：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="practice" name="bean.practice"  value="${bean.practice}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否行政班授课：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isexecutiveclass" name="bean.isexecutiveclass"  value="${bean.isexecutiveclass}"  /></td>
        </tr>
       <tr>
       	   <th width="120">授课学期：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="term" name="bean.term"  value="${bean.term}"  /></td>
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
