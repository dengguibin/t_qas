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
			var baseUrl = "${ctx}/com/upath/plat/common/modules/tCommonOnline";
			var query = "?bean.tid="+args;
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
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="tabBlock">	

<s:form action="tCommonOnline!list" namespace="/com/upath/plat/common/modules" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	<div class="editBlock">
 		<table>
 			<tr>
              <td colspan="4" class="subtitle"  title="点击可展开或关闭">查询条件</td>
            </tr>
            <tbody>
              <tr>
                <th width="120">地区分公司：</th>
                <td><select name="city" id="city">
                  <option>----请选择分公司----</option>
				  <option>广东省公司</option>
				  <option>广州分公司</option>
                </select></td>
                <th width="120">集团名称：</th>
                <td><input type="text" class="inputText" name="textfield22" /></td>
              </tr>
              <tr>
                <td colspan="4" class="toolbar" style="text-align: right;">
                <input name="button" type="button" class="inputButton" value=" 查 询 " />
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
                <th>主键</th>
                <th>会话ID</th>
                <th>登陆时间</th>
                <th>登出时间</th>
                <th>当前状况</th>
                <th>是否在线</th>
                <th>登陆人</th>
                <th>客户端IP</th>
                <th>创建时间</th>
                <th>创建人</th>
                <th>修改时间</th>
                <th>修改人</th>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.TID}</td>
                   	<td>&nbsp;${item.SESSIONID}</td>
                   	<td>&nbsp;${item.LOGINTIME}</td>
                   	<td>&nbsp;${item.LOGOUTTIME}</td>
                   	<td>&nbsp;${item.STATUS}</td>
                   	<td>&nbsp;${item.ONLINE}</td>
                   	<td>&nbsp;${item.USERID}</td>
                   	<td>&nbsp;${item.CIP}</td>
                   	<td>&nbsp;${item.CJSJ}</td>
                   	<td>&nbsp;${item.CJR}</td>
                   	<td>&nbsp;${item.XGSJ}</td>
                   	<td>&nbsp;${item.XGR}</td>
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
