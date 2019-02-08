<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 12:21:32
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
    	   <th width="120">序号：</th>
           <td>${bean.id}</td>
        </tr>
       <tr>
    	   <th width="120">项目名称：</th>
           <td>${bean.projectname}</td>
        </tr>
       <tr>
    	   <th width="120">专业：</th>
           <td>${bean.majorid}</td>
        </tr>
       <tr>
    	   <th width="120">类别：</th>
           <td>${bean.projecttype}</td>
        </tr>
       <tr>
    	   <th width="120">项目级别：</th>
           <td>${bean.grade}</td>
        </tr>
       <tr>
    	   <th width="120">项目负责人：</th>
           <td>${bean.employeeid}</td>
        </tr>
       <tr>
    	   <th width="120">授予部门：</th>
           <td>${bean.department}</td>
        </tr>
       <tr>
    	   <th width="120">立项文件名称、文号：</th>
           <td>${bean.file}</td>
        </tr>
       <tr>
       	   <th width="120">开始时间：</th>
           <td ><fmt:formatDate value="${bean.starttime}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
       	   <th width="120">结束时间：</th>
           <td ><fmt:formatDate value="${bean.endtime}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">当前状态：</th>
           <td>${bean.curstatus}</td>
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
