<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-30 10:31:54
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
       <%-- <tr>
    	   <th width="120">专业方向唯一标识：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">专业编号：</th>
           <td>${bean.majorid}</td>
        </tr>
       <tr>
    	   <th width="120">专业方向代码：</th>
           <td>${bean.directioncode}</td>
        </tr>
       <tr>
    	   <th width="120">专业方向名称：</th>
           <td>${bean.directionname}</td>
        </tr>
       <tr>
       	   <th width="120">批准设置日期：</th>
           <td ><fmt:formatDate value="${bean.setupdate}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
       	   <th width="120">首次招生日期：</th>
           <td ><fmt:formatDate value="${bean.firstrecruitdate}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">修业年限（年）：</th>
           <td>${bean.studyduration}</td>
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
