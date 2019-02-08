<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 12:33:16
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
    	   <th width="120">课题性质：</th>
           <td>${bean.researchnature}</td>
        </tr>
       <tr>
    	   <th width="120">课题分类：</th>
           <td>${bean.researchtype}</td>
        </tr>
       <tr>
    	   <th width="120">课题名称：</th>
           <td>${bean.researchname}</td>
        </tr>
       <tr>
    	   <th width="120">是否横向课题：</th>
           <td>${bean.researchishorizontalissue}</td>
        </tr>
       <tr>
    	   <th width="120">课题级别：</th>
           <td>${bean.researchlevel}</td>
        </tr>
       <tr>
    	   <th width="120">立项日期（年月）：</th>
           <td>${bean.researchestablishdate}</td>
        </tr>
       <tr>
    	   <th width="120">经费来源：</th>
           <td>${bean.researchfund}</td>
        </tr>
       <tr>
    	   <th width="120">到款金额（元）：</th>
           <td>${bean.researchamountreceived}</td>
        </tr>
       <tr>
    	   <th width="120">完成人顺序：</th>
           <td>${bean.researchcompleteorder}</td>
        </tr>
       <tr>
    	   <th width="120">课题来源：</th>
           <td>${bean.researchsource}</td>
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
