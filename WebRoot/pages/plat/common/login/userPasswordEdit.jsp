<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-28 22:24:28
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
function nextCode(){
	var url = "${ctx }/auth/code.action?type=code&v="+Math.random();
	$("#imgCode").attr("src",url);
}

function logout(){
	var result = window.confirm("确定要退出系统吗？");
	var url = "${ctx}/auth/logout.action?v="+Math.random();
		if(result){
			window.location.href = url;
		}
}
//-->
</script>
<body>
<c:if test="${not empty menuId }">
<div class="title"><span>当前位置：</span><x:menu menuId="${menuId}"/></div>
</c:if>

<form action="${ctx }/org/auth/savePassword.action"  method="post" id="opForm" name="opForm">
<s:token></s:token>
<s:hidden name="initStatus" id="initStatus"/>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
  	<div class="formtitle"><span>修改个人密码</span></div>
  	<s:fielderror/>
    <table>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>现在的密码：</th>
           <td><input type="password" name="password" class="inputText"  datatype="*" nullmsg="请设置新的密码！"></td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>设置新的密码：</th>
           <td>
           <input type="password" name="newPassword" id="userpassword" class="inputText"  datatype="*6-16" nullmsg="请设置新的密码！" errormsg="新的密码范围在6~16位之间！">
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>重复新的密码：</th>
           <td>
           	<input type="password" name="newPassword" class="inputText"  datatype="*" recheck="newPassword" nullmsg="请重复新的密码！" errormsg="您两次输入的账号密码不一致！" >
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>验证码：</th>
           <td>
           <input class="inputText" name="code" style="display: block;" datatype="s4-4" errormsg="验证码不能为空，并且长度为必须为4位">
           <img alt="" id="imgCode" style="width: 108px;height: 36px;display: inline-block;" src="${ctx }/auth/code.action?v=t"><span class="note">不区分大小写</span>
           <a href="javascript:void(0);" onclick="nextCode()" class="tablelink">换一张</a>
           <br>
           </td>
        </tr>
       </tbody>
    </table>
    <br>
    <ul class="forminfo">
    <li><label style="width: 120px;">&nbsp;</label><input type="button" class="btn" onclick="$('#opForm').submit();" value="修改密码 " /> 
    	<c:if test="${not empty initStatus }"><input type="button"  class="cancel" value=" 退出系统 " onclick="logout()"/></c:if>
    </li>
    </ul>
    
      <div class="info" >
         欢迎使用系统，为了您的信息的<span class="red">&nbsp;安全&nbsp;</span>，系统要求您第一次使用时重新修改你的密码.<br />
	如果你的密码被管理员重置，我们也需要进行初始密码的修改。<br />
	</div>   
    
    </div> 
    
  
    
   </div>
</div>
</form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
