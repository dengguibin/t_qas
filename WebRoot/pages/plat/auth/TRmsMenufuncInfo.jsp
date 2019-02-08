<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-5-20 15:03:20
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
    	   <th width="120">功能ID：</th>
           <td>${bean.funcid}</td>
        </tr>
       <tr>
    	   <th width="120">菜单ID：</th>
           <td>${bean.cdid}</td>
        </tr>
       <tr>
    	   <th width="120">功能名称：</th>
           <td>${bean.name}</td>
        </tr>
       <tr>
    	   <th width="120">权限码：</th>
           <td>${bean.code}</td>
        </tr>
       <tr>
    	   <th width="120">权限名称：</th>
           <td>${bean.fcname}</td>
        </tr>
       <tr>
    	   <th width="120">功能连接地址：</th>
           <td>${bean.url}</td>
        </tr>
       <tr>
    	   <th width="120">功能类型：</th>
           <td>${bean.lx}</td>
        </tr>
       <tr>
    	   <th width="120">功能描述：</th>
           <td>${bean.descrip}</td>
        </tr>
       <tr>
    	   <th width="120">备注：</th>
           <td>${bean.marks}</td>
        </tr>
       <tr>
       	   <th width="120">创建时间：</th>
           <td ><fmt:formatDate value="${bean.cjsj}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">创建人：</th>
           <td>${bean.cjr}</td>
        </tr>
       <tr>
       	   <th width="120">修改时间：</th>
           <td ><fmt:formatDate value="${bean.xgsj}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">修改人：</th>
           <td>${bean.xgr}</td>
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
