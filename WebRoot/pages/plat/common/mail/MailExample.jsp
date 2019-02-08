<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 12:51:07
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
var vForm;
		function  operate(){
			$("#opDynaForm").submit()
		}
		
		
$(function(){
	$.extend($.Datatype,{
		"more-e" : function(gets,obj,curform,datatype){
			var e= /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			var result = false;
			if(gets != ''){
				var arr = gets.split(";");
				var matched = true;
				for(var i = 0 ; i < arr.length ; i++){
					if(e.test(arr[i]) == false){
						matched = false;
					}
				}
				result = matched;
			}
			return result;
		}
	});
	
	
vForm = $("#opDynaForm").Validform({
		tiptype:function(msg){
		alert(msg);
	},tipSweep:true,
	callback:function(data){
		var baseUrl = "${ctx}/plat/common/tCommonConfig";
		baseUrl += "!sendMail.action?v="+Math.random();
		var datas = {};
		datas['bean.code'] = $("#code").val();
		datas['title'] = $("#title").val();
		datas['contents'] = $("#contents").val();
		datas['receivers'] = $("#receivers").val();
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

});
		
//-->
</script>
<body class="popup">
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
<s:form action="tCommonConfig!sendMail" namespace="/plat/common" method="post" 
id="opDynaForm" name="opForm">
<s:token></s:token>
<s:hidden name="bean.code" id="code"/>
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >邮件内容：</td>
      </tr>
       <tbody>
       
       <tr>
       	   <th width="220"><span class="warning">*</span>主题：</th>
           <td>
           <s:textfield  name="title" cssStyle="width:90%;" cssClass="inputText" value="测试邮件请注意[勿回复]" id="title"/>
           </td>
        </tr>
       <tr>
       	   <th width="220"><span class="warning">*</span>收件人（多个以&nbsp;<font color="red">;</font>&nbsp;隔开）：</th>
           <td><s:textfield cssStyle="width:90%;"  name="receivers" cssClass="inputText" id="receivers"  datatype="more-e" nullmsg="请填收件人" errormsg="错误 的收件人邮箱"/></td>
        </tr>
       <tr>
       	   <th width="220">内容：</th>
       	   <td><div class="smsEdit" style="width:380px;"></div>
          <s:textarea name="contents" cssClass="textinput2"  id="contents" value="测试邮件请注意,请不要直接回复"  datatype="*" nullmsg="请填写内容"></s:textarea>
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
