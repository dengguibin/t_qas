<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-31 21:20:07
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonSeqvalue";
			var query = "?bean.tid="+args+"&bean.seqid="+$("#seqid").val()+"&bean.seqtype="+$("#"+args+"type").val();
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
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
<x:page var="datas" stmt="list" params="${bean}" mapperClass="${mapper}"></x:page>
<div class="tabBlock" style="width: 100%;">	
<s:form action="tCommonSeqvalue!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:hidden name="bean.seqid" id="seqid"></s:hidden>
		<div class="dataGrid"  style="width: 100%;margin: 0;padding: 0;">
		<br>
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>序列类型</th>
                <th>应用ID</th>
                <th>序列当前值</th>
                <th>存取次数</th>
                <th>回滚标识</th>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.SEQTYPE}</td>
                   	<td>&nbsp;${item.TID}</td>
                   	<td>&nbsp;${item.CVALUE}</td>
                   	<td>&nbsp;${item.NUMS}</td>
                   	<td>&nbsp;${item.FLAG}</td>
                 	 <td>&nbsp;
                 	 	<input type="hidden" id="${item.TID }type" value="${item.SEQTYPE}">
                 	 	<a href="javascript:void(0);" class="tablelink" title="修改" onclick="opreate('${item.TID }','update');">&nbsp;修改</a>
                 	 	<a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.TID }','delete');">&nbsp;删 除</a>
                 	 </td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
              <%@include file="/pages/t_qas/layout/page.jsp" %>
           </div>
</s:form>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
