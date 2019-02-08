<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:58:43
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/school/trainingBaseOutOfCampusStatistics/save.action" method="post">
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
       	   <th width="120">校外实践基地：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="practicebaseincampusid" name="bean.practicebaseincampusid"  value="${bean.practicebaseincampusid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">面向专业 ：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="majorid" name="bean.majorid"  value="${bean.majorid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">项目数：</th>
          <td>
           <input type="text" class="inputText" id="numoftrainingproject"  maxlength="9"  name="bean.numoftrainingproject"  value="${bean.numoftrainingproject}"  />
           </td>
        </tr>
       <tr>
          <th width="120">实习实训项目<-->项目：</th>
          <td>
                <textarea id="numofprojectname"  maxlength="127.5" name="bean.numofprojectname" class="textinput2" >${bean.numofprojectname}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">接待学生量(人次)	：</th>
          <td>
           <input type="text" class="inputText" id="numofstureceived"  maxlength="9"  name="bean.numofstureceived"  value="${bean.numofstureceived}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">基地使用时间（天）：</th>
          <td>
           <input type="text" class="inputText" id="baseusetime"  maxlength="9"  name="bean.baseusetime"  value="${bean.baseusetime}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">接受半年顶岗实习学生数：</th>
          <td>
           <input type="text" class="inputText" id="halfyearinternshipstudent"  maxlength="9"  name="bean.halfyearinternshipstudent"  value="${bean.halfyearinternshipstudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">是否有住宿条件	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isaccommodationconditions" name="bean.isaccommodationconditions"  value="${bean.isaccommodationconditions}"  /></td>
        </tr>
       <tr>
       	   <th width="120">基地是否发放学生实习补贴：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="studentinternshipallowance" name="bean.studentinternshipallowance"  value="${bean.studentinternshipallowance}"  /></td>
        </tr>
       <tr>
       	   <th width="120">向基地支付专项实习经费（元/生）：</th>
          <td>
           <input type="text" class="inputText" id="specialpracticefund"  maxlength="9"  name="bean.specialpracticefund"  value="${bean.specialpracticefund}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">派指导教师/学生管理人员（人次）：</th>
          <td>
           <input type="text" class="inputText" id="schooltutorcount"  maxlength="9"  name="bean.schooltutorcount"  value="${bean.schooltutorcount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">接收应届毕业生就业数	：</th>
          <td>
           <input type="text" class="inputText" id="numofgraduateemployed"  maxlength="9"  name="bean.numofgraduateemployed"  value="${bean.numofgraduateemployed}"  />
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
