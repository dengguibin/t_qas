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
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/school/practiceBaseInCampusStatistics/save.action" method="post">
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
       <%-- <tr>
       	   <th width="120">记录标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写记录标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">校内实践基地：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="practicebaseincampusid" name="bean.practicebaseincampusid"  value="${bean.practicebaseincampusid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">面向专业：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="majorid" name="bean.majorid"  value="${bean.majorid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学年内基地使用时间：</th>
          <td>
           <input type="text" class="inputText" id="averagetimeperyear"  maxlength="9"  name="bean.averagetimeperyear"  value="${bean.averagetimeperyear}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">设备值（万元）<-->设备总值：</th>
          <td>
           <input type="text" class="inputText" id="equipmentvalue"  maxlength="9"  name="bean.equipmentvalue"  value="${bean.equipmentvalue}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">设备值（万元）<-->当年新增设备值：</th>
          <td>
           <input type="text" class="inputText" id="newequipmentvalue"  maxlength="9"  name="bean.newequipmentvalue"  value="${bean.newequipmentvalue}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">当年设备来源(万元）<-->自主研制设备值：</th>
          <td>
           <input type="text" class="inputText" id="selfdevelopedequvalue"  maxlength="9"  name="bean.selfdevelopedequvalue"  value="${bean.selfdevelopedequvalue}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">当年设备来源(万元）<-->社会捐赠设备值：</th>
          <td>
           <input type="text" class="inputText" id="societydevelopedequvalue"  maxlength="9"  name="bean.societydevelopedequvalue"  value="${bean.societydevelopedequvalue}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">当年设备来源(万元）<-->社会准捐赠设备值：</th>
          <td>
           <input type="text" class="inputText" id="socialdonationequvalue"  maxlength="9"  name="bean.socialdonationequvalue"  value="${bean.socialdonationequvalue}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">设备数（台套）<-->设备总数：</th>
          <td>
           <input type="text" class="inputText" id="equimentcount"  maxlength="9"  name="bean.equimentcount"  value="${bean.equimentcount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">设备数（台套）<-->大型设备数：</th>
          <td>
           <input type="text" class="inputText" id="largeequimentcount"  maxlength="9"  name="bean.largeequimentcount"  value="${bean.largeequimentcount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">项目个数	：</th>
          <td>
           <input type="text" class="inputText" id="numoftrainingproject"  maxlength="9"  name="bean.numoftrainingproject"  value="${bean.numoftrainingproject}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">实训项目名称：</th>
          <td>
           <input type="text" class="inputText" id="numofprojectname"  maxlength="9"  name="bean.numofprojectname"  value="${bean.numofprojectname}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学年使用频率（人时）<-->校内：</th>
          <td>
           <input type="text" class="inputText" id="frequencyofcampus"  maxlength="9"  name="bean.frequencyofcampus"  value="${bean.frequencyofcampus}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学年使用频率（人时）<-->社会：</th>
          <td>
           <input type="text" class="inputText" id="frequencyofsociology"  maxlength="9"  name="bean.frequencyofsociology"  value="${bean.frequencyofsociology}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">工位数(个)：</th>
          <td>
           <input type="text" class="inputText" id="numofworker"  maxlength="9"  name="bean.numofworker"  value="${bean.numofworker}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">原材料(耗材)费用（万元）：</th>
          <td>
           <input type="text" class="inputText" id="costofconsumptive"  maxlength="9"  name="bean.costofconsumptive"  value="${bean.costofconsumptive}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">设备维护费用（万元）：</th>
          <td>
           <input type="text" class="inputText" id="costofmaterials"  maxlength="9"  name="bean.costofmaterials"  value="${bean.costofmaterials}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">专职管理人员（名）：</th>
          <td>
           <input type="text" class="inputText" id="fulltimemanagement"  maxlength="9"  name="bean.fulltimemanagement"  value="${bean.fulltimemanagement}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">兼职管理人员（名）：</th>
          <td>
           <input type="text" class="inputText" id="parttimemanagement"  maxlength="9"  name="bean.parttimemanagement"  value="${bean.parttimemanagement}"  />
           </td>
        </tr>
     <%--   <tr>
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
