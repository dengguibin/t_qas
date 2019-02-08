<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 12:25:18
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
    	   <th width="120">专业方向：</th>
           <td>${bean.directionid}</td>
        </tr>
       <tr>
    	   <th width="120">课题内容：</th>
           <td>${bean.content}</td>
        </tr>
       <tr>
    	   <th width="120">合作企业名称：</th>
           <td>${bean.companyid}</td>
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
    	   <th width="120">项目负责人(校方)：</th>
           <td>${bean.employeeid}</td>
        </tr>
       <tr>
    	   <th width="120">立项部门：</th>
           <td>${bean.departmentid}</td>
        </tr>
       <tr>
    	   <th width="120">立项文件名称、文号：</th>
           <td>${bean.file}</td>
        </tr>
       <tr>
    	   <th width="120">是否横向课题：</th>
           <td>${bean.ishorizontal}</td>
        </tr>
       <tr>
    	   <th width="120">金额（万元）：</th>
           <td>${bean.amount}</td>
        </tr>
       <tr>
       	   <th width="120">开始时间：</th>
           <td ><fmt:formatDate value="${bean.starttime}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
       	   <th width="120">结束时间	：</th>
           <td ><fmt:formatDate value="${bean.endtime}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">当前状态	：</th>
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
