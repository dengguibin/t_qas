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
			var baseUrl = "${ctx}/plat/auth/tRmsUser";
			var query = "?bean.yhid="+args;
			if('update' === opCode){
				$.registerForm('opForm');
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				if(window.confirm("确定要永久删除数据吗？")){
				baseUrl += "!delete.action"+query;
				$.post(baseUrl,{},function(data){
					if(data && data.status == '2'){
						alert('删除的用户已经存在关联的数据，删除失败。');
					}else{
						$("#opForm").submit();
					}
					
				});
				}
			}else if('add' === opCode){
				$.registerForm('opForm');
				baseUrl += "!select.action";
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('reset' === opCode){
				if(window.confirm("确定重置用户的密码吗？重置后用户的密码将为系统初始密码")){
					baseUrl = "${ctx}/org/auth/resetUserPwd.action"+query;
					$.post(baseUrl,{},function(data){
						if(data && data.status == '2'){
							alert('操作失败。');
						}else{
							$("#opForm").submit();
						}
					});
					}
			}else if('change' === opCode){
				if(window.confirm("确定要[禁用/启用]用户吗，禁用情况下面用户不可用？")){
					baseUrl = "${ctx}/org/auth/changeOrgUser.action"+query;
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
		
$(function(){
	$(".select8").select2({
	});
});	
//-->
</script>
<body>
<%
//<x:query stmt="系统用户查询" var="datas"></x:query>
%>
<c:set var="yhids" value="," scope="request"/>
<c:if test="${not empty datas }">
	<c:forEach items="${datas}" var="item"  varStatus="stat">
	<c:set var="yhids" value="${yhids }${item.YHID}," scope="request"/>
	</c:forEach>
</c:if>

<!-- 权限查询,因为IFRAME不验证访问路径 -->
 <x:qx var="qx" menuId="${param.menuId}" verify="false"></x:qx>

<x:query stmt="用户角色查询" var="roles" paged="false"></x:query>
<div class="dataGrid">
<s:form action="tRmsUser!list" namespace="/plat/auth" method="post"  id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	
	<div class="filter">
 		<table>
 			
            <tbody>
              <tr>
                <th>用户帐号/名称：</th>
                <td><s:textfield name="bean.yhmc" cssClass="inputText"></s:textfield></td>
          		<th>&nbsp;单位名称：&nbsp;</th>
                <td>
                <select class="select8" name="bean.bmid" style="width:180px;">
                 		<option value="">--请选择--</option>
				   	 <x:cache subject="ORGS"  option="true" selected="${bean.bmid }"></x:cache>
				   </select>
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
		<li class="click add" onclick="opreate('','add');">添加</li>
        <%--<li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li>
        --%></ul>
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
                <c:if test="${qx.update or qx.delete }">
                  <th>操作</th>
                </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td>${item.YHID}</td>
                   	<td>${item.BMMC}</td>
                   	<td>${item.YHMC}</td>
                   	<td><c:choose>
                   		<c:when test="${empty item.USTATUS }">正常</c:when>
                   		<c:otherwise><span class="red">${item.USTATUS }</span> </c:otherwise>
                   	</c:choose></td>
                   
                   	<td>
                   	<c:forEach var="role" items="${roles.rows }" varStatus="rStat">
                   		<c:if test="${item.YHID eq role.YHID }">
                   			<a href="javascript:void(0);" title="${role.JSMS }" style="display: block;margin-bottom: 2px;">${role.JSMC }</a>
                   		</c:if>
                   	</c:forEach></td>
                   	<td><x:cache subject="OPTION01" key="${item.SFYX}"/></td>
                   	<td>${item.PXH}</td>
                   	 <c:if test="${qx.update or qx.delete }">	
                 	 <td>
                 	     <c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.YHID }','update');">修改</a></c:if>
                 	 	 <c:if test="${qx.delete }"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.YHID }','delete');">删除</a></c:if>
                 	 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="禁用" onclick="opreate('${item.YHID }','change');">${empty item.DISABLE ? '禁用' : '启用'  }</a></c:if>
                 	 	 <c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="重置密码" onclick="opreate('${item.YHID }','reset');">重置</a></c:if>
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
