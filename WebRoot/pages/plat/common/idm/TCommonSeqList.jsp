<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-31 21:20:06
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonSeq";
			var query = "?bean.seqid="+args;
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl+"&menuId="+$("#menuId").val();
			}else if('delete' === opCode){
				baseUrl += "!delete.action"+query;
				$.post(baseUrl,{},function(data){
				});
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
<x:query stmt="序列号管理查询" var="datas"></x:query>
<x:qx var="qx" menuId="${menuId }"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">

<s:form action="tCommonSeq!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
		<div class="filter">
 		<table>
            <tbody>
              <tr>
                <th>序列名称：</th>
                <td>
                <s:textfield name="bean.name" cssClass="inputText"></s:textfield>
                </td>
                <th>备注说明</th>
                <td>
                <s:textfield name="bean.des" cssClass="inputText"></s:textfield>
                </td>
                <td><input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " /></td>
              </tr>
            </tbody>
          </table>
		</div>
		<c:if test="${qx.add }">
		<div class="tools">
			<ul class="toolbar">
				<li class="click add" onclick="oopreate('','add');">新 增</li>
       			<%--<li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>新 增 </li>--%>
        	</ul>
		</div>
		</c:if>
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>序列名称</th>
                <th>最小值</th>
                <th>最大值</th>
                <th>开始位置</th>
                <th>步长</th>
                <th>备注说明</th>
                 <th width="100">操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td>${item.NAME}</td>
                   	<td>${item.MINVAL}</td>
                   	<td>${item.MAXVAL}</td>
                   	<td>${item.SPOS}</td>
                   	<td>${item.STEPS}</td>
                   	<td>${item.DES}</td>
                 	 <td>
                 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="修改" onclick="opreate('${item.SEQID }','update');">修改</a></c:if>
                 	 <c:if test="${qx.delete }"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.SEQID }','delete');">删除</a></c:if>
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
</div><!-- grid  end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
