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
<form action="" id="opForm">
<s:hidden name="menuId" id="menuId"/>
	<div class="formtitle"><span>放在这里提示</span></div>
		<table>
			<tr>
				<td colspan="2" class="subtitle">必填选填放在TBODY前面信息 </td>
			</tr>
       <tbody>
     <%--   <tr>
    	   <th width="120">学生唯一标识：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">班级名称：</th>
           <td>${bean.gradeid}</td>
        </tr>
       <tr>
    	   <th width="120">学号：</th>
           <td>${bean.no}</td>
        </tr>
       <tr>
    	   <th width="120">姓名：</th>
           <td>${bean.name}</td>
        </tr>
       <tr>
    	   <th width="120">性别：</th>
           <td>${bean.sex}</td>
        </tr>
       <tr>
    	   <th width="120">民族：</th>
           <td>${bean.nation}</td>
        </tr>
       <tr>
    	   <th width="120">电子邮箱：</th>
           <td>${bean.email}</td>
        </tr>
       <tr>
    	   <th width="120">出生日期：</th>
           <td>${bean.birthday}</td>
        </tr>
       <tr>
    	   <th width="120">生源地：</th>
           <td>${bean.birthplace}</td>
        </tr>
       <tr>
    	   <th width="120">来自军队：</th>
           <td>${bean.fromarmy}</td>
        </tr>
       <tr>
    	   <th width="120">招生方式：</th>
           <td>${bean.enrollment}</td>
        </tr>
       <tr>
    	   <th width="120">生源类型：</th>
           <td>${bean.typeofstudent}</td>
        </tr>
       <tr>
    	   <th width="120">是否常住户口在农村：</th>
           <td>${bean.isresidentsincountry}</td>
        </tr>
       <tr>
    	   <th width="120">是否订单（定向）培养：</th>
           <td>${bean.isspecialtraining}</td>
        </tr>
       <tr>
    	   <th width="120">是否建档立卡贫困家庭	：</th>
           <td>${bean.ispovertyfamily}</td>
        </tr>
       <tr>
    	   <th width="120">年级：</th>
           <td>${bean.grade}</td>
        </tr>
       <tr>
    	   <th width="120">学制：</th>
           <td>${bean.lengthofschooling}</td>
        </tr>
       <tr>
    	   <th width="120">入学日期（年月）：</th>
           <td>${bean.admissiondate}</td>
        </tr>
       <tr>
    	   <th width="120">是否毕业：</th>
           <td>${bean.isgraduation}</td>
        </tr>
       <tr>
    	   <th width="120">欠费金额（元）：</th>
           <td>${bean.arrearage}</td>
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
