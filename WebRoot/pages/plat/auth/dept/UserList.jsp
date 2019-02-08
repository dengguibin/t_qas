<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-3 22:10:24
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/org/auth/";
			var query = "?bean.yhid="+args+"&menuId="+$("#menuId").val();
			if('update' === opCode){
				$.registerForm('opForm');
				baseUrl += "toEditOrgUserInfo.action"+query;
				window.location.href = baseUrl;
			}else if('change' === opCode){
				if(window.confirm("确定要[禁用/启用]用户吗，禁用情况下面用户不可用？")){
				baseUrl += "changeOrgUser.action"+query;
				$.post(baseUrl,{},function(data){
					if(data && data.status == '2'){
						alert('操作失败。');
					}else{
						$("#opForm").submit();
					}
				});
				}
			}else if('add' === opCode){
				$.registerForm('opForm');
				baseUrl += "toEditOrgUserInfo.action"+"?menuId="+$("#menuId").val();
				window.location.href = baseUrl;
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('reset' === opCode){
				if(window.confirm("确定重置用户的密码吗？重置后用户的密码将为系统初始密码")){
					baseUrl += "resetUserPwd.action"+query;
					$.post(baseUrl,{},function(data){
						if(data && data.status == '2'){
							alert('操作失败。');
						}else{
							$("#opForm").submit();
						}
					});
					}
			}
		}
//-->
</script>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${menuId}"/></div>
<c:set var="yhids" value="," scope="request"/>
<c:if test="${not empty datas}">
	<c:forEach items="${datas}" var="item"  varStatus="stat">
	<c:set var="yhids" value="${yhids }${item.YHID}," scope="request"/>
	</c:forEach>
<x:query stmt="用户角色查询" var="roles" paged="false"></x:query>	
</c:if>

<!-- 权限查询,因为IFRAME不验证访问路径 -->
 <x:qx var="qx" menuId="${menuId}"></x:qx>
<div class="dataGrid">
<s:form action="listOrgUserInfo" namespace="/org/auth" method="post"  id="opForm" name="opForm">
<s:hidden name="bean.bmid"></s:hidden>
<s:hidden name="menuId" id="menuId"/>
	
	<div class="filter">
 		<table>
 			
            <tbody>
              <tr>
                <th>用户名称：</th>
                <td><s:textfield name="bean.yhmc" cssClass="inputText" ></s:textfield></td>
                <th>用户帐号：</th>
                <td>
                <s:textfield name="bean.yhid" cssClass="inputText"></s:textfield>
                </td>
         
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                </td>
              </tr>
            </tbody>
          </table>
		</div>
			<c:if test="${qx.add }">
		<div class="tools">
		<ul class="toolbar">
        <li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li>
        </ul>
		 </div>
		</c:if>
		
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>用户帐号</th>
                <th>部门名称</th>
                <th>用户名称</th>
                <th>用户状态</th>
                <th>关联角色</th>
                <th>是否有效</th>
                <th>排序号</th>
                <c:if test="${qx.update }">
                  <th>操作</th>
                </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.YHID}</td>
                   	<td>&nbsp;${item.BMMC}</td>
                   	<td>&nbsp;${item.YHMC}</td>
                   	<td><c:choose>
                   		<c:when test="${empty item.USTATUS }">正常</c:when>
                   		<c:otherwise><span class="red">${item.USTATUS }</span> </c:otherwise>
                   	</c:choose></td>
                   	<td>&nbsp;
                   	<c:forEach var="role" items="${roles.rows }" varStatus="rStat">
                   		<c:if test="${item.YHID eq role.YHID }">
                   			<a href="javascript:void(0);" title="${role.JSMS }">${role.JSMC }</a>
                   		</c:if>
                   	</c:forEach></td>
                   	<td>&nbsp;<x:cache subject="OPTION01" key="${item.SFYX}"/></td>
                   	<td>&nbsp;${item.PXH}</td>
                   	 <c:if test="${qx.update}">	
                 	 <td>&nbsp;
                 	     <c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.YHID }','update');">修改</a></c:if>
                 	 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="禁用" onclick="opreate('${item.YHID }','change');">${empty item.DISABLE ? '禁用' : '启用'  }</a></c:if>
                 	 	 <c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="重置密码" onclick="opreate('${item.YHID }','reset');">重置密码</a></c:if>
                 	 </td>
                 	  </c:if>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
            <%@include file="/pages/t_qas/layout/page.jsp" %>
      </s:form>
 </div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
