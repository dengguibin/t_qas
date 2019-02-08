<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-7-9 19:13:31
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/quartz/logs/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.logid" id="bean.logid"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
       <tr>
       	   <th width="120">任务ID：</th>
           <td><input type="text" class="inputText"  maxlength="16"  id="taskid" name="bean.taskid"  value="${bean.taskid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">运行状态(0:失败，1：成功)：</th>
           <td><input type="text" class="inputText"  maxlength="25"  id="states" name="bean.states"  value="${bean.states}"  /></td>
        </tr>
       <tr>
          <th width="120">运行日志(失败的异常数据)：</th>
          <td>
                <textarea id="marks"  maxlength="32,767.5" name="bean.marks" class="textinput2" >${bean.marks}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">工作计算机：</th>
          <td>
                <textarea id="worker"  maxlength="125" name="bean.worker" class="textinput2" >${bean.worker}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">计算机IP：</th>
          <td>
                <textarea id="workip"  maxlength="125" name="bean.workip" class="textinput2" >${bean.workip}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">计算机MAC：</th>
          <td>
                <textarea id="mac"  maxlength="125" name="bean.mac" class="textinput2" >${bean.mac}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">备注说明：</th>
          <td>
                <textarea id="des"  maxlength="1,000" name="bean.des" class="textinput2" >${bean.des}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">运行时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="rundate" name="bean.rundate"  value="${rundate}" />
          </td>
        </tr>
	   
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
