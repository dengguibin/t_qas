<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 17:12:16
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">

		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonKeys";
			var query = "?bean.code="+args+"&menuId="+$("#menuId").val();;
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				baseUrl += "!delete.action"+query;
				$.post(baseUrl,{},function(data){
				});
			}else if('add' === opCode){
				baseUrl += "!select.action?menuId="+$("#menuId").val();;
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
		
		$(document).keydown(function(e) {		//回车搜索
			if(e.keyCode == 13) {
				opreate("","query");
			}
		});
</script>
<body>
<x:query stmt="系统参数管理查询" var="datas" ></x:query>
<x:qx var="qx" menuId="${menuId }"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">
<s:form action="tCommonKeys!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
		<div class="filter">
 		<table>
            <tbody>
              <tr>
                <th>字典键值：</th>
                <td>
                	<s:textfield name="bean.code" cssClass="inputText"></s:textfield>
                </td>
                <th>字典名称：</th>
                <td><s:textfield name="bean.cname" cssClass="inputText"></s:textfield></td>
                <th>备注：</th>
                <td>
                	<s:textfield name="bean.des" cssClass="inputText"></s:textfield>
                </td>
                <th >参数：</th>
                <td><s:textfield name="bean.pname1" cssClass="inputText"></s:textfield></td>
                <td> <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " /></td>
              </tr>
            </tbody>
          </table>
          </div>
		
			
		<c:if test="${qx.add }">
		<div class="tools">
		<ul class="toolbar">
			<li class="click add" onclick="opreate('','add');">添加</li>
        <%--<li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li>--%>
        </ul>
		 </div>
		</c:if>
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>字典键值</th>
                <th>字典名称</th>
                <th>是否有效</th>
                <th>参数1名称</th>
                <th>参数2名称</th>
                <th>排序号</th>
                <th>备注说明</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td>${item.CODE}</td>
                   	<td>${item.CNAME}</td>
                   	<td><x:cache subject="OPTION01" key="${item.VALID}"/></td>
                   	<td>${item.PNAME1}</td>
                   	<td>${item.PNAME2}</td>
                   	<td>${item.SEQ}</td>
                   	<td>${item.DES}</td>
                 	 <td>
                 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.CODE }','update');">修改</a></c:if>
                 	 <c:if test="${qx.delete }"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.CODE }','delete');">删除</a></c:if>
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
