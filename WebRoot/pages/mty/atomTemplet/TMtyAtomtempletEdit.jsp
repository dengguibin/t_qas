<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-10 12:04:39
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/mty/atomTemplet/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
       <tr>
       	   <th width="120">中间表主键：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写中间表主键"/></td>
        </tr>
       <tr>
       	   <th width="120">关联原子样式表的外键：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="atomid" name="bean.atomid"  value="${bean.atomid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">关联前端模板表的外键：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="templetid" name="bean.templetid"  value="${bean.templetid}"  /></td>
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
