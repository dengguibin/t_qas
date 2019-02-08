<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:07:46
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
      <%--  <tr>
    	   <th width="120">序号：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">专业方向：</th>
           <td>${bean.directionid}</td>
        </tr>
       <tr>
    	   <th width="120">课程名称：</th>
           <td>${bean.courseid}</td>
        </tr>
       <tr>
    	   <th width="120">课程性质：</th>
           <td>${bean.coursenature}</td>
        </tr>
       <tr>
    	   <th width="120">教学计划规定课时数（学时）：</th>
           <td>${bean.planhours}</td>
        </tr>
       <tr>
    	   <th width="120">实践课课时数：</th>
           <td>${bean.normalhours}</td>
        </tr>
       <tr>
    	   <th width="120">授课年级：</th>
           <td>${bean.classgrade}</td>
        </tr>
       <tr>
    	   <th width="120">主要授课地点：</th>
           <td>${bean.classaddress}</td>
        </tr>
       <tr>
    	   <th width="120">主要授课方式：</th>
           <td>${bean.classtype}</td>
        </tr>
       <tr>
    	   <th width="120">考试/考核主要方法：</th>
           <td>${bean.examemethod}</td>
        </tr>
       <tr>
    	   <th width="120">课证融通课程：</th>
           <td>${bean.papertocourse}</td>
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
