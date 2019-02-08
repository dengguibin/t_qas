<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-28 22:24:28
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/plat/frame/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonSql";
			var query = "?bean.tid="+args;
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				popUp(baseUrl);
				//window.location.href = baseUrl;
			}else if('delete' === opCode){
			var result = 	window.confirm("确定要永久删除数据吗？");
				if(result ){
					baseUrl += "!delete.action"+query;
					$.post(baseUrl,{},function(data){
					$("#opForm").submit();
					});
				}
			}else if('add' === opCode){
				baseUrl += "!select.action";
				popUp(baseUrl);
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
//-->
</script>
<body style="background-color:#eff5f9;">
<x:query var="datas" stmt="SQL管理器查询"></x:query>
<!-- 
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
 -->
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
 
<s:form action="tCommonSql!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	<div class="editBlock">
 		<table>
 			<tr>
              <td colspan="4" class="subtitle"  title="点击可展开或关闭">查询条件</td>
            </tr>
            <tbody>
              <tr>
               	<th width="120">模板名称：</th>
                <td>
                <s:textfield name="bean.name" cssClass="inputText"></s:textfield>
               </td>
                <th width="120">脚本语言：</th>
                <td><s:textfield name="bean.scripts" cssClass="inputText"></s:textfield></td>
              </tr>
              <tr>
                <td colspan="4" class="toolbar" style="text-align: right;">
                <input name="button"  onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                <c:if test="${qx.add }"><input name="button" onclick="opreate('','add');" type="button" class="inputButton" value=" 新 增 " /></c:if>
                </td>
              </tr>
            </tbody>
          </table>
		</div>
		<div class="dataGrid">
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>所属目录</th>
                <th>SQL名称</th>
                <th>引用类型</th>
                <th>SQL类型</th>
                <th>返回类型</th>
                <th>调用次数</th>
                <th>均消</th>
                <th>备注</th>
                <c:if test="${qx.update or qx.delete }">
                  <th>操作</th>
                </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.PTID}</td>
                   	<td>&nbsp;${item.NAME}</td>
                   	<td>&nbsp;<x:cache subject="SQLREF" key="${item.RTYPE}"/></td>
                   	<td>&nbsp;<x:cache subject="SQLTYPE" key="${item.TYPE}"/>  </td>
                   	<td>&nbsp;<x:cache subject="SQLRESULT" key="${item.RESULT}"/></td>
                   	<td>&nbsp;${item.TIMES}</td>
                   	<td>&nbsp;${item.COSTS}</td>
                   	<td>&nbsp;${item.DES}</td>
                   	  <c:if test="${qx.update or qx.delete }">
                 	 <td>&nbsp;
                 	 	<c:if test="${qx.update }"><a href="javascript:void(0);" class="iconMod" title="更 新" onclick="opreate('${item.TID }','update');">&nbsp;</a></c:if>
                 	 	<c:if test="${qx.delete }"><a href="javascript:void(0);" class="iconDel" title="删 除" onclick="opreate('${item.TID }','delete');">&nbsp;</a></c:if>
                 	 </td>
                 	 </c:if>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%@include file="/pages/plat/frame/page.jsp" %>
          </div><!-- dataGrid end -->
</s:form>
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>
