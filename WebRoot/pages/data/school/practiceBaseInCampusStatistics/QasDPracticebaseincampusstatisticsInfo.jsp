<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:52:24
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
    	   <th width="120">记录标识：</th>
           <td>${bean.id}</td>
        </tr>
       <tr>
    	   <th width="120">校内实践基地：</th>
           <td>${bean.practicebaseincampusid}</td>
        </tr>
       <tr>
    	   <th width="120">面向专业：</th>
           <td>${bean.majorid}</td>
        </tr>
       <tr>
    	   <th width="120">学年内基地使用时间：</th>
           <td>${bean.averagetimeperyear}</td>
        </tr>
       <tr>
    	   <th width="120">设备值（万元）<-->设备总值：</th>
           <td>${bean.equipmentvalue}</td>
        </tr>
       <tr>
    	   <th width="120">设备值（万元）<-->当年新增设备值：</th>
           <td>${bean.newequipmentvalue}</td>
        </tr>
       <tr>
    	   <th width="120">当年设备来源(万元）<-->自主研制设备值：</th>
           <td>${bean.selfdevelopedequvalue}</td>
        </tr>
       <tr>
    	   <th width="120">当年设备来源(万元）<-->社会捐赠设备值：</th>
           <td>${bean.societydevelopedequvalue}</td>
        </tr>
       <tr>
    	   <th width="120">当年设备来源(万元）<-->社会准捐赠设备值：</th>
           <td>${bean.socialdonationequvalue}</td>
        </tr>
       <tr>
    	   <th width="120">设备数（台套）<-->设备总数：</th>
           <td>${bean.equimentcount}</td>
        </tr>
       <tr>
    	   <th width="120">设备数（台套）<-->大型设备数：</th>
           <td>${bean.largeequimentcount}</td>
        </tr>
       <tr>
    	   <th width="120">项目个数	：</th>
           <td>${bean.numoftrainingproject}</td>
        </tr>
       <tr>
    	   <th width="120">实训项目名称：</th>
           <td>${bean.numofprojectname}</td>
        </tr>
       <tr>
    	   <th width="120">学年使用频率（人时）<-->校内：</th>
           <td>${bean.frequencyofcampus}</td>
        </tr>
       <tr>
    	   <th width="120">学年使用频率（人时）<-->社会：</th>
           <td>${bean.frequencyofsociology}</td>
        </tr>
       <tr>
    	   <th width="120">工位数(个)：</th>
           <td>${bean.numofworker}</td>
        </tr>
       <tr>
    	   <th width="120">原材料(耗材)费用（万元）：</th>
           <td>${bean.costofconsumptive}</td>
        </tr>
       <tr>
    	   <th width="120">设备维护费用（万元）：</th>
           <td>${bean.costofmaterials}</td>
        </tr>
       <tr>
    	   <th width="120">专职管理人员（名）：</th>
           <td>${bean.fulltimemanagement}</td>
        </tr>
       <tr>
    	   <th width="120">兼职管理人员（名）：</th>
           <td>${bean.parttimemanagement}</td>
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
