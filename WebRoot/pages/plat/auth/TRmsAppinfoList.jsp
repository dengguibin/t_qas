<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-11 12:58:42
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsAppinfo";
			var query = "?bean.appid="+args+"&menuId="+$("#menuId").val();
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				$.registerForm('opForm');
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				baseUrl += "!delete.action"+query;
				$.post(baseUrl,{},function(data){
				});
			}else if('add' === opCode){
				baseUrl += "!select.action";
				$.registerForm('opForm');
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
//-->
</script>
<body>
<x:qx var="perm" menuId="${menuId}"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${menuId}"/></div>
    <c:if test="${perm.add and 1 eq 2}">
 <div class="toolbar">
<input name="button" onclick="opreate('','add');" type="button" class="inputButton" value=" 新 增 " />
  </div>
  </c:if>
<div class="dataGrid">  
<s:form action="tRmsAppinfo!list" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<s:hidden name="menuId" id="menuId"></s:hidden>
		<div class="filter">
	 		<table>
	            <tbody>
	              <tr>
	                <th>系统名称：</th>
	                <td><input type="text" class="inputText" name="bean.xtms" value="${bean.xtms }"/>
	                </td>
	                 <c:if test="${perm.query}">
	                 <td><input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " /></td>
	                 </c:if>
	              </tr>
	            </tbody>
	          </table>
		</div>
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>组织ID</th>
                <th>系统名称</th>
                <th>系统默认首页</th>
                <th>系统当前版本</th>
                <th>开发维护人</th>
                <th>邮件联系方式</th>
                <th>电话方式</th>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td>${item.ORGID}</td>
                   	<td>${item.XTMS}</td>
                   	<td>${item.XTMRSY}</td>
                   	<td>${item.XTDQBB}</td>
                   	<td>${item.KFWFR}</td>
                   	<td>${item.YJLXFS}</td>
                   	<td>${item.DHFS}</td>
                 	 <td>
                 	 	<c:if test="${perm.update}">
                 	 	<a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.APPID }','update');">修改</a>
                 	 	</c:if>
                 	 	<!-- 系统不允许新加操作，目前产品化只允许 一个系统出现 -->
               	 		<c:if test="${perm.update and 1 eq 2}">
               	 		<a href="javascript:void();" class="tablelink" title="删 除" onclick="opreate('${item.APPID }','delete');">&nbsp;</a>
               	 		</c:if>
                 	 	<c:if test="${perm.update  ne true}">
                 	 		<span class="note">无权限</span>
                 	 	</c:if>
                 	 	
                 	 </td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
           <%@include file="/pages/t_qas/layout/page.jsp" %>
          
</s:form>
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
