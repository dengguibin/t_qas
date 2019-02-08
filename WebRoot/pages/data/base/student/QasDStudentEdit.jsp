<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-25 10:28:59
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/base/student/save.action" method="post">
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
       	   <th width="120">学生唯一标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写学生唯一标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">班级名称：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="gradeid" name="bean.gradeid"  value="${bean.gradeid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学号：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="no" name="bean.no"  value="${bean.no}"  /></td>
        </tr>
       <tr>
       	   <th width="120">姓名：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="name" name="bean.name"  value="${bean.name}"  /></td>
        </tr>
       <tr>
       	   <th width="120">性别：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="sex" name="bean.sex"  value="${bean.sex}"  /></td>
        </tr>
       <tr>
       	   <th width="120">民族：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="nation" name="bean.nation"  value="${bean.nation}"  /></td>
        </tr>
       <tr>
       	   <th width="120">电子邮箱：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="email" name="bean.email"  value="${bean.email}"  /></td>
        </tr>
       <tr>
       	   <th width="120">出生日期：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="birthday" name="bean.birthday"  value="${bean.birthday}"  /></td>
        </tr>
       <tr>
       	   <th width="120">生源地：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="birthplace" name="bean.birthplace"  value="${bean.birthplace}"  /></td>
        </tr>
       <tr>
       	   <th width="120">来自军队：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="fromarmy" name="bean.fromarmy"  value="${bean.fromarmy}"  /></td>
        </tr>
       <tr>
       	   <th width="120">招生方式：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="enrollment" name="bean.enrollment"  value="${bean.enrollment}"  /></td>
        </tr>
       <tr>
       	   <th width="120">生源类型：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="typeofstudent" name="bean.typeofstudent"  value="${bean.typeofstudent}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否常住户口在农村：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isresidentsincountry" name="bean.isresidentsincountry"  value="${bean.isresidentsincountry}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否订单（定向）培养：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isspecialtraining" name="bean.isspecialtraining"  value="${bean.isspecialtraining}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否建档立卡贫困家庭	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="ispovertyfamily" name="bean.ispovertyfamily"  value="${bean.ispovertyfamily}"  /></td>
        </tr>
       <tr>
       	   <th width="120">年级：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="grade" name="bean.grade"  value="${bean.grade}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学制：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="lengthofschooling" name="bean.lengthofschooling"  value="${bean.lengthofschooling}"  /></td>
        </tr>
       <tr>
       	   <th width="120">入学日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="admissiondate" name="bean.admissiondate"  value="${bean.admissiondate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否毕业：</th>
           <td>
           		<%-- <input type="text" class="inputText"  maxlength="50"  id="isgraduation" name="bean.isgraduation"  value="${bean.isgraduation}"  /> --%>
           		<select id="select9"  name="bean.isgraduation" style="width:152px;height:34px">
						<!--调用字典的效果-->
						<x:cache subject="10010" option="true"
							selected="${bean.isgraduation }"></x:cache>
				</select>
           </td>
        </tr>
       <tr>
       	   <th width="120">欠费金额（元）：</th>
          <td>
           <input type="text" class="inputText" id="arrearage"  maxlength="9"  name="bean.arrearage"  value="${bean.arrearage}"  />
           </td>
        </tr>
    <%--    <tr>
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
