<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2013-5-15 10:22:26
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/plat/frame/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonTemplate";
			var query = "?bean.tid="+args;
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				baseUrl += "!delete.action"+query;
				if(window.confirm("确定要永久删除记录？")){
				$.post(baseUrl,{},function(data){
					window.location.reload();
				});
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
<x:query stmt="标准语句模板查询" var="datas"></x:query>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="tabBlock">	

<s:form action="tCommonTemplate!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	<div class="editBlock">
 		<table>
 			<tr>
              <td colspan="4" class="subtitle"  title="点击可展开或关闭">查询条件</td>
            </tr>
            <tbody>
              <tr>
                 <th width="120">模板配置类型：</th>
	                <td> <select name="bean.mblx" id="mblx" style="width: 135px;">
	          		<option value="">--请选择模板类型--</option>
	          		<x:cache subject="TEMPLATE"  option="true" selected="${bean.mblx}"/>
	          		</select></td>
                <th width="120">模板名称：</th>
                <td>
                	<s:textfield name="bean.template" id="template" cssClass="inputText"></s:textfield>
                </td>
              </tr>
              <tr>
                <td colspan="4" class="toolbar" style="text-align: right;">
                <input name="button" onclick="opreate('','query');"  type="button" class="inputButton" value=" 查 询 " />
                <input name="button" onclick="opreate('','add');" type="button" class="inputButton" value=" 新 增 " />
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
                <th>模板</th>
                <th>模板类型</th>
                <th>排序号</th>
                <th>是否有效</th>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.TEMPLATE}</td>
                   	<td>&nbsp;<x:cache subject="TEMPLATE" key="${item.MBLX}"/></td>
                   	<td>&nbsp;${item.PXH}</td>
                   	<td>&nbsp;<x:cache subject="OPTION01" key="${item.SFYX}"/></td>
                 	 <td>&nbsp;
                 	 	<a href="javascript:void(0);" class="iconMod" title="更 新" onclick="opreate('${item.TID }','update');">&nbsp;</a>
                 	 	<a href="javascript:void(0);" class="iconDel" title="删 除" onclick="opreate('${item.TID }','delete');">&nbsp;</a>
                 	 </td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%@include file="/pages/plat/frame/page.jsp" %>
          </div><!-- dataGrid end -->
</s:form>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>
