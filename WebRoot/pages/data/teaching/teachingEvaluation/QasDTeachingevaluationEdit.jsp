<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 12:17:59
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/teaching/teachingEvaluation/save.action" method="post">
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
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">评教起始日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="teachingevaluationstarttime" name="bean.teachingevaluationstarttime"  value="${bean.teachingevaluationstarttime}"  /></td>
        </tr>
       <tr>
       	   <th width="120">评教终止日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="teachingevaluationendtime" name="bean.teachingevaluationendtime"  value="${bean.teachingevaluationendtime}"  /></td>
        </tr>
       <tr>
       	   <th width="120">评教客体（教师）<-->评教客体（教师）<-->参与数（人）：</th>
          <td>
           <input type="text" class="inputText" id="numofparticipantteacher"  maxlength="9"  name="bean.numofparticipantteacher"  value="${bean.numofparticipantteacher}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教客体（教师）<-->评教客体（教师）<-->总数（人）：</th>
          <td>
           <input type="text" class="inputText" id="totalnumofteacher"  maxlength="9"  name="bean.totalnumofteacher"  value="${bean.totalnumofteacher}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教主体参与度<-->学生<-->参与数（人）：</th>
          <td>
           <input type="text" class="inputText" id="numofstudent"  maxlength="9"  name="bean.numofstudent"  value="${bean.numofstudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教主体参与度<-->学生<-->总数（人）：</th>
          <td>
           <input type="text" class="inputText" id="totalnumofstudent"  maxlength="9"  name="bean.totalnumofstudent"  value="${bean.totalnumofstudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教主体参与度<-->同行<-->参与数（人）：</th>
          <td>
           <input type="text" class="inputText" id="numofparticipantschoolmate"  maxlength="9"  name="bean.numofparticipantschoolmate"  value="${bean.numofparticipantschoolmate}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教主体参与度<-->同行<-->总数（人）：</th>
          <td>
           <input type="text" class="inputText" id="totalnumofschoolmate"  maxlength="9"  name="bean.totalnumofschoolmate"  value="${bean.totalnumofschoolmate}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教主体参与度<-->校领导<-->参与数（人）：</th>
          <td>
           <input type="text" class="inputText" id="numofparticipantleader"  maxlength="9"  name="bean.numofparticipantleader"  value="${bean.numofparticipantleader}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教主体参与度<-->校领导<-->总数（人）：</th>
          <td>
           <input type="text" class="inputText" id="totalnumofleader"  maxlength="9"  name="bean.totalnumofleader"  value="${bean.totalnumofleader}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教主体参与度<-->社会<-->参与数（人）：</th>
          <td>
           <input type="text" class="inputText" id="numofparticipantsociety"  maxlength="9"  name="bean.numofparticipantsociety"  value="${bean.numofparticipantsociety}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">评教主体参与度<-->社会<-->总数（人）：</th>
          <td>
           <input type="text" class="inputText" id="totalnumofsociety"  maxlength="9"  name="bean.totalnumofsociety"  value="${bean.totalnumofsociety}"  />
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
        </tr>
	    --%>
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
