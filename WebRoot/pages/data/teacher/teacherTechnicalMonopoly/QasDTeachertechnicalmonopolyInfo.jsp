<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 12:32:42
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
    	   <th width="120">教工名称：</th>
           <td>${bean.employeeid}</td>
        </tr>
       <tr>
    	   <th width="120">专利类别：</th>
           <td>${bean.technicalmonopolytype}</td>
        </tr>
       <tr>
    	   <th width="120">获得日期（年月）：</th>
           <td>${bean.technicalmonopolyreceivedate}</td>
        </tr>
       <tr>
    	   <th width="120">技术专利（发明）名称(全称)：</th>
           <td>${bean.technicalmonopolyname}</td>
        </tr>
       <tr>
    	   <th width="120">技术专利（发明）编号：</th>
           <td>${bean.technicalmonopolycode}</td>
        </tr>
       <tr>
    	   <th width="120">是否主持：</th>
           <td>${bean.technicalmonopolyishost}</td>
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
