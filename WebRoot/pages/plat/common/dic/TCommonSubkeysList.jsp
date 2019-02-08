<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 17:12:16
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,sub,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonSubkeys";
			var query = "?bean.code="+args+"&bean.subcode="+sub;
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				baseUrl += "!delete.action"
				var datas = {};
				datas['bean.code'] = args;
				datas['bean.subcode'] = sub;
				$.post(baseUrl,datas,function(data){
				});
			}
		}
//-->
</script>
<body>
<div class="tabBlock" style="width: 100%;">	
<br>
<s:form action="tCommonSubkeys!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:hidden name="bean.code"/>
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th >代码键</th>
                <th >代码名称</th>
                <th >是否有效</th>
                <th >排序号</th>
                <th >参数1</th>
                <th >参数2</th>
                <th >备注说明</th>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td nowrap="nowrap">&nbsp;${item.SUBCODE}</td>
                   	<td nowrap="nowrap">&nbsp;${item.CNAME}</td>
                   	<td>&nbsp;<x:cache subject="OPTION01" key="${item.VALID}"/></td>
                   	<td>&nbsp;${item.SEQ}</td>
                   	<td>&nbsp;${item.PARAMS1}</td>
                   	<td>&nbsp;${item.PARAMS2}</td>
                   	<td>&nbsp;${item.DES}</td>
                 	 <td style="width: 120px;">&nbsp;
                 	 		<a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.CODE }','${item.SUBCODE }','update');">修改</a>
                 	 		<a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.CODE }','${item.SUBCODE }','delete');">删除</a>
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
