<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-3 22:10:24
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		var dlg;
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsDeptment!listTree.action";
		}
		
		function checkUser(){
			
			if($("#yhid").val().length > 5){
				var baseUrl = "${ctx}/org/auth/queryUser.action?v="+Math.random();
				var datas = {};
				datas['bean.yhid'] = $("#yhid").val();
				$.getJSON(baseUrl,datas,function(data){
					if(data.status == '1'){
						$("#userMsg").addClass("note")
						$("#userMsg").html("帐号还未使用").fadeOut(100).fadeIn(100);
					}else{
						$("#userMsg").removeClass("note")
						$("#userMsg").html(data.message).fadeOut(500).fadeIn(500);
					}
					
				});
				
			}
			
		}
//-->
</script>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${menuId}"/></div>
<c:if test="${not empty bean.yhid }">
<c:set var="yhids" value=",${bean.yhid}," scope="request"/>
<x:query stmt="用户角色查询" var="queryRoles" paged="false"></x:query>
</c:if>
<s:form action="saveOrgUser" namespace="/org/auth" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<s:hidden name="bean.uid" id="uid"/>
<input type="hidden" name="menuId" value="${menuId}" id="menuId">
<div class="tabBlock" id="tabBlock">
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >基本信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>用户帐号：</th>
           <td>
           <c:choose>
           	<c:when test="${not empty bean.yhid}"><s:textfield  name="bean.yhid" cssClass="inputText" readonly="true"/></c:when>
           	<c:otherwise><s:textfield  name="bean.yhid" cssClass="inputText"  id="yhid" onchange="checkUser()"/></c:otherwise>
           </c:choose>
           <em  class="valid" title="用户帐号是必须录入项，长度控制在6-20字符" lang="s6-20"></em>
            &nbsp; &nbsp;<span class="red" id="userMsg"></span>
           </td>
        </tr>
        <tr>
       	   <th width="120"><span class="warning">*</span>用户名称：</th>
           <td>
           <s:textfield  name="bean.yhmc" cssClass="inputText" id="yhmc"/>
            <em  class="valid" title="用户名称是必须录入项，长度控制在2-20字符" lang="s2-20"></em>
           </td>
        </tr>
        <c:if test="${empty bean.yhid}">
          <tr>
       	   <th width="120"><span class="warning">*</span>设置密码：</th>
           <td>
           <s:password  name="bean.yhmm" cssClass="inputText" id="yhmm"/>
            <em  class="valid" title="密码是必须录入项，长度控制在6-20字符" lang="s6-20"></em>
           </td>
          </tr>
          <tr>
       	   <th width="120"><span class="warning">*</span>密码确认：</th>
           <td>
           <input type="password" name="newPassword" class="inputText"  datatype="*" recheck="bean.yhmm" nullmsg="请确认设置的密码！" errormsg="您两次输入的账号密码不一致！" >
           </td>
          </tr>
        </c:if>
       <tr>
       	   <th width="120"><span class="warning">*</span>单位部门：</th>
       	   <td>
       	   <select name="bean.bmid" id="bmid" class="select2">
										<c:forEach var="item" items="${datas }">
											<option value="${item.BMID}" ${item.BMID eq bean.bmid ? 'selected' : '' }>${item.BMMC }</option>
										</c:forEach>
			</select>
       	   <em  class="valid" title="必须选择用户所在的部门。" lang="*"></em>
           </td>
        </tr>
          <s:hidden name="bean.yhcw"/>
      	  <s:hidden name="bean.yhjc"/>
        <!-- 
       <tr>
       	   <th width="120">用户简称：</th>
           <td><s:textfield  name="bean.yhjc" cssClass="inputText" id="yhjc" maxlength="10"/></td>
        </tr>
    
       <tr>
       	   <th width="120">用户称谓：</th>
           <td><s:textfield  name="bean.yhcw" cssClass="inputText" id="yhcw" maxlength="10"/></td>
        </tr>
         -->
        <tr>
       	   <th width="120"><span class="warning">*</span>是否有效：</th>
           <td>
           <x:cache subject="OPTION01" var="list" scope="requestScope"/>
           <s:radio list="#request.list" name="bean.sfyx" id="sfyx" listKey="subcode" listValue="cname" ></s:radio>
           	 <em  class="valid" title="是否有效是必须录入项" lang="*" for="sfyx1"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>排序号：</th>
           <td>
           <s:textfield  name="bean.pxh" cssClass="inputText" id="pxh"/>
           <em  class="valid" title="排序号是必须输入项，而且为数字类型" lang="n"></em>
           </td>
        </tr>
        <tr>
       	   <th width="120">分配角色：</th>
           <td>
           	<c:forEach var="role" items="${roles }" varStatus="stat">
           		<c:set value="" var="checked"/>
           		<c:if test="${not empty queryRoles }">
           			<c:forEach var="sRole" items="${queryRoles.rows }">
           				<c:if test="${sRole.JSID eq role.roleId}">
           					<c:set value="checked" var="checked"/>
           				</c:if>
           			</c:forEach>
           		</c:if>
           		<c:if test="${role.admin ne true }">
           		<input type="checkbox" name="bean.roleIds" ${checked } value="${role.roleId }">${role.roleName }
           		</c:if>
           	</c:forEach>
           </td>
        </tr>
       </tbody>
        <tr>
        <td colspan="2" class="subtitle" >联系方式</td>
      	</tr> 
       <tbody> 
       <tr>
       	   <th width="120">手机号码：</th>
           <td><s:textfield  name="bean.sjhm" cssClass="inputText" id="sjhm" datatype="m" ignore="ignore" errormsg="请填写正确的手机格式"/><span class="note">&nbsp;手机号接收系统的短信服务信息</span></td>
        </tr>
       <tr>
       	   <th width="120">电子邮箱：</th>
           <td><s:textfield  name="bean.dzyj" cssClass="inputText" id="dzyj" datatype="e" ignore="ignore" errormsg="请填写正确的电子邮箱格式"/><span class="note">&nbsp;邮件帐号接收系统的邮件服务信息</span></td>
        </tr>
          <s:hidden name="bean.gzdh"/>
      	  <s:hidden name="bean.grzy"/>
      	  <s:hidden name="bean.jtdh"/>
     <!-- 
       <tr>
       	   <th width="120">家庭电话：</th>
           <td><s:textfield  name="bean.jtdh" cssClass="inputText" id="jtdh"  maxlength="30"/></td>
        </tr>
       <tr>
       	   <th width="120">工作电话：</th>
           <td><s:textfield  name="bean.gzdh" cssClass="inputText" id="gzdh"  maxlength="30"/></td>
        </tr>
       <tr>
       	   <th width="120">个人主页：</th>
           <td><s:textfield  name="bean.grzy" cssClass="inputText" id="grzy"  maxlength="30"/></td>
        </tr>
      -->   
       </tbody>
      <tr>
        <td colspan="2" class="toolbar"><input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
          <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
  </div>    
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
