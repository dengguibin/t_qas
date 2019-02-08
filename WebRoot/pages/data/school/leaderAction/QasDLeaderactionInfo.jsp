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
<form action="" id="opForm">
<s:hidden name="menuId" id="menuId"/>
	<div class="formtitle"><span>放在这里提示</span></div>
		<table>
			<tr>
				<td colspan="2" class="subtitle">必填选填放在TBODY前面信息 </td>
			</tr>
       <tbody>
       <tr>
    	   <th width="120">记录标识：</th>
           <td>${bean.id}</td>
        </tr>
       <tr>
    	   <th width="120">教工名称：</th>
           <td>${bean.employeeid}</td>
        </tr>
       <tr>
    	   <th width="120">关注教学和学生情况<-->听课（节）：</th>
           <td>${bean.lecturecount}</td>
        </tr>
       <tr>
    	   <th width="120">关注教学和学生情况<-->走访学生寝室（次）：</th>
           <td>${bean.interviewcount}</td>
        </tr>
       <tr>
    	   <th width="120">关注教学和学生情况<-->走访校外实习点（次）：</th>
           <td>${bean.practicalsessioncount}</td>
        </tr>
       <tr>
    	   <th width="120">关注教学和学生情况<-->参与学生社团文体活动（次）：</th>
           <td>${bean.studentassociationcount}</td>
        </tr>
       <tr>
    	   <th width="120">兼课量（学时）：</th>
           <td>${bean.parttimecount}</td>
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
