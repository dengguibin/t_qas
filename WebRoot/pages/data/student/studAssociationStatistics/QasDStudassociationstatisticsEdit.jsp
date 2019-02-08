<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:30:46
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/student/studAssociationStatistics/save.action" method="post">
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
      <%--  <tr>
       	   <th width="120">记录标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写记录标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">社团：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="communityid" name="bean.communityid"  value="${bean.communityid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">举办活动次数：</th>
          <td>
           <input type="text" class="inputText" id="activitycount"  maxlength="9"  name="bean.activitycount"  value="${bean.activitycount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">参与活动总人数：</th>
          <td>
           <input type="text" class="inputText" id="participantinactivity"  maxlength="9"  name="bean.participantinactivity"  value="${bean.participantinactivity}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">会员数量（人）<-->总数	：</th>
          <td>
           <input type="text" class="inputText" id="membertotal"  maxlength="9"  name="bean.membertotal"  value="${bean.membertotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">会员数量（人）<-->教工数：</th>
          <td>
           <input type="text" class="inputText" id="employeemembernum"  maxlength="9"  name="bean.employeemembernum"  value="${bean.employeemembernum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">会员数量（人）<-->学生数：</th>
          <td>
           <input type="text" class="inputText" id="studentmembernum"  maxlength="9"  name="bean.studentmembernum"  value="${bean.studentmembernum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">会费情况（元）<-->总数：</th>
          <td>
           <input type="text" class="inputText" id="duenum"  maxlength="9"  name="bean.duenum"  value="${bean.duenum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">会费情况（元）<-->总数：</th>
          <td>
           <input type="text" class="inputText" id="handinnum"  maxlength="9"  name="bean.handinnum"  value="${bean.handinnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">会费情况（元）<-->留存自用：</th>
          <td>
           <input type="text" class="inputText" id="remainnum"  maxlength="9"  name="bean.remainnum"  value="${bean.remainnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">活动经费来源（元）<-->总数：</th>
          <td>
           <input type="text" class="inputText" id="activityfund"  maxlength="9"  name="bean.activityfund"  value="${bean.activityfund}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">活动经费来源（元）<-->会费：</th>
          <td>
           <input type="text" class="inputText" id="activitydue"  maxlength="9"  name="bean.activitydue"  value="${bean.activitydue}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">活动经费来源（元）<-->学校拨款：</th>
          <td>
           <input type="text" class="inputText" id="activityfundfromschool"  maxlength="9"  name="bean.activityfundfromschool"  value="${bean.activityfundfromschool}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">活动经费来源（元）<-->留存自用的捐款：</th>
          <td>
           <input type="text" class="inputText" id="activityremain"  maxlength="9"  name="bean.activityremain"  value="${bean.activityremain}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">活动经费来源（元）<-->其他：</th>
          <td>
           <input type="text" class="inputText" id="activityothers"  maxlength="9"  name="bean.activityothers"  value="${bean.activityothers}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">捐赠情况（元）<-->总数：</th>
          <td>
           <input type="text" class="inputText" id="donationtotal"  maxlength="9"  name="bean.donationtotal"  value="${bean.donationtotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">捐赠情况（元）<-->上交业务主管单位	：</th>
          <td>
           <input type="text" class="inputText" id="donationhandin"  maxlength="9"  name="bean.donationhandin"  value="${bean.donationhandin}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">捐赠情况（元）<-->留存自用主要活动内容：</th>
          <td>
           <input type="text" class="inputText" id="donationremain"  maxlength="9"  name="bean.donationremain"  value="${bean.donationremain}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">培训情况<-->总数（人次）：</th>
          <td>
           <input type="text" class="inputText" id="trainingtotal"  maxlength="9"  name="bean.trainingtotal"  value="${bean.trainingtotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">培训情况<-->获得证书数（本）：</th>
          <td>
           <input type="text" class="inputText" id="trainingcertcount"  maxlength="9"  name="bean.trainingcertcount"  value="${bean.trainingcertcount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">造血干细胞（人次）<-->采集数：</th>
          <td>
           <input type="text" class="inputText" id="hematopoieticstemcellcount"  maxlength="9"  name="bean.hematopoieticstemcellcount"  value="${bean.hematopoieticstemcellcount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">造血干细胞（人次）<-->配对数	：</th>
          <td>
           <input type="text" class="inputText" id="hematopoieticstemcellpair"  maxlength="9"  name="bean.hematopoieticstemcellpair"  value="${bean.hematopoieticstemcellpair}"  />
           </td>
        </tr>
       <%-- <tr>
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
