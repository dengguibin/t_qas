<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:45:25
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
    	   <th width="120">阅览室座位数（个)：</th>
           <td>${bean.numofreadingroomseat}</td>
        </tr>
       <tr>
    	   <th width="120">计算机数（台）<-->合计：</th>
           <td>${bean.numofcomputer}</td>
        </tr>
       <tr>
    	   <th width="120">计算机数（台）<-->教学用计算机<-->合计	：</th>
           <td>${bean.numofteachingcomputer}</td>
        </tr>
       <tr>
    	   <th width="120">计算机数（台）<-->教学用计算机<-->平板电脑：</th>
           <td>${bean.numofteachingpad}</td>
        </tr>
       <tr>
    	   <th width="120">计算机数（台）<-->机房用计算机<-->公共机房：</th>
           <td>${bean.numofpubliccomputerroom}</td>
        </tr>
       <tr>
    	   <th width="120">计算机数（台）<-->机房用计算机<-->专业机房：</th>
           <td>${bean.numofspecialcomputerroom}</td>
        </tr>
       <tr>
    	   <th width="120">教室（间）<-->合计：</th>
           <td>${bean.numofclassroom}</td>
        </tr>
       <tr>
    	   <th width="120">教室（间）<-->网络多媒体教室：</th>
           <td>${bean.numofmediaroom}</td>
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
