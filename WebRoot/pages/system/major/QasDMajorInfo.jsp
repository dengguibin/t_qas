<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-30 10:54:53
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
    	   <th width="120">专业唯一标识：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">所属系部编号：</th>
           <td>${bean.organizationid}</td>
        </tr>
       <tr>
    	   <th width="120">专业代码：</th>
           <td>${bean.majorcode}</td>
        </tr>
       <tr>
    	   <th width="120">专业名称：</th>
           <td>${bean.majorname}</td>
        </tr>
       <tr>
    	   <th width="120">专业文理类别：</th>
           <td>${bean.divisiontype}</td>
        </tr>
       <tr>
    	   <th width="120">是否招生：</th>
           <td>${bean.isenroll}</td>
        </tr>
       <tr>
    	   <th width="120">新增年月：</th>
           <td>${bean.enrolldate}</td>
        </tr>
       <tr>
    	   <th width="120">停招年月：</th>
           <td>${bean.notenrolldate}</td>
        </tr>
       <tr>
    	   <th width="120">撤销年月：</th>
           <td>${bean.revokemajorcount}</td>
        </tr>
       <tr>
    	   <th width="120">状态：</th>
           <td>${bean.status}</td>
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
