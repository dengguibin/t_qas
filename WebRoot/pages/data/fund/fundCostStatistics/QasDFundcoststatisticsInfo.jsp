<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 12:16:28
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
    	   <th width="120">学校总支出（万元）：</th>
           <td>${bean.schoolexpenditure}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->征地（万元）：</th>
           <td>${bean.landrequisition}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->基础设施建设（万元）：</th>
           <td>${bean.infrastructureconstruction}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->设备采购（万元）<-->合计：</th>
           <td>${bean.equipmentprocurementtotal}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->日常教学经费（万元）<-->合计：</th>
           <td>${bean.teachingfundtotal}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->日常教学经费（万元）<-->实(验)训耗材：</th>
           <td>${bean.trainingequipment}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->日常教学经费（万元）<-->实习专项：</th>
           <td>${bean.pacticefee}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->日常教学经费（万元）<-->聘请兼职教师经费：</th>
           <td>${bean.hireteacherfee}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->日常教学经费（万元）<-->体育维持费：</th>
           <td>${bean.sportsfee}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->日常教学经费（万元）<-->其他：</th>
           <td>${bean.othersfee}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->教学改革及研究<-->合计（万元）：</th>
           <td>${bean.teachingresearchtotal}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->师资建设<-->合计（万元）：</th>
           <td>${bean.teacherconstructiontotal}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->师资建设<-->教师培训专项经费：</th>
           <td>${bean.teachertrainingfee}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->图书购置费（万元）：</th>
           <td>${bean.bookacquisitionfee}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->其他支出总额（万元）：</th>
           <td>${bean.others}</td>
        </tr>
       <tr>
    	   <th width="120">还贷金额（万元）：</th>
           <td>${bean.amountofrepayment}</td>
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
