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
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/fund/fundCostStatistics/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.id" id="id"/>
			<s:hidden name="bean.status" id="status"/>
			<s:hidden name="bean.createdby" id="createdby"/>
			<s:hidden name="bean.createdtime" id="createdtime"/>
			<s:hidden name="bean.updatedby" id="updatedby"/>
			<s:hidden name="bean.updatedtime" id="updatedtime"/>
			<s:hidden name="bean.tenantid" id="tenantid"/>
			<s:hidden name="bean.storagetime" id="storagetime"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
     <%--   <tr>
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">学校总支出（万元）：</th>
          <td>
           <input type="text" class="inputText" id="schoolexpenditure"  maxlength="9"  name="bean.schoolexpenditure"  value="${bean.schoolexpenditure}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->征地（万元）：</th>
          <td>
           <input type="text" class="inputText" id="landrequisition"  maxlength="9"  name="bean.landrequisition"  value="${bean.landrequisition}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->基础设施建设（万元）：</th>
          <td>
           <input type="text" class="inputText" id="infrastructureconstruction"  maxlength="9"  name="bean.infrastructureconstruction"  value="${bean.infrastructureconstruction}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->设备采购（万元）<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="equipmentprocurementtotal"  maxlength="9"  name="bean.equipmentprocurementtotal"  value="${bean.equipmentprocurementtotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->日常教学经费（万元）<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="teachingfundtotal"  maxlength="9"  name="bean.teachingfundtotal"  value="${bean.teachingfundtotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->日常教学经费（万元）<-->实(验)训耗材：</th>
          <td>
           <input type="text" class="inputText" id="trainingequipment"  maxlength="9"  name="bean.trainingequipment"  value="${bean.trainingequipment}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->日常教学经费（万元）<-->实习专项：</th>
          <td>
           <input type="text" class="inputText" id="pacticefee"  maxlength="9"  name="bean.pacticefee"  value="${bean.pacticefee}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->日常教学经费（万元）<-->聘请兼职教师经费：</th>
          <td>
           <input type="text" class="inputText" id="hireteacherfee"  maxlength="9"  name="bean.hireteacherfee"  value="${bean.hireteacherfee}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->日常教学经费（万元）<-->体育维持费：</th>
          <td>
           <input type="text" class="inputText" id="sportsfee"  maxlength="9"  name="bean.sportsfee"  value="${bean.sportsfee}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->日常教学经费（万元）<-->其他：</th>
          <td>
           <input type="text" class="inputText" id="othersfee"  maxlength="9"  name="bean.othersfee"  value="${bean.othersfee}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->教学改革及研究<-->合计（万元）：</th>
          <td>
           <input type="text" class="inputText" id="teachingresearchtotal"  maxlength="9"  name="bean.teachingresearchtotal"  value="${bean.teachingresearchtotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->师资建设<-->合计（万元）：</th>
          <td>
           <input type="text" class="inputText" id="teacherconstructiontotal"  maxlength="9"  name="bean.teacherconstructiontotal"  value="${bean.teacherconstructiontotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->师资建设<-->教师培训专项经费：</th>
          <td>
           <input type="text" class="inputText" id="teachertrainingfee"  maxlength="9"  name="bean.teachertrainingfee"  value="${bean.teachertrainingfee}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->图书购置费（万元）：</th>
          <td>
           <input type="text" class="inputText" id="bookacquisitionfee"  maxlength="9"  name="bean.bookacquisitionfee"  value="${bean.bookacquisitionfee}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->其他支出总额（万元）：</th>
          <td>
           <input type="text" class="inputText" id="others"  maxlength="9"  name="bean.others"  value="${bean.others}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">还贷金额（万元）：</th>
          <td>
           <input type="text" class="inputText" id="amountofrepayment"  maxlength="9"  name="bean.amountofrepayment"  value="${bean.amountofrepayment}"  />
           </td>
        </tr>
      <%--  <tr>
       	   <th width="120">状态：</th>
          <td>
           <input type="text" class="inputText" id="status"  maxlength="9"  name="bean.status"  value="${bean.status}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">创建人：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="createdby" name="bean.createdby"  value="${bean.createdby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">创建时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="createdtime" name="bean.createdtime"  value="${createdtime}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">修改人：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="updatedby" name="bean.updatedby"  value="${bean.updatedby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">修改时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="updatedtime" name="bean.updatedtime"  value="${updatedtime}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">租户：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="tenantid" name="bean.tenantid"  value="${bean.tenantid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">入库时间（接口传输，导入）：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="storagetime" name="bean.storagetime"  value="${storagetime}" />
          </td>
        </tr> --%>
	   
	    <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
         <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      	</tr>
	   
       </tbody>
    </table>
         </form>
  </div><!--editblock end-->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
