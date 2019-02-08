<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:29:01
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/student/studAssociation/save.action" method="post">
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
       	   <th width="120">社团唯一标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写社团唯一标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">社团代码：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="communitycode" name="bean.communitycode"  value="${bean.communitycode}"  /></td>
        </tr>
       <tr>
       	   <th width="120">社团名称(全称)	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="communityname" name="bean.communityname"  value="${bean.communityname}"  /></td>
        </tr>
       <tr>
       	   <th width="120">社团类别：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="communitytype" name="bean.communitytype"  value="${bean.communitytype}"  /></td>
        </tr>
       <tr>
       	   <th width="120">登记情况<-->登记日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="registrationdate" name="bean.registrationdate"  value="${bean.registrationdate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">登记情况<-->批准单位（部门）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="approvalunit" name="bean.approvalunit"  value="${bean.approvalunit}"  /></td>
        </tr>
       <tr>
       	   <th width="120">注册单位：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="registrationunit" name="bean.registrationunit"  value="${bean.registrationunit}"  /></td>
        </tr>
       <tr>
       	   <th width="120">现有成员（人）：</th>
          <td>
           <input type="text" class="inputText" id="membercount"  maxlength="9"  name="bean.membercount"  value="${bean.membercount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">负责人情况<-->姓名：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="headname" name="bean.headname"  value="${bean.headname}"  /></td>
        </tr>
       <tr>
       	   <th width="120">负责人情况<-->所在年级：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="headingrade" name="bean.headingrade"  value="${bean.headingrade}"  /></td>
        </tr>
       <tr>
       	   <th width="120">负责人情况<-->单位职务：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="headduty" name="bean.headduty"  value="${bean.headduty}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否设有学分（学时）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="iscredit" name="bean.iscredit"  value="${bean.iscredit}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学校指导部门	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="guidancedepartment" name="bean.guidancedepartment"  value="${bean.guidancedepartment}"  /></td>
        </tr>
       <tr>
       	   <th width="120">指导教师名单	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="guidanceteacher" name="bean.guidanceteacher"  value="${bean.guidanceteacher}"  /></td>
        </tr>
       <tr>
       	   <th width="120">主要活动内容：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="activitycontent" name="bean.activitycontent"  value="${bean.activitycontent}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学校分管部门：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="management" name="bean.management"  value="${bean.management}"  /></td>
        </tr>
       <tr>
       	   <th width="120">活动经费（元）：</th>
          <td>
           <input type="text" class="inputText" id="activityfund"  maxlength="9"  name="bean.activityfund"  value="${bean.activityfund}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">是否有获奖项目：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isaward" name="bean.isaward"  value="${bean.isaward}"  /></td>
        </tr>
       <tr>
       	   <th width="120">来源	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="source" name="bean.source"  value="${bean.source}"  /></td>
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
