<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-30 17:54:20
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
    	   <th width="120">：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">父机构ID：</th>
           <td>${bean.parentid}</td>
        </tr>
       <tr>
    	   <th width="120">类型ID,来自数据库：</th>
           <td>${bean.typeid}</td>
        </tr>
       <tr>
    	   <th width="120">机构号：</th>
           <td>${bean.orgcode}</td>
        </tr>
       <tr>
    	   <th width="120">机构名称：</th>
           <td>${bean.orgname}</td>
        </tr>
       <tr>
    	   <th width="120">简称：</th>
           <td>${bean.abbreviation}</td>
        </tr>
       <tr>
    	   <th width="120">简拼：</th>
           <td>${bean.jianpin}</td>
        </tr>
       <tr>
    	   <th width="120">机构地址：</th>
           <td>${bean.address}</td>
        </tr>
       <tr>
    	   <th width="120">排序：</th>
           <td>${bean.sort}</td>
        </tr>
       <tr>
    	   <th width="120">是否是实体：</th>
           <td>${bean.isphysical}</td>
        </tr>
       <tr>
    	   <th width="120">层级：</th>
           <td>${bean.layer}</td>
        </tr>
       <tr>
    	   <th width="120">备注：</th>
           <td>${bean.remark}</td>
        </tr>
       <tr>
    	   <th width="120">组织状态：</th>
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
					<td colspan="2" class="toolbar">
						<input type="button" id="returnButton" class="cancel" value=" 返 回 " /></td>
				</tr>
       </tbody>
    </table>
 </div>   <!--editBlock END-->
  </form>
</body> 
<%@include file="/pages/t_qas/layout/footer.jsp" %>
