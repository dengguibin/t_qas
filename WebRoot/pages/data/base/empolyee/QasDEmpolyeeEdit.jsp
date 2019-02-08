<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 11:09:27
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/base/empolyee/save.action" method="post">
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
  <%--      <tr>
       	   <th width="120">教工唯一标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写教工唯一标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">所属系部：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="departmentid" name="bean.departmentid"  value="${bean.departmentid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">所属专业：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="majorid" name="bean.majorid"  value="${bean.majorid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">教工号：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="employeecode" name="bean.employeecode"  value="${bean.employeecode}"  /></td>
        </tr>
       <tr>
       	   <th width="120">姓名：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="name" name="bean.name"  value="${bean.name}"  /></td>
        </tr>
       <tr>
       	   <th width="120">民族：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="nation" name="bean.nation"  value="${bean.nation}"  /></td>
        </tr>
       <tr>
       	   <th width="120">职务：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="duty" name="bean.duty"  value="${bean.duty}"  /></td>
        </tr>
       <tr>
       	   <th width="120">职称：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="title" name="bean.title"  value="${bean.title}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学历：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="qualification" name="bean.qualification"  value="${bean.qualification}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学位：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="academicdegree" name="bean.academicdegree"  value="${bean.academicdegree}"  /></td>
        </tr>
       <tr>
       	   <th width="120">性别：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="sex" name="bean.sex"  value="${bean.sex}"  /></td>
        </tr>
       <tr>
       	   <th width="120">出生日期：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="birthday" name="bean.birthday"  value="${bean.birthday}"  /></td>
        </tr>
       <tr>
       	   <th width="120">区号-电话号码：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="phone" name="bean.phone"  value="${bean.phone}"  /></td>
        </tr>
       <tr>
       	   <th width="120">电子邮箱：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="email" name="bean.email"  value="${bean.email}"  /></td>
        </tr>
       <tr>
       	   <th width="120">工作经历简介：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="workexperience" name="bean.workexperience"  value="${bean.workexperience}"  /></td>
        </tr>
       <tr>
       	   <th width="120">专业技术职务<-->等级：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="majordeep" name="bean.majordeep"  value="${bean.majordeep}"  /></td>
        </tr>
       <tr>
          <th width="120">专业技术职务<-->名称（全称）：</th>
          <td>
                <textarea id="highmajorname"  maxlength="127.5" name="bean.highmajorname" class="textinput2" >${bean.highmajorname}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">专业技术职务<-->发证单位：</th>
          <td>
                <textarea id="grantcompany"  maxlength="127.5" name="bean.grantcompany" class="textinput2" >${bean.grantcompany}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">专业技术职务<-->获取日期(年月)：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="receiveddate" name="bean.receiveddate"  value="${bean.receiveddate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否在编：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isinplan" name="bean.isinplan"  value="${bean.isinplan}"  /></td>
        </tr>
       <tr>
       	   <th width="120">岗位职能：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="postduty" name="bean.postduty"  value="${bean.postduty}"  /></td>
        </tr>
       <tr>
       	   <th width="120">科研成果：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="achievement" name="bean.achievement"  value="${bean.achievement}"  /></td>
        </tr>
       <tr>
       	   <th width="120">分管工作：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="managework" name="bean.managework"  value="${bean.managework}"  /></td>
        </tr>
       <tr>
       	   <th width="120">教师类型：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="teachertype" name="bean.teachertype"  value="${bean.teachertype}"  /></td>
        </tr>
       <tr>
       	   <th width="120">专业领域：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="specialarea" name="bean.specialarea"  value="${bean.specialarea}"  /></td>
        </tr>
       <tr>
       	   <th width="120">专业特长：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="specialty" name="bean.specialty"  value="${bean.specialty}"  /></td>
        </tr>
       <tr>
       	   <th width="120">有无高校教师资格证：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isteacherdegree" name="bean.isteacherdegree"  value="${bean.isteacherdegree}"  /></td>
        </tr>
       <tr>
       	   <th width="120">行业、企业一线工作时间<-->历年（年）：</th>
          <td>
           <input type="text" class="inputText" id="workyear"  maxlength="9"  name="bean.workyear"  value="${bean.workyear}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">行业、企业一线工作时间<-->本学年（天）：</th>
          <td>
           <input type="text" class="inputText" id="workincurrentyear"  maxlength="9"  name="bean.workincurrentyear"  value="${bean.workincurrentyear}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">职业资格证书<-->等级：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="qualificationlevel" name="bean.qualificationlevel"  value="${bean.qualificationlevel}"  /></td>
        </tr>
       <tr>
       	   <th width="120">职业资格证书<-->名称(全称)：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="qualificationname" name="bean.qualificationname"  value="${bean.qualificationname}"  /></td>
        </tr>
       <tr>
       	   <th width="120">职业资格证书<-->发证单位：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="qualificationunit" name="bean.qualificationunit"  value="${bean.qualificationunit}"  /></td>
        </tr>
       <tr>
       	   <th width="120">职业资格证书<-->获取日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="qualificationreceivedate" name="bean.qualificationreceivedate"  value="${bean.qualificationreceivedate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">高校教师资格证书<-->发证单位	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="teacherqualificationunit" name="bean.teacherqualificationunit"  value="${bean.teacherqualificationunit}"  /></td>
        </tr>
       <tr>
       	   <th width="120">高校教师资格证书<-->获取日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="teacherqualificationreceivedate" name="bean.teacherqualificationreceivedate"  value="${bean.teacherqualificationreceivedate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否专业教师：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isprofessionalteacher" name="bean.isprofessionalteacher"  value="${bean.isprofessionalteacher}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否为骨干教师：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="iscoreteacher" name="bean.iscoreteacher"  value="${bean.iscoreteacher}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否为双师素质教师：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="doublequalifiedteacher" name="bean.doublequalifiedteacher"  value="${bean.doublequalifiedteacher}"  /></td>
        </tr>
       <tr>
       	   <th width="120">教学名师：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="famousteacher" name="bean.famousteacher"  value="${bean.famousteacher}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否校企双导师：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="dualmentor" name="bean.dualmentor"  value="${bean.dualmentor}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否企业导师：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="companymentor" name="bean.companymentor"  value="${bean.companymentor}"  /></td>
        </tr>
       <tr>
       	   <th width="120">互聘公培导师：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="publictrainingsupervisor" name="bean.publictrainingsupervisor"  value="${bean.publictrainingsupervisor}"  /></td>
        </tr>
       <tr>
       	   <th width="120">"千百十"人才培养等级：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="traininglevel" name="bean.traininglevel"  value="${bean.traininglevel}"  /></td>
        </tr>
       <tr>
       	   <th width="120">珠江学者：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="iszhujiangscholar" name="bean.iszhujiangscholar"  value="${bean.iszhujiangscholar}"  /></td>
        </tr>
       <tr>
       	   <th width="120">校外教师<-->参加工作日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="dateofwork" name="bean.dateofwork"  value="${bean.dateofwork}"  /></td>
        </tr>
       <tr>
       	   <th width="120">校外教师<-->签约情况：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="signedstatus" name="bean.signedstatus"  value="${bean.signedstatus}"  /></td>
        </tr>
       <tr>
       	   <th width="120">校外教师<-->当前专职工作背景<-->单位名称：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="backgroundunit" name="bean.backgroundunit"  value="${bean.backgroundunit}"  /></td>
        </tr>
       <tr>
       	   <th width="120">校外教师<-->当前专职工作背景<-->职务：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="backgroundduty" name="bean.backgroundduty"  value="${bean.backgroundduty}"  /></td>
        </tr>
       <tr>
       	   <th width="120">校外教师<-->当前专职工作背景<-->任职日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="backgroundappointmentdate" name="bean.backgroundappointmentdate"  value="${bean.backgroundappointmentdate}"  /></td>
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
