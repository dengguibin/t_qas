<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:09:27
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
    	   <th width="120">序号：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">专业方向：</th>
           <td>${bean.directionid}</td>
        </tr>
       <tr>
    	   <th width="120">产学合作企业总数（个)：</th>
           <td>${bean.companies}</td>
        </tr>
       <tr>
    	   <th width="120">订单培养数（人）：</th>
           <td>${bean.ordercount}</td>
        </tr>
       <tr>
    	   <th width="120">共同开发课程数（门）：</th>
           <td>${bean.teachcourse}</td>
        </tr>
       <tr>
    	   <th width="120">共同开发教材数（种）：</th>
           <td>${bean.teachmaterial}</td>
        </tr>
       <tr>
    	   <th width="120">支持学校兼职教师数（人）：</th>
           <td>${bean.parttimetch}</td>
        </tr>
       <tr>
    	   <th width="120">接受顶岗实习学生数（人）：</th>
           <td>${bean.practicestud}</td>
        </tr>
       <tr>
    	   <th width="120">对学校捐赠设备总值（万元）：</th>
           <td>${bean.donatedevval}</td>
        </tr>
       <tr>
    	   <th width="120">对学校准捐赠设备总值（万元）：</th>
           <td>${bean.readydonateval}</td>
        </tr>
       <tr>
    	   <th width="120">接受毕业生就业数（人）：</th>
           <td>${bean.accesswork}</td>
        </tr>
       <tr>
    	   <th width="120">学校为企业技术服务年收入（万元）：</th>
           <td>${bean.servicevalue}</td>
        </tr>
       <tr>
    	   <th width="120">学校为企业年培训员工数（人天）：</th>
           <td>${bean.traincount}</td>
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
