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
<form action="" id="opForm">
<s:hidden name="menuId" id="menuId"/>
	<div class="formtitle"><span>调度日志信息查看</span></div>
		<table>
			<tr>
				<td colspan="2" class="subtitle">调度日志信息</td>
			</tr>
       <tbody>
       <tr>
    	   <th width="120">任务名称：</th>
           <td>${bean.taskname}</td>
        </tr>
       <tr>
    	   <th width="120">运行状态：</th>
           <td><x:cache subject="RUN_STATE" option="false" key="${bean.states}"></x:cache></td>
        </tr>
       <tr>
    	   <th width="120">运行日志：</th>
           <td class="wrap" >
           	 ${bean.marks}
           </td>
        </tr>
       <tr>
    	   <th width="120">工作计算机：</th>
           <td>${bean.worker}</td>
        </tr>
       <tr>
    	   <th width="120">计算机IP：</th>
           <td>${bean.workip}</td>
        </tr>
       <tr>
    	   <th width="120">计算机MAC：</th>
           <td>${bean.mac}</td>
        </tr>
       <tr>
    	   <th width="120">备注说明：</th>
           <td>${bean.des}</td>
        </tr>
       <tr>
       	   <th width="120">运行时间：</th>
           <td ><fmt:formatDate value="${bean.rundate}" pattern="yyyy-MM-dd"/></td>
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
