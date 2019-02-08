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
<form action="" id="opForm">
<s:hidden name="menuId" id="menuId"/>
	<div class="formtitle"><span>放在这里提示</span></div>
		<table>
			<tr>
				<td colspan="2" class="subtitle">必填选填放在TBODY前面信息 </td>
			</tr>
       <tbody>
   <%--     <tr>
    	   <th width="120">教工唯一标识：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">所属系部：</th>
           <td>${bean.departmentid}</td>
        </tr>
       <tr>
    	   <th width="120">所属专业：</th>
           <td>${bean.majorid}</td>
        </tr>
       <tr>
    	   <th width="120">教工号：</th>
           <td>${bean.employeecode}</td>
        </tr>
       <tr>
    	   <th width="120">姓名：</th>
           <td>${bean.name}</td>
        </tr>
       <tr>
    	   <th width="120">民族：</th>
           <td>${bean.nation}</td>
        </tr>
       <tr>
    	   <th width="120">职务：</th>
           <td>${bean.duty}</td>
        </tr>
       <tr>
    	   <th width="120">职称：</th>
           <td>${bean.title}</td>
        </tr>
       <tr>
    	   <th width="120">学历：</th>
           <td>${bean.qualification}</td>
        </tr>
       <tr>
    	   <th width="120">学位：</th>
           <td>${bean.academicdegree}</td>
        </tr>
       <tr>
    	   <th width="120">性别：</th>
           <td>${bean.sex}</td>
        </tr>
       <tr>
    	   <th width="120">出生日期：</th>
           <td>${bean.birthday}</td>
        </tr>
       <tr>
    	   <th width="120">区号-电话号码：</th>
           <td>${bean.phone}</td>
        </tr>
       <tr>
    	   <th width="120">电子邮箱：</th>
           <td>${bean.email}</td>
        </tr>
       <tr>
    	   <th width="120">工作经历简介：</th>
           <td>${bean.workexperience}</td>
        </tr>
       <tr>
    	   <th width="120">专业技术职务<-->等级：</th>
           <td>${bean.majordeep}</td>
        </tr>
       <tr>
    	   <th width="120">专业技术职务<-->名称（全称）：</th>
           <td>${bean.highmajorname}</td>
        </tr>
       <tr>
    	   <th width="120">专业技术职务<-->发证单位：</th>
           <td>${bean.grantcompany}</td>
        </tr>
       <tr>
    	   <th width="120">专业技术职务<-->获取日期(年月)：</th>
           <td>${bean.receiveddate}</td>
        </tr>
       <tr>
    	   <th width="120">是否在编：</th>
           <td>${bean.isinplan}</td>
        </tr>
       <tr>
    	   <th width="120">岗位职能：</th>
           <td>${bean.postduty}</td>
        </tr>
       <tr>
    	   <th width="120">科研成果：</th>
           <td>${bean.achievement}</td>
        </tr>
       <tr>
    	   <th width="120">分管工作：</th>
           <td>${bean.managework}</td>
        </tr>
       <tr>
    	   <th width="120">教师类型：</th>
           <td>${bean.teachertype}</td>
        </tr>
       <tr>
    	   <th width="120">专业领域：</th>
           <td>${bean.specialarea}</td>
        </tr>
       <tr>
    	   <th width="120">专业特长：</th>
           <td>${bean.specialty}</td>
        </tr>
       <tr>
    	   <th width="120">有无高校教师资格证：</th>
           <td>${bean.isteacherdegree}</td>
        </tr>
       <tr>
    	   <th width="120">行业、企业一线工作时间<-->历年（年）：</th>
           <td>${bean.workyear}</td>
        </tr>
       <tr>
    	   <th width="120">行业、企业一线工作时间<-->本学年（天）：</th>
           <td>${bean.workincurrentyear}</td>
        </tr>
       <tr>
    	   <th width="120">职业资格证书<-->等级：</th>
           <td>${bean.qualificationlevel}</td>
        </tr>
       <tr>
    	   <th width="120">职业资格证书<-->名称(全称)：</th>
           <td>${bean.qualificationname}</td>
        </tr>
       <tr>
    	   <th width="120">职业资格证书<-->发证单位：</th>
           <td>${bean.qualificationunit}</td>
        </tr>
       <tr>
    	   <th width="120">职业资格证书<-->获取日期（年月）：</th>
           <td>${bean.qualificationreceivedate}</td>
        </tr>
       <tr>
    	   <th width="120">高校教师资格证书<-->发证单位	：</th>
           <td>${bean.teacherqualificationunit}</td>
        </tr>
       <tr>
    	   <th width="120">高校教师资格证书<-->获取日期（年月）：</th>
           <td>${bean.teacherqualificationreceivedate}</td>
        </tr>
       <tr>
    	   <th width="120">是否专业教师：</th>
           <td>${bean.isprofessionalteacher}</td>
        </tr>
       <tr>
    	   <th width="120">是否为骨干教师：</th>
           <td>${bean.iscoreteacher}</td>
        </tr>
       <tr>
    	   <th width="120">是否为双师素质教师：</th>
           <td>${bean.doublequalifiedteacher}</td>
        </tr>
       <tr>
    	   <th width="120">教学名师：</th>
           <td>${bean.famousteacher}</td>
        </tr>
       <tr>
    	   <th width="120">是否校企双导师：</th>
           <td>${bean.dualmentor}</td>
        </tr>
       <tr>
    	   <th width="120">是否企业导师：</th>
           <td>${bean.companymentor}</td>
        </tr>
       <tr>
    	   <th width="120">互聘公培导师：</th>
           <td>${bean.publictrainingsupervisor}</td>
        </tr>
       <tr>
    	   <th width="120">"千百十"人才培养等级：</th>
           <td>${bean.traininglevel}</td>
        </tr>
       <tr>
    	   <th width="120">珠江学者：</th>
           <td>${bean.iszhujiangscholar}</td>
        </tr>
       <tr>
    	   <th width="120">校外教师<-->参加工作日期（年月）：</th>
           <td>${bean.dateofwork}</td>
        </tr>
       <tr>
    	   <th width="120">校外教师<-->签约情况：</th>
           <td>${bean.signedstatus}</td>
        </tr>
       <tr>
    	   <th width="120">校外教师<-->当前专职工作背景<-->单位名称：</th>
           <td>${bean.backgroundunit}</td>
        </tr>
       <tr>
    	   <th width="120">校外教师<-->当前专职工作背景<-->职务：</th>
           <td>${bean.backgroundduty}</td>
        </tr>
       <tr>
    	   <th width="120">校外教师<-->当前专职工作背景<-->任职日期（年月）：</th>
           <td>${bean.backgroundappointmentdate}</td>
        </tr>
       <tr>
    	   <th width="120">状态：</th>
           <td>${bean.status}</td>
        </tr>
       <tr>
    	   <th width="120">创建人：</th>
           <td>${bean.createdby}</td>
        </tr>
       <tr>
       	   <th width="120">创建时间：</th>
           <td ><fmt:formatDate value="${bean.createdtime}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">修改人：</th>
           <td>${bean.updatedby}</td>
        </tr>
       <tr>
       	   <th width="120">修改时间：</th>
           <td ><fmt:formatDate value="${bean.updatedtime}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">租户：</th>
           <td>${bean.tenantid}</td>
        </tr>
       <tr>
       	   <th width="120">入库时间（接口传输，导入）：</th>
           <td ><fmt:formatDate value="${bean.storagetime}" pattern="yyyy-MM-dd"/></td>
        </tr>
	   
	  			 <tr>
					<td colspan="2" class="toolbar">
						<input type="button" id="returnButton" class="cancel" value=" 返 回 " /></td>
				</tr>
       </tbody>
    </table>
 </div>   <!--editBlock END-->
  </form>
</body> 
<%@include file="/pages/t_qas/layout/footer.jsp" %>
