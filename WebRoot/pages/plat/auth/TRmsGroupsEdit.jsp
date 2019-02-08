<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-17 23:51:48
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		var dlg ;
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsGroups!listTree.action";
			if('select' === opCode){
				if(dlg && dlg.closed == false){
					dlg.show();
				}else{
				dlg =	$.dialog({
				id : 'depart',
				lock: true, 
				max: false, 
    			min: false ,
				title:'选择用户组',
				width:'360px',
				height:'460px',
				content: 'url:'+baseUrl});
				}
			}else if('delete' === opCode){
				
			}else if('clear' === opCode){
						$("#fyhzid").val('');
						$("#fyhzmc").val('');
			}
		}
		
		function changeStatus(obj){
			if(obj.value == '2'){
			 opreate('','clear');
			 $("#selectTree").attr("disabled",true);
			}else{
				$("#selectTree").attr("disabled",false);
			}
		}
		
		function initNode(node){
			if(node){
						$("#fyhzid").val(node.YHZID);
						$("#fyhzmc").val(node.YHZMC);
			}
		}
//-->
</script>
<body>
<s:form action="tRmsGroups!save" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<s:hidden name="bean.yhzid" id="yhzid"></s:hidden>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
  <div class="editBlock"  style="width: 100%;margin: 0;padding: 0;">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
       <tbody>
        <tr>
       	   <th width="120">用户组类型：</th>
           <td>
           <c:if test="${not empty bean.yhzid}">
           	<c:set var="attr" value="disabled='disabled'"></c:set>
           </c:if>
           <select name="bean.yhzlx" ${attr }  id="yhzlx" class="select2" onchange="changeStatus(this);">
           	<option value="">--请选择--</option>
           	<x:cache subject="YHZLX" option="true" selected="${bean.yhzlx}"></x:cache>
           </select>
           <em  class="valid" title="组名称为必须输入项，控制为4到12个字符。" for="yhzlx" lang="n"></em>
           </td>
        </tr>
         <tr>
       	   <th width="120"><span class="warning">*</span>组名称：</th>
           <td>
           <s:textfield  name="bean.yhzmc" cssClass="inputText" id="yhzmc"/>
            <em  class="valid" title="组名称为必须输入项，控制为4到12个字符。" lang="s4-12"></em>
           </td>
        </tr>
         <tr>
       	   <th width="120">上一级组：</th>
           <td>
          	 <s:hidden name="bean.fyhzid" id="fyhzid"></s:hidden>
           <input  name="fyhzmc" id="fyhzmc" value="${pgroup.yhzmc }" readonly="readonly" class="inputText">
           <input type="button" class="ibtn" value=" 选 择 " onclick="opreate('','select')" name="" id="selectTree" >
           <input type="button" class="ibtn" value=" 清 空 " onclick="opreate('','clear')" name="" id="">
           </td>
        </tr>
      
       <tr>
       	   <th width="120">排序号：</th>
           <td>
           <s:textfield  name="bean.pxh" cssClass="inputText" id="pxh"/>
           <em  class="valid" title="排序号输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">是否有效：</th>
            <td>
           <x:cache subject="OPTION01" var="list" scope="requestScope"/>
           <s:radio list="#request.list" name="bean.sfyx" id="sfyx" listKey="subcode" listValue="cname" ></s:radio>
           	 <em  class="valid" title="是否有效是必须录入项" lang="*" for="sfyx1"></em>
           </td>
        </tr>
         <tr>
          <th width="120">用户组描述：</th>
          <td><div class="smsEdit" style="width:380px;"></div>
          <s:textarea name="bean.yhzms" cssClass="textinput2" id="bmms"></s:textarea>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
         <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      </tr>
    </table>
</div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
