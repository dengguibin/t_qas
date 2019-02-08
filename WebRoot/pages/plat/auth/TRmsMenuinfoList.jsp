<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-3 13:54:18
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsMenuinfo";
			var query = "?bean.cdid="+args;
			if('update' === opCode){
				$.registerForm('opForm');
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				if(window.confirm("确定要永久删除数据？")){
				baseUrl += "!delete.action"+query;
				$.getJSON(baseUrl,{},function(data){
					if(data.status == '1'){
						$("#opForm").submit();
					}else if(data.status == '2'){
						alert('菜单数据已经跟权限有关联，请先删除跟菜单相关的权限信息');
					}
					
				});
				}
			}else if('add' === opCode){
				baseUrl += "!select.action";
				$.registerForm('opForm');
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('manage' === opCode){
				baseUrl = "${ctx}/plat/auth/tRmsMenufunc!queryList.action";
				query = "?menuId="+$("#menuId_").val()+"&bean.cdid="+args;
				$.registerForm('opForm');
				window.location.href = (baseUrl+query);
			}
		}
//-->
</script>
<body>
<x:query var="datas" stmt="菜单管理查询"></x:query>
<x:qx var="qx" menuId="${menuId }" verify="false"></x:qx>
<div class="dataGrid">
<s:form action="tRmsMenuinfo!list" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<s:hidden name="bean.pcdid" id="pcdid"/>
<s:hidden name="bean.cdid" id="cdid"/>
<!-- 不使用菜单ID 关联 -->
<input type="hidden" name="menuId_" value="${param.menuId}" id="menuId_">
		<div class="filter">
 		<table>
            <tbody >
             <tr>
                <th>菜单名称：</th>
                <td><s:textfield name="bean.cdmc" cssClass="inputText"></s:textfield></td>
                <th>URL：</th>
                <td><s:textfield name="bean.ljdz" cssClass="inputText"></s:textfield></td>
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
                <th width="50px">序号</th>
                <th width="150px">菜单名称</th>
                <th width="120px">URL</th>
                <th width="120px">是否有效</th>
                <th width="70px">排序号</th>
                 <th width="120px">功能配置</th>
                 <th width="120px">操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td>${item.CDMC}</td>
                   	<td width="180" style="text-align: left;">&nbsp;${item.LJDZ}</td>
                   	<td><x:cache subject="OPTION01" key="${item.SFYX}"/></td>
                 	 <td>${item.PXH}</td>
                 	 <td><a href="javascript:void(0);" class="tablelink" title="管理" onclick="opreate('${item.CDID }','manage');">
                 	 功能配置<c:if test="${not empty item.NUMS_FUNC }">[${item.NUMS_FUNC }]</c:if>
                 	 </a></td>
                 	 <td>
                 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.CDID }','update');">修改</a></c:if>
                 	 <c:if test="${qx.delete }"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.CDID }','delete');">删除</a></c:if>
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
	</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
