<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 12:51:07
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
var vForm;
		function  operate(){
			$("#opDynaForm").submit()
		}
		
		
$(function(){
vForm = $("#opDynaForm").Validform({
		tiptype:function(msg){
		alert(msg);
	},tipSweep:true,
	callback:function(data){
		var baseUrl = "${ctx}/plat/common/tCommonConfig";
		baseUrl += "!sendMsg.action?v="+Math.random();
		var datas = {};
		datas['bean.code'] = $("#code").val();
		datas['title'] = $("#title").val();
		datas['contents'] = $("#contents").val();
		datas['receivers'] = $("#receivers").val()+"";
		//转义
		datas['receivers'] = datas['receivers'].replace(",",";");
		$.ajax({
			 url:baseUrl
			,data :datas
			,datatype:'json'
			,type : 'post'
			,success :function(data){
				if (data && data.status == '1') {
					alert("发送成功");
				}else{
					alert("发送失败");
				}
			}
		});
		return false;
	}
	});

$('#receivers').select2({
	  tags: false
});



});
		
//-->
</script>
<body  class="popup">
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
<s:form action="tCommonConfig!sendMail" namespace="/plat/common" method="post" 
id="opDynaForm" name="opDynaForm">
<s:token></s:token>
<s:hidden name="bean.code" id="code"/>
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >系统消息内容：</td>
      </tr>
       <tbody>
       
       <tr>
       	   <th width="220"><span class="warning">*</span>标题：</th>
           <td>
           <s:textfield  name="title" cssStyle="width:90%;" cssClass="inputText" value="测试系统消息标题" id="title"/>
           </td>
        </tr>
       <tr>
       	   <th width="220"><span class="warning">*</span>收件人：</th>
           <td>
           <select  id="receivers" name="receivers" style="width:90%;" multiple="multiple"  datatype="*" nullmsg="请填收件人">
           		<option value="">--请选择--</option>
           		<x:cache subject="USERS" option="true"></x:cache>
           </select>
        </td>
        </tr>
       <tr>
       	   <th width="220">内容：</th>
       	   <td><div class="smsEdit" style="width:380px;"></div>
          <s:textarea name="contents" cssClass="textinput2"  id="contents" value="测试系统消息内容，你好。"></s:textarea>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar" >
        <input type="button" class="inputButton" onclick="operate();" value=" 发送" />
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
</div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
