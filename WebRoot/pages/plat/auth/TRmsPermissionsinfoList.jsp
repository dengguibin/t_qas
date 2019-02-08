<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-11 21:51:54
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsPermissionsinfo";
			var query = "?bean.qxid="+args+"&menuId="+$("#menuId").val();
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				if(window.confirm("永久删除选中数据？")){
					baseUrl += "!delete.action"+query;
					$.post(baseUrl,{},function(data){
					});
					$("#opForm").submit();
				}
				
			}else if('add' === opCode){
				baseUrl += "!select.action";
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
//-->
</script>
<body>
<x:query  var="datas" stmt="权限管理查询"></x:query>
<x:qx var="qx" menuId="${menuId }"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">
<s:form action="tRmsPermissionsinfo!list" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	 
	    <div class="filter">
 		<table >
              <tr>
                <th>权限名称：</th>
                <td>
                  <s:textfield name="bean.qxmc" cssClass="inputText"></s:textfield>
                </td>
                <td>
                 <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                </td>
              </tr>
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
                <th>权限标识</th>
                <th>权限名称</th>
                <th>权限描述</th>
                <th>位移码</th>
                <th>是否有效</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td>${item.QXID}</td>
                   	<td>${item.QXMC}</td>
                   	<td>${item.QXMS}</td>
                   	<td>${item.PXH}</td>
                   	<td><x:cache subject="OPTION01" key="${item.SFYX}"/></td>
                 	 <td style="width: 120px;">
                 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.QXID }','update');">修改</a></c:if>
                 	 <c:if test="${qx.delete }"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.QXID }','delete');">删除</a></c:if>
                 	 <c:if test="${(qx.update or qx.delete) eq false }">
                 	 	<span class="note">无权限</span>
                 	 </c:if>
                 	 </td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%@include file="/pages/t_qas/layout/page.jsp" %>
</s:form>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
